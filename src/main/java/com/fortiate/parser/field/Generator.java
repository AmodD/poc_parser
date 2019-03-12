package com.fortiate.parser.field;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "generator")
@XmlAccessorType(XmlAccessType.FIELD)
public class Generator {
	
	private String minValue;
	private String maxValue;
	private String possivleValues;
	
	
	public Generator()
	{
				
	}
	
	public Generator(String minValue, String maxValue, String possivleValues) {
		super();
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.possivleValues = possivleValues;
	}
	
	
	public String getMinValue() {
		return minValue;
	}
	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}
	public String getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}
	public String getPossivleValues() {
		return possivleValues;
	}
	public void setPossivleValues(String possivleValues) {
		this.possivleValues = possivleValues;
	}
	

}
