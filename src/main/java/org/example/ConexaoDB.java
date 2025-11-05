public class ConexaoBD {
    private static ConexaoBD instancia;

    private ConexaoBD() {
        System.out.println("Conectando ao banco de dados...");
    }

    public static ConexaoBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexaoBD();
        }
        return instancia;
    }

    public void executarConsulta(String sql) {
        System.out.println("Executando: " + sql);
    }
}

// Teste
public class MainSingleton {
    public static void main(String[] args) {
        ConexaoBD c1 = ConexaoBD.getInstancia();
        ConexaoBD c2 = ConexaoBD.getInstancia();

        System.out.println(c1 == c2); // true
        c1.executarConsulta("SELECT * FROM usuarios");
    }
}
