package ICS.summative.Folder;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
/**
 * @Author: Waheed Magsi
 * @Description: This is the save system class. It is where the game will be saved and loaded.
 */

public class Savesystem {
    private static final String PREF_NAME = "gameprogress";
    private static final String PREF_LEVEL = "level";

    private Preferences prefs;

    public Savesystem() {
        prefs = Gdx.app.getPreferences(PREF_NAME);
    }

    public void saveProgress(int level) {
        prefs.putInteger(PREF_LEVEL, level);
        prefs.flush();
    }

    public int getLevel() {
        return prefs.getInteger(PREF_LEVEL, 1);
    }


}

// SaveSystem Savesystem = new Savesystem();
// 	saveSystem.saveProgress(3);
// 	int level = saveSystem.getLevel();