package com.fortiate.parser.field;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.xml.bind.JAXBException;

import org.jboss.logging.Logger;
import org.junit.Assert;
import org.junit.Test;

import com.fortiate.parser.Strings;
import com.fortiate.parser.field.Field;
import com.fortiate.parser.field.FixedBinField;
import com.fortiate.parser.field.IsoField;

public class FixedBinFieldTest {

    @Test
    public void testEncode() {
        Logger logger = Logger.getLogger(FixedNumFieldTest.class);
        logger.info("Encoding FixedBinField ...");
        try {
            byte[] bytes;
            String lines;
            bytes = Files.readAllBytes(Paths.get(FixedNumFieldTest.class.getResource("/iso_field.xml").toURI()));
            lines = new String(bytes, "ISO-8859-1");
            IsoField isoField = Strings.unmarshal(lines, IsoField.class, "application/xml");
            isoField = isoField.getIsoFields().get(1);
            Field field = new FixedBinField(isoField);
            field.setValue("1000001000111000000000000000000000000000000000000000000000000000");
            String encodedValue = field.encode();
            logger.infof("Encoded value => %s", encodedValue);
            field.setValue("");
            field.decode(encodedValue);
            Assert.assertEquals("1000001000111000000000000000000000000000000000000000000000000000", field.getValue());
        } catch (JAXBException | IOException | RuntimeException | URISyntaxException ex) {
            logger.error(ex);
            Assert.fail();
        }

    }

    @Test
    public void testDecode() {
        Logger logger = Logger.getLogger(FixedNumFieldTest.class);
        logger.info("Decoding FixedBinField ...");
        try {
            byte[] bytes;
            String lines;
            bytes = Files.readAllBytes(Paths.get(FixedNumFieldTest.class.getResource("/iso_field.xml").toURI()));
            lines = new String(bytes, "ISO-8859-1");
            IsoField isoField = Strings.unmarshal(lines, IsoField.class, "application/xml");
            isoField = isoField.getIsoFields().get(1);
            bytes = Files.readAllBytes(Paths.get(FixedNumFieldTest.class.getResource("/echo.log").toURI()));
            lines = new String(bytes, "ISO-8859-1");
            Field field = new FixedBinField(isoField);
            field.decode(lines.substring(4));
            logger.infof("Value => %s", field.getValue());
            Assert.assertEquals("1000001000111000000000000000000000000000000000000000000000000000", field.getValue());
        } catch (JAXBException | IOException | RuntimeException | URISyntaxException ex) {
            logger.error(ex);
            Assert.fail();
        }

    }
}
