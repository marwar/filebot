package pl.marwar.filebot.actions;

import org.junit.Test;
import org.mockito.InjectMocks;
import pl.marwar.filebot.scripts.Action;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MoveToTest {

    @Test
    public void testMoveTo() throws IOException {
        Path path = Paths.get("src", "test", "resources", "testFile.txt");
        if (Files.notExists(path)) {
            Files.createFile(path);
        }
        Action action = new Action("moveTo", String.valueOf(path.toAbsolutePath()));
        moveTo.execute(path, action);

    }

    @InjectMocks
    MoveTo moveTo = new MoveTo();
}
