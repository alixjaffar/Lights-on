package ICS.summative.Screens;

import java.sql.BatchUpdateException;

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
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import ICS.summative.Monster;
import ICS.summative.Player;
import ICS.summative.Screens.Rooms.Apartment1;
import ICS.summative.Screens.Rooms.Apartment2;
import ICS.summative.Screens.Rooms.Apartment3;
import ICS.summative.Screens.Rooms.Apartment4;
import box2dLight.Light;

import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * @Author: Nazeem Naik
 * @Description: This is the DeathScreen class. It is a screen that is displayed when the player dies.
 */

public class DeathScreen implements Screen {
     
    TiledMap tiledMap;
     OrthogonalTiledMapRenderer tiledMapRenderer;
     OrthographicCamera camera;
     Player player;
     Monster npc;
     SpriteBatch batch;
     BitmapFont font;
     Vector2 position;
     boolean gameOver = false;
     Stage stage = new Stage();
     Long elapsedTime;
     


     //This will hold a reference to the Main Game class (Main.java, which extends Game)
     Game gameReference;

     public DeathScreen(Game game){  
        gameOver = true;
        System.out.println(elapsedTime);
        
            //Set the game reference to the parameter passed in (the game reference passed in is the one created in Main.java)
          gameReference=game;
          camera = new OrthographicCamera();
          camera.setToOrtho(false, 256, 210);
            camera.update();
          
     }

 public void camera() {
          // set the camera
          tiledMapRenderer.setView(camera);
     }

    @Override
    public void show() {
           // This method is called when this screen becomes the current screen for a Game.
           // create the stage and set it as the input processor
           Gdx.input.setInputProcessor(stage);


         // get the tmx file
         TiledMap tiledMap = new TmxMapLoader().load("End_Screen.tmx");
         tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

         
    }








    @Override
    public void render(float delta) {    
         // call the camera method in the render method
         camera();

         // render the map
            tiledMapRenderer.render();
    
          }
               
          
          

           // render the stage






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
         tiledMap.dispose();
           tiledMapRenderer.dispose();
               batch.dispose();
               
    }
    


}