package models;

import java.util.List;

import interfaces.ElectronicDevices;

import utils.Utils;

public class VectThread implements ElectronicDevices, Runnable {
	double avgWeight;
	List<ElectronicDevices> phonesList;
	
	public VectThread() {
		Utils utils = new Utils();
		this.phonesList = utils.readBinaryPhones(utils.file);
	}

	public double getAvgWeight() {
		return avgWeight;
	}

	public void setAvgWeight(double avgWeight) {
		this.avgWeight = avgWeight;
	}

	public List<ElectronicDevices> getPhonesList() {
		return phonesList;
	}

	public void setPhonesList(List<ElectronicDevices> phonesList) {
		this.phonesList = phonesList;
	}

	@Override
	public void run() {
		double sumWeight = 0;
		
		for (int i = 0; i < phonesList.size(); i++) {
			Phone phone = (Phone) phonesList.get(i);
			sumWeight += phone.getWeight();
		}
		
		this.avgWeight = sumWeight / phonesList.size();
	}

	@Override
	public String infoDevice() {
		return null;
	}

}
