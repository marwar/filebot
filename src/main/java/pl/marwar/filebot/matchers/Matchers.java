package pl.marwar.filebot.matchers;

import pl.marwar.filebot.scripts.Action;

import java.nio.file.Path;

public interface Matchers {
    Boolean match(Path pathFile, Action action);
}
