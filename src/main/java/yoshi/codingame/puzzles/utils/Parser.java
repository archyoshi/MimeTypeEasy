package yoshi.codingame.puzzles.utils;

import java.util.List;

public interface Parser {
    String LINE_SEPARATOR = System.getProperty("line.separator");
    List parseWithSeparator(int entry, String separator);
}
