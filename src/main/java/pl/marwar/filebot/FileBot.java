package pl.marwar.filebot;

import org.apache.commons.cli.Options;
import pl.marwar.filebot.actions.RunAction;
import pl.marwar.filebot.files.FileVeryfication;
import pl.marwar.filebot.files.GetFile;
import pl.marwar.filebot.options.FileBotOptions;
import pl.marwar.filebot.parameters.FileBotParameters;
import pl.marwar.filebot.scripts.Scripts;
import pl.marwar.filebot.scripts.ScriptsGetter;

import java.nio.file.Path;
import java.util.List;

public class FileBot {
    public static void main(String[] args) {

        Options options = FileBotOptions.getOptions();

        FileBotParameters parameters = FileBotParameters.getParameters(args, options);

        System.out.println(parameters);

        Scripts scripts = ScriptsGetter.getScripts(parameters);

        List<Path> pathsList = GetFile.getFileListFromPath(parameters.getDirPath());

        System.out.println("Pliki w katalogu:");
        pathsList.forEach(System.out::println);

        pathsList.parallelStream().forEach(path -> scripts.getScripts().stream().forEach(script -> {
            if (FileVeryfication.isFileToRunAction(path, script)) {
                RunAction.runAction(script, path);
            }
        }));
    }

}
