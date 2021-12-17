package pl.marwar.filebot.actions;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

public class ActionsFactoryTest {
    @InjectMocks
    ActionsFactory actionsFactory = new ActionsFactory();

    @Test
    public void testGetCopyAction() {
        Assert.assertEquals(ActionsMap.getAction("copyTo"), actionsFactory.getAction("copyTo"));
    }

    @Test
    public void testGetDeleteFileAction() {
        Assert.assertEquals(ActionsMap.getAction("deleteFile"), actionsFactory.getAction("deleteFile"));
    }

    @Test
    public void testGetMoveToAction() {
        Assert.assertEquals(ActionsMap.getAction("moveTo"), actionsFactory.getAction("moveTo"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotFoundAction() {
        actionsFactory.getAction("notFoundAction");
    }
}
