var dataModel = []



$(document).ready(function() {



	var socket = new SockJS("/jenkinsTracker");

	var stompClient = Stomp.over(socket);

	stompClient.connect({}, function() {

		stompClient.subscribe("/topic/jenkinsTracker", onMessage);


	});


});

/** function(data) {
			var message = data.body;
			
			dataModel.push(message);
			//dataModel = countingSort(dataModel);
			
			//messageList.append("<tr><td>"+dataModel+"</td></tr>");
			//messageList.append("<tr><td>" + message[0] + "</td><td>" + message[1] + "</td><td>" + message[2] + "</td><td>" + message[3] + "</td><td>" + message[4] + "</td><td>" + message[5] + "</td></tr>");
		},{id: mysubid} */

function onMessage(message) {
	//document.write(message.body);
	if (-1 == parseInt(message.body)) {
		taflan(message.body);
	} if (1 == parseInt(message.body)) {
		document.write("Değerler aynı\n")
	}
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

if (performance.navigation.type == performance.navigation.TYPE_RELOAD) {
	taflan(0);
}

function taflan(notifyValue) {
	if (0 == notifyValue) {
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
					messageList.append("<tr><td>" + dashboardData[i].jobName + "</td><td>" + dashboardData[i].devColor + "</td><td>" + dashboardData[i].stableColor + "</td><td>" + dashboardData[i].stageColor + "</td><td>" + dashboardData[i].prodColor + "</td><td>" + dashboardData[i].score+ "</td></tr>");
				}

			}

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


function hierarchy(dataArr) {

	let prod = [], stage = [], stable = [], dev = [];
	let maxProd, maxStage, maxStable, maxDev;
	for (i = 0; i < dataArr.length; i++) {
		prod.push(dataArr[i].prodScore);
		stage.push(dataArr[i].stageScore);
		stable.push(dataArr[i].stableScore);
		dev.push(dataArr[i].devScore);
	}
	prod.sort();
	stage.sort();
	stable.sort();
	dev.sort();

	maxProd = Math.max(prod);
	maxStage = Math.max(stage);
	maxStable = Math.max(stable);
	maxDev = Math.max(dev);



	minProd = Math.min(prod);
	minStage = Math.min(stage);
	minStable = Math.min(stable);
	minDev = Math.min(dev);

	let countProd = [maxProd], countStage = [maxStage], countStable = [maxStable], countDev = [maxDev];
	for (i = 0; i < maxProd; i++) {
		countProd[i] = 0;
	}
	for (i = 0; i < maxStage; i++) {
		countStage[i] = 0;
	}
	for (i = 0; i < maxStable; i++) {
		countStable[i] = 0;
	}
	for (i = 0; i < maxDev; i++) {
		countDev[i] = 0;
	}
	var hiearchicalDatamodel;
	for (i = 0; i <= countProd.length; i++) {
		countProd[dataArr[5].prodScore]++;
		countStage[dataArr[5].stageScore]++;
		countStable[dataArr[5].stableScore]++;
		countDev[dataArr[5].devScore]++;
	}
	let score = 0;
	for (i = 0; i < dataArr.length; i++) {
		for (j = 0; j < dataArr.length; j++) {
			if (0 < countProd[prod[dataArr.length - i - 1]] && prod[dataArr.length - i - 1] == dataArr[j].prodScore) {
				score++;
			}
			if (0 < countStage[stage[dataArr.length - i - 1]] && stage[dataArr.length - i - 1] == dataArr[j].stageScore) {
				score++;
			}
			if (0 < countStable[stable[dataArr.length - i - 1]] && stable[dataArr.length - i - 1] == dataArr[j].stableScore) {
				score++;
			}
			if (0 < countDev[dev[dataArr.length - i - 1]] && dev[dataArr.length - i - 1] == dataArr[j].devScore) {
				score++;
			}
			if (4 == score) {
				hierarhiearchicalDatamodel.push[dataArr[j]];
				countProd[prod[dataArr.length - i - 1]]--;
				countStage[stage[dataArr.length - i - 1]]--;
				countStable[stable[dataArr.length - i - 1]]--;
				countDev[dev[dataArr.length - i - 1]]--;
				score = 0;
			}
		}
	}
	return hiearchicalDatamodel;
}
