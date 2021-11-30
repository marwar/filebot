package pl.marwar.filebot.actions;

import pl.marwar.filebot.scripts.Action;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyTo implements TakeAction {
    @Override
    public void execute(Path pathFile, Action action) {
        Path targetDirectoryPath = Paths.get(action.getActionParam());
        try {
            System.out.println("kopiowanie: " + pathFile + "do: " + targetDirectoryPath);
            Files.copy(pathFile,targetDirectoryPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("kopiowanie pliku" + pathFile + " zakończone niepowodzeniem");
        }
    }
}
