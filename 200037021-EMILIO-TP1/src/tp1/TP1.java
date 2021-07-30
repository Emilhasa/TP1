package tp1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TP1 {
	
	static Scanner input = new Scanner(System.in);
	static ArrayList<User> users = new ArrayList<>();
	static ArrayList<Product> products = new ArrayList<>();
	
	public static void main(String[] args) {
		loadData();
		
		boolean n = true;
		
		do {
			switch (menu()) {
				case 1:
					registerUsers();
					break;
				case 2:
					searchUsers();
					break;
				case 3:
					registerProduct();
					break;
				case 4:
					searchProducts();
					break;
				case 5:
					registerSell();
					break;
				case 6:
					stockList();
					break;
				case 7:
					System.out.println("Programa encerrado.");
					n = false;
					break;
				default:
					break;
			}
		} while(n);
	}
	
	
	static int menu(){
		System.out.println("	\nMenu de Opções\n");
		System.out.println("1. Cadastro de novo cliente.");
		System.out.println("2. Busca por cliente.");
		System.out.println("3. Cadastro de novo produto.");
		System.out.println("4. Busca por produto.");
		System.out.println("5. Cadastro de venda.");
		System.out.println("6. Mostrar produtos em estoque.");
		System.out.println("7. Sair");
		System.out.print("Digite uma opção: ");
		int option = input.nextInt();
		
		return option;		
	}
	
	static void registerUsers() {
		int i = 0, x = 1;
		
		System.out.println("\n\nBem vindo ao sistema de cadastro de clientes\n");
		System.out.print("Insira a quantidade de clientes: ");
		int qtyUsers = input.nextInt();
		
		while (i < qtyUsers) {
			System.out.println("\nCliente " + x);
			System.out.print("Nome: ");
			input.nextLine();
			String name = input.nextLine();
			System.out.print("Endereço: ");
			//input.nextLine();
			String address = input.nextLine();
			System.out.print("Telefone: ");
			String telephone = input.next();
			
			users.add(new User(name, address, telephone));
			System.out.println("CLIENTE CADASTRADO COM SUCESSO!!");
			
			i++;
			x++;
		} 
	}
	
	static void searchUsers() {
		boolean result = true;
		char a = 0;
		int i;
		
		System.out.println("\n\nBem vindo ao sistema de busca de clientes\n");
		System.out.print("Insira o nome do cliente para busca: ");
		input.nextLine();
		String user1 = input.nextLine().toUpperCase();
		
		for (i = 0; i < users.size(); i++) {
			String user2 = users.get(i).getName();
			boolean compare = user1.equals(user2);
			
			if (compare) {
				System.out.println("	\nDados do cliente\n");
				
				users.get(i).data();
				System.out.print("Deseja alterar os dados do cliente(S/N) ? ");
				a = input.next().charAt(0);
				
				result = false;
				break;
			}
		}
		
		if (a == 'S' || a =='s') {
			System.out.print("\nInsira o nome do cliente: ");
			input.nextLine();
			String name = input.nextLine();
			System.out.print("Insira o endereço do cliente: ");
			String address = input.nextLine();
			System.out.print("Insira o telefone do cliente: ");
			String telephone = input.next();
			
			users.set(i, new User(name, address, telephone));
			System.out.println("	\nALTERAÇÃO REALIZADA COM SUCESSO");
		}
		
		if (result) System.out.println("\nCliente não encontrado!");	
	}
	
	static void registerProduct() {
		int i = 0, x = 1;
		
		System.out.println("\n\nBem vindo ao sistema de cadastro de produtos\n");
		System.out.print("Insira a quantidade de produtos: ");
		int qtyProducts = input.nextInt();

		while (i < qtyProducts) {
			System.out.println("\nProduto " + x);
			System.out.print("Nome: ");
			input.nextLine();
			String name = input.nextLine();
			System.out.print("Descrição: ");
			//input.nextLine();
			String description = input.nextLine();
			System.out.print("Valor: ");
			double vBuy = input.nextDouble();
			System.out.print("Porcentagem de lucro: ");
			double pct = input.nextInt();
			System.out.print("Quantidade em estoque: ");
			double qtyStock = input.nextDouble();
			
			products.add(new Product(name, description, vBuy, pct, qtyStock));
			System.out.println("	\nPRODUTO CADASTRADO COM SUCESSO!!\n");
			i++;
			x++;
		}
	}
	
	static void searchProducts() {
		boolean result = true;
		char a = 0;
		int i;
		
		System.out.println("\n\nBem vindo ao sistema de busca de produtos\n");
		System.out.print("Insira o nome do produto para busca: ");
		input.nextLine();
		String product1 = input.nextLine().toUpperCase();
		
		for (i = 0; i < products.size(); i++) {
			String product2 = products.get(i).getName();
			boolean compare = product1.equals(product2);
			
			if (compare) {
				System.out.println("	\nDados do produto\n");
				
				products.get(i).data();
				System.out.print("Deseja alterar os dados do produto(S/N) ? ");
				a = input.next().charAt(0);
				result = false;
				break;
			}
		}
		
		if (a == 'S' || a =='s') {
			System.out.print("\nInsira o nome do produto: ");
			input.nextLine();
			String name = input.nextLine();
			System.out.print("Insira a descrição do produto: ");
			String description = input.nextLine();
			System.out.print("Insira o valor de compra do produto: ");
			double vBuy = input.nextDouble();
			System.out.print("Insira a porcentagem de lucro do produto: ");
			double pct = input.nextInt();
			System.out.print("Insira a quantidade do produto em estoque: ");
			double stock = input.nextDouble();
			
			products.set(i, new Product(name, description, vBuy, pct, stock));
			System.out.println("	\nALTERAÇÃO REALIZADA COM SUCESSO");
		}
		
		if (result) System.out.println("Produto não encontrado!");
	}
	
	static void registerSell() {
		boolean option;
		
		System.out.println("\n\nBem vindo ao sistema de cadastro de venda\n");
		System.out.println("\tLista de clientes\n");
		
		for (int i = 0; i < users.size(); i++) {
			System.out.println(i + "." + users.get(i).getName());
		}
		
		System.out.print("\nSelecione um dos clientes: ");
		int idUser = input.nextInt();
		System.out.println("\n\tLista de produtos\n");
		
		for (int i = 0; i < products.size(); i++) {
			System.out.println(i + "." + products.get(i).getName());
		}
		
		do {
		option = true;
		
		System.out.print("\nSelecione um dos produtos: ");
		int idProduct = input.nextInt();
		System.out.print("Qual a quantidade de " + products.get(idProduct).getName() + " foi vendida para " + users.get(idUser).getName() + ": ");
		double qtySell = input.nextDouble();
		
		products.get(idProduct).decreaseStock(qtySell);
		System.out.print("Deseja cadastrar novas vendas para o cliente " + users.get(idUser).getName() + " ?(S/N) ");
		char op = input.next().charAt(0);
		if (op == 'N' || op == 'n') option = false;
		} while(option);	
		
		System.out.println("Venda cadastrada com sucesso");
	}
	
	static void stockList() {
		System.out.println("\n\tLista de Produtos\n");
		System.out.println("Produto, estoque");
		
		for (int i = 0; i < products.size(); i++) {
			System.out.println(i + "." + products.get(i).getName() + ", " + products.get(i).getQtyStock());
		}
	}
	
	static void loadData() {
		Random random = new Random();
		
		for (int i = 0; i < 10; i++) {
			String name = "Shaolin Matador de Porco " + i;
			String address = "Onde judas perdeu as botas " + i;
			String telephone = "4002-8922";
			
			users.add(new User(name, address, telephone));
		}
		
		for (int i = 0; i < 10; i++) {
			String name = "Produto " + i;
			String description = "Descrição " + i;
			
			double vBuy = random.nextDouble()*100;
			double pct = random.nextDouble()*100;
			double qtyStock = random.nextDouble()*1000;
			
			products.add(new Product(name, description, vBuy, pct, qtyStock));
		}
	}
	
	
}
