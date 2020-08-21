pipeline {

	agent any

	options {
		disableConcurrentBuilds()
	}

	triggers {
		cron('H H * * *')
	}

	stages {
		stage('Build') {
			steps {
				dir('ws-training') {
					sh 'chmod +x mvnw'
					sh './mvnw package'
				}
			}
		}
	}
	post {
		always {
			junit 'ws-training/target/surefire-reports/*/.xml'
		}
	}
}
