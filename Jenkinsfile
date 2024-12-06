pipeline {
    agent any

    environment {
        JAVA_HOME = '/Library/Java/JavaVirtualMachines/jdk-11.jdk/Contents/Home'
        M2_HOME = '/Applications/apache-maven-3.8.6'  // Set Maven home directory
        PATH = "${JAVA_HOME}/bin:${M2_HOME}/bin:${PATH}"  // Add Maven bin directory to the PATH
    }

    stages {
        stage('Checkout Code') {
            steps {
                echo 'Checking out code from Git repository...'
                git branch: 'master', url: 'https://github.com/nook-automation/rep1.git'
            }
        }

        stage('Install Dependencies') {
            steps {
                echo 'Running Maven clean install...'
                script {
                    try {
                        sh 'mvn clean install'
                    } catch (Exception e) {
                        echo "Maven install failed: ${e.getMessage()}"
                        throw e
                    }
                }
            }
        }

        stage('Start Appium Server') {
            steps {
                echo 'Starting Appium server...'
                script {
                    try {
                        sh '''#!/bin/bash
                        appium --log-level info > appium.log 2>&1 &
                        APP_PID=$!
                        sleep 5  # Give Appium a few seconds to start
                        if ! ps -p $APP_PID > /dev/null; then
                            echo "Appium did not start successfully"
                            exit 1
                        fi
                        echo "Appium started successfully with PID $APP_PID"
                        '''
                    } catch (Exception e) {
                        echo "Appium server start failed: ${e.getMessage()}"
                        throw e
                    }
                }
            }
        }

        stage('Run Automation Script') {
            steps {
                echo 'Running automation script...'
                script {
                    try {
                        sh 'mvn exec:java -Dexec.mainClass="tests.TestApp"'
                    } catch (Exception e) {
                        echo "Test execution failed: ${e.getMessage()}"
                        throw e
                    }
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
            // Clean up the workspace and ensure the Appium server is stopped
            script {
                echo 'Cleaning workspace and stopping Appium server...'
                // Stop Appium if it's still running
                sh 'pkill -f "appium" || true'
            }
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


