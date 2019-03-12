package com.fortiate.parser.field;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.xml.bind.JAXBException;

import org.jboss.logging.Logger;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.fortiate.parser.Strings;
import com.fortiate.parser.field.Field;
import com.fortiate.parser.field.IsoField;
import com.fortiate.parser.field.VariableNumField;

public class VaribaleNumFieldTest {

    @Test
    public void testEncode() {
        Logger logger = Logger.getLogger(FixedNumFieldTest.class);
        logger.info("Encoding VariableNumField ...");
        try {
            byte[] bytes;
            String lines;
            bytes = Files.readAllBytes(Paths.get(FixedNumFieldTest.class.getResource("/iso_field.xml").toURI()));
            lines = new String(bytes, "ISO-8859-1");
            IsoField isoField = Strings.unmarshal(lines, IsoField.class, "application/xml");
            isoField = isoField.getIsoFields().get(2);
            Field field = new VariableNumField(isoField);
            field.setValue("9001000000672941810");
            String encodedValue = field.encode();
            logger.infof("Encoded value => %s", encodedValue);
            field.setValue("");
            field.decode(encodedValue);
            Assert.assertEquals("09001000000672941810", field.getValue());
        } catch (JAXBException | IOException | RuntimeException | URISyntaxException ex) {
            logger.error(ex);
            Assert.fail();
        }

    }

    @Test
    public void testDecode() {
        Logger logger = Logger.getLogger(FixedNumFieldTest.class);
        logger.info("Decoding VaribaleNumField ...");
        try {
            byte[] bytes;
            String lines;
            bytes = Files.readAllBytes(Paths.get(FixedNumFieldTest.class.getResource("/iso_field.xml").toURI()));
            lines = new String(bytes, "ISO-8859-1");
            IsoField isoField = Strings.unmarshal(lines, IsoField.class, "application/xml");
            isoField = isoField.getIsoFields().get(2);
            bytes = Files.readAllBytes(Paths.get(FixedNumFieldTest.class.getResource("/funds_transfer.log").toURI()));
            lines = new String(bytes, "ISO-8859-1");
            Field field = new VariableNumField(isoField);
            field.decode(lines.substring(36));
            logger.infof("Value => %s", field.getValue());
            Assert.assertEquals("09001000000672941810", field.getValue());
        } catch (JAXBException | IOException | RuntimeException | URISyntaxException ex) {
            logger.error(ex);
            Assert.fail();
        }
    }

}
