package pl.marwar.filebot.files;

import lombok.extern.java.Log;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Log
public class GetFile {
    public static List<Path> getFileListFromPath(Path dirPath) {
        List<Path> result = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(dirPath, 1)) {
            result = walk.filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("problem z przeszukiwaniem katalogu");
            log.info(e.getMessage());
            System.exit(1);
        }
        return result;
    }
}
