package pl.marwar.filebot.actions;

import pl.marwar.filebot.scripts.Script;

import java.nio.file.Path;
import java.util.function.Supplier;

public class RunAction {
    private static final Supplier<ActionsFactory> actionsFactory = ActionsFactory::new;

    public static void runAction(Script script, Path path) {
        actionsFactory.get().getAction(script.getAction().getActionName()).get().execute(path, script.getAction());
    }
}
