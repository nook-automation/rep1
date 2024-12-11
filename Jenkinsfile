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

stage('Build and Run Automation Script') {
    steps {
        script {
            // Clean, compile, and run the script
            sh 'mvn clean compile exec:java -Dexec.mainClass="tests.TestApp" -Dexec.classpathScope=test'
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
