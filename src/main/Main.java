package main;

import java.util.ArrayList;
import java.util.List;

import interfaces.ElectronicDevices;
import models.Phone;
import models.VectThread;
import utils.Utils;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		  Utils utils = new Utils();
		  
		  List<ElectronicDevices> list = new ArrayList<ElectronicDevices>();
		  
		  list = utils.createPhones(20);
		  
		  utils.writeBinaryPhones("phones.txt", list);	
		  
		
		VectThread thread = new VectThread();
		
		thread.run();
	}

}
