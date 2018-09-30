package yoshi.codingame.puzzles.utils;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static yoshi.codingame.puzzles.utils.Parser.LINE_SEPARATOR;

public class ParserTest {

    @Test
    public void shouldReturnEmptyListWhenNullInput() {
        final String input = null;
        final Parser parser = new Parser(input, 1);
        assertThat(parser.parseWithSeparator(0))
                .isEmpty();
    }

    @Test
    public void shouldReturnEmptyListOnEmptyInput() {
        final String input = "";
        final Parser parser = new Parser(input, 1);
        assertThat(parser.parseWithSeparator(0))
                .isEmpty();
    }

    @Test
    public void shouldReadFirstInputAsOneWithOneValue() {
        final String input = "" +
                "1" + LINE_SEPARATOR +
                "a";
        final Parser parser = new Parser(input, 1);
        List<List<String>> actual = parser.parseWithSeparator(0);
        assertThat(actual).isNotEmpty().hasSize(1);
        assertThat(actual.get(0)).isNotEmpty().hasSize(1);
        assertThat(actual.get(0)).containsExactly("a");
    }

    @Test
    public void shouldReadFirstInputAsOneWithManyValues() {
        final String input = "" +
                "1" + LINE_SEPARATOR +
                "a b";
        final Parser parser = new Parser(input, 1);
        List<List<String>> actual = parser.parseWithSeparator(0);
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
        final Parser parser = new Parser(input, 1);
        List<List<String>> actual = parser.parseWithSeparator(0);
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
        final Parser parser = new Parser(input, 2);

        List<List<String>> firstEntry = parser.parseWithSeparator(0);
        assertThat(firstEntry).isNotEmpty().hasSize(2);
        assertThat(firstEntry.get(0)).isNotEmpty().hasSize(2);
        assertThat(firstEntry.get(0)).containsExactly("a", "b");
        assertThat(firstEntry.get(1)).isNotEmpty().hasSize(2);
        assertThat(firstEntry.get(1)).containsExactly("c", "d");

        List<List<String>> secondEntry = parser.parseWithSeparator(1);
        assertThat(secondEntry).isNotEmpty().hasSize(2);
        assertThat(secondEntry.get(0)).isNotEmpty().hasSize(2);
        assertThat(secondEntry.get(0)).containsExactly("e", "f");
        assertThat(secondEntry.get(1)).isNotEmpty().hasSize(2);
        assertThat(secondEntry.get(1)).containsExactly("g", "h");
    }

    @Test
    public void shouldReadAllInputsWithManyValues() {
        final String input = "" +
                "2" + LINE_SEPARATOR +
                "2" + LINE_SEPARATOR +
                "2" + LINE_SEPARATOR +
                "a b"+ LINE_SEPARATOR +
                "c d"+ LINE_SEPARATOR +
                "e f"+ LINE_SEPARATOR +
                "g h"+ LINE_SEPARATOR +
                "i j"+ LINE_SEPARATOR +
                "k l";
        final Parser parser = new Parser(input, 3);

        List<List<String>> firstEntry = parser.parseWithSeparator(0);
        assertThat(firstEntry).isNotEmpty().hasSize(2);
        assertThat(firstEntry.get(0)).isNotEmpty().hasSize(2);
        assertThat(firstEntry.get(0)).containsExactly("a", "b");
        assertThat(firstEntry.get(1)).isNotEmpty().hasSize(2);
        assertThat(firstEntry.get(1)).containsExactly("c", "d");

        List<List<String>> secondEntry = parser.parseWithSeparator(1);
        assertThat(secondEntry).isNotEmpty().hasSize(2);
        assertThat(secondEntry.get(0)).isNotEmpty().hasSize(2);
        assertThat(secondEntry.get(0)).containsExactly("e", "f");
        assertThat(secondEntry.get(1)).isNotEmpty().hasSize(2);
        assertThat(secondEntry.get(1)).containsExactly("g", "h");

        List<List<String>> thirdEntry = parser.parseWithSeparator(2);
        assertThat(thirdEntry).isNotEmpty().hasSize(2);
        assertThat(thirdEntry.get(0)).isNotEmpty().hasSize(2);
        assertThat(thirdEntry.get(0)).containsExactly("i", "j");
        assertThat(thirdEntry.get(1)).isNotEmpty().hasSize(2);
        assertThat(thirdEntry.get(1)).containsExactly("k", "l");
    }

    @Test
    public void shouldReadAllInputsWithManyValuesRandom() {
        final String input = "" +
                "1" + LINE_SEPARATOR +
                "2" + LINE_SEPARATOR +
                "3" + LINE_SEPARATOR +
                "a"+ LINE_SEPARATOR +
                "b c"+ LINE_SEPARATOR +
                "d e"+ LINE_SEPARATOR +
                "f g h"+ LINE_SEPARATOR +
                "i j k"+ LINE_SEPARATOR +
                "l m n";
        final Parser parser = new Parser(input, 3);

        List<List<String>> firstEntry = parser.parseWithSeparator(0);
        assertThat(firstEntry).isNotEmpty().hasSize(1);
        assertThat(firstEntry.get(0)).isNotEmpty().hasSize(1);
        assertThat(firstEntry.get(0)).containsExactly("a");

        List<List<String>> secondEntry = parser.parseWithSeparator(1);
        assertThat(secondEntry).isNotEmpty().hasSize(2);
        assertThat(secondEntry.get(0)).isNotEmpty().hasSize(2);
        assertThat(secondEntry.get(0)).containsExactly("b", "c");
        assertThat(secondEntry.get(1)).isNotEmpty().hasSize(2);
        assertThat(secondEntry.get(1)).containsExactly("d", "e");

        List<List<String>> thirdEntry = parser.parseWithSeparator(2);
        assertThat(thirdEntry).isNotEmpty().hasSize(3);
        assertThat(thirdEntry.get(0)).isNotEmpty().hasSize(3);
        assertThat(thirdEntry.get(0)).containsExactly("f", "g", "h");
        assertThat(thirdEntry.get(1)).isNotEmpty().hasSize(3);
        assertThat(thirdEntry.get(1)).containsExactly("i", "j", "k");
        assertThat(thirdEntry.get(2)).isNotEmpty().hasSize(3);
        assertThat(thirdEntry.get(2)).containsExactly("l", "m", "n");
    }
}