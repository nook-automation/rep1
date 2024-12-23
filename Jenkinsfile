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

                    // Construct the API URL to fetch test results from TestRail
                    def apiUrl = "${env.TESTRAIL_URL}/index.php?/api/v2/get_results_for_run/${env.TEST_RUN_ID}"
                    
                    // Make the API request to TestRail (using authentication)
                    def response = httpRequest(
                        acceptType: 'APPLICATION_JSON',
                        authentication: 'testrail-api-auth',  // Jenkins credentials ID for TestRail
                        url: apiUrl,
                        validResponseCodes: '200'
                    )
                    
                    // Check the response content
                    echo "API Response: ${response.content}"

                    // Parse the JSON response from TestRail
                    def jsonResponse = readJSON text: response.content
                    
                    // Save the JSON to a file (optional)
                    writeFile file: 'testrail-report.json', text: groovy.json.JsonOutput.prettyPrint(groovy.json.JsonOutput.toJson(jsonResponse))
                    
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































