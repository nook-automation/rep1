pipeline {
    agent any

    environment {
        JAVA_HOME = '/Library/Java/JavaVirtualMachines/jdk-11.jdk/Contents/Home'
        MAVEN_HOME = '/opt/maven'
        PATH = "${JAVA_HOME}/bin:${MAVEN_HOME}/bin:${PATH}"  // Corrected the PATH variable
    }

    stages {
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

