pipeline {
    agent any

    environment {
        JAVA_HOME = '/Library/Java/JavaVirtualMachines/jdk-11.jdk/Contents/Home'
        M2_HOME = '/Applications/apache-maven-3.8.6'
        PATH = "${JAVA_HOME}/bin:${M2_HOME}/bin:${PATH}"
        TESTRAIL_URL = 'https://nook.testrail.com'
        TESTRAIL_USER = 'Kvengattan@bn.com'
        TESTRAIL_API_KEY = 'MXe4W9iAFAC5XsNq48Qe-maUHMcexc7.6XCejNgAK'
        TEST_RUN_ID = '91648'  // The test run ID for which you want the report
        REPORT_FILE_PATH = 'testrail-report.pdf'  // Or HTML, depending on the format
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

        stage('Fetch TestRail Report') {
            steps {
                script {
                    // Use the TestRail API to fetch the test run results
                    echo "Fetching TestRail Report..."
                    def apiUrl = "${env.TESTRAIL_URL}/index.php?/api/v2/get_results_for_run/${env.TEST_RUN_ID}"
                    def response = httpRequest(
                        acceptType: 'APPLICATION_JSON',
                        authentication: 'testrail-api-auth',  // Define this in Jenkins credentials
                        url: apiUrl,
                        validResponseCodes: '200'
                    )
                    // Parse the JSON response from TestRail
                    def jsonResponse = readJSON text: response.content

                    // Assuming the response contains the URL to download the report
                    def reportUrl = jsonResponse['results'][0]['url'] // Adjust based on your API response structure

                    // Use curl or wget to download the report (assuming PDF format)
                    sh "curl -o ${env.WORKSPACE}/${env.REPORT_FILE_PATH} ${reportUrl}"
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
        success {
            echo 'The pipeline has completed successfully.'

            // Send email with TestRail report
            script {
                def reportFile = "${env.WORKSPACE}/${env.REPORT_FILE_PATH}"
                if (fileExists(reportFile)) {
                    emailext(
                        subject: 'TestRail Report - Build Success',
                        body: 'The build has completed successfully! Please find the attached TestRail report.',
                        attachmentsPattern: reportFile,
                        to: 'kvengattan@bn.com'
                    )
                } else {
                    echo "TestRail report not found at ${reportFile}"
                }
            }
        }

        failure {
            echo 'The pipeline has failed.'

            // Send email with TestRail report on failure
            script {
                def reportFile = "${env.WORKSPACE}/${env.REPORT_FILE_PATH}"
                if (fileExists(reportFile)) {
                    emailext(
                        subject: 'TestRail Report - Build Failed',
                        body: 'The build has failed. Please check the attached TestRail report.',
                        attachmentsPattern: reportFile,
                        to: 'kvengattan@bn.com'
                    )
                } else {
                    echo "TestRail report not found at ${reportFile}"
                }
            }
        }
    }
}






























