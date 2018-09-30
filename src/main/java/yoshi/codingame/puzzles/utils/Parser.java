package yoshi.codingame.puzzles.utils;

import java.util.List;

public interface Parser {

    String LINE_SEPARATOR = System.getProperty("line.separator");
    String DEFAULT_ELEMENT_SEPARATOR = " ";

    List<List<String>> parseWithSeparator(int entry);

}
