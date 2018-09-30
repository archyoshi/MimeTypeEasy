package yoshi.codingame.puzzles.solutions.easymimetype;

import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;
        import java.util.Scanner;
        import java.util.stream.Collectors;

interface Printer {
    String LINE_SEPARATOR = System.getProperty("line.separator");

    String print(List<String> elements);
}

interface MimeTypeCompiler {

    List<String> getAllMimeTypes();

    String getMimeType(String file);
}

// TODO: don't forget to remove package heading !
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        final EasyMimeTypeCompiler compiler = new EasyMimeTypeCompiler(in);
        final MimeTypePrinter printer = new MimeTypePrinter();

        System.out.println(printer.print(compiler.getAllMimeTypes()));
    }
}

class MimeTypePrinter implements Printer {

    @Override
    public String print(final List<String> elements) {
        return String.join(LINE_SEPARATOR, elements);
    }
}

class EasyMimeTypeCompiler implements MimeTypeCompiler {

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
