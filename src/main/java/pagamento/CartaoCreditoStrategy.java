package pagamento;

public class CartaoCreditoStrategy implements PagamentoStrategy{

    @Override
    public String pagar() {
        return "cartão de Crédito";
    }
}
