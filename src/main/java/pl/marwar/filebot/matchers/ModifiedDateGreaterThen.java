package pl.marwar.filebot.matchers;

import pl.marwar.filebot.scripts.Matcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class ModifiedDateGreaterThen implements Matchers {
    @Override
    public Boolean match(Path pathFile, Matcher matcher) {

        try {
            BasicFileAttributes fileAttributes =
                    Files.readAttributes(pathFile, BasicFileAttributes.class);

            LocalDate lastModifiedFileDate = LocalDateTime.ofInstant(
                    Instant.ofEpochSecond(fileAttributes.lastModifiedTime().toMillis()), TimeZone
                            .getDefault().toZoneId()).toLocalDate();
            LocalDate matchDate = LocalDate.parse(matcher.getParam(), DateTimeFormatter.ofPattern("yyyyMMdd"));
            return lastModifiedFileDate.isAfter(matchDate);
        } catch (IOException e) {
            System.out.println("błąd przy weryfikacji daty pliku " + e.getMessage());
        }
        return null;
    }

}