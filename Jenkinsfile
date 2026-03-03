pipeline{
    agent any
    tools{
        maven 'Maven'
    }
    stages{
        stage('Checkout'){
            steps{
                checkout scm
            }
        }
        stage('Build'){
            steps{
                sh 'mvn clean verify'
            }
        }
        stage('SonarQube Analysis'){
            steps{
                withSonarQubeEnv('LocalSonar'){
                    sh 'mvn sonar:sonar'
                }
            }
        }
        stage('Quality Gate'){
            steps{
                timeout(time:2, unit:'MINUTES'){
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        stage('Docker Build'){
            steps{
                sh 'docker build -t task_manager_api .'
            }
        }
        stage('Trivy Scan'){
            steps{
                sh 'trivy image --exit-code 1 --severity HIGH,CRITICAL task_manager_api'
            }
        }
        stage('Deploy'){
            steps{
                echo 'Deploying Application..'
            }
        }
    }
}