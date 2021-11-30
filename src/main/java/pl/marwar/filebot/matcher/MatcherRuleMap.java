package pl.marwar.filebot.matcher;

import java.util.Map;
import java.util.TreeMap;

public class MatcherRuleMap {
    Map<String, Class> getMatcherRuleMap(){
        Map<String, Class> matcherRuleMap = new TreeMap<>();
        matcherRuleMap.put("extensionIsNot",ExtensionIsNot.class);
        matcherRuleMap.put("extensionIs",ExtensionIs.class);
        matcherRuleMap.put("modifiedDateGreaterThen",ModifiedDateGreaterThen.class);
        matcherRuleMap.put("modifiedDateLessThen",ModifiedDateLessThen.class);
        matcherRuleMap.put("nameContains",NameContains.class);

        return matcherRuleMap;
    }
}
