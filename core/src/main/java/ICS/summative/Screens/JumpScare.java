package ICS.summative.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
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
import com.badlogic.gdx.utils.TimeUtils;

/*
 * @Author: Ali Jaffar
 * @Description: This is the jump scare screen. It will appear if the player does not complete the game in the set time.
 */


/** First screen of the application. Displayed after the application is created. */
public class JumpScare implements Screen {
	//This will hold a reference to the Main Game class (Main.java, which extends Game)
		Game gameReference;
        private long startTime;
        private boolean gameOver = false;
        Stage stage = new Stage();
        SpriteBatch batch;
        Texture backgroundTexture = new Texture("JUMP.png");
        Sprite backgroundSprite = new Sprite(backgroundTexture);
        long elapsedTime = TimeUtils.timeSinceMillis(startTime);
        BitmapFont font;

        // create a texture for the background image
        //Constructor that receives a Game object as a parameter
        
	  public JumpScare (Game game){
			 gameReference=game;  
            batch = new SpriteBatch();      
		}
	@Override
	public void show() {
		// create a stage for the title screen
		

		// create a texture for the background image
		Texture backgroundTexture = new Texture("JUMP.png");

		// create a sprite for the background image
		Sprite backgroundSprite = new Sprite(backgroundTexture);
	

		// set the sprite to fill the entire stage
		backgroundSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());


		
		stage.getBatch().begin();
		stage.getBatch().draw(backgroundSprite, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stage.getBatch().end();

		stage.draw();

        

        

		

		};

		


	@Override
	public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // render the stage
        stage.act(delta);
        stage.getBatch().begin();
		stage.getBatch().draw(backgroundSprite, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stage.getBatch().end();
        stage.draw();

        batch.begin();
          font = new BitmapFont();
          font.setColor(Color.WHITE);
          font.draw (batch, "Press Space", delta, delta);
          batch.end();
          //You have been killed by the monster, to play again Press Space"

        

        // if the player presses the space bar, go to the game screen
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            gameReference.setScreen(new DeathScreen(gameReference));
        }
       
     
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
	}
}