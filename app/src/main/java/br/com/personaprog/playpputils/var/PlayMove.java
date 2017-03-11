package br.com.personaprog.playpputils.var;
/**
 * Created by persprog on 04/03/17.
 */
public enum  PlayMove{

  PULAR(Posicao.PULAR.getPos(), Horienta.V, Posicao.PULAR.getDirecao()),
  CAIR(Posicao.CAIR.getPos(), Horienta.V, Posicao.CAIR.getDirecao()),
  ANDAR_E(Posicao.ESQ.getPos(), Horienta.H, Posicao.ESQ.getDirecao()),
  ANDAR_D(Posicao.DIR.getPos(), Horienta.H, Posicao.DIR.getDirecao());

  private Horienta direcao;
  private int posicao;
  private int sentido;

  PlayMove(int posicao,   Horienta direcao, int sentido) {
    this.direcao = direcao;
    this.posicao = posicao;
    this.sentido = sentido;
  }
  public Horienta getDirecao(){
    return direcao;
  }
  public int getPosicao(){
    return posicao;
  }
  public int getSentido(){return sentido;}
}
