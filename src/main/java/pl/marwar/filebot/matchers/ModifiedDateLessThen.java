package pl.marwar.filebot.matchers;

import pl.marwar.filebot.scripts.Action;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ModifiedDateLessThen implements Matchers{
    @Override
    public Boolean match(Path pathFile, Action action) {
        try {
            BasicFileAttributes fileAttributes =
                    Files.readAttributes(pathFile, BasicFileAttributes.class);
            LocalDate lastModifiedFileDate = LocalDate.ofEpochDay(fileAttributes.lastModifiedTime().toMillis());
            LocalDate matchDate = LocalDate.parse(action.getActionParam(), DateTimeFormatter.ofPattern("yyyyMMdd"));
            return lastModifiedFileDate.isBefore(matchDate);
        } catch (IOException e) {
            System.out.println("błąd przy weryfikacji daty pliku");
        }
        return null;
    }
}
