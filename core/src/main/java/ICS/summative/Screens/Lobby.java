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
 * @Author: Waheed Magsi
 * @Description: This is the Lobby class. It is a screen that is displayed when walking into the lobby.
 */

public class Lobby implements Screen {
     
    TiledMap tiledMap;
     OrthogonalTiledMapRenderer tiledMapRenderer;
     OrthographicCamera camera;
     Player player;
     Monster npc;
     SpriteBatch batch;
     BitmapFont font;
     Vector2 position;
     Stage stage = new Stage();
     


     //This will hold a reference to the Main Game class (Main.java, which extends Game)
     Game gameReference;

     public Lobby(Game game){
          
          //This is how you can get a reference to the Main Game class
          player = new Player();
          npc = new Monster();
          batch = new SpriteBatch();
          position = new Vector2(0, -200);

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
         TiledMap tiledMap = new TmxMapLoader().load("Lobby.tmx");
         tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

           // create the player
               player = new Player();
               player.setPosition(0, -250);
               npc = new Monster();
               batch = new SpriteBatch();
         
    }

//     public lightM(){
//      BatchUpdateException.setColor(c.r,c.b,c.g, 1f);
//      Utils.drawTexture(Assets.get("sprites/lightcircle2.png", Texture.class), pos, size, true);
//      batch.setColor(1,1,1,1);
// }







    @Override
    public void render(float delta) {    
         // call the camera method in the render method
         camera();
     
     
           // Update player position
          updatePlayerPosition();

          // Check if player has reached the far right side
          if (position.x > Gdx.graphics.getWidth()) {
               changeScreen();
          }


         // render the map
           tiledMapRenderer.render();

      

          // render the player
         player.render();
          

        player.render(delta);
        player.draw(batch);

  
        
            batch.begin();
               font = new BitmapFont();
               npc.update();
               npc.render(batch);
               batch.end();
          }
               
          
          

           // render the stage




           
private void updatePlayerPosition() {
        // Update player position based on input or other logic
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
               position.x -= 1;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
               position.x += 1;
               }
    }

    private void changeScreen() {
        // Change to a new screen, for example the next level or the main menu
        gameReference.setScreen(new GameScreen(gameReference));
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
         tiledMap.dispose();
           tiledMapRenderer.dispose();
               batch.dispose();
               
    }
    


}