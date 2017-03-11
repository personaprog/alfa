package br.com.personaprog.playpputils;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
/**
 * Created by persprog on 16/02/17.
 */
public class PlayPreferences {
  private SharedPreferences.Editor mEditor = null;
  private SharedPreferences mpreferences = null;
  public PlayPreferences(Activity activity) {
    mpreferences = activity.getPreferences(Context.MODE_PRIVATE);
    mEditor = mpreferences.edit();
  }
  public PlayPreferences begin() {
    mEditor = mpreferences.edit();
    return this;
  }
  public PlayPreferences remove(String key) {
    mEditor.remove(key);
    return this;
  }
  public PlayPreferences end() {
    mEditor.commit();
    return this;
  }
  public boolean getBoolean(String key, boolean defaultValue) {
    try {
      return mpreferences.getBoolean(key, defaultValue);
    } catch (ClassCastException e) {
      Log.d(PlayActivity.TAG, "SGpreferencia.getBoolean possui valor diferente");
      return defaultValue;
    }
  }
  public PlayPreferences putBoolean(String key, boolean defaultValue) {
    mEditor.putBoolean(key, defaultValue);
    return this;
  }
  public Float getFloat(String key, Float defaultValue) {
    try {
      return mpreferences.getFloat(key, defaultValue);
    } catch (ClassCastException e) {
      Log.d(PlayActivity.TAG, "SGpreferencia.getFloat possui valor diferente");
      return defaultValue;
    }
  }
  public PlayPreferences putFloat(String key, Float defaultValue) {
    mEditor.putFloat(key, defaultValue);
    return this;
  }
  public int getint(String key, int defaultValue) {
    try {
      return mpreferences.getInt(key, defaultValue);
    } catch (ClassCastException e) {
      Log.d(PlayActivity.TAG, "SGpreferencia.getint possui valor diferente");
      return defaultValue;
    }
  }
  public PlayPreferences putInt(String key, int defaultValue) {
    mEditor.putInt(key, defaultValue);
    return this;
  }
  public Long getLong(String key, Long defaultValue) {
    try {
      return mpreferences.getLong(key, defaultValue);
    } catch (ClassCastException e) {
      Log.d(PlayActivity.TAG, "SGpreferencia.getLong possui valor diferente");
      return defaultValue;
    }
  }
  public PlayPreferences putLong(String key, Long defaultValue) {
    mEditor.putLong(key, defaultValue);
    return this;
  }
  public String getString(String key, String defaultValue) {
    try {
      return mpreferences.getString(key, defaultValue);
    } catch (ClassCastException e) {
      Log.d(PlayActivity.TAG, "SGpreferencia.getBoolean possui valor diferente");
      return defaultValue;
    }
  }
  public PlayPreferences putString(String key, String defaultValue) {
    mEditor.putString(key, defaultValue);
    return this;
  }
}