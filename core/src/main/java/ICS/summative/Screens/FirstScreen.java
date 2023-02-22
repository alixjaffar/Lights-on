package ICS.summative.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import ICS.summative.OptionsScreen;

/*
 * @Author: Ali Jaffar
 * @Description: This is the title game screen. It is where the user will start the game.
 */


/** First screen of the application. Displayed after the application is created. */
public class FirstScreen implements Screen {
	public static Music music;
	//This will hold a reference to the Main Game class (Main.java, which extends Game)
		Game gameReference;
	  public FirstScreen (Game game){
			 gameReference=game;        
		}
	@Override
	public void show() {

		// create a stage for the title screen
		Stage stage = new Stage();

		// create a texture for the background image
		Texture backgroundTexture = new Texture("ALLEY.png");

		// create a sprite for the background image
		Sprite backgroundSprite = new Sprite(backgroundTexture);
	

		// set the sprite to fill the entire stage
		backgroundSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());


		// create a texture for the start button
		Texture startButtonTexture = new Texture("start_button.png");

		// create a button for the start button
		ImageButton startButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(startButtonTexture)));
	

		// set the position of the start button
		startButton.setPosition(Gdx.graphics.getWidth()/2 - startButton.getWidth()/2, Gdx.graphics.getHeight()/2 - 100);
		

		// create a texture for the options button
		Texture optionsButtonTexture = new Texture("options_button.png");

		// create a button for the options button
		Button optionsButton = new Button(new TextureRegionDrawable(new TextureRegion(optionsButtonTexture)));
		

		// set the position of the options button
		optionsButton.setPosition(Gdx.graphics.getWidth()/2 - optionsButton.getWidth()/2, Gdx.graphics.getHeight()/2 - 200);

		// add the background sprite, title label, start button, and options button to the stage
		stage.act(Gdx.graphics.getDeltaTime());

		stage.getBatch().begin();
		stage.getBatch().draw(backgroundSprite, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stage.addActor(startButton);
		stage.addActor(optionsButton);
		stage.getBatch().end();

		stage.draw();

		Music music = Gdx.audio.newMusic(Gdx.files.internal("intro.mp3"));
		music.setLooping(true);
		music.play();
		music.setVolume((float) 0.5);


		


		// add a listener to the start button that changes to the game screen when clicked
		startButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				gameReference.setScreen(new GameScreen(gameReference));
			}


		});

		// add a listener to the options button that changes to the options screen when clicked
		optionsButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				gameReference.setScreen(new OptionsScreen(gameReference));
			}


		});

		Gdx.input.setInputProcessor(stage);
	}


	@Override
	public void render(float delta) {
		// Draw your screen here. "delta" is the time since last render in seconds.
		// float delta = Gdx.graphics.getDeltaTime();
		// Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// stage.act(delta);
		// stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// Resize your screen here. The parameters represent the new window size.
		// setHeight(height);
		// setWidth(width);
	}



	@Override
	public void pause() {
		// Invoked when your application is paused.
	}

	@Override
	public void resume() {
		// Invoked when your application is resumed after pause.
	}

	@Override
	public void hide() {
		// This method is called when another screen replaces this one.



	}

	@Override
	public void dispose() {
		// Destroy screen's assets here.
		music.dispose();
	}
}