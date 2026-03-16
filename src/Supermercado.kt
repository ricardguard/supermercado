import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    
    // Listas para armazenar nomes e preços dos produtos
    val listaProdutos = mutableListOf<String>()
    val listaPrecos = mutableListOf<Double>()
    
    var opcao: Int
    
    // Usando Do-While para manter o menu ativo até o usuário sair
    do {
        println("\n--- 🛒 LISTA DE SUPERMERCADO ---")
        println("1. Adicionar Mercadoria")
        println("2. Remover Mercadoria")
        println("3. Alterar Preço")
        println("4. Ver Lista Completa")
        println("5. Sair")
        print("Escolha uma opção: ")
        
        opcao = try {
            scanner.nextInt()
        } catch (e: Exception) {
            scanner.next() // Limpa o buffer
            -1
        }
        
        // Usando When para tratar as opções do menu
        when (opcao) {
            1 -> {
                print("Nome do produto: ")
                val nome = scanner.next()
                print("Preço do produto: ")
                val preco = try { scanner.nextDouble() } catch (e: Exception) { 0.0 }
                
                listaProdutos.add(nome)
                listaPrecos.add(preco)
                println("[+] Produto adicionado com sucesso!")
            }
            
            2 -> {
                if (listaProdutos.isEmpty()) {
                    println("A lista está vazia!")
                } else {
                    println("Produtos disponíveis:")
                    for (i in 0 until listaProdutos.size) {
                        println("$i - ${listaProdutos[i]}")
                    }
                    print("Digite o índice do produto para remover: ")
                    val index = scanner.nextInt()
                    
                    if (index in 0 until listaProdutos.size) {
                        listaProdutos.removeAt(index)
                        listaPrecos.removeAt(index)
                        println("[-] Produto removido.")
                    } else {
                        println("Índice inválido!")
                    }
                }
            }
            
            3 -> {
                if (listaProdutos.isEmpty()) {
                    println("A lista está vazia!")
                } else {
                    println("Produtos disponíveis:")
                    for (i in 0 until listaProdutos.size) {
                        println("$i - ${listaProdutos[i]} (R$ ${listaPrecos[i]})")
                    }
                    print("Digite o índice do produto para alterar o preço: ")
                    val index = scanner.nextInt()
                    
                    if (index in 0 until listaProdutos.size) {
                        print("Novo preço: ")
                        val novoPreco = scanner.nextDouble()
                        listaPrecos[index] = novoPreco
                        println("[*] Preço alterado com sucesso!")
                    } else {
                        println("Índice inválido!")
                    }
                }
            }
            
            4 -> {
                if (listaProdutos.isEmpty()) {
                    println("\nSua lista está vazia no momento.")
                } else {
                    println("\n--- ITENS NA LISTA ---")
                    var total = 0.0
                    // Usando For para percorrer os índices
                    for (i in 0 until listaProdutos.size) {
                        println("${i + 1}. ${listaProdutos[i]} - R$ ${listaPrecos[i]}")
                        total += listaPrecos[i]
                    }
                    println("----------------------")
                    println("Valor Total: R$ $total")
                }
            }
            
            5 -> println("Saindo do programa... Até logo!")
            
            else -> println("Opção inválida! Tente novamente.")
        }
        
    } while (opcao != 5)
}
