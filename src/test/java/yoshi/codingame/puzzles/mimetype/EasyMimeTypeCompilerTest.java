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
            "test.html, text/html",
            "noextension, UNKNOWN",
            "portrait.png ,image/png",
            "doc.TXT, UNKNOWN"
    })
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
        final MimeTypeParser mimeTypeParser = new MimeTypeParser(input);
        final EasyMimeTypeCompiler compiler = new EasyMimeTypeCompiler(mimeTypeParser);
        assertThat(compiler.getMimeType(file)).isEqualTo(mimeType);
    }

    @Test
    public void shouldPrintUknownWhenPointWithNoExtension() {
        String input = "" +
                "1\r\n" +
                "1\r\n" +
                "html text/html\r\n" +
                "more.";
        final MimeTypeParser mimeTypeParser = new MimeTypeParser(input);
        final EasyMimeTypeCompiler compiler = new EasyMimeTypeCompiler(mimeTypeParser);
        assertThat(compiler.getMimeType("more.")).isEqualTo("UNKNOWN");
    }

    @Test
    public void shouldPrintUknownWhenLastExtensionIsUnknown() {
        String input = "" +
                "1\r\n" +
                "1\r\n" +
                "html text/html\r\n" +
                "more.html.tmp";
        final MimeTypeParser mimeTypeParser = new MimeTypeParser(input);
        final EasyMimeTypeCompiler compiler = new EasyMimeTypeCompiler(mimeTypeParser);
        assertThat(compiler.getMimeType("more.html.tmp")).isEqualTo("UNKNOWN");
    }

    @Test
    public void shouldPrintUknownWhenLastExtensionIsNotExactlyAsListed() {
        String input = "" +
                "1\r\n" +
                "1\r\n" +
                "html text/html\r\n" +
                "more.xhtml";
        final MimeTypeParser mimeTypeParser = new MimeTypeParser(input);
        final EasyMimeTypeCompiler compiler = new EasyMimeTypeCompiler(mimeTypeParser);
        assertThat(compiler.getMimeType("more.xhtml")).isEqualTo("UNKNOWN");
    }


    @Test
    public void shouldPrintExtensionEvenWhenNotMatchingCase() {
        String input = "" +
                "1\r\n" +
                "1\r\n" +
                "html text/html\r\n" +
                "more.HTML";
        final MimeTypeParser mimeTypeParser = new MimeTypeParser(input);
        final EasyMimeTypeCompiler compiler = new EasyMimeTypeCompiler(mimeTypeParser);
        assertThat(compiler.getMimeType("more.HTML")).isEqualTo("text/html");
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
        final MimeTypeParser mimeTypeParser = new MimeTypeParser(input);
        final EasyMimeTypeCompiler compiler = new EasyMimeTypeCompiler(mimeTypeParser);
        final MimeTypePrinter printer = new MimeTypePrinter();
        assertThat(printer.print(compiler.getAllMimeTypes())).isEqualTo(output);
    }

}