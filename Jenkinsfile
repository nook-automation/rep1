pipeline {
    agent any
    
    environment {
        JAVA_HOME = tool name: 'JDK 11', type: 'JDK'  // Use Jenkins tool configuration for Java
        M2_HOME = tool name: 'Maven 3.8.6', type: 'Maven'  // Use Jenkins tool configuration for Maven
        PATH = "${JAVA_HOME}/bin:${M2_HOME}/bin:${PATH}"  // Add Maven bin to PATH
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
                    // Run Maven install (could also add -DskipTests if needed)
                    sh 'mvn clean install'
                }
            }
        }

        stage('Post Results') {
            steps {
                echo "Java automation script has finished running."
                // Publish TestNG results
                publishTestNGResults testResults: '**/target/test-*.xml'  // Adjust path as necessary
            }
        }
    }

    post {
        always {
            cleanWs()  // Clean workspace after the build
        }
        success {
            echo 'The pipeline has completed successfully.'
            // Send success email (you need to configure email server first)
            mail to: 'kvengattan@bn.com',
                 subject: "Build Success: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Build ${env.BUILD_NUMBER} has completed successfully!\n\nJob URL: ${env.BUILD_URL}"
        }
        failure {
            echo 'The pipeline has failed.'
            // Send failure email
            mail to: 'kvengattan@bn.com',
                 subject: "Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Build ${env.BUILD_NUMBER} has failed.\n\nJob URL: ${env.BUILD_URL}\n\nPlease check the build logs for more information."
        }
    }
}




