package edu.eci.cvds.primeFaces;

import java.util.ArrayList;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "calculadoraBean")
//@ApplicationScoped
@SessionScoped
public class BackingBean {
	private ArrayList<Double> numberList = new ArrayList<Double>();
	private double mean;
	private double mode;
	private double standardDeviation;
	private double variance;
	private String stringL;
	
	public double getMean() {
		return this.mean;
	}

	public double getMode() {
		return this.mode;
	}
	public double getStandardDeviation() {
		return this.standardDeviation;
	}
	public double getVariance() {
		return this.variance;
	}
	public ArrayList<Double> getNumberList() {
		return this.numberList;
	}
	public String getStringL() {
		return this.stringL;
	}

	public void setStringL(String stringL) {
		this.stringL=stringL;
	}
	public void setMean(Double mean) {
		this.mean = mean;
	}
	public void setMode(Double mode) {
		this.mode = mode;
	}
	public void setStandardDeviation(Double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}
	public void setVarianza(Double variance) {
		this.variance = variance;
	}
	public void setNumberList(ArrayList<Double> numberList) {
		this.numberList = numberList;
	}
	
	public double calculateMean(ArrayList<Double> numberList) {
		double sum = 0;
		for(Double i : numberList) {
			sum+=i;
		}
		mean = sum / numberList.size();
		return mean;
	}
	
	public double calculateMode(ArrayList<Double> numberList) {
		double max = 0, maxCount = 0;
		for (int i = 0; i < numberList.size(); ++i) {
			int count = 0;
			for (Double number : numberList) {
				if (number.equals(numberList.get(i))) { 
					count+=1;
				}
			}
			if (count > maxCount) {
				maxCount = count;
				max = numberList.get(i);
			}
		}
		mode = max;
		return mode;
	}
	
	public double calculateStandardDeviation(ArrayList<Double> numberList) {
		calculateVariance(numberList);
		standardDeviation = Math.sqrt(variance);
		return Math.round(standardDeviation * Math.pow(10, 5)) / Math.pow(10, 5);
	}
	
	public double calculateVariance(ArrayList<Double> numberList) {
		double localVariance = 0;
		calculateMean(numberList);
		for (double number : numberList) {
			localVariance += Math.pow(number - mean, 2);
		}
		this.variance = localVariance / numberList.size();

		return Math.round(variance * Math.pow(10, 5)) / Math.pow(10, 5);
	}

	public ArrayList<Double> change(String stringList){
		String cad="";
		stringList+=",";
		for(int i=0;i<stringList.length();i++){
			if(stringList.charAt(i)!=','){
				cad += stringList.charAt(i)+"";
			}
			else {
				numberList.add(Double.parseDouble(cad));
				cad="";
			}
		}
		return numberList;
	}	
	
	public void calculate(String numberList) {
		this.stringL=numberList;
		ArrayList<Double> newArraylist = change(numberList);
		calculateMean(newArraylist);
		calculateMode(newArraylist);
		calculateStandardDeviation(newArraylist);
		calculateVariance(newArraylist);
	}
	
	public void restart() {
		numberList.clear();
		mean=0;
		mode=0;
		standardDeviation=0;
		variance=0;
	}
	
}