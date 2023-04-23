package bancodedados;

import modelo.Cliente;
import modelo.Produto;
import pagamento.PagamentoStrategy;

import java.util.List;

public class ConexaoSingleton {

    private static ConexaoSingleton conexaoDataBase;

    private ConexaoSingleton() {

    }

    public static ConexaoSingleton getConexaoDataBase() {
        if (conexaoDataBase == null) {
            conexaoDataBase = new ConexaoSingleton();
        }
        System.out.println("conectando com o banco de dados...."+conexaoDataBase);
        return conexaoDataBase;
    }

    public void gravandoInformacoes(Cliente cliente, List<Produto> produtos, PagamentoStrategy pagamentoStrategy){
        System.out.println("----------------------------------");
        System.out.printf("gravado no banco de dados." +
                "Cliente, %s ,  "+System.lineSeparator() +
                "Produtos %s , " +System.lineSeparator()+
                "Pagamento %s "+System.lineSeparator(),
                cliente, produtos, pagamentoStrategy.pagar());
        System.out.println("----------------------------------");
    }

}
