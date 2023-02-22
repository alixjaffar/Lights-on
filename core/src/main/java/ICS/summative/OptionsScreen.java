package ICS.summative;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import ICS.summative.Screens.FirstScreen;

/**
 * @Author: Waheed Magsi
 *  Description: This class is the screen for the options screen
 */


public class OptionsScreen implements Screen {
    Game gameReference;
    SpriteBatch batch;

    public OptionsScreen (Game game){
        gameReference=game;  
       batch = new SpriteBatch();      
   }

    @Override
    public void show() {

        // create the stage
        Stage stage = new Stage();

        // create the buttons
        Button backButton = new Button(new TextureRegionDrawable(new TextureRegion(new Texture("backButton.png"))));
        backButton.setPosition(Gdx.graphics.getWidth()/2 - backButton.getWidth()/2, Gdx.graphics.getHeight()/2 - 200);
        Button musicButton = new Button(new TextureRegionDrawable(new TextureRegion(new Texture("musicButton.png"))));
        musicButton.setPosition(Gdx.graphics.getWidth()/2 - musicButton.getWidth()/2, Gdx.graphics.getHeight()/2 - 200);





        // add the buttons to the stage
        stage.addActor(backButton);
        stage.addActor(musicButton);


        // add the labels to the stage

        //add the listeners to the buttons
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameReference.setScreen(new FirstScreen(gameReference));
            }
        });

        musicButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // mutes all of the music
                FirstScreen.music.setVolume(0);
                
            }
        });

        // set the input processor
        Gdx.input.setInputProcessor(stage);


        // draw the stage
        stage.draw();
        stage.act();
        
    }

    @Override
    public void render(float delta) {
        


        
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void hide() {
    
        
    }

    @Override
    public void dispose() {



        
    }

}
