package br.com.personaprog.playpputils.Entitys;
import android.graphics.PointF;

import br.com.personaprog.playpputils.PlayEntity;
import br.com.personaprog.playpputils.PlayMundo;
import br.com.personaprog.playpputils.model.JogoModel;
/**
 * Created by persprog on 05/03/17.
 */
public class EntBloco extends PlayEntity {
  private  float speed;
  public EntBloco(PlayMundo mundo, int id, PointF pos, PointF dim) {
    super(mundo, id, "Educ", pos, dim);

  }
  @Override
  public void step() {

  }
}
