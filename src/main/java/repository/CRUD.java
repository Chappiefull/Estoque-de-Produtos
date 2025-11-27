import java.util.ArrayList;

public class CRUD {
    public static Produto Criar(String nome, double preco, int quantidade) {
        return new Produto(nome, preco, quantidade);
    }

    public static void Listar(ArrayList<Produto> produtos) {
        
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + "  " + produtos.get(i).getNome() + " | " + produtos.get(i).getPreco() + " | " + produtos.get(i).getQuantidade());
        }
    }

    public static void Modificar(Produto produto, String nome, double preco, int quantidade) {
        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setQuantidade(quantidade);
    }

    public static ArrayList<Produto> Deletar(ArrayList<Produto> produtos, int i) {
        produtos.remove(i);
        return produtos;
    }
}
