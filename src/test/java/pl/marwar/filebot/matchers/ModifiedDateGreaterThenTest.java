package pl.marwar.filebot.matchers;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import pl.marwar.filebot.CommonMethodsForTesting;
import pl.marwar.filebot.scripts.Matcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;

public class ModifiedDateGreaterThenTest {
    @InjectMocks
    private ModifiedDateGreaterThen modifiedDateGreaterThen = new ModifiedDateGreaterThen();

    Path path = CommonMethodsForTesting.getOnlyPathTestFile();

    @Test
    public void testReturnTrue() throws IOException {

        FileTime fileTime = FileTime.fromMillis(System.currentTimeMillis());
        Files.setLastModifiedTime(path, fileTime);
        Matcher matcher = new Matcher("modifiedDateGreaterThen", "20211030");
        Assert.assertTrue(modifiedDateGreaterThen.match(path, matcher));
    }

    @Test
    public void testReturnFalse() throws IOException {

        FileTime fileTime = FileTime.fromMillis(System.currentTimeMillis());
        Files.setLastModifiedTime(path, fileTime);
        Matcher matcher = new Matcher("modifiedDateGreaterThen", "20211231");
        Assert.assertFalse(modifiedDateGreaterThen.match(path, matcher));
    }
}
