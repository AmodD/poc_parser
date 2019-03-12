package com.fortiate;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.jboss.logging.Logger;

import com.fortiate.parser.Converters;
import com.fortiate.parser.Strings;
import com.fortiate.parser.field.CompoundField;
import com.fortiate.parser.field.FixedCompoundField;
import com.fortiate.parser.field.IsoField;

public class Generator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Logger logger = Logger.getLogger(Generator.class);
        logger.info("Encoding Funds Transfer Message ...");
        try {
            byte[] bytes;
            String lines;
            bytes = Files.readAllBytes(Paths.get(Generator.class.getResource("iso_field.xml").toURI()));
            lines = new String(bytes, "ISO-8859-1");
            IsoField isoField = Strings.unmarshal(lines, IsoField.class, "application/xml");
            CompoundField field = new FixedCompoundField(isoField);
            field.setValue(0, "0200"); // MTI - n4
            field.setValue(2, "9001000000672941810"); // PAN - n..19
            field.setValue(3, "10000"); // Processing Code - n6
            field.setValue(4, ""); // Amount, Transaction - n12
            field.setValue(5, "50000"); // Amount, Settlement - n12
            field.setValue(6, "50000"); // Amount, Cardholder Billing - n12
            field.setValue(7, "1124222950"); // Date Time - n10
            field.setValue(11, "869236"); // STAN - n6
            field.setValue(12, "012958"); // Local Transaction Time (hhmmss) - n6
            field.setValue(13, "1125"); // Local Transaction Date (MMDD) - n4
            field.setValue(15, "1124"); // Settlement Date - n4
            field.setValue(18, "6011"); // Merchant Type - n4
            field.setValue(19, "254"); // Acquiring Institution Country Code - n3
            field.setValue(22, "1"); // Point of Serice Entry Mode - n3
            field.setValue(25, "00"); // Point of Service Condition Code - n2
            field.setValue(26, "12"); // Point of Service Capture Code - n2
            field.setValue(28, "D00000000"); // Amount, Transaction Fee - x+n8
            field.setValue(32, "666767"); // Acquiring Institution Identificatio Code - n..11
            field.setValue(33, "555555"); // Forwarding Institution Identification Code - n..11
            field.setValue(37, "732822869236"); // Retrieval Reference Number - an12
            field.setValue(41, "42810486"); // Card Acceptor Teerminal Identification - ans8
            field.setValue(42, "Shemistone PLC"); // Card Acceptor Identification Code - ans15
            field.setValue(43, "Shemistone PLC NRB KE"); // Card acceptor name/location (1-23 street address, 24-36 city, 37-38 state, 39-40 country)  - ans40
            field.setValue(49, "835"); // Currency Code Transaction - a3 or n3
            field.setValue(50, "835"); // Currency Setttlement - a3 or n3
            field.setValue(51, "835"); // Currency Cardholder Billing - a3 or n3
            field.setValue(52, Converters.hexToBin("931EFFFFFFFFFFFF")); // PIN Data - b8
            field.setValue(53, "2001000000000000"); // Security Related Control Information - n16
            field.setValue(60, "00000000000000000000"); // Recerved - ans...999
            String encodedValue = field.encode();
            logger.infof("Encoded value => %s", encodedValue);

        }
        catch (Exception e){
            System.out.println(e.getCause());
        }
		
	}//endof main method

}//end of class
