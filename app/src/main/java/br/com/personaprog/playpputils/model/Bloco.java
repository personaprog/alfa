package br.com.personaprog.playpputils.model;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import java.util.Collection;
import br.com.personaprog.playpputils.PlayImage;
import br.com.personaprog.playpputils.PlayImageFactory;
import br.com.personaprog.playpputils.PlayRenderer;

/**
 * Created by persprog on 20/02/17.
 */

public class Bloco extends Objetos {
private PlayImage bit;
  private int rowSelect = 0;

  public Bloco(Context context) {
//    this.bit =  new PlayImageFactory(context).createImage(R.drawable.numbs);
  }

  public Bloco() {}
  @Override
  public void CriarLista(Point point) {
    int currentFrame = 0;
    rowSelect = 0;
    final int BMP_ROWS = 1;
    final int BMP_COLUMNS = 10;
    int srcX, srcY;
    int  i =0;
    Objetos t;
    int spritesW= (bit.getBitmap().getWidth()/BMP_COLUMNS);
    int spritesH= (bit.getBitmap().getHeight());
    while (true) {
      t =new Bloco();
      t.setH(90);
      t.setW(90);
      srcX = i * spritesW;
      srcY =0;
      t.setX(++i * 110); // direita esquerda
      t.setY(point.y - 330); // cima baixo
      t.setImgRect(new RectF(t.getX() , t.getY(), t.getX() + t.getW(), t.getY() + t.getH()));
      t.setPosRect(new Rect(srcX,  srcY  , srcX +spritesW , srcY +  spritesH));
      Log.d("Dim:","X: "+ t.getX() + " Y: "+ t.getY() + " H: "+ t.getH() + " W: "+ t.getW() +
          " sY: "+srcY
          + " sX: "+srcX + " SpH: " + spritesH + " SpW: " + spritesW);
      setList(t);
      if (i == 10) {
        break;
      }

    }


  }



  @Override
  public void Mostra(Canvas canvas, PlayRenderer renderer) {

  }

  public void MostraLista(Canvas canvas, Collection<Objetos> manage, PlayRenderer rerender) {
    for (Object l : manage.toArray()) {
      Bloco imp = (Bloco) l;
     rerender.drawRect(imp.getImgRect(),Color.BLUE);
//     rerender.drawImg(bit, imp.getPosRect(), imp.getImgRect());
    }
  }
  @Override
  public void draw(Canvas canvas) {
  }
  @Override
  public void processAI() {
  }

}
