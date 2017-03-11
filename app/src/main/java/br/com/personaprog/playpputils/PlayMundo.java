package br.com.personaprog.playpputils;
import android.graphics.Point;
import android.graphics.RectF;
/**
 * Created by persprog on 05/03/17.
 */
public class PlayMundo {
  private Point point;

  public PlayMundo(Point point) {this.point = new Point(point);}

  public void step(){}

  public  void setup() {};

  public Point getPoint(){return point;}

  public boolean testCollisao(RectF r1,RectF r2){
    return r1.bottom < r2.top;
  }
}
