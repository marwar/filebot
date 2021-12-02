package pl.marwar.filebot.files;

import org.apache.commons.collections4.CollectionUtils;
import pl.marwar.filebot.matchers.MatchersRuleUtils;
import pl.marwar.filebot.scripts.Script;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileVeryfication {
    public static boolean isFileToRunAction(Path path, Script script) {
        return Files.exists(path) && !CollectionUtils.containsAny(MatchersRuleUtils.getMatchersRuleResultList(script, path), Boolean.FALSE);
    }
}
