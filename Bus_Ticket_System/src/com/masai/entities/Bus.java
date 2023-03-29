package com.masai.entities;

import java.io.Serializable;

import java.util.Objects;

public class Bus implements Serializable{

	private int id;
	private String name;
	private int totalseat;
	private String source;
	private String destination;
	private String busType;
	private String departureTime;
	private String arrivalTime;
	public Bus() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Bus(int id, String name, int totalseat, String source, String destination, String busType,
			String departureTime, String arrivalTime) {
		super();
		this.id = id;
		this.name = name;
		this.totalseat = totalseat;
		this.source = source;
		this.destination = destination;
		this.busType = busType;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalseat() {
		return totalseat;
	}

	public void setTotalseat(int totalseat) {
		this.totalseat = totalseat;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(arrivalTime, busType, departureTime, destination, id, name, source, totalseat);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bus other = (Bus) obj;
		return Objects.equals(arrivalTime, other.arrivalTime) && Objects.equals(busType, other.busType)
				&& Objects.equals(departureTime, other.departureTime) && Objects.equals(destination, other.destination)
				&& id == other.id && Objects.equals(name, other.name) && Objects.equals(source, other.source)
				&& totalseat == other.totalseat;
	}

	@Override
	public String toString() {
		return "Bus [id=" + id + ", name=" + name + ", totalseat=" + totalseat + ", source=" + source + ", destination="
				+ destination + ", busType=" + busType + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + "]";
	}

	
}
