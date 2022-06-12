package models;

import java.io.Serializable;

import interfaces.ElectronicDevices;

public class Phone implements ElectronicDevices, Serializable, Cloneable{
	private float weight;
	private double diagonal;
	private String producer;
	
	private static final long serialVersionUID = 1L;

	public Phone() {
		this.weight = 10;
		this.diagonal = 0;
		this.producer = "";
	}
	
	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public double getDiagonal() {
		return diagonal;
	}

	public void setDiagonal(double diagonal) {
		this.diagonal = diagonal;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) throws Exception {
		if (producer == null || producer.length() < 1) 
			throw new Exception("Unfulfilled criteria");
		
		this.producer = producer;
	}

	@Override
	public String infoDevice() {
		return this.producer;
	}

	@Override
	public int hashCode() {
		return (int) (37 * 37 * this.weight) + (int) (37 * this.diagonal) + this.producer.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
