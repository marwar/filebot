package pl.marwar.filebot.scripts;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import pl.marwar.filebot.parameters.FileBotParameters;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;

public class ScriptsGetter {
    public static Scripts getScripts(FileBotParameters parameters) {
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        Type scriptsType = new TypeToken<Scripts>(){}.getType();
        JsonReader reader = null;
        Scripts scripts;
        try {
            reader = new JsonReader(new FileReader(parameters.getScriptsPath().toFile()));
        } catch (FileNotFoundException e) {
            System.out.println("nie udało się znaleźć pliku ze skryptem");
            System.exit(1);
        } finally {
            scripts = gson.fromJson(reader,scriptsType);

        }
        return scripts;
    }
}
