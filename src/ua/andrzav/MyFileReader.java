package ua.andrzav;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class MyFileReader implements AutoCloseable {
  private String[] words;
  private StringBuilder line = new StringBuilder();

  public void readLine(String fileName) {
    try (InputStreamReader isr = new InputStreamReader(new FileInputStream(new File(fileName)))) {
      int c = 0;
      while ((c = isr.read()) != -1) {
        line.append((char)c);
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public String getLine() {
    return line.toString();
  }

  public void splitWords(String delimiter) {
    words = line.toString()
            .replace("\r\n", " ")
            .replace(",", " ")
            .replace(".", " ")
            .replace(":", " ")
            .replace("!", " ")
            .split(delimiter);
  }

  public List<String> getWords() {
    return Arrays.asList(words);
  }

  @Override
  public void close() throws Exception {
    System.out.println("Resource is closed");
  }
}
