package yoshi.codingame.puzzles.mimetype;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static yoshi.codingame.puzzles.utils.Parser.LINE_SEPARATOR;

public class MimeTypeParserTest {

    @Test
    public void shouldReturnEmptyListWhenNullInput() {
        final String input = null;
        final MimeTypeParser mimeTypeParser = new MimeTypeParser(input);
        assertThat(mimeTypeParser.parseWithSeparator(0, " "))
                .isEmpty();
    }

    @Test
    public void shouldReturnEmptyListOnEmptyInput() {
        final String input = "";
        final MimeTypeParser mimeTypeParser = new MimeTypeParser(input);
        assertThat(mimeTypeParser.parseWithSeparator(0, " "))
                .isEmpty();
    }

    @Test
    public void shouldReadFirstInputWithOneValue() {
        final String input = "" +
                "1" + LINE_SEPARATOR +
                "a";
        final MimeTypeParser mimeTypeParser = new MimeTypeParser(input);
        List<List<String>> actual = mimeTypeParser.parseWithSeparator(0, " ");
        assertThat(actual).isNotEmpty().hasSize(1);
        assertThat(actual.get(0)).isNotEmpty().hasSize(1);
        assertThat(actual.get(0).get(0)).isEqualTo("a");
    }

    @Test
    public void shouldReadFirstInputWithManyValues() {
        final String input = "" +
                "1" + LINE_SEPARATOR +
                "a b";
        final MimeTypeParser mimeTypeParser = new MimeTypeParser(input);
        List<List<String>> actual = mimeTypeParser.parseWithSeparator(0, " ");
        assertThat(actual).isNotEmpty().hasSize(1);
        assertThat(actual.get(0)).isNotEmpty().hasSize(2);
        assertThat(actual.get(0)).containsExactly("a", "b");
    }

    @Test
    @Ignore
    public void name() {
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
        assertThat(mimeTypeParser.parseWithSeparator(0, " "));
    }
}