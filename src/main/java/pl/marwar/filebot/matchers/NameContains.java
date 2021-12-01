package pl.marwar.filebot.matchers;

import org.apache.commons.lang3.StringUtils;
import pl.marwar.filebot.scripts.Action;

import java.nio.file.Path;

public class NameContains implements Matchers{
    @Override
    public Boolean match(Path pathFile, Action action) {
        return StringUtils.contains(pathFile.getFileName().toString(),action.getActionParam()) ;
    }
}
