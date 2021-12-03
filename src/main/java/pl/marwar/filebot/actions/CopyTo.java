package pl.marwar.filebot.actions;

import lombok.extern.java.Log;
import pl.marwar.filebot.files.FileUtils;
import pl.marwar.filebot.scripts.Action;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Log
public class CopyTo implements TakeAction {
    @Override
    public void execute(Path pathFile, Action action) {
        try {
            Path targetDirectoryPath = FileUtils.getPathAndVeryficationDirectoryToAction(pathFile, action);
            System.out.println("kopiowanie: " + pathFile + " do: " + targetDirectoryPath);
            Files.copy(pathFile, targetDirectoryPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("kopiowanie pliku " + pathFile + " zakończone niepowodzeniem");
            log.info(e.getMessage());
        }
    }
}
