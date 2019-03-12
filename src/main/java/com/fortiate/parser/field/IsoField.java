package com.fortiate.parser.field;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "isoField")
@XmlAccessorType(XmlAccessType.FIELD)
public class IsoField {


	private int id;
    private int length;
    private int maxLength;
    private String cls;
    private Padder padder;
    private String description;
    private Encoding valueEncoding;
    private Encoding lengthEncoding;
    @XmlElement(name = "isoField")
    private List<IsoField> isoFields;
    @XmlElement(name = "generator")
    private List<Generator> generator;

    public IsoField() {
    }

    public IsoField(int id, int length, int maxLength, String type, Padder padder, String description, Encoding valueEncoding, Encoding lengthEncoding, List<Generator> generator) {
        this.id = id;
        this.length = length;
        this.maxLength = maxLength;
        this.cls = type;
        this.padder = padder;
        this.description = description;
        this.valueEncoding = valueEncoding;
        this.lengthEncoding = lengthEncoding;
        this.generator = generator;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Encoding getValueEncoding() {
        return valueEncoding;
    }

    public void setValueEncoding(Encoding valueEncoding) {
        this.valueEncoding = valueEncoding;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Encoding getLengthEncoding() {
        return lengthEncoding;
    }

    public void setLengthEncoding(Encoding lengthEncoding) {
        this.lengthEncoding = lengthEncoding;
    }

    public Padder getPadder() {
        return padder;
    }

    public void setPadder(Padder padder) {
        this.padder = padder;
    }

    public List<IsoField> getIsoFields() {
        return isoFields;
    }

    public void setIsoFields(List<IsoField> isoFields) {
        this.isoFields = isoFields;
    }

	public List<Generator> getGenerator() {
		return generator;
	}

	public void setGenerator(List<Generator> generator) {
		this.generator = generator;
	}

}
