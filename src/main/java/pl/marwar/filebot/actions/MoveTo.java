package pl.marwar.filebot.actions;

import lombok.extern.java.Log;
import pl.marwar.filebot.files.FileUtils;
import pl.marwar.filebot.scripts.Action;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Log
public class MoveTo implements TakeAction {
    @Override
    public void execute(Path pathFile, Action action) {

        try {
            Path targetDirectoryPath = FileUtils.getPathAndVeryficationDirectoryToAction(pathFile, action);
            if (!pathFile.equals(targetDirectoryPath)) {
                System.out.println("przenoszenie: " + pathFile + " do: " + targetDirectoryPath);
                Files.copy(pathFile, targetDirectoryPath, StandardCopyOption.REPLACE_EXISTING);
            } else {
                // nie ma sensu wykonywać operacji na pliku skoro to by było przeniesienie w to samo miejsce
                System.out.println("przenoszenie: " + pathFile + " -> katalog docelowy taki sam jak pierwotny");
            }
        } catch (IOException e) {
            System.out.println("przenoszenie pliku " + pathFile + " zakończone niepowodzeniem");
            log.info(e.getMessage());
            e.printStackTrace();
        }
    }

}
