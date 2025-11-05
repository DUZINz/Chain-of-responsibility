interface Mensagem {
    String formatar();
}

class MensagemSimples implements Mensagem {
    public String formatar(){ return "Mensagem base"; }
}

abstract class MensagemDecorator implements Mensagem {
    protected Mensagem mensagem;
    public MensagemDecorator(Mensagem mensagem){ this.mensagem = mensagem; }
}

class Criptografada extends MensagemDecorator {
    public Criptografada(Mensagem m){ super(m); }
    public String formatar(){ return "🔒 " + mensagem.formatar(); }
}

class Comprimida extends MensagemDecorator {
    public Comprimida(Mensagem m){ super(m); }
    public String formatar(){ return "📦 " + mensagem.formatar(); }
}

class Assinada extends MensagemDecorator {
    public Assinada(Mensagem m){ super(m); }
    public String formatar(){ return mensagem.formatar() + " ✍️ Assinada"; }
}

// Teste
public class MainDecorator {
    public static void main(String[] args) {
        Mensagem msg = new Assinada(new Comprimida(new Criptografada(new MensagemSimples())));
        System.out.println(msg.formatar());
    }
}
