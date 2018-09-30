package yoshi.codingame.puzzles.mimetype;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class EasyMimeTypeCompilerTest {


    @Test
    @Parameters({
            "noextension, UNKNOWN",
            "test.html, text/html",
            "something.png ,image/png"})
    public void shouldPrintMimeTypeForGivenInputFile(String file, String mimeType) {
        String input = "" +
                "2\r\n" +
                "4\r\n" +
                "html text/html\r\n" +
                "png image/png\r\n" +
                "test.html\r\n" +
                "noextension\r\n" +
                "portrait.png\r\n" +
                "doc.TXT";
        final MimeTypeParser mimeTypeParser = new MimeTypeParser(input, 2);
        final EasyMimeTypeCompiler compiler = new EasyMimeTypeCompiler(mimeTypeParser);
        assertThat(compiler.getMimeType(file)).isEqualTo(mimeType);
    }

    @Test
    public void listMimeTypesOfAllEntriesMultipleCases() {
        String input = "" +
                "2\r\n" +
                "4\r\n" +
                "html text/html\r\n" +
                "png image/png\r\n" +
                "test.html\r\n" +
                "noextension\r\n" +
                "portrait.png\r\n" +
                "doc.TXT";
        String output = "" +
                "text/html\r\n" +
                "UNKNOWN\r\n" +
                "image/png\r\n" +
                "UNKNOWN";
        final MimeTypeParser mimeTypeParser = new MimeTypeParser(input, 2);
        final EasyMimeTypeCompiler compiler = new EasyMimeTypeCompiler(mimeTypeParser);
        final MimeTypePrinter printer = new MimeTypePrinter();
        assertThat(printer.print(compiler.getAllMimeTypes())).isEqualTo(output);
    }

}