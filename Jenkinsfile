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
                
                // Get the next page URL correctly using 'next' link from the response
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

































