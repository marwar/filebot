package pl.marwar.filebot.actions;

import java.util.function.Supplier;

public class ActionsFactory {
    public Supplier<TakeAction> getAction(String actionName) {

        Supplier<TakeAction> action = ActionsMap.getAction(actionName);
        if (action != null) {
            return action;
        }
        throw new IllegalArgumentException("nie znaleziono akcji: " + actionName);
    }
}
