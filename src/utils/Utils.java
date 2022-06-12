package utils;

import java.util.List;
import java.util.ArrayList;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedInputStream;

import java.io.IOException;

import interfaces.ElectronicDevices;

import models.Phone;

public class Utils {
	public static final String file = "C:/Users/AliSener/phones.txt";
	
	private static List<ElectronicDevices> electronicDevices = new ArrayList<ElectronicDevices>();
	
	public static List<ElectronicDevices> createPhones(int n) {
		for (int i = 0; i < n; i++) {
			Phone phone = new Phone();
			
			electronicDevices.add(phone);
		}
		
		return electronicDevices;
	}
	
	public static List<ElectronicDevices> readPhones(String file) {
		DataInputStream dis = null;
		
		try {
			
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			dis = new DataInputStream(bis);
			
			for (int i = 0; i < electronicDevices.size(); i++) {
				float weight = dis.readFloat();
				double diagonal = dis.readDouble();
				String producer = dis.readUTF();
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		return electronicDevices;
	}
	
	public static void writeBinaryPhones(String file, List<ElectronicDevices> listP) {		
		try {
			FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
						
			for (int i = 0; i < electronicDevices.size(); i++) {
				oos.writeObject(electronicDevices.get(i));
			}
			
		}
		catch (IOException ioe) {
			
		}
	}
	
	public static List<ElectronicDevices> readBinaryPhones(String file) {
		List<Phone> phonesList = new ArrayList<Phone>();
		
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			for (int i = 0; i < electronicDevices.size(); i++) {				
				phonesList.add((Phone) ois.readObject());
			}
			
		} 
		catch (ClassNotFoundException e) {
			
		}
		catch (IOException ioe) {
			
		}
		
		return electronicDevices;
	}
	
	
}
