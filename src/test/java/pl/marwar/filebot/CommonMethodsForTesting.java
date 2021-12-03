package pl.marwar.filebot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CommonMethodsForTesting {
    public static Path getPathTestFile() throws IOException {
        Path path = Paths.get("src", "test", "resources", "testFile.txt");
        if (Files.notExists(path)) {
            Files.createFile(path);
        }
        return path;
    }

    public static Path getOnlyPathTestFile() {
        return Paths.get("src", "test", "resources", "testFile.txt");
    }
}
