package br.com.personaprog.playpputils;
import android.graphics.Bitmap;
import android.graphics.Point;

import java.io.Serializable;
/**
 * Created by persprog on 21/02/17.
 */
public class PlayImage implements Serializable{
  private Bitmap bitmap = null;
  private Point point = new Point();
  public PlayImage(Bitmap bitmap) {
    this.bitmap = bitmap;
    point.set(bitmap.getWidth(),bitmap.getWidth());
  }

  public Bitmap getBitmap() {
    return bitmap;
  }

  public Point getPoint() {
    return point;
  }

}
