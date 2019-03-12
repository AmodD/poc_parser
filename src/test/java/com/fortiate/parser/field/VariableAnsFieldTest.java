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
import com.fortiate.parser.field.IsoField;
import com.fortiate.parser.field.VariableAnsField;

public class VariableAnsFieldTest {

    @Test
    public void testEncode() {
        Logger logger = Logger.getLogger(FixedNumFieldTest.class);
        logger.info("Encoding VaribaleAnsField ...");
        try {
            byte[] bytes;
            String lines;
            bytes = Files.readAllBytes(Paths.get(FixedNumFieldTest.class.getResource("/iso_field.xml").toURI()));
            lines = new String(bytes, "ISO-8859-1");
            IsoField isoField = Strings.unmarshal(lines, IsoField.class, "application/xml");
            isoField = isoField.getIsoFields().get(60);
            Field field = new VariableAnsField(isoField);
            field.setValue("0000000000");
            String encodedValue = field.encode();
            logger.infof("Encoded value => %s", encodedValue);
            field.setValue("");
            field.decode(encodedValue);
            logger.infof("Value => %s", field.getValue());
            Assert.assertEquals("0000000000", field.getValue());
        } catch (JAXBException | IOException | RuntimeException | URISyntaxException ex) {
            logger.error(ex);
            Assert.fail();
        }

    }
}
