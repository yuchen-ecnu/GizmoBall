import controller.GameController;
import controller.UiController;

public class Driver {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        UiController uiController = new UiController(gameController);
    }
}
