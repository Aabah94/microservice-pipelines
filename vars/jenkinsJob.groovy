def call(){
    node {
        stage('Checkout') {
            checkout scm
        }

        // Execute different stages depending on the job
        if(env.JOB_NAME.contains("deploy")){
            packageArtifact()
        } else if(env.JOB_NAME.contains("test")) {
            buildAndTest()
        }
    }
}

def packageArtifact(){
    stage("Package artifact") {
        def mvnHome = "C:/Users/Aabha.Verma/Downloads/apache-maven-3.6.3-bin/apache-maven-3.6.3"
        bat "${mvnHome}/bin/mvn.cmd package"
    }
}

def buildAndTest(){
    stage("Backend tests"){
        def mvnHome = "C:/Program Files (x86)/Jenkins/tools/hudson.tasks.Maven_MavenInstallation/Maven"
        bat "mvn test"
    }
}
