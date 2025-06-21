pipeline{
    agent any
    tools{
        maven 'maven'
    }

    stages{
//         stage('Checkout'){
//             steps{
//                 git 'https://github.com/Arpit3009/TestPractice'
//             }
//         }
        stage('Run test'){
            steps{
                sh 'mvn clean test'
            }
//             post{
//                 success{
//                     junit '**/target/surefire-reports/TEST-*.xml'
//                 }
//             }
        }
        stage('publish result'){
            steps{
                junit '**/target/surefire-reports/TEST-*.xml'
            }
        }
    }
}