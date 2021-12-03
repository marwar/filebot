package pl.marwar.filebot.actions;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import pl.marwar.filebot.CommonMethodsForTesting;
import pl.marwar.filebot.files.FileUtils;
import pl.marwar.filebot.scripts.Action;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MoveToTest {

    @InjectMocks
    MoveTo moveTo = new MoveTo();

    @Test
    public void testMoveToIsTheSameDir() throws IOException {
        Path path = CommonMethodsForTesting.getPathTestFile();
        Action action = new Action("moveTo", String.valueOf(path));
        moveTo.execute(path, action);

        boolean creationFileIsExist = Files.exists(FileUtils.getPathAndVeryficationDirectoryToAction(path, action));
        Assert.assertTrue(creationFileIsExist);
    }

    @Test
    public void testMoveToOtherDict() throws IOException {
        Path path = CommonMethodsForTesting.getPathTestFile();
        Action action = new Action("moveTo", "src/test/resources/move");
        moveTo.execute(path, action);

        boolean creationFileIsExist = Files.exists(FileUtils.getPathAndVeryficationDirectoryToAction(path, action));
        Assert.assertTrue(creationFileIsExist);
        if (creationFileIsExist) {
            Path pathToDel = Paths.get("src", "test", "resources", "move");
            FileUtils.deletePath(pathToDel);
        }

    }
}
