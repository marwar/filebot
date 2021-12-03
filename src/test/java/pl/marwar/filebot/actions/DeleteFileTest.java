package pl.marwar.filebot.actions;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import pl.marwar.filebot.scripts.Action;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteFileTest {

    @InjectMocks
    DeleteFile deleteFile = new DeleteFile();

    @Test
    public void testDeleteFile() throws IOException {
        Path path = Paths.get("src", "test", "resources", "testFile.txt");
        if (Files.notExists(path)) {
            Files.createFile(path);
        }
        Action action = new Action("deleteFile", null);
        deleteFile.execute(path, action);
        Assert.assertTrue(Files.notExists(path));
        Files.createFile(path);
    }
}
