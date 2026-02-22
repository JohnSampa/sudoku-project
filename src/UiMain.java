import br.com.dio.ui.custom.screen.MainScreen;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;


public class UiMain {

    public static void main(String[] args) {

        final var gameConfig = Stream.of(args)
                .collect(toMap(x -> x.split(";")[0], x -> x.split(";")[1]));

        MainScreen  mainScreen = new MainScreen(gameConfig);
        mainScreen.buildMainScreen();
    }
}
