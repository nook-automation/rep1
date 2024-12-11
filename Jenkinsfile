pipeline {
    agent any

    environment {
        JAVA_HOME = '/Library/Java/JavaVirtualMachines/jdk-11.jdk/Contents/Home'
        M2_HOME = '/Applications/apache-maven-3.8.6'  // Set Maven home directory
        PATH = "${JAVA_HOME}/bin:${M2_HOME}/bin:${PATH}"  // Add Maven bin directory to the PATH
        WATCH_DIR = '/Users/Balaji J/Documents/jenkins build'  // Path to the folder to monitor
    }

    triggers {
        // Polling every 5 minutes to check if a new .ipa file is added to the directory
        pollSCM('H/5 * * * *')  // Cron: every 5 minutes (adjust as needed)
    }

    stages {
        stage('Check for .ipa File') {
            steps {
                script {
                    // Use 'find' to search for .ipa files in the specified directory
                    def ipaFile = sh(script: "find \"${WATCH_DIR}\" -name \"*.ipa\" -type f", returnStdout: true).trim()

                    if (ipaFile) {
                        echo "Found .ipa file: ${ipaFile}"
                    } else {
                        echo "No .ipa files found."
                        currentBuild.result = 'SUCCESS'  // Mark the build as successful if no .ipa file found
                        return  // Skip further stages if no .ipa file is found
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
                    // Install dependencies using Maven and run tests as part of `mvn clean install`
                    sh 'mvn clean install'
                }
            }
        }

        stage('Post Results') {
            steps {
                echo "Java automation script has finished running."
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


