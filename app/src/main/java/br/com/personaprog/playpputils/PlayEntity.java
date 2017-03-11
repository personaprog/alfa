package br.com.personaprog.playpputils;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.RectF;
import android.renderscript.Float2;
/**
 * Created by persprog on 05/03/17.
 */
public class PlayEntity {
  public enum DebugDraw {
    FILLED, OUTLINE;
  }
  private String category;
  private int debugCor = Color.RED;
  private DebugDraw debugStyle = DebugDraw.FILLED;
  public PointF dim = new PointF();
  private int id;
  private boolean isativo = true;
  public PointF pos ;
  private RectF boxPad ;
  public RectF boxBound;
  public PlayMundo mundo;
  //
  public PlayEntity(PlayMundo mundo, int id, String category, PointF pos, PointF dim) {
    this.mundo = mundo;
    this.id = id;
    this.category = category;
    this.pos = pos;
    this.dim = dim;
  }
  public PlayEntity(PlayMundo mundo,String category, PointF dim, PointF pos) {
    this.dim = dim;
    this.pos = pos;
    this.category = category;
    _updateboxBound();
  }
  public PlayEntity(PlayMundo mundo,int id,PointF dim, PointF pos) {
    this.id = id;
    this.dim =dim;
    this.pos = pos;
    _updateboxBound();
  }
  public  void step(){}
  public void move(float x, float y){
    pos.x += x;
    pos.y += y;
    _updateboxBound();
  }
  public void setBoxPad(RectF boxPad) {

    this.boxPad = boxPad;
  }
  public RectF getBoxPad() {
    return boxPad;
  }
  public RectF getBoxBound() {
    return boxBound;
  }

  private void _updateboxBound() {
    boxBound.set(pos.x + boxPad.left,
        pos.y + boxPad.top,
        (pos.x + dim.x) - boxPad.right,
        (pos.y + dim.y) - boxPad.bottom
    );
  }


  public String getCategory() {return category;}
  public void setCategory(String category) {this.category = category;}
  public int getDebugCor() {return debugCor;}
  public void setDebugCor(int debugCor) {this.debugCor = debugCor;}
  public DebugDraw getDebugStyle() {return debugStyle;}
  public void setDebugStyle(DebugDraw debugStyle) {
    this.debugStyle = debugStyle;
  }
  public PointF getDim() {
    return dim;
  }
  public void setDim(PointF dim) {
    this.dim = dim;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public boolean isativo() {
    return isativo;
  }
  public void setIsativo(boolean isativo) {
    this.isativo = isativo;
  }
  public PointF getPos() {
    return pos;
  }
  public void setPos(PointF pos) {
    this.pos =pos;
    _updateboxBound();}
  public void setPos(float x, float y) {
    this.pos = new PointF(x,y);
    _updateboxBound();


  }
  public PlayMundo getMundo() {
    return mundo;
  }
  public void setMundo(PlayMundo mundo) {
    this.mundo = mundo;
  }
}
