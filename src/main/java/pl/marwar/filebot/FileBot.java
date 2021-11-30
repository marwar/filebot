package pl.marwar.filebot;

import org.apache.commons.cli.Options;
import pl.marwar.filebot.options.FileBotOptions;
import pl.marwar.filebot.parameters.FileBotParameters;
import pl.marwar.filebot.scripts.Scripts;
import pl.marwar.filebot.scripts.ScriptsGetter;

public class FileBot {
    public static  void main(String[] args) {

        Options options = FileBotOptions.getOptions();

        FileBotParameters parameters = FileBotParameters.getParameters(args, options);

        System.out.println(parameters);

        Scripts scripts = ScriptsGetter.getScripts(parameters);

    }



}
