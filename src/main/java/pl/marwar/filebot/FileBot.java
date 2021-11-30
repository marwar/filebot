package pl.marwar.filebot;

import org.apache.commons.cli.Options;
import pl.marwar.filebot.actions.ActionsFactory;
import pl.marwar.filebot.files.GetFile;
import pl.marwar.filebot.options.FileBotOptions;
import pl.marwar.filebot.parameters.FileBotParameters;
import pl.marwar.filebot.scripts.Scripts;
import pl.marwar.filebot.scripts.ScriptsGetter;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Supplier;

public class FileBot {
    public static  void main(String[] args) {

        Options options = FileBotOptions.getOptions();

        FileBotParameters parameters = FileBotParameters.getParameters(args, options);

        System.out.println(parameters);

        Scripts scripts = ScriptsGetter.getScripts(parameters);

        List<Path> paths = GetFile.getFileListFromPath(parameters.getDirPath());

        paths.forEach(x -> System.out.println(x));

        scripts.getScripts().stream().parallel().forEach(script -> {
            paths.stream().filter(path-> {
                // TODO weryfikacja czy plik spełnia wymagania
                return false;
            }).forEach(path -> {
                Supplier<ActionsFactory> actionsFactory = ActionsFactory::new;
                actionsFactory.get().getAction(script.getAction().getActionName());
            });
        } );
    }

}
