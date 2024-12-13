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
                git branch: 'main', url: 'https://github.com/nook-automation/rep1.git'
            }
        }

        stage('Install Dependencies') {
            steps {
                script {
                    // Install dependencies using Maven and run tests as part of `mvn clean install`
                    echo "Installing dependencies and running tests with Maven..."
                    sh 'mvn clean install'
                }
            }
        }

        stage('Post Results') {
            steps {
                echo "Java automation script has finished running."
                
                // Publish TestNG results (adjust path as necessary)
                publishTestNGResults testResults: '**/target/test-*.xml'
            }
        }
    }

    post {
        always {
            cleanWs()  // Clean workspace after the build
        }
        success {
            echo 'The pipeline has completed successfully.'
            
            // Send success email (configure email server in Jenkins)
            mail to: 'kvengattan@bn.com',
             subject: "Build Success",
             body: "The build has completed successfully!"
        }
        failure {
            echo 'The pipeline has failed.'
            
            // Send failure email
            mail to: 'kvengattan@bn.com',
             subject: "Build Failed",
             body: "The build has failed.\n\nPlease check the build logs for more information."
        }
    }
}




