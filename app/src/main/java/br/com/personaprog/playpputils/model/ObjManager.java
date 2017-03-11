package br.com.personaprog.playpputils.model;
import android.graphics.Canvas;

import java.util.Collection;
import java.util.HashSet;

import br.com.personaprog.playpputils.model.Objetos;
/**
 * Created by persprog on 01/03/17.
 */
public class ObjManager {
  private Collection<Objetos> pieces;

  public ObjManager() {
    pieces = new HashSet<>();
  }

  public void addPiece(Objetos ent) {
    pieces.add(ent);
  }
  public void addPieces(Collection<Objetos> ent) {pieces= ent;}
  public void draw(Canvas canvas) {
    for (Objetos ent : pieces)
      ent.draw(canvas);
  }

  public Collection<Objetos> getPieces() {
    return pieces;
  }

  public void processAI() {
    for (Objetos ent : pieces)
      ent.processAI();
  }
}
