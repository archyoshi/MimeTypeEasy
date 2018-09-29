import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class EasyMimeTypeCompilerTest {


    @Test
    @Parameters({"noextension"})
    public void shouldPrintMimeTypeForGivenInputFile(String file) {
        final EasyMimeTypeCompiler compiler = new EasyMimeTypeCompiler();
        Assertions.assertThat(compiler.getMimeTypeFor(file)).isEqualTo("UNKNOWN");
    }

}