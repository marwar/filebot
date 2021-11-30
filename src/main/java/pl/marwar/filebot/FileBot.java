package pl.marwar.filebot;

import org.apache.commons.cli.Options;
import pl.marwar.filebot.options.FileBotOptions;
import pl.marwar.filebot.parameters.FileBotParameters;
import pl.marwar.filebot.scripts.Scripts;
import pl.marwar.filebot.scripts.ScriptsGetter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileBot {
    public static  void main(String[] args) {

        Options options = FileBotOptions.getOptions();

        FileBotParameters parameters = FileBotParameters.getParameters(args, options);

        System.out.println(parameters);

        Scripts scripts = ScriptsGetter.getScripts(parameters);

        List<Path> paths = getFileListFromPath(parameters.getDirPath());
        paths.forEach(x -> System.out.println(x));

    }

    private static List<Path> getFileListFromPath(Path dirPath) {
        List<Path> result = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(dirPath,1)) {
            result = walk.filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("problem z przeszukiwaniem katalogu");
            System.exit(1);
        }
        return result;
    }

}
