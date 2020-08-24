package com.mysocket.wstraining.regulation;

import com.mysocket.wstraining.restapi.models.DashboardDataModel;

public class JenkinsDataModelConfig {

	
	private static final int PROD_HANDICAP = 1000;
	private static final int STAGE_HANDICAP = 100;
	private static final int STABLE_HANDICAP = 10;
	private static final int DEV_HANDICAP = 1;

	private static final int NOTBUILT_SCORE = 5;
	private static final int ABORTED_SCORE = 4;
	private static final int RED_SCORE = 3;
	private static final int YELLOW_SCORE = 2;
	private static final int BLUE_SCORE = 1;
	
	

	public static DashboardDataModel[] getModels(DashboardDataModel[] dashboardDatas) {
		if (null != dashboardDatas) {
			double tempDevScore, tempStableScore, tempStageScore, tempProdScore;
			for (int i = 0; i < dashboardDatas.length; i++) {
				tempDevScore = pickColor(dashboardDatas[i].getDevColor());
				tempStableScore = pickColor(dashboardDatas[i].getStableColor());
				tempStageScore = pickColor(dashboardDatas[i].getStageColor());
				tempProdScore = pickColor(dashboardDatas[i].getProdColor());

				double totalScore = (tempDevScore * DEV_HANDICAP) + (tempStableScore * STABLE_HANDICAP)
						+ (tempStageScore * STAGE_HANDICAP) + (tempProdScore * PROD_HANDICAP);
				dashboardDatas[i].setScore(totalScore);

			}

		}

		return dashboardDatas;
	}

	private static double pickColor(String color) {
		switch (color) {
		case "notbuilt":
		case "notbuilt_anime":
			return NOTBUILT_SCORE;
		case "aborted":
		case "aborted_anime":
			return ABORTED_SCORE;
		case "red":
		case "red_anime":
			return RED_SCORE;
		case "yellow":
		case "yellow_anime":
			return YELLOW_SCORE;
		default:
			return BLUE_SCORE;

		}
	}

}
