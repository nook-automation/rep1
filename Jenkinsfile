pipeline {
    agent any
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
                echo "Build complete. Sending email with report..."
            }
        }
    }

    post {
        success {
            echo 'The pipeline has completed successfully.'
            
            script {
                emailext (
                    subject: "Build Success - TestNG Report",
                    body: "The build has completed successfully! Please find the attached TestNG report.",
                    to: "kvengattan@bn.com",
                    smtpHost: "smtp-mail.outlook.com",  // Replace with your SMTP host
                    mimeType: "text/html",
                    from: "bjanakiraman@bn.com",  // Replace with your sender email
                    authUser: "bjanakiraman@bn.com",  // Replace with your SMTP user
                    authPassword: "Autumn@Nov2024!",  // Replace with your SMTP password
                    attachmentsPattern: '**/target/surefire-reports/*.html',  // Attach the generated report
                    attachLog: true  // Attach Jenkins console log (optional)
                )
            }
        }

        failure {
            echo 'The pipeline has failed.'

            script {
                emailext (
                    subject: "Build Failed - TestNG Report",
                    body: "The build has failed. Please find the details in the attached report.",
                    to: "kvengattan@bn.com",
                    smtpHost: "smtp-mail.outlook.com",  // Replace with your SMTP host
                    mimeType: "text/html",
                    from: "bjanakiraman@bn.com",  // Replace with your sender email
                    authUser: "bjanakiraman@bn.com",  // Replace with your SMTP user
                    authPassword: "Autumn@Nov2024!",  // Replace with your SMTP password
                    attachmentsPattern: '**/target/surefire-reports/emailable-report.html',  // Attach the generated report
                    attachLog: true  // Attach Jenkins console log (optional)
                )
            }
        }
    }
}
























