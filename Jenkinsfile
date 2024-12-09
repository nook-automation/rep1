pipeline {
    agent any

    environment {
        JAVA_HOME = '/Library/Java/JavaVirtualMachines/jdk-11.jdk/Contents/Home'
        M2_HOME = '/Applications/apache-maven-3.8.6'  // Set Maven home directory
        PATH = "${JAVA_HOME}/bin:${M2_HOME}/bin:${PATH}"  // Add Maven bin directory to the PATH
        FOLDER_PATH = '/Users/Balaji J/Documents/jenkins build'  // Folder to monitor for new builds (path with spaces)
        TIMEOUT_SECONDS = 3600  // 1 hour timeout for folder monitoring
    }

    stages {
        stage('Monitor Folder for IPA Files') {
            steps {
                script {
                    try {
                        // Run fswatch to monitor the folder for .ipa files
                        sh '''#!/bin/bash
                        # Timeout mechanism to limit the time spent monitoring
                        END_TIME=$(( $(date +%s) + ${TIMEOUT_SECONDS} ))

                        echo "Monitoring folder: '${FOLDER_PATH}'"
                        while [ $(date +%s) -lt $END_TIME ]; do
                            # Monitor for .ipa files being moved to the folder
                            fswatch -o "${FOLDER_PATH}" | while read NEW_FILE; do
                                if [[ "$NEW_FILE" =~ \.ipa$ ]]; then
                                    echo "New .ipa file detected: ${NEW_FILE}"
                                    # Perform any necessary action, e.g., trigger another job or notify
                                    # Example: Trigger a different Jenkins job here
                                    curl -X POST http://jenkins.example.com/job/another-job-name/build \
                                         --user your-username:your-api-token
                                fi
                            done
                        done
                        echo "Timeout reached, stopping folder monitoring."
                        '''
                    } catch (Exception e) {
                        echo "Error occurred while monitoring folder: ${e.getMessage()}"
                        currentBuild.result = 'FAILURE'
                    }
                }
            }
        }

        // Other pipeline stages (Checkout Code, Install Dependencies, etc.)
    }

    post {
        always {
            cleanWs()  // Clean workspace after build
        }
        success {
            echo 'The pipeline has completed successfully.'
        }
        failure {
            echo 'The pipeline has failed.'
        }
    }
}




