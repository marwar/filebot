package pl.marwar.filebot;

import org.apache.commons.cli.*;

public class FileBot {
    public static void main(String[] args) {

        Options options = new Options();

        Option dir = new Option(null,"dir", true, "ścieżka katalogu na którym mają być wykonane skrypty z pliku");
        dir.setRequired(true);
        options.addOption(dir);

        Option scriptsFile = new Option(null,"scripts", true, "nazwa pliku ze skryptem");
        scriptsFile.setRequired(true);
        options.addOption(scriptsFile);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("FileBot", options);

            System.exit(1);
        } finally {
            String dirPath = cmd.getOptionValue("dir");
            String scriptsFileName = cmd.getOptionValue("scriptsFile");

            System.out.println("dirPath: "+dirPath);
            System.out.println("scriptsFileName: "+scriptsFileName);
        }


    }
}
