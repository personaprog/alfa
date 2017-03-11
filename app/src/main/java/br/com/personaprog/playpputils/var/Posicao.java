package br.com.personaprog.playpputils.var;
public enum Posicao {
  PARADO(0),ESQ(1,-1),DIR(2,1),PULAR(0,1),CAIR(0,-1);
  private int pos;
  private int direcao;
  Posicao(int pos,int direcao) {
    this.pos = pos;
    this.direcao = direcao;
  }
  Posicao(int pos) {
    this.pos = pos;
  }
  public int getPos(){
    return  pos;
  }
  public int getDirecao(){
    return  direcao;
  }
}

