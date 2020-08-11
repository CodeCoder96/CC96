package com.mysocket.wstraining.restapi;

import java.util.List;

import com.mysocket.wstraining.restapi.models.Job;
import com.mysocket.wstraining.restapi.models.Root;


// -1 : Servis yeni başladı
// 1 : Değerler Aynı
// 0 : Değerler farklı clientlere bildir
public class ClientNotifier {

	public int isNotifiable(List<Root> oldData, List<Root> newData) {
		int toggle = 0;
		if (null == oldData) {
			return -1;
		}
		for (int i = 0; i < oldData.size(); i++) {
			if (true == compareJobs(oldData.get(i).getJobs(), newData.get(i).getJobs())) {
				toggle = 1;
			} else {
				toggle = 0;
				break;
			}
		}
		return toggle;
	}

	private Boolean compareJobs(List<Job> oldJobs, List<Job> newJobs) {
		for (int i = 0; i < oldJobs.size(); i++) {
			if (true == oldJobs.get(i).getColor().equalsIgnoreCase(newJobs.get(i).getColor())) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public void nofityClients() {
		
	}
	
	
	public static String notifyClients(String notice) {
		notice="Merhaba Dünya";
		return notice;
	}
}
