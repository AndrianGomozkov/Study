package com;

import java.io.Serializable;

public class Car implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    private int idcar;
    private String model;
    private String color;
    private String complect; 
    
    public Car(){ }
    public Car(String model, String color, String complect){
         
        this.model = model;
        this.color = color;
        this.complect = complect;
    }
    public Car(int idcar, String model, String color, String complect){
         
        this.idcar = idcar;
        this.model = model;
        this.color = color;
        this.complect = complect;
    }
	public int getIdcar() {
		return idcar;
	}
	public void setIdcar(int idcar) {
		this.idcar = idcar;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getComplect() {
		return complect;
	}
	public void setComplect(String complect) {
		this.complect = complect;
	} 
}
    