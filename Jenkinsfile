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

            // Send success email with emailable-report.html attachment
            script {
                def reportFile = '**/target/surefire-reports/emailable-report.html'  // Adjusted to your file path
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

            // Send failure email with emailable-report.html attachment
            script {
                def reportFile = '**/target/surefire-reports/emailable-report.html'  // Adjusted to your file path
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


























