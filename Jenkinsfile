pipeline {
    agent any

    environment {
        JAVA_HOME = '/Library/Java/JavaVirtualMachines/jdk-11.jdk/Contents/Home'
        M2_HOME = '/Applications/apache-maven-3.8.6'
        PATH = "${JAVA_HOME}/bin:${M2_HOME}/bin:${PATH}"
    }

    tools {
        maven 'Maven 3.x'  // Reference globally installed Maven
        appium 'Appium'    // Reference globally configured Appium tool
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'master', url: 'https://github.com/nook-automation/rep1.git'
            }
        }

        stage('Start Appium Server') {
            steps {
                script {
                    echo 'Starting Appium server...'
                    sh 'appium --log-level info &'
                    sleep 10 // Wait for the Appium server to start
                }
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

        stage('Run Automation Script') {
            steps {
                script {
                    // Run your automation script (replace with your main class path)
                    sh 'mvn exec:java -Dexec.mainClass="tests.TestApp"'
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



