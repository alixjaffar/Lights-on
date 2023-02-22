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
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;

import ICS.summative.Player;
import ICS.summative.Screens.GameScreen;

import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * @Author: Ali Jaffar
 * @Description: This is the first apartment screen. It is the first room the player will see.
 */

public class Apartment1 implements Screen {
    TiledMap tiledMap;
     OrthogonalTiledMapRenderer tiledMapRenderer;
     OrthographicCamera camera;
     Player player;
     SpriteBatch batch;
     BitmapFont font;
     public static boolean keyCollected = false;
    Texture keyTexture;
     Sprite keySprite;
    Vector2 keyPosition;
    Array<String> inventory;


     //This will hold a reference to the Main Game class (Main.java, which extends Game)
     Game gameReference;

     public Apartment1(Game game){
          
          //This is how you can get a reference to the Main Game class
          player = new Player();
          player.setPosition(0, -300);
          batch = new SpriteBatch();

          gameReference=game;
          camera = new OrthographicCamera();
          camera.setToOrtho(false,256, 256);
            camera.update();
          
     }


    @Override
    public void show() {
            // This method is called when the screen is set as the screen with game.setScreen();
            // Initialize all the things here.
            tiledMap = new TmxMapLoader().load("Apartment_1.tmx");
            tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

            keyTexture = new Texture("Key.png");
            batch = new SpriteBatch();
            keyPosition = new Vector2(100, 50);
            inventory = new Array<String>();

            Player player = new Player();
            player.setPosition(0,-300);
               batch = new SpriteBatch();
    }
      

    @Override
    public void render(float delta) {
        // render the map
        tiledMapRenderer.render();

        // set the camera
        camera();

        player.render();


      if (keyCollected == true) {
          // dont render the key
          keyPosition = new Vector2(-100, -100);
      } else {
          // render the key
          batch.begin();
          batch.draw(keyTexture, keyPosition.x, keyPosition.y);
          batch.end();
      }

      if (Gdx.input.isKeyPressed(Input.Keys.E) && keyCollected == false) {
          // collect the key
          keyCollected = true;
          inventory.add("key");
          System.out.println("Key collected!" + inventory);
          // delete the key from the map once collected
            keyPosition = new Vector2(-100, -100);
       
      }

      

        player.render(delta);

        player.draw(batch);
        batch.begin();
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.draw(batch, "To exit the apartment press Q", 250, 150);
        font.draw(batch, "To enter the bathroom press B", 450, 150);
        font.draw(batch, "Press E to collect the key", keyPosition.x, keyPosition.y);
        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
            gameReference.setScreen(new GameScreen(gameReference));
       }
       if (Gdx.input.isKeyPressed(Input.Keys.B)){
          gameReference.setScreen(new Bathroom1(gameReference));
       }
        batch.end();
    }

 public void update(float delta) {
          
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