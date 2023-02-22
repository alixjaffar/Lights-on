// import com.badlogic.gdx.Gdx;
// import com.badlogic.gdx.files.FileHandle;
// import com.badlogic.gdx.utils.Json;

/**
 * @Author: Waheed Magsi
 */


// public class Highscore {
//     private static final String Highscore = "score.json";
//     private int highScore;

//     public Highscore() {

//         FileHandle file = Gdx.files.local(Highscore);
//         Json json = new Json();
//         HighscoreData data = json.fromJson(HighscoreData.class, score.json);
//         highScore = data.highscore;
//     }

//     public void checkNewHighScore(int currentscore) {
//         if (currentscore > highscore) {
//             highScore = currentscore;

//             FileHandle file = Gdx.files.local(Highscore);
//             Json json = new Json();
//             HighscoreData data = new HighscoreData();
//             data.highScore = highscore;
//             file.writeString(json.toJson(data), false);
           
//         }
//     }

//     public int getHighscore() {
//         return highScore;
//     }
// }