def createTestJob(testName, repoUrl) {
    pipelineJob(testName) {
        definition {
            cpsScm {
                scm {
                    git {
                        remote {
                            url(repoUrl)
                        }
                        branches('master')
                        extensions {
                            cleanBeforeCheckout()
                        }
                    }
                }
                scriptPath("Jenkinsfile")
            }
        }
    }
}


def buildPipelineJobs() {
    def repo = "https://github.com/Aabah94/"
    def repoUrl = repo + jobName + ".git"
    def testName = jobName + "_test"

    createTestJob(testName, repoUrl)
}

buildPipelineJobs()
