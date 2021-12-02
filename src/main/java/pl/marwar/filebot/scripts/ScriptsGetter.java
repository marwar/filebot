package pl.marwar.filebot.scripts;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import lombok.extern.java.Log;
import pl.marwar.filebot.parameters.FileBotParameters;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;

@Log
public class ScriptsGetter {

    public static Scripts getScripts(FileBotParameters parameters) {
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        Type scriptsType = new TypeToken<Scripts>() {
        }.getType();

        try {
            return gson.fromJson(new JsonReader(new FileReader(parameters.getScriptsPath().toFile())), scriptsType);
        } catch (FileNotFoundException e) {
            System.out.println("nie udało się znaleźć pliku ze skryptem");
            log.info(e.getMessage());
            System.exit(1);
        }
        return null;
    }
}
