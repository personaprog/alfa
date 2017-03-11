package br.com.personaprog.playpputils;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.view.SurfaceView;
import android.view.View;
/**
 * Created by persprog on 16/02/17.
 */

public class PlayView extends View {

   private Playtepwatch mTepwatch = new Playtepwatch();
   private PlayRenderer render;
  private Point mDimensions = new Point();
  private static PlayImageFactory nums;
  private boolean mHasStarted;




  public PlayView(Context context) {
    super(context);
    nums = new PlayImageFactory(context);
    render = new PlayRenderer();
  }
  @Override
  protected void onDraw(Canvas canvas) {
    step(canvas);
    invalidate();
  }

  public void step(Canvas canvas){

  }

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    mDimensions.set(w,h);
    if(!mHasStarted){
      setup();
      mHasStarted = true;
    }
  }

  protected void setup(){}
  public Point getmDimensions(){ return mDimensions;};
  public PlayImageFactory getImgFac() {return nums;}
  public static PlayImageFactory getImgFacS() {return nums;}
  public PlayRenderer getRenderer() {return render;}
}
