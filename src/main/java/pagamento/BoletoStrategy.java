package pagamento;

public class BoletoStrategy implements PagamentoStrategy{

    @Override
    public String pagar() {
        return "boleto";
    }
}
