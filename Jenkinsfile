pipeline {
    agent any

    environment {
        JAVA_HOME = '/Library/Java/JavaVirtualMachines/jdk-11.jdk/Contents/Home'
        M2_HOME = '/Applications/apache-maven-3.8.6'
        PATH = "${JAVA_HOME}/bin:${M2_HOME}/bin:${PATH}"
        TESTRAIL_API_URL = 'https://your-testrail-instance.com/index.php?/api/v2/get_run/'
        TESTRAIL_API_USER = 'Kvengattan@bn.com'
        TESTRAIL_API_KEY = 'G76ePR6uxA4xETkqmZu.-i1TIFkK/1sUinlnsd4OZ'  // If you're using an API key
        TEST_RUN_ID = '91648'  // ID of the test run you want to retrieve
    }

    stages {
        stage('Checkout Code') {
            steps {
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

        stage('Archive HTML Report') {
            steps {
                script {
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

        stage('Send TestRail Report') {
            steps {
                script {
                    // Fetch the TestRail report using the TestRail API
                    def testrailReport = fetchTestRailReport(TESTRAIL_API_URL, TEST_RUN_ID, TESTRAIL_API_USER, TESTRAIL_API_KEY)

                    // Send the report via email
                    sendEmailReport(testrailReport)
                }
            }
        }
    }

    post {
        always {
            cleanWs()
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

def fetchTestRailReport(apiUrl, testRunId, user, apiKey) {
    def url = "${apiUrl}${testRunId}"
    def response = httpRequest acceptType: 'APPLICATION_JSON',
                               authentication: 'TestRailCredentials', // You can configure this credential in Jenkins
                               url: url
    def result = readJSON text: response.content
    return result
}

def sendEmailReport(testrailReport) {
    // Format the TestRail report into a simple HTML message or plain text
    def reportHtml = "<html><body>"
    reportHtml += "<h2>TestRail Report</h2>"
    reportHtml += "<p>Status: ${testrailReport.status}</p>"
    reportHtml += "<p>Details: ${testrailReport.details}</p>"
    reportHtml += "</body></html>"

    // Send the email with the report
    mail to: 'kvengattan@bn.com', 
         subject: "TestRail Report for Test Run", 
         body: reportHtml
}





















