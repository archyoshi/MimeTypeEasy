package yoshi.codingame.puzzles.mimetype;

import yoshi.codingame.puzzles.utils.GenericParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MimeTypeParser extends GenericParser {

    private final int N;
    private final int Q;
    private final Map<String, String> knownMimeTypes;
    private final List<String> filesToEvaluate;

    public MimeTypeParser(final String input) {
        super(input, 2);
        N=0;
        Q=0;
        knownMimeTypes=null;
        filesToEvaluate=null;
    }

    public MimeTypeParser(final Scanner in) {
        super(in, 2);

        // Number of elements which make up the association table.
        N = in.nextInt();

        // Number Q of file names to be analyzed.
        Q = in.nextInt();

        knownMimeTypes = new HashMap<>();
        for (int i = 0; i < N; i++) {
            knownMimeTypes.put(in.next(), in.next()); // (EXT, MT)
        }
        in.nextLine();

        filesToEvaluate = new ArrayList<>();
        for (int i = 0; i < Q; i++) {
            filesToEvaluate.add(in.nextLine()); // One file name per line.
        }
    }

    public Map<String, String> getKnownMimeTypes() {
        return knownMimeTypes;
    }

    public List<String> getFilesToEvaluate() {
        return filesToEvaluate;
    }
}
