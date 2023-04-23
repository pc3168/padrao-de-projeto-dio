package pagamento;

public class DinheiroStrategy implements PagamentoStrategy{

    @Override
    public String pagar() {
        return "Dinheiro";
    }
}
