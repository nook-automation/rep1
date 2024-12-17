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
                echo "Checking out code from Git repository..."
                git branch: 'master', url: 'https://github.com/nook-automation/rep1.git'
            }
        }

        stage('Install Dependencies') {
            steps {
                script {
                    echo "Installing dependencies and running tests with Maven..."
                    sh 'mvn clean install'
                }
            }
        }

        stage('Post Results') {
            steps {
                echo "Java automation script has finished running."
                script {
                    def reportPath = 'test-output/emailable-report.html'
                    if (fileExists(reportPath)) {
                        echo "Test report exists: ${reportPath}"
                        // Send success email with the HTML report as attachment (if it exists)
                        emailext to: 'kvengattan@bn.com',
                                 subject: "Build Success",
                                 body: "The build has completed successfully!\n\nPlease find the test report attached.",
                                 attachmentsPattern: reportPath  // Attach the report
                    } else {
                        echo "Test report not found at: ${reportPath}"
                    }
                }
            }
        }
    }

    post {
        always {
            // Clean workspace after sending the email
            echo "Cleaning up the workspace..."
            cleanWs()  // Clean workspace after the build
        }
    }
}
















