package pl.marwar.filebot;

import org.apache.commons.cli.Options;
import pl.marwar.filebot.options.FileBotOptions;
import pl.marwar.filebot.parameters.FileBotParameters;

public class FileBot {
    public static void main(String[] args) {

        Options options = FileBotOptions.getOptions();

        FileBotParameters parameters = FileBotParameters.getParameters(args, options);

        System.out.println(parameters);
    }


}
