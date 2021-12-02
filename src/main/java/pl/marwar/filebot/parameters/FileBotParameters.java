package pl.marwar.filebot.parameters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;
import org.apache.commons.cli.*;

import java.nio.file.Path;
import java.nio.file.Paths;

@AllArgsConstructor
@Data
@Log
public class FileBotParameters {
    Path dirPath;
    Path scriptsPath;

    public static FileBotParameters getParameters(String[] args, Options options) {
        HelpFormatter formatter = new HelpFormatter();
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);

        } catch (ParseException e) {
            log.info(e.getMessage());
            formatter.printHelp("FileBot", options);
            System.exit(1);
        } finally {
            Path dirPath = Paths.get(cmd.getOptionValue("dir"));
            Path scriptsPath = Paths.get(cmd.getOptionValue("scripts"));
            return new FileBotParameters(dirPath, scriptsPath.toAbsolutePath());
        }

    }
}
