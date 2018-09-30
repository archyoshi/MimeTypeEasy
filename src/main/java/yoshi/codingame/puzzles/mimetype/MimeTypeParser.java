package yoshi.codingame.puzzles.mimetype;

import yoshi.codingame.puzzles.utils.Parser;

import java.util.Scanner;

public class MimeTypeParser extends Parser {

    public MimeTypeParser(final Scanner in) {
        super(in, 2);
    }

    public MimeTypeParser(final String input) {
        super(input, 2);
    }

}
