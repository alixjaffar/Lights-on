package ICS.summative;

import com.badlogic.gdx.Game;

import ICS.summative.Screens.FirstScreen;
import ICS.summative.Screens.HallScreen;

/**
 * @Author: Ali Jaffar
 * @Description: This is the main game class. It is where the game will be initialized and the first screen will be set.
 */

public class Main extends Game {
	@Override
	public void create() {
		 setScreen(new FirstScreen(this));
	}   
}


// public static void setScreen(GameScreen gameScreen) {
// 	setScreen(new GameScreen());
// }

// public static void setScreen(OptionsScreen optionsScreen) {
// 	setScreen(new OptionsScreen());
// }