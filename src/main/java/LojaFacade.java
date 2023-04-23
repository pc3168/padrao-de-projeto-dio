import bancodedados.ConexaoSingleton;
import modelo.Cliente;
import modelo.Produto;
import pagamento.PagamentoStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LojaFacade {

    private List<Produto> produtos;
    private Cliente cliente;

    public LojaFacade(Cliente cliente){
        this.cliente = cliente;
        produtos = new ArrayList<>();
    }

    public void carrinho(Produto produto){
        produtos.add(produto);
    }

    public void finalizarCompras(PagamentoStrategy pagamentoStrategy){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("pedido finalizado com sucesso.");
        System.out.printf("O cliente %s realizou a compra dos itens %s" +
                        " e o valor da compra é %2.2f e o pagamento foi em %s",
                cliente.getNome(),
                concatenarItens(),
                totalItens(),
                pagamentoStrategy.pagar());
        System.out.println(System.lineSeparator()+"---------------------------------------------------------------------");
        ConexaoSingleton conexaoDataBase = ConexaoSingleton.getConexaoDataBase();
        conexaoDataBase.gravandoInformacoes(cliente , produtos, pagamentoStrategy);
    }

    private double totalItens() {
        return produtos.stream()
                .mapToDouble(e -> e.getPreco())
                .sum();
    }

    private String concatenarItens(){
        return produtos.stream()
                .map(e -> e.getNome())
                .collect(Collectors.joining(" | "));
    }
}
