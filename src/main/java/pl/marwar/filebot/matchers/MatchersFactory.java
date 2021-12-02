package pl.marwar.filebot.matchers;

import java.util.function.Supplier;

public class MatchersFactory {
    public Supplier<Matchers> getMatcher(String rule) {

        Supplier<Matchers> matcherRule = MatchersRuleMap.getMatcherRuleMap().get(rule);
        if (matcherRule != null) {
            return matcherRule;
        }
        throw new IllegalArgumentException("nie znaleziono reguły: " + rule);
    }
}
