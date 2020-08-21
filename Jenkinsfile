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
					catchError{
						sh './mvnw -Dmaven.test.failure.ignore=true package'
					}
					
				}
			}
		}
	}
	post {
		always {
			junit 'ws-training/target/surefire-reports/**/*.xml'
		}
	}
}
