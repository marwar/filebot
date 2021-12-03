package pl.marwar.filebot.matchers;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import pl.marwar.filebot.CommonMethodsForTesting;
import pl.marwar.filebot.scripts.Matcher;

import java.nio.file.Path;

public class ExtensionIsNotTest {
    @InjectMocks
    private ExtensionIsNot extensionIsNot = new ExtensionIsNot();

    Path path = CommonMethodsForTesting.getOnlyPathTestFile();

    @Test
    public void testReturnTrue() {
        Matcher matcher = new Matcher("extensionIs", "pdf");
        Assert.assertTrue(extensionIsNot.match(path, matcher));
    }

    @Test
    public void testReturnFalse() {
        Matcher matcher = new Matcher("extensionIs", "txt");
        Assert.assertFalse(extensionIsNot.match(path, matcher));
    }
}
