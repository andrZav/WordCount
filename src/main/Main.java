package main;

import ua.andrzav.MyFileReader;
import ua.andrzav.Statistics;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
      MyFileReader fileReader = new MyFileReader();
      fileReader.readLine("testFile.txt");
      fileReader.splitWords(" ");

      Statistics statistics = new Statistics();
      List<String> words = fileReader.getWords();
      Map<String, Long> mapCount = statistics.findFrequencies(
              words.stream()
                .parallel()
                .map(w -> w.toLowerCase())
                .collect(Collectors.toList())
      );

      for (Map.Entry<String, Long> entry : mapCount.entrySet()) {
        System.out.println(entry.getValue() + " " + entry.getKey());
      }
    }
}
