package pl.marwar.filebot.matchers;

import pl.marwar.filebot.scripts.Matcher;
import pl.marwar.filebot.scripts.Script;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MatchersRuleUtils {
    private static Supplier<MatchersFactory> matchersFactory = MatchersFactory::new;

    public static List<Boolean> getMatchersRuleResultList(Script script, Path path) {
        return script.getMatchers().stream().map(matcher -> getMatchResult(matchersFactory, path, matcher)).collect(Collectors.toList());
    }

    private static Boolean getMatchResult(Supplier<MatchersFactory> matchersFactory, Path path, Matcher matcher) {
        return matchersFactory.get().getMatcher(matcher.getMatcherRule()).get().match(path, matcher);
    }
}
