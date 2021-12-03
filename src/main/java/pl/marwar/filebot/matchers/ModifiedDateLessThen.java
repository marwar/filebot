package pl.marwar.filebot.matchers;

import pl.marwar.filebot.files.FileUtils;
import pl.marwar.filebot.scripts.Matcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.DateTimeException;
import java.time.LocalDate;

public class ModifiedDateLessThen implements Matchers {
    @Override
    public Boolean match(Path pathFile, Matcher matcher) {
        try {
            BasicFileAttributes fileAttributes =
                    Files.readAttributes(pathFile, BasicFileAttributes.class);

            LocalDate lastModifiedFileDate = FileUtils.getLastModifiedFileDate(fileAttributes);
            LocalDate matchDate = FileUtils.getDateFromMatcherParam(matcher);
            return lastModifiedFileDate.isBefore(matchDate);
        } catch (IOException | DateTimeException e) {
            System.out.println("błąd przy weryfikacji daty pliku: " + e.getMessage());
        }
        return null;
    }
}
