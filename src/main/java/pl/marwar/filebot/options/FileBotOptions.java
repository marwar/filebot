package pl.marwar.filebot.options;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class FileBotOptions {
    public static Options getOptions() {
        Options options = new Options();

        Option dir = new Option("d", "dir", true, "ścieżka katalogu na którym mają być wykonane skrypty z pliku");
        dir.setRequired(true);
        options.addOption(dir);

        Option scriptsFile = new Option("s", "scripts", true, "nazwa pliku ze skryptem");
        scriptsFile.setRequired(true);
        options.addOption(scriptsFile);
        return options;
    }
}
