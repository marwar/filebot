package pl.marwar.filebot.actions;

import pl.marwar.filebot.scripts.Action;

import java.nio.file.Path;

@FunctionalInterface
public interface TakeAction {
    void execute(Path pathFile, Action action);
}
