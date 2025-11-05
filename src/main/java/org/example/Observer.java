import java.util.*;

interface Observer {
    void atualizar(float temperatura, float umidade);
}

interface Subject {
    void registrar(Observer o);
    void remover(Observer o);
    void notificar();
}

class EstacaoClimatica implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private float temperatura;
    private float umidade;

    public void registrar(Observer o){ observers.add(o); }
    public void remover(Observer o){ observers.remove(o); }
    public void notificar(){
        for(Observer o : observers) o.atualizar(temperatura, umidade);
    }

    public void setMedidas(float temp, float umi){
        this.temperatura = temp;
        this.umidade = umi;
        notificar();
    }
}

class DisplayTemperatura implements Observer {
    public void atualizar(float temperatura, float umidade){
        System.out.println("Temperatura atual: " + temperatura);
    }
}

class DisplayUmidade implements Observer {
    public void atualizar(float temperatura, float umidade){
        System.out.println("Umidade atual: " + umidade);
    }
}

// Teste
public class MainObserver {
    public static void main(String[] args) {
        EstacaoClimatica estacao = new EstacaoClimatica();
        estacao.registrar(new DisplayTemperatura());
        estacao.registrar(new DisplayUmidade());

        estacao.setMedidas(30, 60);
    }
}
