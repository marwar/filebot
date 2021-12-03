package pl.marwar.filebot.actions;

import org.junit.Test;
import org.mockito.InjectMocks;
import pl.marwar.filebot.scripts.Action;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyToTest {

    @Test
    public void testCopy() {
        Path path = Paths.get("src", "test", "resources", "testFile.txt");
        Action action = new Action("copyTo", "C:/testFileBot/");
        copyTo.execute(path, action);
    }

    @InjectMocks
    CopyTo copyTo = new CopyTo();
}
