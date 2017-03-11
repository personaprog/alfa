package br.com.personaprog.playpputils;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;

import com.bumptech.glide.BitmapTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawableResource;

import java.lang.ref.Reference;
import java.util.concurrent.ExecutionException;
/**
 * Created by persprog on 23/02/17.
 */
public class PlayRenderer {
  private  Canvas tempCanvas;
  private  Paint tempPaint = new Paint();
  private RectF  tempRect = new RectF();
  private  BitmapTypeRequest<Bitmap> bitmap ;

  public PlayRenderer(){

  };
public  void drawRect(Point pos,Point dim, int color){
  tempPaint.setColor(color);
  tempPaint.setStyle(Paint.Style.FILL);
  tempRect.set(pos.x,pos.y,pos.x + dim.x,pos.y + dim.y);
tempCanvas.drawRect(tempRect,tempPaint);
}
  public  void drawRect(PointF pos,PointF dim, int color){
  tempPaint.setColor(color);
    tempPaint.setStyle(Paint.Style.FILL);
    tempRect.set(pos.x,pos.y,pos.x + dim.x,pos.y + dim.y);
    tempCanvas.drawRect(tempRect,tempPaint);
  }
  public  void drawRect(RectF rect, int color){
    tempPaint.setColor(color);
    tempPaint.setStyle(Paint.Style.FILL);
    tempCanvas.drawRect(tempRect,tempPaint);
  }
  public void drawOutlineRect(Rect word,int color){
    tempPaint.setColor(color);
    tempPaint.setStyle(Paint.Style.STROKE);
    tempPaint.setStrokeWidth(0);
    tempRect.set(word);
    tempRect.right -= 1;
    tempRect.bottom -= 1;
    tempCanvas.drawRect(tempRect,tempPaint);
  }
  public void drawOutlineRect(PointF pos, PointF dim,int color){
    tempPaint.setColor(color);
    tempPaint.setStyle(Paint.Style.STROKE);
    tempPaint.setStrokeWidth(0);
    tempRect.set(pos.x,pos.y,pos.x + dim.x,pos.y + dim.y);
    tempRect.right -= 1;
    tempRect.bottom -= 1;
    tempCanvas.drawRect(tempRect,tempPaint);
  }
  public void iniDraw(Canvas canvas, int corFundo ){

    tempCanvas = canvas;
    tempCanvas.drawColor(corFundo);

  }
public void drawImg(final String image,final Context context, final Rect source,final PointF pos,
   final PointF dim){

  tempRect.set(pos.x,pos.y,pos.x + dim.x,pos.y + dim.y);
   new Thread() {
     @Override
     public void run() {
       try {
         tempCanvas.drawBitmap(Glide.with(context).load(image).asBitmap().into(source.width(),
             source
                 .height()).get(), source, tempRect, tempPaint);

       } catch (
           InterruptedException e
           ) {
         e.printStackTrace();
       } catch (
           ExecutionException e
           ) {
         e.printStackTrace();
       }
     }
     }.start();
}

public void fimImg(){}
}
