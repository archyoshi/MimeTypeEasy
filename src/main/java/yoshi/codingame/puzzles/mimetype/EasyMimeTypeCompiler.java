package yoshi.codingame.puzzles.mimetype;

public class EasyMimeTypeCompiler implements MimeTypeCompiler {

    @Override
    public String getMimeTypeFor(final String s) {
        if (!s.contains("."))
            return "UNKNOWN";
        return "text/html";
    }
}
