package pl.marwar.filebot.actions;

import pl.marwar.filebot.scripts.Action;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MoveTo implements TakeAction {
    @Override
    public void execute(Path pathFile, Action action) {
        Path targetDirectoryPath = Paths.get(action.getActionParam());
        try {
            System.out.println("przenoszenie: " + pathFile + "do: " + targetDirectoryPath);
            Files.copy(pathFile, targetDirectoryPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("przenoszenie pliku " + pathFile + " zakończone niepowodzeniem");
        }
    }
}
