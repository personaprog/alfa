package br.com.personaprog.playpputils;
import android.os.SystemClock;
/**
 * Created by persprog on 17/02/17.
 */
public class Playtepwatch {
   protected long mTempoAtual;     //timestamp marcação atual
   protected long mTempoAnterior;  //timestamp marcação anterior
   protected float mTempoEspaco;   // Tempo decorrido entre atual e anterior;

  public float tick(){
    if(mTempoAtual == 0) mTempoAnterior = mTempoAtual = SystemClock.uptimeMillis();
    else mTempoAtual =SystemClock.uptimeMillis();
    mTempoEspaco = (mTempoAtual - mTempoAnterior) /1000.0f;
    mTempoAnterior = mTempoAtual;
    return mTempoEspaco;
  }
}
