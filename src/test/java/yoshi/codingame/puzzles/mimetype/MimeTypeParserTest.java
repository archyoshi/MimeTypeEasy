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
        final MimeTypeParser mimeTypeParser = new MimeTypeParser(input, 1);
        assertThat(mimeTypeParser.parseWithSeparator(0, " "))
                .isEmpty();
    }

    @Test
    public void shouldReturnEmptyListOnEmptyInput() {
        final String input = "";
        final MimeTypeParser mimeTypeParser = new MimeTypeParser(input, 1);
        assertThat(mimeTypeParser.parseWithSeparator(0, " "))
                .isEmpty();
    }

    @Test
    public void shouldReadFirstInputAsOneWithOneValue() {
        final String input = "" +
                "1" + LINE_SEPARATOR +
                "a";
        final MimeTypeParser mimeTypeParser = new MimeTypeParser(input, 1);
        List<List<String>> actual = mimeTypeParser.parseWithSeparator(0, " ");
        assertThat(actual).isNotEmpty().hasSize(1);
        assertThat(actual.get(0)).isNotEmpty().hasSize(1);
        assertThat(actual.get(0).get(0)).isEqualTo("a");
    }

    @Test
    public void shouldReadFirstInputAsOneWithManyValues() {
        final String input = "" +
                "1" + LINE_SEPARATOR +
                "a b";
        final MimeTypeParser mimeTypeParser = new MimeTypeParser(input, 1);
        List<List<String>> actual = mimeTypeParser.parseWithSeparator(0, " ");
        assertThat(actual).isNotEmpty().hasSize(1);
        assertThat(actual.get(0)).isNotEmpty().hasSize(2);
        assertThat(actual.get(0)).containsExactly("a", "b");
    }

    @Test
    public void shouldReadFirstInputGreaterThanOneWithManyValues() {
        final String input = "" +
                "2" + LINE_SEPARATOR +
                "a b"+ LINE_SEPARATOR +
                "c d";
        final MimeTypeParser mimeTypeParser = new MimeTypeParser(input, 1);
        List<List<String>> actual = mimeTypeParser.parseWithSeparator(0, " ");
        assertThat(actual).isNotEmpty().hasSize(2);
        assertThat(actual.get(0)).isNotEmpty().hasSize(2);
        assertThat(actual.get(0)).containsExactly("a", "b");
        assertThat(actual.get(1)).isNotEmpty().hasSize(2);
        assertThat(actual.get(1)).containsExactly("c", "d");
    }

    @Test
    public void shouldReadFirstAndSecondInputWithManyValues() {
        final String input = "" +
                "2" + LINE_SEPARATOR +
                "2" + LINE_SEPARATOR +
                "a b"+ LINE_SEPARATOR +
                "c d"+ LINE_SEPARATOR +
                "e f"+ LINE_SEPARATOR +
                "g h";
        final MimeTypeParser mimeTypeParser = new MimeTypeParser(input, 2);

        List<List<String>> firstEntry = mimeTypeParser.parseWithSeparator(0, " ");
        assertThat(firstEntry).isNotEmpty().hasSize(2);
        assertThat(firstEntry.get(0)).isNotEmpty().hasSize(2);
        assertThat(firstEntry.get(0)).containsExactly("a", "b");
        assertThat(firstEntry.get(1)).isNotEmpty().hasSize(2);
        assertThat(firstEntry.get(1)).containsExactly("c", "d");

        List<List<String>> secondEntry = mimeTypeParser.parseWithSeparator(1, " ");
        assertThat(secondEntry.get(0)).isNotEmpty().hasSize(2);
        assertThat(secondEntry.get(0)).containsExactly("e", "f");
        assertThat(secondEntry.get(1)).isNotEmpty().hasSize(2);
        assertThat(secondEntry.get(1)).containsExactly("g", "h");
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
        final MimeTypeParser mimeTypeParser = new MimeTypeParser(input, 1);
        assertThat(mimeTypeParser.parseWithSeparator(0, " "));
    }
}