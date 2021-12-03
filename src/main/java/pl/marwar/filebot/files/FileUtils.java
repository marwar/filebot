package pl.marwar.filebot.files;

import org.apache.commons.lang3.StringUtils;
import pl.marwar.filebot.scripts.Action;
import pl.marwar.filebot.scripts.Matcher;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.TimeZone;

public class FileUtils {
    public static Path getPathAndVeryficationDirectoryToAction(Path pathFile, Action action) throws IOException {
        String fileName = pathFile.getFileName().toString();
        String actionParam = action.getActionParam();
        StringBuilder targetDirectoryPathStringBuilder = new StringBuilder().append(actionParam);
        Path targetDirectoryPath = Paths.get(targetDirectoryPathStringBuilder.toString());
        checkDir(targetDirectoryPath);
        if (!StringUtils.endsWith(String.valueOf(targetDirectoryPath), fileName)) {
            targetDirectoryPathStringBuilder.append(StringUtils.endsWithAny("\\") ? StringUtils.EMPTY : "\\").append(
                    fileName);
            targetDirectoryPath = Paths.get(targetDirectoryPathStringBuilder.toString());
        }
        return targetDirectoryPath;
    }

    private static void checkDir(Path targetDirectoryPath) throws IOException {
        if (!Files.isDirectory(targetDirectoryPath) && Files.notExists(targetDirectoryPath)) {
            Files.createDirectories(targetDirectoryPath);
        }
    }

    public static void deletePath(Path pathToDel) throws IOException {
        Files.walk(pathToDel)
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
    }

    public static LocalDate getLastModifiedFileDate(BasicFileAttributes fileAttributes) {
        return LocalDateTime.ofInstant(
                Instant.ofEpochSecond(fileAttributes.lastModifiedTime().toMillis()), TimeZone
                        .getDefault().toZoneId()).toLocalDate();
    }

    public static LocalDate getDateFromMatcherParam(Matcher matcher) {
        return LocalDate.parse(matcher.getParam(), DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

}
