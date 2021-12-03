package pl.marwar.filebot.actions;

import org.junit.Test;
import org.mockito.InjectMocks;
import pl.marwar.filebot.CommonMethodsForTesting;
import pl.marwar.filebot.scripts.Action;

import java.io.IOException;
import java.nio.file.Path;

public class CopyToTest {

    @InjectMocks
    CopyTo copyTo = new CopyTo();

    @Test
    public void testCopy() throws IOException {
        Path path = CommonMethodsForTesting.getPathTestFile();
        Action action = new Action("copyTo", "C:/testFileBot/");
        copyTo.execute(path, action);
    }
}
