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
        always {
            cleanWs()  // Clean workspace after the build
        }

        success {
            echo 'The pipeline has completed successfully.'
            
            // Send success email with attachments (TestNG reports)
            mail to: 'kvengattan@bn.com',
                 subject: "Build Success",
                 body: "The build has completed successfully!\n\nPlease find the attached TestNG report.",
                 attachFiles: '**/target/surefire-reports/*.html'  // Attach HTML reports
        }

        failure {
            echo 'The pipeline has failed.'
            
            // Send failure email with attachments (TestNG report or emailable report)
            mail to: 'kvengattan@bn.com',
                 subject: "Build Failed",
                 body: "The build has failed.\n\nPlease check the build logs for more information.",
                 attachFiles: '**/target/surefire-reports/emailable-report.html'  // Attach the emailable report
        }
    }
}

























