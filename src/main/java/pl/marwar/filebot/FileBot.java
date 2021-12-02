package pl.marwar.filebot;

import org.apache.commons.cli.Options;
import org.apache.commons.collections4.CollectionUtils;
import pl.marwar.filebot.actions.ActionsFactory;
import pl.marwar.filebot.files.GetFile;
import pl.marwar.filebot.matchers.MatchersFactory;
import pl.marwar.filebot.options.FileBotOptions;
import pl.marwar.filebot.parameters.FileBotParameters;
import pl.marwar.filebot.scripts.Scripts;
import pl.marwar.filebot.scripts.ScriptsGetter;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FileBot {
    public static void main(String[] args) {

        Options options = FileBotOptions.getOptions();

        FileBotParameters parameters = FileBotParameters.getParameters(args, options);

        System.out.println(parameters);

        Scripts scripts = ScriptsGetter.getScripts(parameters);

        List<Path> pathsList = GetFile.getFileListFromPath(parameters.getDirPath());

        pathsList.forEach(x -> System.out.println(x));

        Supplier<MatchersFactory> matchersFactory = MatchersFactory::new;
        Supplier<ActionsFactory> actionsFactory = ActionsFactory::new;

        // TODO ogarnąć co z plikiem który został skasowany przy 1 skrypcie, wynieść to poza ciało głównej klasy
        scripts.getScripts().stream().forEach(script -> {
            List<Path> paths = GetFile.getFileListFromPath(parameters.getDirPath()); // chyba dobrze wyciagnac na zewnatrz albo w akcji dodac jakąś aktualizację listy
            paths.stream().filter(path -> {

                List<Boolean> matchersRuleResultList = script.getMatchers().stream().map(m -> matchersFactory.get().getMatcher(m.getMatcherRule()).get().match(path, m)).collect(Collectors.toList());

                return !CollectionUtils.containsAny(matchersRuleResultList, Boolean.FALSE);
            }).forEach(path -> {
                System.out.println("akcje");
                actionsFactory.get().getAction(script.getAction().getActionName()).get().execute(path, script.getAction());
            });
        });
    }

}
