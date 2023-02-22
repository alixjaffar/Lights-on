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
import com.badlogic.gdx.utils.ScreenUtils;

import box2dLight.Light;

import com.badlogic.gdx.graphics.Texture;

/**
 * @Author: Nazeem Naik
 * @Description: This class is used to create the monster object.
 */

public class Monster {
    private Vector2 position;
    private Vector2 target;
    private Texture texture;
    private float speed;
    private boolean active;

    public Monster() {
        position = new Vector2();
        target = new Vector2();
        texture = new Texture("l0_bad guy monsterssd1.png");
        speed = 2;
        active = false;
    }

    public void update() {
        if (active) {
            // Move towards the target position
            position.lerp(target, speed * Gdx.graphics.getDeltaTime());

            // Check if the NPC has reached the target position
            if (position.epsilonEquals(target, 0.1f)) {
                // Update the target position to the player's position
                target.set(Player.getPosition());
            }

            // Check if the NPC is touching the player
            // if (position.dst(Player.getPosition()) < MONSTER_RADIUS + PLAYER_RADIUS) {
                // Kill the player
                Player.kill();
            }
        }
    // }

    public void render(SpriteBatch batch) {
        if (active) {
            batch.draw(texture, position.x, position.y);
        }
    }

    public void spawn() {
        active = true;
        // Set the initial position and target to the player's position
        position.set(Player.getPosition());
        target.set(Player.getPosition());
    }

    public void despawn() {
        active = false;
    }

    public void dispose() {
        texture.dispose();
    }
}