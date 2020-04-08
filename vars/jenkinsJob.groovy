def call(){
    node {
        stage('Checkout') {
            checkout scm
        }

        // Execute different stages depending on the job
		
		compile()
		test()
		sonarScan()
    }
}

def compile(){
    stage("Comiple") {
       def mvnHome = "E:/Jenkins/tools/hudson.tasks.Maven_MavenInstallation/Maven"
       bat "${mvnHome}/bin/mvn.cmd compile"
    }
}

def test(){
    stage("Backend tests"){
       def mvnHome = "E:/Jenkins/tools/hudson.tasks.Maven_MavenInstallation/Maven"
       bat "${mvnHome}/bin/mvn.cmd test"
    }
}
	
def sonarScan(){
    stage("Sonar scan"){
       def mvnHome = "E:/Jenkins/tools/hudson.tasks.Maven_MavenInstallation/Maven"
       bat "${mvnHome}/bin/mvn.cmd sonar:sonar"
    }
}
