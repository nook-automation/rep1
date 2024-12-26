pipeline {
    agent any

    environment {
        JAVA_HOME = '/Library/Java/JavaVirtualMachines/jdk-11.jdk/Contents/Home'
        M2_HOME = '/Applications/apache-maven-3.8.6'
        PATH = "${JAVA_HOME}/bin:${M2_HOME}/bin:${PATH}"
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
                def reportFilePattern = '**/target/surefire-reports/emailable-report.html'
                def deviceInfo = sh(script: 'hostname && uname -a', returnStdout: true).trim()  // Get hostname and OS details

                if (fileExists("${env.WORKSPACE}/target/surefire-reports/emailable-report.html")) {
                    emailext(
                        subject: "Build Success - #${currentBuild.number} - ${deviceInfo}",
                        body: """
                            The build has completed successfully!
                            Please find the attached emailable report.
                            
                            Build Number: #${currentBuild.number}
                            Job Name: ${env.JOB_NAME}
                            Build URL: ${env.BUILD_URL}
                            Device Info: ${deviceInfo}
                        """,
                        attachmentsPattern: reportFilePattern, // GLOB pattern
                        to: 'kvengattan@bn.com, ssidharthan@bn.com'
                    )
                } else {
                    echo "Emailable report not found at ${env.WORKSPACE}/target/surefire-reports/emailable-report.html"
                }
            }
        }

        failure {
            echo 'The pipeline has failed.'

            script {
                def reportFilePattern = '**/target/surefire-reports/emailable-report.html'
                def deviceInfo = sh(script: 'hostname && uname -a', returnStdout: true).trim()  // Get hostname and OS details

                if (fileExists("${env.WORKSPACE}/target/surefire-reports/emailable-report.html")) {
                    emailext(
                        subject: "Build Failed - #${currentBuild.number} - ${deviceInfo}",
                        body: """
                            The build has failed.
                            Please check the attached emailable report for details.
                            
                            Build Number: #${currentBuild.number}
                            Job Name: ${env.JOB_NAME}
                            Build URL: ${env.BUILD_URL}
                            Device Info: ${deviceInfo}
                        """,
                        attachmentsPattern: reportFilePattern, // GLOB pattern
                        to: 'kvengattan@bn.com, ssidharthan@bn.com'
                    )
                } else {
                    echo "Emailable report not found at ${env.WORKSPACE}/target/surefire-reports/emailable-report.html"
                }
            }
        }
    }
}
































