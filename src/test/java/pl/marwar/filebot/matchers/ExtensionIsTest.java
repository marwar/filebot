package pl.marwar.filebot.matchers;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import pl.marwar.filebot.CommonMethodsForTesting;
import pl.marwar.filebot.scripts.Matcher;

import java.nio.file.Path;

public class ExtensionIsTest {
    @InjectMocks
    private ExtensionIs extensionIs = new ExtensionIs();

    Path path = CommonMethodsForTesting.getOnlyPathTestFile();

    @Test
    public void testReturnTrue() {
        Matcher matcher = new Matcher("extensionIs", "txt");
        Assert.assertTrue(extensionIs.match(path, matcher));
    }

    @Test
    public void testReturnFalse() {
        Matcher matcher = new Matcher("extensionIs", "pdf");
        Assert.assertFalse(extensionIs.match(path, matcher));
    }
}
