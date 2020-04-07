def call(){
    node {
        stage('Checkout') {
            checkout scm
        }

        // Execute different stages depending on the job
		
		packageArtifact()
		test()
		sonarScan()
    }
}

def packageArtifact(){
    stage("Package artifact") {
       def mvnHome = "E:/Jenkins/tools/hudson.tasks.Maven_MavenInstallation/Maven"
       bat "${mvnHome}/bin/mvn.cmd compile"
       bat "${mvnHome}/bin/mvn.cmd package"
    }
}

def Test(){
    stage("Backend tests"){
       def mvnHome = "E:/Jenkins/tools/hudson.tasks.Maven_MavenInstallation/Maven"
       bat "${mvnHome}/bin/mvn.cmd test"
    }
}
	
def sonarScan(){
    stage("Sonar scan"){
        bat "mvn sonar:sonar"
    }
}
