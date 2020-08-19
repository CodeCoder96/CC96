package com.mysocket.wstraining.regulation;

import com.mysocket.wstraining.restapi.models.DashboardDataModel;

public class JenkinsDataSorting {

	public static DashboardDataModel[] gradeJob(DashboardDataModel[] dashboardDatas) {

		String[] parentJobAndColorArray = initParentJobAndColorArr();
		for (String str : parentJobAndColorArray) {
			System.out.println(str);
		}
		double tempDevScore, tempStableScore, tempStageScore, tempProdScore;
		for (int i = 0; i < dashboardDatas.length; i++) {
			tempDevScore = calculate("dev", dashboardDatas[i].getDevColor());
			tempStableScore = calculate("stable",dashboardDatas[i].getStableColor());
			tempStageScore = calculate("stage",dashboardDatas[i].getStageColor());
			tempProdScore = calculate("prod",dashboardDatas[i].getProdColor());
			
		
			double totalScore =Math.pow(tempDevScore, 2)+Math.pow(tempStableScore, 2)+Math.pow(tempStageScore, 2)+Math.pow(tempProdScore, 2);
			dashboardDatas[i].setScore(totalScore);

		}

		return dashboardDatas;
	}

	private static int calculateScore(String parentJobAndColor, String[] pJobAndColorArr) {

		for (int i = 0; i < pJobAndColorArr.length; i++) {
			if (parentJobAndColor.equals(pJobAndColorArr[i])) {
				return (i + 1);
			}
		}

		return -1;
	}

	private static String[] initParentJobAndColorArr() {
		String[] arr = new String[20];
		String[] colors = new String[] { "blue", "yellow", "red", "aborted", "notbuilt" };
		String[] parentJobName = new String[] { "dev", "stable", "stage", "prod" };
		int countOfColors = colors.length, holdCounterPosition = 4, matched = 0, arrLen = 0;

		for (int i = 0; i < countOfColors; i++) {

			arr[arrLen] = parentJobName[matched].concat(colors[i]);
			if (holdCounterPosition > matched) {
				i--;
				matched++;
			}
			if (holdCounterPosition == matched) {
				matched = 0;
				i++;
			}
			arrLen++;
		}

		return arr;
	}

	private static double calculate(String parentJobName,String color) {
		double score = 0;
		switch (color) {
		case "red":
			score += 2.3;
			break;
		case "yellow":
			score += 2.2;
			break;
		case "blue":
			score += 2.1;
			break;
		default:
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
