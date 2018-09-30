package yoshi.codingame.puzzles.mimetype;

import yoshi.codingame.puzzles.utils.Printer;

import java.util.List;

public class MimeTypePrinter implements Printer {

    @Override
    public String print(final List<String> elements) {
        return String.join(LINE_SEPARATOR, elements);
    }
}
