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
                    sh script: 'mvn clean install', returnStatus: true
                }
            }
        }

        stage('Publish Test Results') {
            steps {
                echo "Publishing test results..."
                
                // Publish JUnit (or TestNG) results
                junit '**/target/test-*.xml'  // This works for both JUnit and TestNG results
            }
        }
    }

    post {
        always {
            cleanWs()  // Clean workspace after the build
        }
        success {
            echo 'The pipeline has completed successfully.'
            
            // Send success email with attachment (TestNG report)
            emailext to: 'kvengattan@bn.com',
                     subject: "Build Success",
                     body: "The build has completed successfully!",
                     attachLog: true,  // Attach Jenkins log (optional)
                     attachmentsPattern: '**/target/surefire-reports/*.xml' // Attach the TestNG report(s)
        }
        failure {
            echo 'The pipeline has failed.'
            
            // Send failure email with attachment (TestNG report)
            emailext to: 'kvengattan@bn.com',
                     subject: "Build Failed",
                     body: "The build has failed.\n\nPlease check the build logs for more information.",
                     attachLog: true,  // Attach Jenkins log (optional)
                     attachmentsPattern: '**/target/surefire-reports/*.xml' // Attach the TestNG report(s)
            
            // Archive build logs in case of failure for easier debugging
            archiveArtifacts artifacts: '**/target/*.log', allowEmptyArchive: true
        }
    }
}

















