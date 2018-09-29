import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class MimeTypeCompilerTest {

    @Test
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
        Assertions.assertThat(MimeTypeCompiler.generateListFor(input)).isEqualTo(output);
    }
}