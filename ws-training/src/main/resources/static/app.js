var dataModel = []



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


function taflan() {


	var xhttp = new XMLHttpRequest();
	xhttp.open("GET", "http://localhost:8080/api", true);
	xhttp.send();

	xhttp.addEventListener("readystatechange", hostRequestListener, false);

	xhttp.onreadystatechange = hostRequestListener;

	function hostRequestListener() {

		if (xhttp.readyState == 4 && xhttp.status == 200) {
			var messageList = $('#noticeTbody');

			str = xhttp.responseText;
			
			
			
			dashboardData = str.split("},")
			for (i = 0; i < dashboardData.length; i++) {
				if (i == 0) {
					dashboardData[i] = dashboardData[i].replace("[ ", "");
					dashboardData[i] = dashboardData[i] + " }";
					dashboardData[i] = JSON.parse(dashboardData[i]);
					continue;
				}
				if (i == dashboardData.length - 1) {
					dashboardData[i] = dashboardData[i].replace(" ]", "");
					dashboardData[i] = JSON.parse(dashboardData[i]);
					continue;
				}
				dashboardData[i] = dashboardData[i] + " }";
				dashboardData[i] = JSON.parse(dashboardData[i]);
			}
			dashboardData = mergeSort(dashboardData);
			dashboardData.reverse();
			for (i = 0; i < dashboardData.length; i++) {
				messageList.append("<tr><td>" + dashboardData[i].jobName + "</td><td>" + dashboardData[i].devColor + "</td><td>" + dashboardData[i].stableColor + "</td><td>" + dashboardData[i].stageColor + "</td><td>" + dashboardData[i].prodColor + "</td></tr>");
			}

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



