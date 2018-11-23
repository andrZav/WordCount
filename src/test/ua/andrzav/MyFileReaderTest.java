package test.ua.andrzav;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import ua.andrzav.MyFileReader;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyFileReaderTest {
  private static MyFileReader fileReader = new MyFileReader();
  private String expectedLine;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setUp() throws Exception {
    expectedLine = "Hello world!\r\n" +
            "My name is Andrew.\r\n" +
            "This is a unit test.\r\n" +
            "This task is very good.\r\n" +
            "I am software developer.";
  }

  @Test
  public void readLineSuccess() throws FileNotFoundException {
    fileReader.readLine("test/test.txt");
    assertEquals(expectedLine, fileReader.getLine());
    assertNotEquals("", fileReader.getLine());
  }

  @Test
  public void splitWords() throws Exception {
    fileReader.splitWords(" ");
    List<String> words = fileReader.getWords();
    assertEquals("Hello", words.get(0));
    assertEquals("is", words.get(5));
    assertEquals("test", words.get(12));
  }

}