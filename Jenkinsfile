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
                    sh 'mvn surefire-report:report'  // Ensure TestNG report is generated
                }
            }
        }

        stage('Post Results') {
            steps {
                echo "Build complete. Sending email with report..."
            }
        }
    }

    post {
        success {
            echo 'The pipeline has completed successfully.'

            // Send email with the TestNG report attached
            emailext(
                to: 'kvengattan@bn.com',
                subject: "Build Success - TestNG Report",
                body: "The build has completed successfully! Please find the attached TestNG report.",
                attachLog: true,  // Attach Jenkins console log (optional)
                attachmentsPattern: '**/target/surefire-reports/emailable-report.html',  // Attach the generated report
                mimeType: 'text/html'  // Ensure the correct mime type for HTML
            )
        }

        failure {
            echo 'The pipeline has failed.'

            // Send failure email (you can adjust content as needed)
            emailext(
                to: 'kvengattan@bn.com',
                subject: "Build Failed - TestNG Report",
                body: "The build has failed. Please find the details in the attached report.",
                attachLog: true,  // Attach Jenkins console log (optional)
                attachmentsPattern: '**/target/surefire-reports/emailable-report.html',  // Attach the generated report
                mimeType: 'text/html'  // Ensure the correct mime type for HTML
            )
        }

        always {
            cleanWs()  // Clean workspace after the build, after email is sent
        }
    }
}

















