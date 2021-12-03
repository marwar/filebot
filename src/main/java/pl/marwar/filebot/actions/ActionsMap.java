package pl.marwar.filebot.actions;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.Supplier;

public class ActionsMap {
    private static final Map<String, Supplier<TakeAction>> actionsMap = new TreeMap<>();

    static {
        actionsMap.put("deleteFile", DeleteFile::new);
        actionsMap.put("moveTo", MoveTo::new);
        actionsMap.put("copyTo", CopyTo::new);
    }

    public static Map<String, Supplier<TakeAction>> getActionsMap() {
        return actionsMap;
    }
}
