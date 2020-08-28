import {html, render} from '/webjars/lit-html/lit-html.js'
import {repeat} from '/webjars/lit-html/directives/repeat.js'

const projectTemplate = (projects) => html`
	${repeat(projects, (project, index) => html`
		<div class="col-xl-6">
			<div class="row">
				<div class="col-lg-6 buttonSquareColumn "><div class="buttonSquare ${project.devColor ? project.devColor : ''} "><i class="fa fa-cog"></i><span>${project.jobName}</span></div></div>
				<div class="col-sm-4 col-lg-2 buttonSquareColumn "><div class="buttonSquare ${project.stableColor ? project.stableColor : ''} "><i class="fa fa-code-branch"></i><span>stable</span></div></div>
				<div class="col-sm-4 col-lg-2 buttonSquareColumn "><div class="buttonSquare ${project.stageColor ? project.stageColor : ''} "><i class="fa fa-code-branch"></i><span>stage</span></div></div>
				<div class="col-sm-4 col-lg-2 buttonSquareColumn "><div class="buttonSquare ${project.prodColor ? project.prodColor : ''} "><i class="fa fa-code-branch"></i><span>prod</span></div></div>
			</div>
		</div>
	`)}
`;

$(document).ready(function() {

	var socket = new SockJS("/jenkinsTracker");
	var stompClient = Stomp.over(socket);

	stompClient.connect({}, function() {
		stompClient.subscribe("/topic/jenkinsTracker", onMessage);
	});
});



function onMessage(message) {
	if (0 == parseInt(message.body)) {
		taflan()
	}



}

if (performance.navigation.type == performance.navigation.TYPE_NAVIGATE) {
	taflan();
}

if(performance.navigation.type == performance.navigation.TYPE_RELOAD){
	taflan();
}


function taflan() {


	var xhttp = new XMLHttpRequest();
	xhttp.open("GET", "http://localhost:8080/api", true);
	xhttp.send();

	xhttp.addEventListener("readystatechange", hostRequestListener, false);

	xhttp.onreadystatechange = hostRequestListener;

	function hostRequestListener() {

		if (xhttp.readyState == 4 && xhttp.status == 200) {
		

			
			var dashboardData = JSON.parse(xhttp.responseText);
		

			dashboardData = mergeSort(dashboardData);
			dashboardData.reverse();
			render(projectTemplate(dashboardData), document.getElementById('projects'));
		}

	}

}




function merge(left, right) {
	let arr = [];

	while (left.length && right.length) {

		if (left[0].score < right[0].score) {
			arr.push(left.shift());
		}
		else {
			arr.push(right.shift());
		}
	}
	return arr.concat(left.slice().concat(right.slice()));
}

function mergeSort(arr) {
	if (arr.length < 2) {
		return arr;
	}

	const middle = Math.floor(arr.length / 2);
	const left = arr.slice(0, middle);
	const right = arr.slice(middle);

	return merge(mergeSort(left), mergeSort(right));
}


