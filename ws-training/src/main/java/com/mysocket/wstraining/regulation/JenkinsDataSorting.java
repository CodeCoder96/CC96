package com.mysocket.wstraining.regulation;

import com.mysocket.wstraining.restapi.models.DashboardDataModel;

public class JenkinsDataSorting {

	public static DashboardDataModel[] gradeJob(DashboardDataModel[] dashboardDatas) {
		if(null!=dashboardDatas) {
			double tempDevScore, tempStableScore, tempStageScore, tempProdScore;
			for (int i = 0; i < dashboardDatas.length; i++) {
				tempDevScore = calculate("dev", dashboardDatas[i].getDevColor());
				tempStableScore = calculate("stable", dashboardDatas[i].getStableColor());
				tempStageScore = calculate("stage", dashboardDatas[i].getStageColor());
				tempProdScore = calculate("prod", dashboardDatas[i].getProdColor());

				double totalScore = Math.pow(tempDevScore, 2) + Math.pow(tempStableScore, 2) + Math.pow(tempStageScore, 2)
						+ Math.pow(tempProdScore, 2);
				dashboardDatas[i].setScore(totalScore);

			}

		}
		return dashboardDatas;
	}

	private static double calculate(String parentJobName, String color) {
		double score = 0;
		switch (color) {
		case "notbuilt":
			score += 2.5;
			break;
		case "aborted":
			score += 2.4;
			break;
		case "red":
			score += 2.3;
			break;
		case "yellow":
			score += 2.2;
			break;
		default:
			score += 2.1;
			break;
		}

		switch (parentJobName) {
		case "dev":
			return score += 1.211;
		case "stable":
			return score += 1.212;
		case "stage":
			return score += 1.213;
		case "prod":
			return score += 1.214;
		default:
			return score;
		}
	}

}
