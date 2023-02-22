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
import ICS.summative.Screens.HallScreen;

import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * @Author: Ali Jaffar
 * @Description: This is the Water Room screen. It is a room in the game, that you can only enter through if you have a key
 */

public class WaterScreen implements Screen {
    TiledMap tiledMap;
     OrthogonalTiledMapRenderer tiledMapRenderer;
     OrthographicCamera camera;
     Player player;
     SpriteBatch batch;
     Vector2 position;
     BitmapFont font;
     public static boolean holyCollected = false;
    Texture holyTexture;
     Sprite holySprite;
    Vector2 holyPosition;
    Array<String> inventory;

     //This will hold a reference to the Main Game class (Main.java, which extends Game)
     Game gameReference;

     public WaterScreen(Game game){
          
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
            tiledMap = new TmxMapLoader().load("Water_Room.tmx");
            tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

            Player player = new Player();
            player.setPosition(0, -300);

            holyTexture = new Texture("holy.png");
            batch = new SpriteBatch();
            holyPosition = new Vector2(265, 70);
            // how to call the inventory array in another class file
            inventory = new Array<String>();
            inventory.add("key");
            
    }
      

    @Override
    public void render(float delta) {
        // render the map
        tiledMapRenderer.render();

    
       

        

    //     if (position.x > Gdx.graphics.getWidth()) {
    //         gameReference.setScreen(new HallScreen(gameReference));
    //    }

        // set the camera
        camera();

        player.render();

        batch.begin();
          batch.draw(holyTexture, holyPosition.x, holyPosition.y);
          batch.end();

          batch.begin();
            font = new BitmapFont();
            font.setColor(Color.WHITE);
            font.draw (batch, "Press Q to go back", 100, 200);
            font.draw(batch, "Press E to collect the Water", holyPosition.x, holyPosition.y);
            if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
                gameReference.setScreen(new HallScreen(gameReference));
            }
            batch.end();


          if (Gdx.input.isKeyPressed(Input.Keys.E) && !holyCollected) {
            holyCollected = true;
            inventory.add("holy");
            System.out.println("Key collected!" + inventory);
            // delete the key from the map once collected
              holyPosition = new Vector2(-100, -100);
         
        }

        player.render(delta);
        player.draw(batch);
        batch.begin();
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        batch.end();
    }

    private void changeScreen() {
        // Change to a new screen, for example the next level or the main menu
        gameReference.setScreen(new HallScreen(gameReference));
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