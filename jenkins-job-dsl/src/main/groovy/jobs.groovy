
def folders = ['dev', 'stable', 'stage', 'prod']

folders.each { folder ->

	for (int i = 1; i < 151; i++) {

		queue(pipelineJob("$folder/ws-training-" + "$i".padLeft(3, '0')) {
			definition {
				cpsScm {
					scm {
						git {
							remote {
								url('https://github.com/CodeCoder96/CC96.git')
							}
							branch('refs/heads/master')
						}
					}
					lightweight()
				}
			}
		})
	}
}
