package yoshi.codingame.puzzles.mimetype;

import yoshi.codingame.puzzles.utils.GenericParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EasyMimeTypeCompiler implements MimeTypeCompiler {

    private final int N;
    private final int Q;
    private final Map<String, String> knownMimeTypes;
    private final List<String> filesToEvaluate;

    public EasyMimeTypeCompiler(final Scanner in) {
        // Number of elements which make up the association table.
        N = in.nextInt();

        // Number Q of file names to be analyzed.
        Q = in.nextInt();

        knownMimeTypes = new HashMap<>();
        for (int i = 0; i < N; i++) {
            knownMimeTypes.put(in.next().toLowerCase(), in.next()); // (EXT, MT)
        }
        in.nextLine();

        filesToEvaluate = new ArrayList<>();
        for (int i = 0; i < Q; i++) {
            filesToEvaluate.add(in.nextLine()); // One file name per line.
        }
    }

    public EasyMimeTypeCompiler(final GenericParser parser) {
        N = 0;
        Q = 0;
        knownMimeTypes = parser.parseWithSeparator(0).stream().collect(Collectors.toMap(l -> l.get(0).toLowerCase(), l -> l.get(1)));
        filesToEvaluate = parser.parseWithSeparator(1).stream().map(e -> e.get(0)).collect(Collectors.toList());
    }

    @Override
    public List<String> getAllMimeTypes() {
        return filesToEvaluate.parallelStream().map(this::getMimeType).collect(Collectors.toList());
    }

    @Override
    public String getMimeType(final String fileName) {
        int lastDotIndex = fileName.lastIndexOf(".");
        if (lastDotIndex < 0) {
            return "UNKNOWN";
        }
        final String mimeType = knownMimeTypes.get(fileName.substring(lastDotIndex + 1).toLowerCase());
        if(mimeType != null)
            return mimeType;
        return "UNKNOWN";
    }
}
