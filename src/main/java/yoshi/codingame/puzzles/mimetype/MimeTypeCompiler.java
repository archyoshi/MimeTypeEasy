package yoshi.codingame.puzzles.mimetype;

import java.util.List;

public interface MimeTypeCompiler {

    List<String> getAllMimeTypes();

    String getMimeType(String file);
}
