package ICS.summative;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

import box2dLight.Light;

/**
 * @Author: Ali Jaffar
 * @Description: This class is the player class. It handles the player's movement
 */


public class Player {

    private Texture texture;
    private Texture lightTexture;
    private static Vector2 position;
    private float speed;
    boolean keyCollected = false;
    Texture keyTexture;
     Sprite keySprite;
    Vector2 keyPosition;
    Array<String> inventory;

    public Player() {
        texture = new Texture("Player.png");

        position = new Vector2(0, -200);
        speed = 100;

        //animation = new Animation<TextureRegion>(0.1f, texture);
        //add a walking animation whenever Left or Right get pressed
    }

    public void setPosition(float x, float y) {
        position.set(x, y);
    }

    public static Vector2 getPosition() {
        return position;
    }

    public void render(float delta) {
        // //make the screen darker
        // Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        // Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //add a walking animation whenever Left or Right get pressed
        // handle player movement here
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            position.x -= 1;
            texture = new Texture("Player-Left-walk1.png");
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            position.x += 1;
            texture = new Texture("Player-walk2.png");
        }
        if (!Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
            texture = new Texture("Player.png");
        }

        // render the light
        lightTexture = new Texture("LightCircle.png");
        
      
    }

    public void draw(SpriteBatch batch) {
        batch.begin();
        //make the player light up when the player is moving
        batch.draw(texture, position.x, position.y);
        // set the color
        batch.setColor(0.1f, 0.1f, 0.1f,1f);
        batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        // reset the color
        batch.setColor(1f, 1f, 1f,1f);
        batch.setBlendFunction(GL20.GL_DST_COLOR, GL20.GL_SRC_ALPHA);
        batch.draw(lightTexture, position.x, position.y);
        batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        batch.end();
    }

    public void messages() {
        //add a message when the player is moving
        String messages = "";

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            messages = "You are moving left";
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            messages = "You are moving right";
        }
        if (!Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
            messages = "You are not moving";
        }

        // render the message
        BitmapFont font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(2);
        font.draw(new SpriteBatch(), messages, 100, 100);


        // if the player is in a certain screen, display a message
        if (position.x == 0 && position.y == -200) {
            messages = "You are in the starting screen";
        }

        


    }

    public void render() {
    }

    public void dispose() {
        texture.dispose();
    }

    public static void kill() {
        // kill the player and go to the starting screen


    }

    public Rectangle getBoundingRectangle() {
        return null;
    }

    public String getInventory() {
        // add the key to the inventory
        if (Gdx.input.isKeyPressed(Input.Keys.E) && !keyCollected) {
            keyCollected = true;
            System.out.println("Key collected!" + inventory);
            // delete the key from the map once collected
              keyPosition = new Vector2(-100, -100);
            // make the array of inventory store the items when collected
            
        }
        return "key";
    }
}
