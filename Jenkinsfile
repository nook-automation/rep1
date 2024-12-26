pipeline {
    agent any

    environment {
        JAVA_HOME = '/Library/Java/JavaVirtualMachines/jdk-11.jdk/Contents/Home'
        M2_HOME = '/Applications/apache-maven-3.8.6'
        PATH = "${JAVA_HOME}/bin:${M2_HOME}/bin:${PATH}"
        DEVICE_NAME = 'Iphone 13'
        DEVICE_OS = '16.5.1'
        DEVICE_UDID = '00008110-001A4DCA3A81401E'
        TESTRAIL_URL = 'https://nook.testrail.com/index.php?/runs/view/91648&group_by=cases:section_id&group_order=asc'
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
            
            // Print device details in the success section
            echo "Device Name: ${env.DEVICE_NAME}"
            echo "Device OS: ${env.DEVICE_OS}"
            echo "Device UDID: ${env.DEVICE_UDID}"
            echo "TestRail URL: ${env.TESTRAIL_URL}"

            script {
                def reportFilePattern = '**/target/surefire-reports/emailable-report.html'
                if (fileExists("${env.WORKSPACE}/target/surefire-reports/emailable-report.html")) {
                    emailext(
                        subject: 'Build Success',
                        body: "The build has completed successfully! Please find the attached emailable report.\n\nDevice Details:\nDevice Name: ${env.DEVICE_NAME}\nDevice OS: ${env.DEVICE_OS}\nDevice UDID: ${env.DEVICE_UDID}\nTestRail URL: ${env.TESTRAIL_URL}",
                        attachmentsPattern: reportFilePattern, // GLOB pattern
                        to: 'kvengattan@bn.com,ssidharthan@bn.com'
                    )
                } else {
                    echo "Emailable report not found at ${env.WORKSPACE}/target/surefire-reports/emailable-report.html"
                }
            }
        }

        failure {
            echo 'The pipeline has failed.'

            // Print device details in the failure section
            echo "Device Name: ${env.DEVICE_NAME}"
            echo "Device OS: ${env.DEVICE_OS}"
            echo "Device UDID: ${env.DEVICE_UDID}"
            echo "TestRail URL: ${env.TESTRAIL_URL}"

            script {
                def reportFilePattern = '**/target/surefire-reports/emailable-report.html'
                if (fileExists("${env.WORKSPACE}/target/surefire-reports/emailable-report.html")) {
                    emailext(
                        subject: 'Build Failed',
                        body: "The build has failed. Please check the attached emailable report.\n\nDevice Details:\nDevice Name: ${env.DEVICE_NAME}\nDevice OS: ${env.DEVICE_OS}\nDevice UDID: ${env.DEVICE_UDID}\nTestRail URL: ${env.TESTRAIL_URL}",
                        attachmentsPattern: reportFilePattern, // GLOB pattern
                        to: 'kvengattan@bn.com'
                    )
                } else {
                    echo "Emailable report not found at ${env.WORKSPACE}/target/surefire-reports/emailable-report.html"
                }
            }
        }
    }
}

































