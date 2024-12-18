pipeline {
    agent any

    environment {
        JAVA_HOME = '/Library/Java/JavaVirtualMachines/jdk-11.jdk/Contents/Home'
        M2_HOME = '/Applications/apache-maven-3.8.6'
        PATH = "${JAVA_HOME}/bin:${M2_HOME}/bin:${PATH}"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'master', url: 'https://github.com/nook-automation/rep1.git'
            }
        }

        stage('Install Dependencies and Run Tests') {
            steps {
                script {
                    echo "Running Maven tests..."
                    sh 'mvn clean install'
                }
            }
        }

        stage('Post Results') {
            steps {
                echo "Build complete. Preparing to send email..."
            }
        }
    }

    post {
        success {
            echo 'The pipeline has completed successfully.'

            // Define the relative path using the Jenkins workspace environment variable
            script {
                def reportFile = "${env.WORKSPACE}/target/surefire-reports/emailable-report.html"
                if (fileExists(reportFile)) {
                    emailext(
                        subject: 'Build Success',
                        body: 'The build has completed successfully! Please find the attached emailable report.',
                        attachmentsPattern: reportFile,
                        to: 'kvengattan@bn.com'
                    )
                } else {
                    echo "Emailable report not found at ${reportFile}"
                }
            }
        }

        failure {
            echo 'The pipeline has failed.'

            // Define the relative path using the Jenkins workspace environment variable
            script {
                def reportFile = "${env.WORKSPACE}/target/surefire-reports/emailable-report.html"
                if (fileExists(reportFile)) {
                    emailext(
                        subject: 'Build Failed',
                        body: 'The build has failed. Please check the attached emailable report.',
                        attachmentsPattern: reportFile,
                        to: 'kvengattan@bn.com'
                    )
                } else {
                    echo "Emailable report not found at ${reportFile}"
                }
            }
        }
    }
}




























