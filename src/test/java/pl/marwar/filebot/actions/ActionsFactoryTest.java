package pl.marwar.filebot.actions;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

public class ActionsFactoryTest {
    @InjectMocks
    ActionsFactory actionsFactory = new ActionsFactory();

    @Test
    public void testGetCopyAction() {
        Assert.assertEquals(ActionsMap.getActionsMap().get("copyTo"), actionsFactory.getAction("copyTo"));
    }

    @Test
    public void testGetDeleteFileAction() {
        Assert.assertEquals(ActionsMap.getActionsMap().get("deleteFile"), actionsFactory.getAction("deleteFile"));
    }

    @Test
    public void testGetMoveToAction() {
        Assert.assertEquals(ActionsMap.getActionsMap().get("moveTo"), actionsFactory.getAction("moveTo"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotFoundAction() {
        actionsFactory.getAction("notFoundAction");
    }
}
