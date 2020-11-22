package de.exxcellent.challenge;

import de.exxcellent.challenge.utils.FileReaderUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderUtilTest {

    @Test
    public void testReadFile_HappyPath() throws IOException {
        String result = FileReaderUtil.readFile("de/exxcellent/challenge/football.csv");
        assertNotNull(result);
    }

    @Test
    public void testReadFile_NullData() throws IOException {
        String result = FileReaderUtil.readFile("de/exxcellent/challenge/dummy.csv");
        assertNull(result);
    }

    @Test
    public void testReadFile_NegativeTest() throws IOException {
        try {
            String result = FileReaderUtil.readFile("de/exxcellent/challenge/dummy.csv");
            fail("Exception was supposed to happen");
        } catch (Exception e) {
            assertNotNull(e);
        }
    }
}
