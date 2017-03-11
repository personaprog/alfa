package br.com.personaprog.playpputils.model;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import br.com.personaprog.playpputils.Entitys.EntBloco;
import br.com.personaprog.playpputils.Entitys.EntPlayer;
import br.com.personaprog.playpputils.PlayMundo;
/**
 * Created by persprog on 05/03/17.
 */
public class JogoModel extends PlayMundo {
  public static final int PLAYER_ID = 10;
  public static final int BLOCO_SIZE = 90;
  public static final int PLAYER_H = 70;
  public static final int PLAYER_W = 20;

  private EntPlayer player;
  private List<EntBloco> blocos ;

  public Collection<EntBloco> getBlocos() {
    return blocos;
  }

  public void setBlocos(EntBloco bloco) {
    if(blocos == null)
      blocos = new ArrayList<>();
    blocos.add(bloco);
  }
  public void setPlayer(EntPlayer player) {
    this.player = player;
  }
  private EntBloco[] bloco = new EntBloco[9];

  public JogoModel(Point point) {
    super(point);
  }
  @Override
  public void step() {
    super.step();
  }
  @Override
  public void setup() {
    super.setup();
    Point point = getPoint();

   final  PointF dimBloco = new PointF(BLOCO_SIZE, BLOCO_SIZE);
   final PointF tempJog = new PointF(PLAYER_H, point.y - PLAYER_H);
   final PointF dimJog = new PointF(PLAYER_W, point.y - PLAYER_H);
    ThModel(this,dimBloco,tempJog,dimJog,point).start();
//    setImgRect(new RectF(getX(),getY() - getH(),getX() +getW(), getY()));
//    setPosRect(new Rect(srcX, srcY, srcX + getPlayH(), srcY + getPlayH()));
  }
  @Override
  public Point getPoint() {
    return super.getPoint();
  }
  @Override
  public boolean testCollisao(RectF r1, RectF r2) {
    return super.testCollisao(r1, r2);
  }
  private Thread ThModel(final PlayMundo pl,  final PointF dimBloco,
      final PointF tempJog, final PointF dimJog,final Point point) {
    return new Thread() {
      public void run() {


        setPlayer(new EntPlayer(pl, tempJog, dimJog));
       // Log.v("Repeat: ","x: "+player.getPos().x + " - " + "y: "+player.getPos().y + "");
        int i = 0;
        PointF tempBloco ;
        tempBloco = new PointF((i + 1) * 100 + PLAYER_H, point.y - 350 - PLAYER_H);
        while (true) {

          setBlocos(new EntBloco(pl, i, tempBloco, dimBloco));
       ///   Log.v("Repeat: ","x: "+bloco[i].getPos().x + " - " + "y: "+bloco[i].getPos().y + "");
          if (i == 9) break;
        }

      }
    };
  }
  public Collection<EntBloco> getBloco() {
    return blocos;
  }
  public EntPlayer getPlayer() {
    return player;
  }
}
