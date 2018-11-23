package ua.andrzav;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Statistics {
  public Statistics() {}

  public <V> Map<V, Long> findFrequencies(final Collection<V> items) {
    return items.stream()
            .filter(w -> !w.equals(""))
            .filter(w -> !w.equals(" "))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }
}
