package pl.marwar.filebot.files;

import org.apache.commons.lang3.StringUtils;
import pl.marwar.filebot.scripts.Action;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class FileUtils {
    public static Path getPathAndVeryficationDirectoryToAction(Path pathFile, Action action) throws IOException {
        String fileName = pathFile.getFileName().toString();
        String actionParam = action.getActionParam();
        StringBuilder targetDirectoryPathStringBuilder = new StringBuilder().append(actionParam);
        Path targetDirectoryPath = Paths.get(targetDirectoryPathStringBuilder.toString());
        checkDir(targetDirectoryPath);
        targetDirectoryPathStringBuilder.append(StringUtils.endsWithAny("\\") ? StringUtils.EMPTY : "\\").append(
                fileName);
        targetDirectoryPath = Paths.get(targetDirectoryPathStringBuilder.toString());
        return targetDirectoryPath;
    }

    private static void checkDir(Path targetDirectoryPath) throws IOException {
        if (!Files.isDirectory(targetDirectoryPath)) {
            Files.createDirectories(targetDirectoryPath);
        }
    }

    public static void deletePath(Path pathToDel) throws IOException {
        Files.walk(pathToDel)
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
    }
}
