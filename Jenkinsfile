pipeline{
    agent any
    tools{
        maven 'Maven'
    }
    stages{
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
    }
}