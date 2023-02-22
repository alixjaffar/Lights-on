package ICS.summative.Screens.Rooms;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import ICS.summative.Player;
import ICS.summative.Screens.GameScreen;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * @Author: Nazeem Naik
 * @Description:   This class is the screen for the apartment room
 */

public class Apartment4 implements Screen {
    TiledMap tiledMap;
     OrthogonalTiledMapRenderer tiledMapRenderer;
     OrthographicCamera camera;
     Player player;
     SpriteBatch batch;
     BitmapFont font;

     //This will hold a reference to the Main Game class (Main.java, which extends Game)
     Game gameReference;

     public Apartment4(Game game){
          
          //This is how you can get a reference to the Main Game class
          player = new Player();
          batch = new SpriteBatch();

          gameReference=game;
          camera = new OrthographicCamera();
          camera.setToOrtho(false, 256, 256);
            camera.update();
          
     }


    @Override
    public void show() {
            // This method is called when the screen is set as the screen with game.setScreen();
            // Initialize all the things here.
            tiledMap = new TmxMapLoader().load("Apartment_1.tmx");
            tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

            Player player = new Player();
            player.setPosition(0, -300);
    }
      

    @Override
    public void render(float delta) {
        // render the map
        tiledMapRenderer.render();

        // set the camera
        camera();

        player.render();

        player.render(delta);
        player.draw(batch);
        batch.begin();
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.draw(batch, "To exit the apartment press Q", 250, 150);
        font.draw(batch, "To enter the bathroom press B", 450, 150);
        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
            gameReference.setScreen(new GameScreen(gameReference));
       }
       if (Gdx.input.isKeyPressed(Input.Keys.B)){
          gameReference.setScreen(new Bathroom4(gameReference));
       }
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
      


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

    public void camera() {
        // set the camera
        tiledMapRenderer.setView(camera);
   }
    


}