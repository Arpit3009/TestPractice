package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.assertTrue;
//@Ignore
public class TestngTest {

    @Test(priority = 0, enabled = true, timeOut = 10000)
    @Parameters({"a", "b"})
    public void firstTest(String at, @Optional("hj") String bt){
        System.out.println("first test");
        System.out.println(at);
        System.out.println(bt);

    }

//    @Ignore
    @Test(priority = 1, groups = {"sanity", "smoke"})
    public void afirstTestb(){
        System.out.println("afirstb test");
//        assertTrue(false);
//        SoftAssert sa = new SoftAssert();
    }

    @Test(priority = 0, dependsOnGroups = {"sanity"})
    public void afirstTesta(){
        System.out.println("afirsta test");
    }


    @Test(dataProvider = "giveData2")
    public void testDataProvider(String s){
        System.out.println(s);
    }

    @DataProvider(name = "giveData2", parallel = true)
    public Object[][] giveData(){
        return new Object[][]{{"2"}, {"5"}, {"h"}, {"jh"}};
    }

    @Test(dataProvider = "gg", dataProviderClass = DataProviderStatic.class)
    public void testDataProviderStatic(int s, int u){
        System.out.println(s+u);
    }

    @Test
    public void webTest(){
        System.out.println( "Hello World!" );
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--start-maximized");
        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demo.nopcommerce.com/");
        System.out.println("Current url : " + driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equals("https://demo.nopcommerce.com/"));
    }



//    pipeline {
//        agent any
//
//
//        tools {
//            maven 'Maven'     // Name must match what you configured in Jenkins (Manage Jenkins → Global Tool Configuration)
//        }
//
//        stages {
//            // stage('Install Chrome & Driver') {
//            //     steps {
//            //         sh '''
//            //             apt-get update
//            //             apt-get install -y chromium-browser unzip wget
//            //             wget https://storage.googleapis.com/chrome-for-testing-public/114.0.5735.90/linux64/chromedriver-linux64.zip
//            //             unzip chromedriver-linux64.zip
//            //             chmod +x chromedriver-linux64/chromedriver
//            //             mv chromedriver-linux64/chromedriver /usr/local/bin/
//            //         '''
//            //     }
//            // }
//
//
//            stage('Build') {
//                agent {
//                    docker { image 'selenium/standalone-chrome:with-node'
//
//                    }
//                }
//                steps {
//                    // Get some code from a GitHub repository
//                    git 'https://github.com/Arpit3009/TestPractice.git'
//
//                    // Run Maven on a Unix agent.
//                    // sh "mvn -Dmaven.test.failure.ignore=true clean package"
//                    sh "mvn clean test"
//
//                    // To run Maven on a Windows agent, use
//                    // bat "mvn -Dmaven.test.failure.ignore=true clean package"
//                }
//
//
//                post {
//                    // If Maven was able to run the tests, even if some of the test
//                    // failed, record the test results and archive the jar file.
//                    success {
//                        junit '**/target/surefire-reports/TEST-*.xml'
//                        // archiveArtifacts 'target/*.jar'
//                    }
//                }
//            }
//            stage('Publish TestNG Report') {
//                steps {
//                    // testNG reportFilenamePattern: '**/test-output/*.xml'
//                    archiveArtifacts artifacts: 'test-output/**/*.*', allowEmptyArchive: true
//                }
//            }
//
//        }
//    }


    //install chrome in jenkins container
//    apt-get install -y wget
//    wget -q https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
//    apt-get install -y ./google-chrome-stable_current_amd64.deb


    //Parameterized pipeline

//    pipeline {
//        agent any
//
//        parameters {
//            choice(name: 'PIPELINE_TO_RUN', choices: ['None', 'testingRepo', 'testingRepo2', 'gh'], description: 'Choose pipeline to trigger')
//        }
//
//        stages {
//            stage('Trigger Selected Pipeline') {
//                steps {
//                    script {
//                        if (params.PIPELINE_TO_RUN == 'testingRepo') {
//                            build job: 'testingRepo'
//                        } else if (params.PIPELINE_TO_RUN == 'testingRepo2') {
//                            build job: 'testingRepo2'
//                        } else if (params.PIPELINE_TO_RUN == 'gh') {
//                            build job: 'gh'
//                        } else {
//                            echo 'No pipeline selected.'
//                        }
//                    }
//                }
//            }
//        }
//    }


    //Multiple pipeline in one

//    pipeline {
//        agent any
//
//        stages {
//            stage('Build Project A') {
//                steps {
//                    build job: 'testingRepo'
//                }
//            }
//            stage('Build Project B') {
//                steps {
//                    build job: 'testingRepo2'
//                }
//            }
//            stage('Build Project C') {
//                steps {
//                    build job: 'gh'
//                }
//            }
//        }
//    }


    //run pipeline on user approval
//    pipeline {
//        agent any
//
//        stages {
//            stage('Trigger Pipeline A') {
//                steps {
//                    echo 'Running Pipeline A...'
//                    build job: 'testingRepo'
//                }
//            }
//
//            stage('Wait for Approval Before B') {
//                steps {
//                    input message: 'Run Pipeline B?', ok: 'Proceed'
//                }
//            }
//
//            stage('Trigger Pipeline B') {
//                steps {
//                    echo 'Running Pipeline B...'
//                    build job: 'testingRepo2'
//                }
//            }
//
//            stage('Wait for Approval Before C') {
//                steps {
//                    input message: 'Run Pipeline C?', ok: 'Proceed'
//                }
//            }
//
//            stage('Trigger Pipeline C') {
//                steps {
//                    echo 'Running Pipeline C...'
//                    build job: 'gh'
//                }
//            }
//        }
//    }






}
