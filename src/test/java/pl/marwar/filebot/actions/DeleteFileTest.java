package pl.marwar.filebot.actions;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import pl.marwar.filebot.CommonMethodsForTesting;
import pl.marwar.filebot.scripts.Action;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DeleteFileTest {

    @InjectMocks
    DeleteFile deleteFile = new DeleteFile();

    @Test
    public void testDeleteFile() throws IOException {
        Path path = CommonMethodsForTesting.getPathTestFile();
        Action action = new Action("deleteFile", null);
        deleteFile.execute(path, action);
        Assert.assertTrue(Files.notExists(path));
        Files.createFile(path);
    }

}
