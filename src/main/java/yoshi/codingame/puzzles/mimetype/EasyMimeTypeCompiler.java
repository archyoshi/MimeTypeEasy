package yoshi.codingame.puzzles.mimetype;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EasyMimeTypeCompiler implements MimeTypeCompiler {

    private final Map<String, String> knownMimeTypes;
    private final List<String> filesToEvaluate;

    public EasyMimeTypeCompiler(final MimeTypeParser parser) {
        knownMimeTypes = parser.parseWithSeparator(0).stream().collect(Collectors.toMap(l -> l.get(0), l -> l.get(1)));
        filesToEvaluate = parser.parseWithSeparator(1).stream().map(e -> e.get(0)).collect(Collectors.toList());
    }

    @Override
    public List<String> getAllMimeTypes() {
        return filesToEvaluate.stream().map(this::getMimeType).collect(Collectors.toList());
    }

    @Override
    public String getMimeType(final String fileName) {
        if (fileName != null) {
            return knownMimeTypes.entrySet().stream()
                    .filter(e -> {
                        if(fileName.contains(".")){
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
