package yoshi.codingame.puzzles.utils;

import java.util.List;

public interface Printer {
    String LINE_SEPARATOR = System.getProperty("line.separator");

    String print(List<String> elements);
}
