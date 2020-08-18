var dataModel = []



$(document).ready(function() {

	/*
	
		var socket = new SockJS("/jenkinsTracker");
	
		var stompClient = Stomp.over(socket);
	
		stompClient.connect({}, function() {
			
			stompClient.subscribe("/topic/jenkinsTracker",onMessage);
			//messageList.append("<tr><td>"+mysubid+"</td></tr>");
			
		});
		*/

});

/** function(data) {
			var message = data.body;
			
			dataModel.push(message);
			//dataModel = countingSort(dataModel);
			
			//messageList.append("<tr><td>"+dataModel+"</td></tr>");
			//messageList.append("<tr><td>" + message[0] + "</td><td>" + message[1] + "</td><td>" + message[2] + "</td><td>" + message[3] + "</td><td>" + message[4] + "</td><td>" + message[5] + "</td></tr>");
		},{id: mysubid} */

function onMessage(message) {

	//var messageList = $('#noticeTbody');
	//let str = message.body;
	//getDashboardDatas();
	/*dataModel.push(str);
	
	dataModel = str.split("},")
	for(i=0;i<dataModel.length;i++){
		if(i==0){
			dataModel[i]=dataModel[i].replace("[ ","");
			dataModel[i]=dataModel[i]+" }";
			dataModel[i]=JSON.parse(dataModel[i]);
			continue;
		}
		if(i==dataModel.length-1){
			dataModel[i]=dataModel[i].replace(" ]","");
			dataModel[i]=JSON.parse(dataModel[i]);
			continue;
		}
		dataModel[i]=dataModel[i]+" }";
		dataModel[i]=JSON.parse(dataModel[i]);
	}
	dataModel=mergeSort(dataModel);
	dataModel.reverse();
	for(i=0;i<dataModel.length;i++){
		messageList.append("<tr><td>"+dataModel[i].jobName+"</td><td>"+dataModel[i].devColor+"</td><td>"+dataModel[i].stableColor+"</td><td>"+dataModel[i].stageColor+"</td><td>"+dataModel[i].prodColor+"</td><td>"+dataModel[i].score+"</td></tr>");
	}*/

}


var xhttp = new XMLHttpRequest();
xhttp.open("GET", "http://localhost:8080/api", true);
xhttp.send();

xhttp.addEventListener("readystatechange", hostRequestListener, false);

xhttp.onreadystatechange = hostRequestListener;

function hostRequestListener() {

	if (xhttp.readyState == 4 && xhttp.status == 200) {
		//document.getElementById("getDatasBtn").innerHTML = this.responseText;
		var messageList = $('#noticeTbody');
		
		//messageList.append("<tr><td>" + xhttp.responseText + "</td></tr>");
		str = xhttp.responseText;
		dashboardData = str.split("},")
		//messageList.append("<tr><td>" + dashboardData + "</td></tr>");
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
			messageList.append("<tr><td>" + dashboardData[i].jobName + "</td><td>" + dashboardData[i].devColor + "</td><td>" + dashboardData[i].stableColor + "</td><td>" + dashboardData[i].stageColor + "</td><td>" + dashboardData[i].prodColor + "</td><td>" + dashboardData[i].score + "</td></tr>");
		}
		
	}

}


//ajax request atan method yaz. /api endpointine e istek atacak

function initDashboardData(dashboardData) {

	return dashboardData;
}



// top-down implementation
function merge(left, right) {
	let arr = [];

	while (left.length && right.length) {
		if (left[0].score < right[0].score) {
			arr.push(left.shift());
		} else {
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


/*$(document).ready(function (){
	var messageListDash = $("#noticeTbodyaa");

	var socketDash = new SockJS("/init");

	var stompClientDash = Stomp.over(socketDash);

	stompClientDash.connect({},function(){
		stompClientDash.subscribe("/dashboard/init",function(data){
			var messageDash = data.body;
			messageListDash.append("<tr><td>" + messageDash + "<tr><td>")
		})
	})
})*/