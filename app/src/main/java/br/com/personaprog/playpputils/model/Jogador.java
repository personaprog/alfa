package br.com.personaprog.playpputils.model;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.KeyEvent;

import br.com.personaprog.playpputils.PlayImageFactory;
import br.com.personaprog.playpputils.PlayRenderer;

import br.com.personaprog.playpputils.var.Horienta;
import br.com.personaprog.playpputils.var.PlayMove;
import br.com.personaprog.playpputils.var.Posicao;
;
/**
 * Created by persprog on 20/02/17.
 */
public class Jogador extends Objetos {
  private static final int BMP_ROWS = 4;
  private static final int BMP_COLUMNS = 3; 
  private static final int POS_H = 0;
  private static final int POS_W = 0;
  private Context context;
  private Thread pular;
  private int rowSelect ;
  private int currentFrame;
  private int playW, playH;
  private Paint paint;    //Provisório
  public int getPlayW() {
    return playW;
  }
  public void setPlayW(int playW) {
    this.playW = playW;
  }
  public int getPlayH() {
    return playH;
  }
  public void setPlayH(int playH) {
    this.playH = playH;
  }
  public int getCurrentFrame() {
    return currentFrame;
  }
  public void setCurrentFrame() {
    this.currentFrame = 0;
  }
  public void setCurrentFrame(int currentFrame) {
    this.currentFrame = ++this.currentFrame  % BMP_COLUMNS;
  }
  public int getRowSelect() {
    return rowSelect;
  }
  public void setRowSelect(int rowSelect) {
    this.rowSelect = rowSelect;
  }

  private Thread getPular() {
    return pular;
  }
  private void setPular(Thread pular) {
    this.pular = pular;
  }

  private Context getContext() {
    return context;
  }
  public Jogador(Context context, Point point) {
    this.context = context;
    setDim(point);
    CriarPlayer();
  }
 
  private void CriarPlayer() {
    paint = new Paint();   //Provisório
    this.pular = new Thread();
    setCurrentFrame();
    setRowSelect(Posicao.PARADO.getPos());
//    setImg(new PlayImageFactory(getContext()).createImage(R.drawable.meninas));
    setProporcaoImg(3);
    setW((getImg().getBitmap().getHeight() / BMP_ROWS) * getProporcaoImg());
    setH((getImg().getBitmap().getWidth() / BMP_COLUMNS) * getProporcaoImg());
    LimArea(Horienta.H, POS_H);
    LimArea(Horienta.V, POS_W);
    setImgSalto(170);
    setMoveImg(5);
    setPlayW(getW() / getProporcaoImg());
    setPlayH(getH() / getProporcaoImg());
  }
  @Override
  public void CriarLista(Point point) {}
  @Override
  public void Mostra(Canvas canvas, PlayRenderer renderer) {
    int srcX = getCurrentFrame() * getPlayW();
    int srcY =  getRowSelect() * getPlayH();
    setImgRect(new RectF(getX(),getY() - getH(),getX() +getW(), getY()));
    setPosRect(new Rect(srcX, srcY, srcX + getPlayH(), srcY + getPlayH()));
//  nderer.drawImg(getImg(), getPosRect(), getImgRect());
/*
    paint.setTextSize(45);                                    //Provisório
    paint.setColor(Color.BLACK);                              //Provisório
    setxY(getX() + (getW() / 2));                             //Provisório
    canvas.drawText("x:" + getxY(), 20, 50, paint);           //Provisório
    setxY(getY() + (getH() / 2));                             //Provisório
    canvas.drawText("y:" + getxY(), 20, 100, paint);          //Provisório
*/
  }

  public boolean parar(final int keyCode) {
    setRowSelect(Posicao.PARADO.getPos());
    return true;
  }
  public boolean MoveObjeto(final int keyCode) {
    boolean botao_pressionado = true;
    switch (keyCode) {
      case KeyEvent.KEYCODE_DPAD_UP:
        try {
          if (!getPular().isAlive() ) {
            setPular(ThreadPular());
            getPular().start();
            getPular().destroy();
          }
        } catch (UnsupportedOperationException ignored) {} finally {break;}
      case KeyEvent.KEYCODE_DPAD_LEFT:
        mover(PlayMove.ANDAR_E);
        break;
      case KeyEvent.KEYCODE_DPAD_RIGHT:
        mover(PlayMove.ANDAR_D);
        break;
      default:
        botao_pressionado = false;
        break;
    }
    return botao_pressionado;
  }
  private Thread ThreadPular() {
    return new Thread() {
      public void run() {
        try {
          final int temp = getY();
          setRowSelect(Posicao.PULAR.getPos());
          while (true) {
//              mover(PlayMove.PULAR);
            setY(getY() - getMoveImg());
            sleep(5);
            if (getY() <= temp - getImgSalto()) {
              while (true) {
//                  mover(PlayMove.CAIR);
                setY(getY() + getMoveImg());
                sleep(5);
                if (getY() >= temp) {
                  setY(temp);
                  break;
                }
              }
              break;
            }
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };
  }
  private void mover(PlayMove row) {
    setRowSelect(row.getPosicao());
    LimArea(row.getDirecao(), row.getSentido() * getMoveImg());
    setCurrentFrame(getCurrentFrame());
  }
  @Override
  public void draw(Canvas canvas) {}
  @Override
  public void processAI() {}
}
