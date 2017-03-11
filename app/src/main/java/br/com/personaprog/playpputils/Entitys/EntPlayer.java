package br.com.personaprog.playpputils.Entitys;
import android.graphics.PointF;

import br.com.personaprog.playpputils.PlayEntity;
import br.com.personaprog.playpputils.PlayMundo;
import br.com.personaprog.playpputils.model.JogoModel;
/**
 * Created by persprog on 05/03/17.
 */
public class EntPlayer extends PlayEntity {
  private  float speed;
  public EntPlayer(PlayMundo mundo,  PointF pos, PointF dim) {
   super(mundo, JogoModel.PLAYER_ID, "Educ", pos, dim);
  }
  @Override
  public void step() {
  }
}
