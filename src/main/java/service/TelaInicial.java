import java.util.ArrayList;
import java.util.Scanner;

public class TelaInicial {
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    public static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void telaInicial(){
        Scanner input = new Scanner(System.in);
        int escolha, quantidade, i;
        String nome;
        double preco;
        Produto produto;

        ArrayList<Produto> produtos = new ArrayList<>();
        
        mainLoop: while (true) {
            
            clear();
            System.out.print("CRUD de produtos!\n [1] Criar\n [2] Listar\n [3] Modificar\n [4] Deletar\n [5] Sair\n> ");
            try {
                escolha = input.nextInt();
                input.nextLine();
            } catch (Exception e) {
                input.nextLine();
                continue mainLoop;
            }
            
            switch (escolha) {
                case 1:
                    while (true) {
                        clear();
                        System.out.print("Digite o nome do produto: ");
                        nome = input.nextLine();
                        if (nome.trim().equals("")) {
                            continue;
                        } else if (isNumeric(nome)) {
                            continue;
                        } else { 
                            break;
                        }

                    }

                    while (true) {
                        clear();
                        System.out.println("Digite o nome do produto: " + nome);

                        try {
                            System.out.print("Digite o preço do produto: ");
                            preco = input.nextDouble();
                            input.nextLine();

                            if (preco <= 0) continue;
                            break;
                        } catch (Exception e) {
                            input.nextLine();
                        }
                    }
                    
                    while (true) {
                        try {
                            clear();
                            System.out.println("Digite o nome do produto: " + nome);
                            System.out.println("Digite o preço do produto: " + preco);
                            
                            System.out.print("Digite a quantidade: ");
                            quantidade = input.nextInt();
                            input.nextLine();
                            
                            if (quantidade <= 0) continue;
                            break;
                        
                        } catch (Exception e) {
                            input.nextLine();
                        }
                    }

                    produtos.add(CRUD.Criar(nome, preco, quantidade));
                    
                    System.out.println("Produto " + "\"" + nome + "\"" + " criado com sucesso!");
                    System.out.println("(enter para prosseguir)");
                    input.nextLine();

                    break;
                case 2:
                    clear();
                    CRUD.Listar(produtos);

                    System.out.println("(enter para prosseguir)");
                    input.nextLine();

                    break;
                case 3:
                    while (true) {
                        clear();
                        CRUD.Listar(produtos);

                        try {
                            System.out.print("Digite o id do produto que deseja modificar: ");
                            i = input.nextInt() - 1;
                            input.nextLine();
                        } catch (Exception e) {
                            input.nextLine();
                            continue;
                        }
                        try {
                            produto = produtos.get(i);
                            break;
                        } catch (Exception e) {
                            continue;
                        }
                    }
                    
                    while (true) {
                        clear();
                        System.out.println(produto.getNome() + " | " + produto.getPreco() + " | " + produto.getQuantidade());
                        System.out.print("(enter para não mudar o nome) digite o novo nome do produto: ");
                        nome = input.nextLine();

                        if (isNumeric(nome)) {
                            continue;
                        }
                        break;
                    }
                    nome = (nome.trim().equals("")) ? produto.getNome() : nome; 
                    
                    while (true) {
                        clear();
                        System.out.println(produto.getNome() + " | " + produto.getPreco() + " | " + produto.getQuantidade());
                        System.out.println("(enter para não mudar o nome) digite o novo nome do produto: " + nome);
                        try {
                            System.out.print("(0 para não mudar o preço) digite o novo preço do produto: ");
                            preco = input.nextDouble();
                            input.nextLine();

                            if (preco < 0) continue;
                            break;
                        } catch (Exception e) {
                            input.nextLine();
                        }
                    }
                    preco = (preco == 0) ? produto.getPreco() : preco; 
                    
                    while (true) {
                        clear();
                        System.out.println(produto.getNome() + " | " + produto.getPreco() + " | " + produto.getQuantidade());
                        System.out.println("(enter para não mudar o nome) digite o novo nome do produto: " + nome);
                        System.out.println("(0 para não mudar o preço) digite o novo preço do produto: " + preco);

                        try {
                            System.out.print("(0 para não mudar a quantidade)" + " digite a nova quantidade do produto: ");
                            quantidade = input.nextInt();
                            input.nextLine();

                            if (quantidade < 0) continue;
                            break;
                        } catch (Exception e) {
                            input.nextLine();
                        }
                    }
                    quantidade = (quantidade == 0) ? produto.getQuantidade() : quantidade; 
                    
                    CRUD.Modificar(produto, nome, preco, quantidade);
                    break;
                case 4:
                    while (true) {
                        try {
                            clear();
                            CRUD.Listar(produtos);
                            System.out.print("Digite o id do produto que deseja apagar: ");
                            i = input.nextInt() - 1;
                            input.nextLine();
                        } catch (Exception e) {
                            input.nextLine();
                            continue;
                        }
                        
                        try {
                            produto = produtos.get(i);
                            break;
                        } catch (Exception e) {
                            continue;
                        }
                    }
                    

                    while (true) {
                        clear();
                        System.out.println(produto.getNome() + " | " + produto.getPreco() + " | " + produto.getQuantidade());
                        System.out.print("Tem certeza que deseja excluir o produto " + "\"" + produto.getNome() + "\"" + "?(s/n)");
                        char confirmacao = input.next().charAt(0);
                        confirmacao = Character.toLowerCase(confirmacao);
                        input.nextLine();
                        
                        if (confirmacao == 's') {
                            nome = produto.getNome();
                            CRUD.Deletar(produtos, i);
                            System.out.println("\"" + nome + "\"" + " apagado com sucesso!\n" + "(enter para prosseguir)");
                            input.nextLine();
                            break;
                        } else if (confirmacao == 'n') {
                            break;
                        } else {
                            continue;
                        }
                    }
                    break;
                case 5:
                    clear(); 
                    break mainLoop;
                default:
                    System.out.println("");
            }

        }
        input.close();
    }
}
