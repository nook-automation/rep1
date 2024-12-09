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
        stage('Monitor Folder') {
            steps {
                script {
                    try {
                        // Run inotifywait command to monitor the folder for "moved_to" events
                        sh '''#!/bin/bash
                        # Timeout mechanism to limit the time spent monitoring
                        END_TIME=$(( $(date +%s) + ${TIMEOUT_SECONDS} ))

                        echo "Monitoring folder: ${FOLDER_PATH}"
                        while [ $(date +%s) -lt $END_TIME ]; do
                            # Wait for files to be moved into the folder
                            inotifywait -m -e moved_to --format '%w%f' "${FOLDER_PATH}" | while read NEW_FILE; do
                                echo "New build detected: ${NEW_FILE}"
                                # Perform any necessary action, e.g., trigger another job or notify
                                # Example: Trigger a different Jenkins job here
                                curl -X POST http://jenkins.example.com/job/another-job-name/build \
                                     --user your-username:your-api-token
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

        stage('Checkout Code') {
            steps {
                git branch: 'master', url: 'https://github.com/nook-automation/rep1.git'
            }
        }

        stage('Install Dependencies') {
            steps {
                script {
                    // Install dependencies using Maven
                    sh 'mvn clean install'
                }
            }
        }

        stage('Run TestNG Tests') {
            steps {
                script {
                    // Run your TestNG tests using the Maven Surefire plugin
                    sh 'mvn test -Dtest=tests.TestApp'
                }
            }
        }

        stage('Post Results') {
            steps {
                echo "TestNG automation script has finished running."
            }
        }
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



