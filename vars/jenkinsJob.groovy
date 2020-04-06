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
        def mvnHome = "E:/Jenkins/tools/hudson.tasks.Maven_MavenInstallation/Maven"
        bat "${mvnHome}/bin/mvn.cmd package"
    }
}

def buildAndTest(){
    stage("Backend tests"){
        def mvnHome = "E:/Jenkins/tools/hudson.tasks.Maven_MavenInstallation/Maven"
        bat "${mvnHome}/bin/mvn.cmd test"
    }
}
