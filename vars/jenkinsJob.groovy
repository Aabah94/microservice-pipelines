def call(){
    node {
        stage('Checkout') {
            checkout scm
        }

        // Execute different stages depending on the job
		
	    compile()
	    sonarScan()
		
    }
}

def sonarScan(){
    stage("Sonar scan"){
       def mvnHome = "E:/Jenkins/tools/hudson.tasks.Maven_MavenInstallation/Maven"
       bat "${mvnHome}/bin/mvn.cmd sonar:sonar"
    }
}

def compile(){
    stage("Compile") {
       def mvnHome = "E:/Jenkins/tools/hudson.tasks.Maven_MavenInstallation/Maven"
       bat "${mvnHome}/bin/mvn.cmd compile"
    }
}
