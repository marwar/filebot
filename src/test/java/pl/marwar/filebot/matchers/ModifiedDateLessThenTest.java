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

public class ModifiedDateLessThenTest {
    @InjectMocks
    private ModifiedDateLessThen modifiedDateLessThen = new ModifiedDateLessThen();

    Path path = CommonMethodsForTesting.getOnlyPathTestFile();

    @Test
    public void testReturnFalse() throws IOException {
        // 2021-12-01
        long milis = 1638316800;
        FileTime fileTime = FileTime.fromMillis(System.currentTimeMillis());
        Files.setLastModifiedTime(path, fileTime);
        Matcher matcher = new Matcher("modifiedDateLessThen", "20211030");
        Assert.assertFalse(modifiedDateLessThen.match(path, matcher));
    }

    @Test
    public void testReturnTrue() throws IOException {
        // 2021-12-01
        long milis = 1638316800;
        FileTime fileTime = FileTime.fromMillis(System.currentTimeMillis());
        Files.setLastModifiedTime(path, fileTime);
        Matcher matcher = new Matcher("modifiedDateLessThen", "20211231");
        Assert.assertTrue(modifiedDateLessThen.match(path, matcher));
    }
}
