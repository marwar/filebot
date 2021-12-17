package pl.marwar.filebot.matchers;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.Supplier;

public class MatchersRuleMap {
    private static final Map<String, Supplier<Matchers>> matchersRuleMap = new TreeMap<>();

    static {
        matchersRuleMap.put("extensionIsNot", ExtensionIsNot::new);
        matchersRuleMap.put("extensionIs", ExtensionIs::new);
        matchersRuleMap.put("modifiedDateGreaterThen", ModifiedDateGreaterThen::new);
        matchersRuleMap.put("modifiedDateLessThen", ModifiedDateLessThen::new);
        matchersRuleMap.put("nameContains", NameContains::new);
    }

    public static Supplier<Matchers> getMatcherRule(String ruleName) {
        return matchersRuleMap.get(ruleName);
    }
}



