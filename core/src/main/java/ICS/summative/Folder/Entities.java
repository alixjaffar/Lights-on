package ICS.summative.Folder;
// package ICS.summative;
// import com.badlogic.gdx.ApplicationAdapter;
// import com.badlogic.gdx.Gdx;
// import com.badlogic.gdx.Input;
// import com.badlogic.gdx.InputAdapter;
// import com.badlogic.gdx.graphics.GL20;
// import com.badlogic.gdx.graphics.g2d.BitmapFont;
// import com.badlogic.gdx.graphics.g2d.SpriteBatch;
// import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
// import com.badlogic.gdx.math.Vector2;

/**
 * @Author: Waheed Magsi
 */

// public class Entities {

//     float circleX = 300;
//     float circleY = 150;
//     float circleRadius = 50;

//     if(currentScreen == Screen.TITLE){

//         Gdx.gl.glClearColor(0, .0f, 0, 0);
//         Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//         batch.begin();
//         font.draw(batch, "Lights On...", Gdx.graphics.getWidth()*.43f, Gdx.graphics.getHeight() * .75f);
//         font.draw(batch, "Press Space to Play", Gdx.graphics.getWidth()*.40f, Gdx.graphics.getHeight() * .2f);
//         batch.end();
//     }
//     else if(currentScreen == Screen.MAIN_GAME) {

//         if (Gdx.input.isKeyPressed(Input.Keys.A)) {
//             circleX -= 10;
//         }

//         if (Gdx.input.isKeyPressed(Input.Keys.D)) {
//             circleX += 10 ;
//         }

//         if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
//             circleX -= 10;
//         }

//         if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
//             circleX += 10;
//         }

//         Gdx.gl.glClearColor(0, 0, .25f, 1);
//         Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//         shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//         shapeRenderer.setColor(0, 1, 0, 1);
//         shapeRenderer.circle(circleX, circleY, 25);
//         shapeRenderer.end();
//     }
//     else if(currentScreen == Screen.GAME_OVER){
//         batch.begin();
//         font.draw(batch, "The Monster is Gone... for now.", Gdx.graphics.getWidth()*.35f, Gdx.graphics.getHeight() * .75f);
//         font.draw(batch, "Press enter to restart.", Gdx.graphics.getWidth()*.30f, Gdx.graphics.getHeight() * .3f);
//         batch.end();
//     }
//     else if (currentScreen == Screen.SECOND_LEVEL) {
//         Gdx.gl.glClearColor(.100f, 0, 0, 1);
//         Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//         shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//         shapeRenderer.setColor(0, 1, 0, 1);
//         shapeRenderer.circle(circleX, circleY, 25);
//         shapeRenderer.end();

//         batch.begin();
//         font.draw(batch, "You have reached the second level.", Gdx.graphics.getWidth()*.35f, Gdx.graphics.getHeight() * .75f);
//         batch.end();
//     }

//     else if(currentScreen == Screen.TEST_ROOM){
//         Gdx.gl.glClearColor(.100f, 0, 0, 1);
//         Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
//         shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//         shapeRenderer.setColor(0, 1, 0, 1);
//         shapeRenderer.circle(circleX, circleY, 25);
//         shapeRenderer.end();


//         batch.begin();
//         font.draw(batch, "You have reached the test room.", Gdx.graphics.getWidth()*.35f, Gdx.graphics.getHeight() * .75f);
//         batch.end();{
//             if (Gdx.input.isKeyPressed(Input.Keys.A)) {
//                 circleX -= 10;
//             }

//             if (Gdx.input.isKeyPressed(Input.Keys.D)) {
//                 circleX += 10 ;
//             }

//             if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
//                 circleX -= 10;
//             }

//             if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
//                 circleY += 10;
//             }
//         }
//     }


//     else if(currentScreen == Screen.QUESTION){

//             Gdx.gl.glClearColor(0, .0f, 0, 0);
//             Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//             shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//             shapeRenderer.setColor(0, 1, 0, 1);
//             shapeRenderer.circle(circleX, circleY, 25);
//             shapeRenderer.end();
//             batch.begin();
//             font.draw(batch, "Old Man: I've got a question for you", Gdx.graphics.getWidth()*.43f, Gdx.graphics.getHeight() * .75f);
//             batch.end();
//     }

//     if (circleX == 350 && circleY == 150) {
            
//         batch.begin();
//         font.draw (batch, "Press F to go to the next room.", Gdx.graphics.getWidth()*.35f, Gdx.graphics.getHeight() * .3f);
//         batch.end();
//     }




// }

