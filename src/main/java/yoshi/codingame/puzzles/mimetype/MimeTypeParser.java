package yoshi.codingame.puzzles.mimetype;

import yoshi.codingame.puzzles.utils.Parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MimeTypeParser implements Parser {
    private final String input;
    private String[] lines;


    public MimeTypeParser(final String input) {
        this.input = input;
    }

    @Override
    public List<List<String>> parseWithSeparator(final int line, final String separator) {
        if(input != null && !input.isEmpty()){
            lines = input.split(LINE_SEPARATOR);
            List<String> elements = new ArrayList<>();
            if (lines.length > 0) {
                Collections.addAll(elements, lines[1].split(separator));
            }
            return new ArrayList<>(Collections.singleton(elements));
        }
        return Collections.emptyList();
    }
}
