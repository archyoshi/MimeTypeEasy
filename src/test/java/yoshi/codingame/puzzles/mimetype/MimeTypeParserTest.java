package yoshi.codingame.puzzles.mimetype;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static yoshi.codingame.puzzles.utils.Parser.LINE_SEPARATOR;

public class MimeTypeParserTest {

    @Test
    public void shouldParseSampleInput() {
        final String input = "" +
                "2" + LINE_SEPARATOR +
                "4" + LINE_SEPARATOR +
                "html text/html" + LINE_SEPARATOR +
                "png image/png" + LINE_SEPARATOR +
                "test.html" + LINE_SEPARATOR +
                "noextension" + LINE_SEPARATOR +
                "portrait.png" + LINE_SEPARATOR +
                "doc.TXT";
        final MimeTypeParser mimeTypeParser = new MimeTypeParser(input);

        List<List<String>> firstEntry = mimeTypeParser.parseWithSeparator(0);
        assertThat(firstEntry).isNotEmpty().hasSize(2);
        assertThat(firstEntry.get(0)).isNotEmpty().hasSize(2);
        assertThat(firstEntry.get(0)).containsExactly("html", "text/html");
        assertThat(firstEntry.get(1)).isNotEmpty().hasSize(2);
        assertThat(firstEntry.get(1)).containsExactly("png", "image/png");

        List<List<String>> secondEntry = mimeTypeParser.parseWithSeparator(1);
        assertThat(secondEntry).isNotEmpty().hasSize(4);
        assertThat(secondEntry.get(0)).isNotEmpty().hasSize(1);
        assertThat(secondEntry.get(0)).containsExactly("test.html");
        assertThat(secondEntry.get(1)).isNotEmpty().hasSize(1);
        assertThat(secondEntry.get(1)).containsExactly("noextension");
        assertThat(secondEntry.get(2)).isNotEmpty().hasSize(1);
        assertThat(secondEntry.get(2)).containsExactly("portrait.png");
        assertThat(secondEntry.get(3)).isNotEmpty().hasSize(1);
        assertThat(secondEntry.get(3)).containsExactly("doc.TXT");
    }
}