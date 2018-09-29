package yoshi.codingame.puzzles.mimetype;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
                "1\n" +
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
                "1\n" +
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
                "2\n" +
                "4\n" +
                "html text/html\n" +
                "png image/png\n" +
                "test.html\n" +
                "noextension\n" +
                "portrait.png\n" +
                "doc.TXT";
        final MimeTypeParser mimeTypeParser = new MimeTypeParser(input);
        assertThat(mimeTypeParser.parseWithSeparator(0, " "));
    }
}