interface Transporte {
    void entregar();
}

class Carro implements Transporte {
    public void entregar() { System.out.println("Entrega de carro"); }
}

class Moto implements Transporte {
    public void entregar() { System.out.println("Entrega de moto"); }
}

class Onibus implements Transporte {
    public void entregar() { System.out.println("Entrega de ônibus"); }
}

class TransporteFactory {
    public static Transporte criarTransporte(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "carro" -> new Carro();
            case "moto" -> new Moto();
            case "onibus" -> new Onibus();
            default -> throw new IllegalArgumentException("Tipo inválido");
        };
    }
}

// Teste
public class MainFactory {
    public static void main(String[] args) {
        Transporte t1 = TransporteFactory.criarTransporte("carro");
        t1.entregar();
    }
}
