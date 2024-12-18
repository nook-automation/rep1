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

        stage('Generate Emailable Report') {
            steps {
                echo "Generating Emailable Report..."
                
                // Run Maven surefire report plugin to generate emailable-report.html
                sh 'mvn surefire-report:report'
            }
        }
    }

    post {
        always {
            cleanWs()  // Clean workspace after the build
        }
        success {
            echo 'The pipeline has completed successfully.'
            
            // Send success email with emailable-report.html attached
            emailext to: 'kvengattan@bn.com',
                     subject: "Build Success",
                     body: "The build has completed successfully!",
                     attachLog: true,  // Attach Jenkins log (optional)
                     attachmentsPattern: '**/target/surefire-reports/emailable-report.html' // Attach the emailable report
        }
        failure {
            echo 'The pipeline has failed.'
            
            // Send failure email with emailable-report.html attached
            emailext to: 'kvengattan@bn.com',
                     subject: "Build Failed",
                     body: "The build has failed.\n\nPlease check the build logs for more information.",
                     attachLog: true,  // Attach Jenkins log (optional)
                     attachmentsPattern: '**/target/surefire-reports/emailable-report.html' // Attach the emailable report
            
            // Archive build logs in case of failure for easier debugging
            archiveArtifacts artifacts: '**/target/*.log', allowEmptyArchive: true
        }
    }
}

















