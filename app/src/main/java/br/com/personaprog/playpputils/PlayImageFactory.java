package br.com.personaprog.playpputils;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
/**
 * Created by persprog on 21/02/17.
 */
public class PlayImageFactory {
  protected Context context= null;
  public PlayImageFactory(Context context) {
    this.context = context;
  }

  public PlayImage createImage(String fname){
    Bitmap bitmap = null;
    try{
      AssetManager  assetManager = context.getAssets();
      InputStream inputStream = assetManager.open(fname);
      bitmap = BitmapFactory.decodeStream(inputStream);
      inputStream.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
    PlayImage image = new PlayImage(bitmap);
    return image;
  }

  public PlayImage createImage( int id){
    Bitmap bitmap = null;
    try {
      Resources resources = context.getResources();
      InputStream inputStream = resources.openRawResource(id);
      bitmap = BitmapFactory.decodeStream(inputStream);
      inputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    PlayImage image = new PlayImage(bitmap);
    return image;
  }
  public Context getContext(){
    return null;
  }


}
