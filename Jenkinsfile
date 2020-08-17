pipeline {

	agent any

	options {
		disableConcurrentBuilds()
	}

	trigger {
		cron('H H * * *')
	}

	stages {
		stage('Build') {
			steps {
				dir('ws-training') {
					sh 'chmod +x mvnw'
					sh './mvnw build'
				}
			}
		}
	}
}
