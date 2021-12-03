package pl.marwar.filebot.matchers;

import org.apache.commons.io.FilenameUtils;
import pl.marwar.filebot.scripts.Matcher;

import java.nio.file.Path;

public class ExtensionIsNot implements Matchers {
    @Override
    public Boolean match(Path pathFile, Matcher matcher) {
        return !FilenameUtils.isExtension(String.valueOf(pathFile), matcher.getParam());
    }
}
