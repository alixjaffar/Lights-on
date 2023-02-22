package ICS.summative.Screens;

import java.sql.BatchUpdateException;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
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
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import ICS.summative.Monster;
import ICS.summative.Player;
import ICS.summative.FileSystem.FileWrite;
import ICS.summative.Screens.Rooms.Apartment1;
import ICS.summative.Screens.Rooms.Apartment2;
import ICS.summative.Screens.Rooms.Apartment3;
import ICS.summative.Screens.Rooms.Apartment4;
import ICS.summative.Screens.Rooms.WaterScreen;
import box2dLight.Light;

import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * @Author: Ali Jaffar
 * @Description: This is the main game screen. It is where the player will be able to move around and interact with the world.
 */

public class GameScreen implements Screen {
     
    TiledMap tiledMap;
     OrthogonalTiledMapRenderer tiledMapRenderer;
     OrthographicCamera camera;
     Player player;
     Monster npc;
     SpriteBatch batch;
     BitmapFont font;
     Vector2 position;
     private boolean keyCollected;
     private Texture keyTexture;
      private Vector2 keyPosition;
     Stage stage = new Stage();
     Array<String> inventory;
     long startTime;
     boolean gameOver = false;
     private Integer worldTimer;
    private boolean timeUp; // true when the world timer reaches 0
    private float timeCount;
    private static Integer currentScore;
    private Label countdownLabel;
//     private Sound sound;
    private Music music;
    
     


     //This will hold a reference to the Main Game class (Main.java, which extends Game)
     Game gameReference;

     public GameScreen(Game game){
          worldTimer = 300;
          currentScore = 0;

          //This is how you can get a reference to the Main Game class
          keyTexture = new Texture("l0_bad guy monsterssd1.png");
          batch = new SpriteBatch();
          keyPosition = new Vector2(100, -200);
          player = new Player();
          npc = new Monster();
          batch = new SpriteBatch();
          position = new Vector2(0, -200);

          gameReference=game;
          camera = new OrthographicCamera();
          camera.setToOrtho(false, 256, 210);
            camera.update();

          Music music = Gdx.audio.newMusic(Gdx.files.internal("main.mp3"));
          music.setLooping(true);
          music.play();

          
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
           startTime = TimeUtils.millis();

           new FileWrite();


         // get the tmx file
         TiledMap tiledMap = new TmxMapLoader().load("Hall.tmx");
         tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

           // create the player
               player = new Player();
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

     
         if (!gameOver) {
          long elapsedTime = TimeUtils.timeSinceMillis(startTime);
          if (elapsedTime > 60000) {
               gameReference.setScreen(new JumpScare(gameReference));
          }

          for (int i = 0; i < 100; i++) {
               if (elapsedTime > 12000) {
                    currentScore += 10;
               }
          }
     
      }

         if (!keyCollected) {
          batch.begin();
          batch.draw(keyTexture, keyPosition.x, keyPosition.y);
          batch.end();
      }
          
      

     
     
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

        if (Gdx.input.isKeyPressed(Input.Keys.A) && Gdx.input.isKeyPressed(Input.Keys.L) && Gdx.input.isKeyPressed(Input.Keys.I)){
          gameReference.setScreen(new EasterEgg(gameReference));
        }

  
        
            batch.begin();
               font = new BitmapFont();
               npc.spawn();
               npc.update();
               npc.render(batch);
               batch.end();

          //when the player comes near to a certain coordinate, add a popup that says "press E to enter the next room"
          batch.begin();
          font.setColor(Color.WHITE);
               font.draw (batch, "Press F to go inside.", Gdx.graphics.getWidth()*.35f, Gdx.graphics.getHeight() * .3f);
               if (Gdx.input.isKeyPressed(Input.Keys.F)) {
                    gameReference.setScreen(new Apartment1(gameReference));
               }
               batch.end();

               batch.begin();
               font.setColor(Color.WHITE);
               font.draw (batch, "Press T to go inside.", 100, 180);
               if (Gdx.input.isKeyPressed(Input.Keys.T)) {
                    gameReference.setScreen(new Apartment2(gameReference));
               }
               batch.end();

               batch.begin();
               font.draw (batch, "Press G to go inside.", 450, 180);
               font.setColor(Color.WHITE);
               if (Gdx.input.isKeyPressed(Input.Keys.G)) {
                    gameReference.setScreen(new Apartment3(gameReference));
               }
               batch.end();

               batch.begin();
               font.draw (batch, "Press J to go inside.", 650, 180);
               font.setColor(Color.WHITE);
               if (Gdx.input.isKeyPressed(Input.Keys.J)) {
                    gameReference.setScreen(new Apartment4(gameReference));
               }
               batch.end();

               batch.begin();
               font.setColor(Color.RED);
               if (WaterScreen.holyCollected == true) {
                    font.draw (batch, "Press L to destroy the monster with holy water", 400, 350);
                    if (Gdx.input.isKeyPressed(Input.Keys.L)) {
                         gameReference.setScreen(new EndScreen(gameReference));
                    }
               }
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

public void enterRoom() {
     keyCollected = true;
 }


    private void changeScreen() {
        // Change to a new screen, for example the next level or the main menu
        gameReference.setScreen(new HallScreen(gameReference));
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

    public void update(float dt){
     timeCount += dt;
     if(timeCount >= 1){
         if (worldTimer > 0) {
             worldTimer--;
         } else {
             timeUp = true;
         }
         countdownLabel.setText(String.format("%03d", worldTimer));
         timeCount = 0;
     }
 }

    @Override
    public void dispose() {
         // Destroy screen's assets here.
         tiledMap.dispose();
           tiledMapRenderer.dispose();
               batch.dispose();
               
    }
    


}