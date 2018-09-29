package yoshi.codingame.puzzles.mimetype;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class EasyMimeTypeCompilerTest {


    @Test
    @Parameters({
            "noextension, UNKNOWN",
            "test.html, text/html",
            "something.png ,image/png"})
    public void shouldPrintMimeTypeForGivenInputFile(String file, String mimeType) {
        final EasyMimeTypeCompiler compiler = new EasyMimeTypeCompiler();
        assertThat(compiler.getMimeTypeFor(file)).isEqualTo(mimeType);
    }

    @Test
    @Ignore
    void listMimeTypesOfAllEntriesMultipleCases() {
        String input = "" +
                "2\n" +
                "4\n" +
                "html text/html\n" +
                "png image/png\n" +
                "test.html\n" +
                "noextension\n" +
                "portrait.png\n" +
                "doc.TXT";
        String output = "" +
                "text/html\n" +
                "UNKNOWN\n" +
                "image/png\n" +
                "UNKNOWN";
        assertThat(MimeTypeCompiler.generateListFor(input)).isEqualTo(output);
    }

}