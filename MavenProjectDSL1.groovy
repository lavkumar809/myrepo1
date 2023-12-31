job( 'First-Maven-Project-Via-DSLjob') {
	logRotator(-1, 1)
    description("First maven job generated by the DSL on ${new Date()}, the project is a maven project hosted on gitlab")
	scm {
	    git("https://github.com/lavkumar809/myrepo1.git", "master")
	}
	triggers {
		scm('* * * * *')
		}
	steps {
		maven('clean package', 'pom.xml')
	}
    publishers {
        //archive the war file generated
        archiveArtifacts '**/*.jar'
    }
}
job( 'second-Maven-Project-Via-DSLjob') {
	logRotator(-1, 1)
    description("First maven job generated by the DSL on ${new Date()}, the project is a maven project hosted on gitlab")
	scm {
	    git("https://github.com/lavkumar809/myrepo1.git", "master")
	}
	triggers {
		scm('0 9 * * *')
		}
	steps {
		maven('clean package', 'pom.xml')
	}
    publishers {
        //archive the war file generated
        archiveArtifacts '**/*.jar'
    }
}
