package pl.marwar.filebot.matchers;

import org.apache.commons.lang3.StringUtils;
import pl.marwar.filebot.scripts.Matcher;

import java.nio.file.Path;

public class NameContains implements Matchers {
    @Override
    public Boolean match(Path pathFile, Matcher matcher) {
        return StringUtils.contains(pathFile.getFileName().toString(), matcher.getParam());
    }
}
