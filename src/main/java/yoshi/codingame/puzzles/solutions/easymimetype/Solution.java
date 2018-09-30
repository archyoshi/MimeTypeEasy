package yoshi.codingame.puzzles.solutions.easymimetype;

import java.util.*;
import java.io.*;
import java.math.*;
import java.util.stream.*;

// TODO: don't forget to remove package heading !
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        final EasyMimeTypeCompiler compiler = new EasyMimeTypeCompiler(in);
        final MimeTypePrinter printer = new MimeTypePrinter();

        System.out.println(printer.print(compiler.getAllMimeTypes()));
    }
}

interface Printer {
    String LINE_SEPARATOR = System.getProperty("line.separator");

    String print(List<String> elements);
}

interface MimeTypeCompiler {

    List<String> getAllMimeTypes();

    String getMimeType(String file);
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

    EasyMimeTypeCompiler(final Scanner in) {
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

    public List<String> getAllMimeTypes() {
        return filesToEvaluate.stream().map(this::getMimeType).collect(Collectors.toList());
    }

    public String getMimeType(final String fileName) {
        if (fileName != null) {
            return knownMimeTypes.entrySet().stream()
                    .filter(e -> {
                        if (fileName.contains(".")) {
                            String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                            return extension.equalsIgnoreCase(e.getKey());
                        }
                        return false;
                    })
                    .findFirst().orElse(new AbstractMap.SimpleEntry<>(null, "UNKNOWN")).getValue();
        } else {
            return "UNKNOWN";
        }
    }
}