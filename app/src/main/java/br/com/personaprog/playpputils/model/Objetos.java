package br.com.personaprog.playpputils.model;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.personaprog.playpputils.PlayImage;
import br.com.personaprog.playpputils.PlayRenderer;
import br.com.personaprog.playpputils.var.Horienta;
/**
 * Created by persprog on 19/02/17.
 */
abstract class Objetos implements Serializable {


  private int moveImg;
  private int imgSalto;
  private Rect PosRect;
  private RectF imgRect;
  private Point dim;
  private int x;
  private int y;
  private int w;
  private int h;
  private PlayImage img;
  private int xY;
  private List<Objetos> list;
  private  int proporcaoImg;
  protected int getProporcaoImg() {
    return proporcaoImg;
  }
  protected void setProporcaoImg(int proporcaoImg) {
    this.proporcaoImg = proporcaoImg;
  }
  public Point getDim() {return dim;}
  public void setDim(Point dim) {this.dim = dim;}

  public int getxY() {return xY;}
  public void setxY(int xY) {this.xY = xY;}
  public Rect getPosRect() {return PosRect;}
  public void setPosRect(Rect posRect) {PosRect = posRect;}
  public List<Objetos> getList() {return list;}
  public void setList(Objetos list) {
    if (getList() == null)
      this.list = new ArrayList<>();
    getList().add(list);
  }
  public int getImgSalto() {
    return imgSalto;
  }
  public void setImgSalto(int imgSalto) {
    this.imgSalto = imgSalto;
  }
  public RectF getImgRect() {
    return imgRect;
  }
  public void setImgRect(RectF imgRect) {
    this.imgRect = imgRect;
  }
  public int getMoveImg() {
    return moveImg;
  }
  public void setMoveImg(int moveImg) {
    this.moveImg = moveImg;
  }
  public int getX() {
    return x;
  }
  public void setX(int x) {
    this.x = x;
  }
  public int getY() {
    return y;
  }
  public void setY(int y) {
      this.y = y;
  }
  public PlayImage getImg() {
    return img;
  }
  public void setImg(PlayImage img) {
    this.img = img;
  }
  public int getW() {
    return w;
  }
  public void setW(int w) {this.w = w;}
  public int getH() {
    return h;
  }
  public void setH(int h) {this.h = h;}
  public abstract void Mostra(Canvas canvas, PlayRenderer renderer);
  public abstract void draw(Canvas canvas);
  public abstract void processAI();
  public void Posicao() {}
  public void LimArea(Horienta direct, int v){
       if(direct.equals(Horienta.V))
         setY(getY() + v >= getDim().y ? getH():getY() + v < 0?getDim().y:getDim().y - (getY() + v));
        else
         setX(getX() + v + getW()>= getDim().x  ? getDim().x - getW():getX() +  v<0?0:getX() + v);
  }
  public abstract void CriarLista(Point point);

}
