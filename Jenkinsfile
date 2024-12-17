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

                // Archive the HTML report from the test-output folder
                archiveArtifacts artifacts: 'test-output/emailable-report.html', allowEmptyArchive: true

                // Publish the HTML report from the test-output folder
                publishHTML(target: [
                    reportName: 'TestNG Emailable Report',
                    reportDir: 'test-output',  // Location of the report
                    reportFiles: 'emailable-report.html',  // Report filename
                    keepAll: true  // Keep all reports
                ])
            }
        }
    }

    post {
        always {
            cleanWs()  // Clean workspace after the build
        }
        success {
            echo 'The pipeline has completed successfully.'
            // Send success email with the HTML report as attachment
            emailext to: 'kvengattan@bn.com',
                     subject: "Build Success",
                     body: "The build has completed successfully!\n\nPlease find the test report attached.",
                     attachmentsPattern: 'test-output/emailable-report.html'  // Attach the report
        }
        failure {
            echo 'The pipeline has failed.'
            // Send failure email with the HTML report as attachment
            emailext to: 'kvengattan@bn.com',
                     subject: "Build Failed",
                     body: "The build has failed.\n\nPlease check the build logs for more information.\n\nThe detailed test report is attached.",
                     attachmentsPattern: 'test-output/emailable-report.html'  // Attach the report
        }
    }
}










