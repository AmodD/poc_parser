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
import com.fortiate.parser.field.FixedNumField;
import com.fortiate.parser.field.IsoField;

public class FixedNumFieldTest {

    @Test
    public void testEncode() {
        Logger logger = Logger.getLogger(FixedNumFieldTest.class);
        logger.info("Encoding FixedNumField ...");
        try {
            byte[] bytes;
            String lines;
            bytes = Files.readAllBytes(Paths.get(FixedNumFieldTest.class.getResource("/iso_field.xml").toURI()));
            lines = new String(bytes, "ISO-8859-1");
            IsoField isoField = Strings.unmarshal(lines, IsoField.class, "application/xml");
            isoField = isoField.getIsoFields().get(0);
            Field field = new FixedNumField(isoField);
            field.setValue("0800");
            String encodedValue = field.encode();
            logger.infof("Encoded value => %s", encodedValue);
            field.decode(encodedValue);
            Assert.assertEquals("0800", field.getValue());
        } catch (JAXBException | IOException | RuntimeException | URISyntaxException ex) {
            logger.error(ex);
            Assert.fail();
        }

    }

    @Test
    public void testDecode() {
        Logger logger = Logger.getLogger(FixedNumFieldTest.class);
        logger.info("Decoding FixedNumField ...");
        try {
            byte[] bytes;
            String lines;
            bytes = Files.readAllBytes(Paths.get(FixedNumFieldTest.class.getResource("/iso_field.xml").toURI()));
            lines = new String(bytes, "ISO-8859-1");
            IsoField isoField = Strings.unmarshal(lines, IsoField.class, "application/xml");
            isoField = isoField.getIsoFields().get(0);
            bytes = Files.readAllBytes(Paths.get(FixedNumFieldTest.class.getResource("/echo.log").toURI()));
            lines = new String(bytes, "ISO-8859-1");
            Field field = new FixedNumField(isoField);
            field.setValue("");
            field.decode(lines);
            logger.infof("Value => %s", field.getValue());
            Assert.assertEquals("0800", field.getValue());
        } catch (JAXBException | IOException | RuntimeException | URISyntaxException ex) {
            logger.error(ex);
            Assert.fail();
        }

    }

}
