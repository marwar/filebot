package pl.marwar.filebot.matchers;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import pl.marwar.filebot.scripts.Matcher;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NameContainsTest {
    @InjectMocks
    private NameContains nameContains = new NameContains();

    Path path = Paths.get("src", "test", "resources", "testFile.txt");

    @Test
    public void testReturnTrue() {
        Matcher matcher = new Matcher("nameContains", "test");
        Assert.assertTrue(nameContains.match(path, matcher));
    }

    @Test
    public void testReturnFalse() {
        Matcher matcher = new Matcher("nameContains", "homeImage");
        Assert.assertFalse(nameContains.match(path, matcher));
    }
}
