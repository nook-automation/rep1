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
                // Checkout code from Git repository
                git branch: 'master', url: 'https://github.com/nook-automation/rep1.git'
            }
        }

        stage('Install Dependencies') {
            steps {
                script {
                    // Install dependencies using Maven and run tests as part of `mvn clean install`
                    echo "Installing dependencies and running tests with Maven..."
                    sh 'mvn clean install'
                }
            }
        }

        stage('Generate Emailable Report') {
            steps {
                script {
                    // Generate the emailable report
                    echo "Generating emailable report..."
                    sh 'mvn surefire-report:report'
                }
            }
        }

        stage('Post Results') {
            steps {
                echo "Java automation script has finished running."
                
                // Publish the emailable report (assuming it's generated in the surefire-reports directory)
                archiveArtifacts artifacts: 'target/surefire-reports/emailable-report.html', allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            cleanWs()  // Clean workspace after the build
        }
        success {
            echo 'The pipeline has completed successfully.'
            
            // Send success email with the emailable report
            emailext(
                subject: "Build Success",
                body: "The build has completed successfully! Please find the report attached.",
                to: "kvengattan@bn.com",
                attachmentsPattern: "target/surefire-reports/emailable-report.html"
            )
        }
        failure {
            echo 'The pipeline has failed.'
            
            // Send failure email with the emailable report (if available)
            emailext(
                subject: "Build Failed",
                body: "The build has failed. Please find the report attached for more details.",
                to: "kvengattan@bn.com",
                attachmentsPattern: "target/surefire-reports/emailable-report.html"
            )
        }
    }
}






