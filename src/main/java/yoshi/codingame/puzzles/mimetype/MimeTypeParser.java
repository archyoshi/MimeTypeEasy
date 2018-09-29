package yoshi.codingame.puzzles.mimetype;

import yoshi.codingame.puzzles.utils.Parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MimeTypeParser implements Parser {
    private final String input;
    private final int totalEntries;
    private String[] lines;


    public MimeTypeParser(final String input, final int totalEntries) {
        this.input = input;
        this.totalEntries = totalEntries;
    }

    @Override
    public List<List<String>> parseWithSeparator(final int entry, final String separator) {
        if (input != null && !input.isEmpty()) {
            lines = input.split(LINE_SEPARATOR);
            int relatedLines = Integer.valueOf(lines[0]);
            int offset = computeOffset(entry);
            return IntStream.range(0, relatedLines)
                    .mapToObj(i -> parseLineElements(i + offset, separator))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    private int computeOffset(final int entry) {
        int offset;
        if (entry == 0) {
            offset = 0;
        } else {
            offset = Integer.valueOf(lines[entry - 1]);
        }
        return totalEntries + offset;
    }

    private List<String> parseLineElements(final int lineNumber, final String separator) {
        List<String> elements = new ArrayList<>();
        if (lines.length >= lineNumber) {
            Collections.addAll(elements, lines[lineNumber].split(separator));
        }
        return elements;
    }
}
