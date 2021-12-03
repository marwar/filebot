package pl.marwar.filebot.actions;

import lombok.extern.java.Log;
import pl.marwar.filebot.scripts.Action;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Log
public class DeleteFile implements TakeAction {

    @Override
    public void execute(Path pathFile, Action action) {

        try {
            System.out.println("kasowanie: " + pathFile);
            Files.delete(pathFile);
        } catch (IOException e) {
            System.out.println("kasowanie pliku " + pathFile + " zakończone niepowodzeniem");
            log.info(e.getMessage());
        }
    }
}
