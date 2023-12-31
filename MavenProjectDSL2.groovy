def createMavenJob(jobName, scmUrl, scmBranch, cronExpression) {
    job(jobName) {
        logRotator(-1, 1)
        description("Maven job generated by the DSL on ${new Date()}, the project is a maven project hosted on gitlab")
        
        scm {
            git(scmUrl, scmBranch)
        }
        
        triggers {
            scm(cronExpression)
        }
        
        steps {
            maven('clean package', 'pom.xml')
        }
        
        publishers {
            archiveArtifacts '**/*.jar'
        }
    }
}

createMavenJob('First-Maven-Project-Via-DSLjob', 'https://github.com/lavkumar809/myrepo1.git', 'master', '* * * * *')
createMavenJob('Second-Maven-Project-Via-DSLjob', 'https://github.com/lavkumar809/myrepo1.git', 'master', '0 9 * * *')
