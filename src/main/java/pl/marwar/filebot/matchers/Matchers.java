package pl.marwar.filebot.matchers;

import pl.marwar.filebot.scripts.Matcher;

import java.nio.file.Path;

public interface Matchers {
    Boolean match(Path pathFile, Matcher matcher);
}
