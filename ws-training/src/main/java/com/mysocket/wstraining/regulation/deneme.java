package com.mysocket.wstraining.regulation;

import java.awt.SecondaryLoop;
import java.util.List;

import com.mysocket.wstraining.restapi.models.DashboardDataModel;

public class deneme {

	
	public static DashboardDataModel[] getModels(DashboardDataModel[] dashboardDatas) {
		if(null!=dashboardDatas) {
			double tempDevScore, tempStableScore, tempStageScore, tempProdScore;
			for (int i = 0; i < dashboardDatas.length; i++) {
				tempDevScore =getDevScore(dashboardDatas[i].getDevColor());
				tempStableScore = getStableScore(dashboardDatas[i].getStableColor());
				tempStageScore =getStageScore( dashboardDatas[i].getStageColor());
				tempProdScore = getProdScore( dashboardDatas[i].getProdColor());
				
				double totalScore = (tempDevScore/100*73) + (tempStableScore/100*80) + (tempStageScore/100*90)
				+ tempProdScore;
				dashboardDatas[i].setScore(totalScore);
				

			}
				
		}
		dashboardDatas = sortTheModel(dashboardDatas);
		
		return dashboardDatas;
	}
	
	
	private static double getDevScore(String color) {
		switch (color) {
		case "red":

			return 110;

		case "yellow":
			return 7;
		case "blue":
			return 3;
			
		}
		return -100;
	}
	
	private static double getStableScore(String color) {
		switch (color) {
		case "red":

			return 120;

		case "yellow":
			return 7;
		case "blue":
			return 3;
			
		}
		return -200;
	}
	
	private static  double getStageScore(String color) {
		switch (color) {
		case "red":

			return 130;

		case "yellow":
			return 7;
		case "blue":
			return 3;
			
		}
		return -300;
	}
	
	private static  double getProdScore(String color) {
		switch (color) {
		case "red":

			return 140;

		case "yellow":
			return 7;
		case "blue":
			return 3;
			
		}
		return -400;
	}

	private static DashboardDataModel[] sortTheModel(DashboardDataModel[] model) {
		DashboardDataModel temp = null;
		for(int i=0;i<model.length;i++) {
			for(int j=i+1;j<model.length;j++) {
				if(model[j].getScore()>model[i].getScore()) {
					temp=model[i];
					model[i]=model[j];
					model[j]=temp;
				}
			}
		}
		return model;
	}
	
}