pipeline {
    agent any

    environment {
        JAVA_HOME = '/Library/Java/JavaVirtualMachines/jdk-11.jdk/Contents/Home'
        M2_HOME = '/Applications/apache-maven-3.8.6'
        PATH = "${JAVA_HOME}/bin:${M2_HOME}/bin:${PATH}"
        
        TESTRAIL_URL = 'https://nook.testrail.com'
        TESTRAIL_USER = 'Kvengattan@bn.com'
        TESTRAIL_API_KEY = 'MXe4W9iAFAC5XsNq48Qe-maUHMcexc7.6XCejNgAK'
        TEST_RUN_ID = '91648'  // Test Run ID from your link
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
                    echo "Fetching TestRail Report..."

                    // Initial request to get the first page of results
                    def apiUrl = "${env.TESTRAIL_URL}/index.php?/api/v2/get_results_for_run/${env.TEST_RUN_ID}"
                    def allResults = []
                    def nextPageUrl = apiUrl
                    
                    // Loop through pages if there are more results (pagination)
                    while (nextPageUrl) {
                        // Make the API request to TestRail
                        def response = httpRequest(
                            acceptType: 'APPLICATION_JSON',
                            authentication: 'testrail-api-auth',  // Jenkins credentials ID for TestRail
                            url: nextPageUrl,
                            validResponseCodes: '200'
                        )
                        
                        // Parse the JSON response from TestRail
                        def jsonResponse = readJSON text: response.content
                        allResults += jsonResponse.results  // Add results from this page to the allResults list
                        
                        // Get the next page URL
                        nextPageUrl = jsonResponse._links.next ? "${env.TESTRAIL_URL}${jsonResponse._links.next}" : null
                    }

                    // Initialize counters for passed and failed tests
                    def passedCount = 0
                    def failedCount = 0
                    def blockedCount = 0
                    def untestedCount = 0

                    def summary = "Test Run Summary\n\n"
                    allResults.each { result ->
                        def testStatus = "Unknown"
                        // Determine the test result status based on status_id
                        switch (result.status_id) {
                            case 1:
                                testStatus = "Passed"
                                passedCount++
                                break
                            case 5:
                                testStatus = "Failed"
                                failedCount++
                                break
                            case 2:
                                testStatus = "Blocked"
                                blockedCount++
                                break
                            case 3:
                                testStatus = "Untested"
                                untestedCount++
                                break
                            case 4:
                                testStatus = "Retest"
                                break
                            default:
                                testStatus = "Unknown"
                        }

                        // Add each test result to the summary
                        summary += "Test ID: ${result.test_id}, Status: ${testStatus}, Comment: ${result.comment}\n"
                    }

                    // Create a detailed summary of results
                    summary += "\nTotal Tests: ${allResults.size()}"
                    summary += "\nPassed: ${passedCount}"
                    summary += "\nFailed: ${failedCount}"
                    summary += "\nBlocked: ${blockedCount}"
                    summary += "\nUntested: ${untestedCount}"

                    // Save the full results as JSON
                    writeFile file: 'testrail-report.json', text: groovy.json.JsonOutput.prettyPrint(groovy.json.JsonOutput.toJson(allResults))

                    // Save the summary as a text file
                    writeFile file: 'testrail-report-summary.txt', text: summary

                    // Debug: List the contents of the current directory
                    sh 'ls -la'
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

            // Send email with raw TestRail results as attachment
            script {
                def reportFile = 'testrail-report.json'
                if (fileExists(reportFile)) {
                    emailext(
                        subject: 'TestRail Report - Build Success',
                        body: 'The build has completed successfully! Please find the attached TestRail JSON results.',
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

            // Send email with raw TestRail results on failure
            script {
                def reportFile = 'testrail-report.json'
                if (fileExists(reportFile)) {
                    emailext(
                        subject: 'TestRail Report - Build Failed',
                        body: 'The build has failed. Please check the attached TestRail JSON results.',
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
































