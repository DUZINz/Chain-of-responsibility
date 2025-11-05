interface Guerreiro { void atacar(); }
interface Mago { void conjurar(); }
interface Arqueiro { void disparar(); }

interface ReinoFactory {
    Guerreiro criarGuerreiro();
    Mago criarMago();
    Arqueiro criarArqueiro();
}

// Reino das Sombras
class GuerreiroSombras implements Guerreiro { public void atacar(){ System.out.println("Guerreiro das Sombras atacando"); } }
class MagoSombras implements Mago { public void conjurar(){ System.out.println("Mago das Sombras conjurando"); } }
class ArqueiroSombras implements Arqueiro { public void disparar(){ System.out.println("Arqueiro das Sombras disparando"); } }

class ReinoSombrasFactory implements ReinoFactory {
    public Guerreiro criarGuerreiro(){ return new GuerreiroSombras(); }
    public Mago criarMago(){ return new MagoSombras(); }
    public Arqueiro criarArqueiro(){ return new ArqueiroSombras(); }
}
