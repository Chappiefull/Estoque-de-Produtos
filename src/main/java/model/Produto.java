public class Produto {
    //Atributos
    private String nome;
    private double preco;
    private int quantidade;

    //Construtor
    public Produto (String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    //getters e setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return this.nome;
    }

    public void setPreco(double preco) {
        this.preco = preco ;
    }
    public double getPreco() {
        return this.preco;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public int getQuantidade() {
        return this.quantidade;
    }
}
