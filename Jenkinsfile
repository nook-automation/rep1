pipeline {
    agent any

    environment {
        JAVA_HOME = '/Library/Java/JavaVirtualMachines/jdk-11.jdk/Contents/Home'
        M2_HOME = '/Applications/apache-maven-3.8.6'
        PATH = "${JAVA_HOME}/bin:${M2_HOME}/bin:${PATH}"
        API_URL = 'https://nook.testrail.com/index.php?/api/v2/get_run/91648' // Correct TestRail API URL
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
                    echo "Installing dependencies and running tests with Maven..."
                    sh 'mvn clean install'
                }
            }
        }

        stage('Send TestRail Report') {
            steps {
                script {
                    // Send the TestRail report using the correct API URL
                    echo "Sending request to TestRail API..."
                    def response = httpRequest acceptType: 'APPLICATION_JSON',
                                               authentication: 'TestRailCredentials', // Ensure you have set up TestRail credentials in Jenkins
                                               url: "${API_URL}"
                    echo "Response from TestRail: ${response}"
                }
            }
        }

        stage('Archive HTML Report') {
            steps {
                script {
                    // Archive the specific HTML report
                    echo "Archiving HTML report from target/surefire-reports/emailable-report.html"
                    archiveArtifacts artifacts: 'target/surefire-reports/emailable-report.html', allowEmptyArchive: true
                }
            }
        }

        stage('Publish HTML Report') {
            steps {
                echo "Publishing HTML report..."
                publishHTML(target: [
                    reportName: 'Emailable Test Report',
                    reportDir: 'target/surefire-reports',
                    reportFiles: 'emailable-report.html',
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
            mail to: 'kvengattan@bn.com', subject: "Build Success", body: "The build has completed successfully!"
        }
        failure {
            echo 'The pipeline has failed.'
            mail to: 'kvengattan@bn.com', subject: "Build Failed", body: "The build has failed.\n\nPlease check the build logs for more information."
        }
    }
}






















