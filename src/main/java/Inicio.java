import modelo.Cliente;
import modelo.Produto;
import pagamento.BoletoStrategy;
import pagamento.CartaoCreditoStrategy;
import pagamento.DinheiroStrategy;
import pagamento.PagamentoStrategy;

public class Inicio {
    public static void main(String[] args) {
        Produto p1 = new Produto("Feijão", 18.50);
        Produto p2 = new Produto("Arroz", 22.20);
        Produto p3 = new Produto("Batata", 15.80);
        Produto p4 = new Produto("Pimentão", 8.80);
        Produto p5 = new Produto("Cenoura", 5.80);


        PagamentoStrategy dinheiro = new DinheiroStrategy();
        PagamentoStrategy cartao = new CartaoCreditoStrategy();
        PagamentoStrategy boleto = new BoletoStrategy();

        LojaFacade lojaFacade1 = new LojaFacade(new Cliente("Paulo César"));
        lojaFacade1.carrinho(p1);
        lojaFacade1.carrinho(p4);
        lojaFacade1.carrinho(p5);
        lojaFacade1.finalizarCompras(dinheiro);

        LojaFacade lojaFacade2 = new LojaFacade(new Cliente("Ana Carolina"));
        lojaFacade2.carrinho(p1);
        lojaFacade2.carrinho(p3);
        lojaFacade2.carrinho(p4);
        lojaFacade2.finalizarCompras(cartao);

        LojaFacade lojaFacade3 = new LojaFacade(new Cliente("Pedro Henrique"));
        lojaFacade3.carrinho(p1);
        lojaFacade3.carrinho(p2);
        lojaFacade3.carrinho(p3);
        lojaFacade3.finalizarCompras(boleto);





    }
}
