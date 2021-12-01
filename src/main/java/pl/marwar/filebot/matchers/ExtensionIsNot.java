package pl.marwar.filebot.matchers;

import org.apache.commons.io.FilenameUtils;
import pl.marwar.filebot.scripts.Action;

import java.nio.file.Path;

public class ExtensionIsNot implements Matchers{
    @Override
    public Boolean match(Path pathFile, Action action) {
        return !FilenameUtils.isExtension(String.valueOf(pathFile),action.getActionParam());
    }
}
