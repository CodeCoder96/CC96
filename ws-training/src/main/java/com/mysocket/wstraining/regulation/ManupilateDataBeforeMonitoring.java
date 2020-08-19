package com.mysocket.wstraining.regulation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysocket.wstraining.SBMDashboard;
import com.mysocket.wstraining.restapi.models.DashboardDataModel;
import com.mysocket.wstraining.restapi.models.Job;

public class ManupilateDataBeforeMonitoring {

	public static final int DEV_COLOR = 0;
	public static final int STABLE_COLOR = 1;
	public static final int STAGE_COLOR = 2;
	public static final int PROD_COLOR = 3;
	
	private static final int PARENT_JOB_COUNT_AND_COLORS_SCORE = 5;

	private static ManupilateDataBeforeMonitoring dataBeforeMonitoring = null;
	private static DashboardDataModel[] model;

	public static DashboardDataModel[] getModel() {
		return model;
	}

	private ManupilateDataBeforeMonitoring() {

	}

	public static ManupilateDataBeforeMonitoring getInstance() {
		if (null == dataBeforeMonitoring) {
			dataBeforeMonitoring = new ManupilateDataBeforeMonitoring();
		}
		return dataBeforeMonitoring;
	}

	public DashboardDataModel[] manupilateData(List<Job> devJob, List<Job> prodJob, List<Job> stableJob,List<Job> stageJob) {
		
		List<Job> biggestJob = getBiggestSizeList(devJob, prodJob, stableJob, stageJob);
		model = new DashboardDataModel[biggestJob.size()];
	
		for(int i=0;i<model.length;i++) {
			model[i] = new DashboardDataModel(biggestJob.get(i).getName(),
							getColor(biggestJob.get(i).getName(),devJob),
							getColor(biggestJob.get(i).getName(),stableJob),
							getColor(biggestJob.get(i).getName(), stageJob),
							getColor(biggestJob.get(i).getName(), prodJob),0);
		}
		
		return model;
	}

	private String getColor(String currentJobName,List<Job> jobs ) {
		for (Job job : jobs) {
			if (true == currentJobName.equals(job.getName())) {
				return job.getColor();
			}
		}
		return "Bu job un ilgili parent da verisi bulunmamaktadır";
	}

	private List<Job> getBiggestSizeList(List<Job> devJob, List<Job> prodJob, List<Job> stableJob, List<Job> stageJob) {
		if (devJob.size() > prodJob.size() && devJob.size() > stableJob.size() && devJob.size() > stageJob.size()) {
			return devJob;
		}
		if (prodJob.size() > stableJob.size() && prodJob.size() > stageJob.size()) {
			return prodJob;
		}
		if (stableJob.size() > stageJob.size()) {
			return stableJob;
		}
		return stageJob;
	}
}
