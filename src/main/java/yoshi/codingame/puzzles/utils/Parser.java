package yoshi.codingame.puzzles.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Parser {
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    public static final String DEFAULT_ELEMENT_SEPARATOR = " ";

    private final String input;
    private final int totalEntries;
    private String[] lines;

    /*
    TODO Optimise the parser because i lose time Reading from the scanner which is already parsedn then parsing again !
    The problem I have is that my algorithm doesn't execute very fast... I gotta find ways to optimise it !
     */

    public Parser(final Scanner in, final int totalEntries) {
        StringBuilder inputBuilder = new StringBuilder();
        int N = in.nextInt(); // Number of elements which make up the association table.
        inputBuilder.append(N).append(LINE_SEPARATOR);

        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        inputBuilder.append(Q).append(LINE_SEPARATOR);

        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            String MT = in.next(); // MIME type.
            inputBuilder.append(EXT).append(DEFAULT_ELEMENT_SEPARATOR).append(MT).append(LINE_SEPARATOR);
        }
        in.nextLine();
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            inputBuilder.append(FNAME).append(LINE_SEPARATOR);
        }
        this.input = inputBuilder.toString();
        this.totalEntries = totalEntries;
    }

    public Parser(final String input, final int totalEntries) {
        this.input = input;
        this.totalEntries = totalEntries;
    }

    public List<List<String>> parseWithSeparator(final int entry) {
        if (input != null && !input.isEmpty()) {
            lines = input.split(LINE_SEPARATOR);
            int entryValue = Integer.valueOf(lines[entry]);
            int offset = computeOffset(entry);
            return IntStream.range(0, entryValue)
                    .mapToObj(i -> Arrays.asList(lines[i + offset].split(DEFAULT_ELEMENT_SEPARATOR)))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public void showInput(){
        System.out.println(input);
    }

    private int computeOffset(final int entry) {
        return totalEntries + (entry > 0 ? IntStream.rangeClosed(0, entry - 1).map(i -> Integer.valueOf(lines[i])).sum() : 0);
    }
}

