pipeline {
    agent any

    environment {
        JAVA_HOME = '/Library/Java/JavaVirtualMachines/jdk-11.jdk/Contents/Home'
        M2_HOME = '/Applications/apache-maven-3.8.6'
        PATH = "${JAVA_HOME}/bin:${M2_HOME}/bin:${PATH}"
        TESTRAIL_URL = 'https://nook.testrail.com'
        TEST_RUN_ID = '91648'  // The test run ID for which you want the results
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

        stage('Fetch TestRail Results and Count Statuses') {
            steps {
                script {
                    echo "Fetching TestRail Results..."

                    // TestRail API URL to get results for the specified test run
                    def apiUrl = "${env.TESTRAIL_URL}/index.php?/api/v2/get_results_for_run/${env.TEST_RUN_ID}"

                    // Make the API request to TestRail
                    def response = httpRequest(
                        acceptType: 'APPLICATION_JSON',
                        authentication: 'testrail-api-auth',  // Ensure this is properly configured in Jenkins credentials
                        url: apiUrl,
                        validResponseCodes: '200'
                    )

                    // Parse the JSON response
                    def jsonResponse = readJSON text: response.content

                    // Initialize counters for each status type
                    def statusCounts = [
                        "Passed": 0,
                        "Blocked": 0,
                        "Untested": 0,
                        "Retest": 0,
                        "Failed": 0,
                        "Crash": 0,
                        "Server Error": 0,
                        "Not Support": 0,
                        "Not Applicable": 0
                    ]

                    // Iterate over the results and count the statuses
                    jsonResponse.results.each { result ->
                        switch(result.status_id) {
                            case 1:  // Passed
                                statusCounts["Passed"]++
                                break
                            case 2:  // Blocked
                                statusCounts["Blocked"]++
                                break
                            case 3:  // Untested
                                statusCounts["Untested"]++
                                break
                            case 4:  // Retest
                                statusCounts["Retest"]++
                                break
                            case 5:  // Failed
                                statusCounts["Failed"]++
                                break
                            case 6:  // Crash
                                statusCounts["Crash"]++
                                break
                            case 7:  // Server Error
                                statusCounts["Server Error"]++
                                break
                            case 8:  // Not Support
                                statusCounts["Not Support"]++
                                break
                            case 9:  // Not Applicable
                                statusCounts["Not Applicable"]++
                                break
                        }
                    }

                    // Output the counts to the Jenkins console in the requested format
                    echo """
                        Passed: ${statusCounts['Passed']}
                        Blocked: ${statusCounts['Blocked']}
                        Untested: ${statusCounts['Untested']}
                        Retest: ${statusCounts['Retest']}
                        Failed: ${statusCounts['Failed']}
                        Crash: ${statusCounts['Crash']}
                        Server Error: ${statusCounts['Server Error']}
                        Not Support: ${statusCounts['Not Support']}
                        Not Applicable: ${statusCounts['Not Applicable']}
                    """

                    // Optionally, store this data for use in a report, email, etc.
                    currentBuild.description = """
                        Passed: ${statusCounts['Passed']}, 
                        Blocked: ${statusCounts['Blocked']}, 
                        Failed: ${statusCounts['Failed']}
                    """
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
            script {
                emailext(
                    subject: 'TestRail Status Counts - Build Success',
                    body: """
                        The build has completed successfully. 
                        Test statuses:
                        Passed: ${statusCounts['Passed']}
                        Blocked: ${statusCounts['Blocked']}
                        Failed: ${statusCounts['Failed']}
                        Untested: ${statusCounts['Untested']}
                        Retest: ${statusCounts['Retest']}
                        Crash: ${statusCounts['Crash']}
                        Server Error: ${statusCounts['Server Error']}
                        Not Support: ${statusCounts['Not Support']}
                        Not Applicable: ${statusCounts['Not Applicable']}
                    """,
                    to: 'kvengattan@bn.com'
                )
            }
        }

        failure {
            echo 'The pipeline has failed.'
            script {
                emailext(
                    subject: 'TestRail Status Counts - Build Failed',
                    body: """
                        The build has failed. Please review the test statuses.
                        Passed: ${statusCounts['Passed']}
                        Blocked: ${statusCounts['Blocked']}
                        Failed: ${statusCounts['Failed']}
                        Untested: ${statusCounts['Untested']}
                        Retest: ${statusCounts['Retest']}
                        Crash: ${statusCounts['Crash']}
                        Server Error: ${statusCounts['Server Error']}
                        Not Support: ${statusCounts['Not Support']}
                        Not Applicable: ${statusCounts['Not Applicable']}
                    """,
                    to: 'kvengattan@bn.com'
                )
            }
        }
    }
}
































