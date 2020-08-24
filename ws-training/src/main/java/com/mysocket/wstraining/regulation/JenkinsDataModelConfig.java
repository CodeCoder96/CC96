package com.mysocket.wstraining.regulation;


import com.mysocket.wstraining.restapi.models.DashboardDataModel;

public class JenkinsDataModelConfig {

	
	public static DashboardDataModel[] getModels(DashboardDataModel[] dashboardDatas) {
		if(null!=dashboardDatas) {
			double tempDevScore, tempStableScore, tempStageScore, tempProdScore;
			for (int i = 0; i < dashboardDatas.length; i++) {
				tempDevScore =pickColor(dashboardDatas[i].getDevColor());
				tempStableScore = pickColor(dashboardDatas[i].getStableColor());
				tempStageScore =pickColor( dashboardDatas[i].getStageColor());
				tempProdScore = pickColor( dashboardDatas[i].getProdColor());
				
				double totalScore = (tempDevScore) + (tempStableScore*10) + (tempStageScore*100)
				+ (tempProdScore*1000);
				dashboardDatas[i].setScore(totalScore);
				

			}
				
		}
		
		
		return dashboardDatas;
	}

		private static double pickColor(String color) {
			switch (color) {
			case "red":

				return 3;

			case "yellow":
				return 2;
			case "blue":
				return 1;
				
			}
			return 0;
		}
	
}
