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
                    // Install dependencies using Maven and run tests
                    echo "Installing dependencies and running tests with Maven..."
                    sh 'mvn clean install'
                }
            }
        }

        stage('Generate HTML Report') {
            steps {
                script {
                    // Assume you have a custom HTML report generated at target/reports
                    echo "Generating HTML report..."
                    // Example command to generate HTML (if required, adjust based on your tool)
                    // sh 'mvn generate-report'  // if your tool generates an HTML report as part of build
                }
            }
        }

        stage('Archive HTML Report') {
            steps {
                script {
                    // Archive the HTML report to make it available as a build artifact
                    echo "Archiving HTML report..."
                    archiveArtifacts artifacts: '**/target/*.html', allowEmptyArchive: true
                }
            }
        }

        stage('Post Results') {
            steps {
                echo "Publishing HTML report..."

                // Publish HTML report (you can adjust the path if necessary)
                publishHTML(target: [
                    reportName: 'Custom HTML Test Report',
                    reportDir: 'target/reports',  // Path to your HTML reports
                    reportFiles: 'custom-report.html',  // Name of the HTML file
                    keepAll: false
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
            
            // Send success email
            mail to: 'kvengattan@bn.com',
                 subject: "Build Success",
                 body: "The build has completed successfully!"
        }
        failure {
            echo 'The pipeline has failed.'
            
            // Send failure email
            mail to: 'kvengattan@bn.com',
                 subject: "Build Failed",
                 body: "The build has failed.\n\nPlease check the build logs for more information."
        }
    }
}


















