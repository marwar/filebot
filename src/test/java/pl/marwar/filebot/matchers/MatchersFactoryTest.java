package pl.marwar.filebot.matchers;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

public class MatchersFactoryTest {
    @InjectMocks
    MatchersFactory matchersFactory = new MatchersFactory();

    @Test
    public void testExtensionIs() {
        Assert.assertEquals(MatchersRuleMap.getMatcherRuleMap().get("extensionIs"),
                matchersFactory.getMatcher("extensionIs"));

    }

    @Test
    public void testExtensionIsNot() {
        Assert.assertEquals(MatchersRuleMap.getMatcherRuleMap().get("extensionIsNot"),
                matchersFactory.getMatcher("extensionIsNot"));

    }

    @Test
    public void testModifiedDateGreaterThen() {
        Assert.assertEquals(MatchersRuleMap.getMatcherRuleMap().get("modifiedDateGreaterThen"),
                matchersFactory.getMatcher("modifiedDateGreaterThen"));

    }

    @Test
    public void testModifiedDateLessThen() {
        Assert.assertEquals(MatchersRuleMap.getMatcherRuleMap().get("modifiedDateLessThen"),
                matchersFactory.getMatcher("modifiedDateLessThen"));

    }

    @Test
    public void testNameContains() {
        Assert.assertEquals(MatchersRuleMap.getMatcherRuleMap().get("nameContains"),
                matchersFactory.getMatcher("nameContains"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotFound() {
        matchersFactory.getMatcher("NotFound");

    }
}
