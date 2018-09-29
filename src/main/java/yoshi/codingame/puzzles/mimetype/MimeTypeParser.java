package yoshi.codingame.puzzles.mimetype;

import yoshi.codingame.puzzles.utils.Parser;

import java.util.Arrays;
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
            int entryValue = Integer.valueOf(lines[entry]);
            int offset = computeOffset(entry);
            return IntStream.range(0, entryValue)
                    .mapToObj(i -> Arrays.asList(lines[i + offset].split(separator)))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    private int computeOffset(final int entry) {
        return totalEntries + (entry > 0 ? IntStream.rangeClosed(0, entry - 1).map(i -> Integer.valueOf(lines[i])).sum() : 0);
    }

}
