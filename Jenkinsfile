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
                // Checkout code from Git repository
                echo "Checking out code from Git repository..."
                git branch: 'master', url: 'https://github.com/nook-automation/rep1.git'
            }
        }

        stage('Install Dependencies') {
            steps {
                script {
                    // Install dependencies and run tests with Maven
                    echo "Installing dependencies and running tests with Maven..."
                    sh 'mvn clean install'
                }
            }
        }

        stage('Post Results') {
            steps {
                echo "Java automation script has finished running."
                // Check if the report exists before trying to send it
                script {
                    def reportPath = 'test-output/emailable-report.html'
                    if (fileExists(reportPath)) {
                        echo "Test report exists: ${reportPath}"
                    } else {
                        echo "Test report not found at: ${reportPath}"
                    }
                }
            }
        }
    }

    post {
        always {
            // Clean workspace after sending email
            cleanWs()  // Clean workspace after the build
        }
        success {
            echo 'The pipeline has completed successfully.'
            // Send success email with the HTML report as attachment (if it exists)
            script {
                def reportPath = 'test-output/emailable-report.html'
                if (fileExists(reportPath)) {
                    emailext to: 'kvengattan@bn.com',
                             subject: "Build Success",
                             body: "The build has completed successfully!\n\nPlease find the test report attached.",
                             attachmentsPattern: reportPath  // Attach the report
                } else {
                    echo "No report found to send via email."
                }
            }
        }
        failure {
            echo 'The pipeline has failed.'
            // Send failure email with the HTML report as attachment (if it exists)
            script {
                def reportPath = 'test-output/emailable-report.html'
                if (fileExists(reportPath)) {
                    emailext to: 'kvengattan@bn.com',
                             subject: "Build Failed",
                             body: "The build has failed.\n\nPlease check the build logs for more information.\n\nThe detailed test report is attached.",
                             attachmentsPattern: reportPath  // Attach the report
                } else {
                    echo "No report found to send via email."
                }
            }
        }
    }
}













