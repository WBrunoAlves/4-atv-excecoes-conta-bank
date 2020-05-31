package application;


import java.util.Locale;
import java.util.Scanner;

import model.entitites.Conta;
import model.exception.DomainException;


/*
 * Fazer um programa para ler os dados de uma conta bancária e depois realizar um
saque nesta conta bancária, mostrando o novo saldo. Um saque não pode ocorrer
ou se não houver saldo na conta, ou se o valor do saque for superior ao limite de
saque da conta. Implemente a conta bancária conforme projeto abaixo:
		Examples
		Enter account data
		Number: 8021
		Holder: Bob Brown
		Initial balance: 500.00
		Withdraw limit: 300.00
		Enter amount for withdraw: 100.00
		New balance: 400.00
		Enter account data
		Number: 8021
		Holder: Bob Brown
		Initial balance: 500.00
		Withdraw limit: 300.00
		Enter amount for withdraw: 400.00
		Withdraw error: The amount exceeds withdraw limit
		Examples
		Enter account data
		Number: 8021
		Holder: Bob Brown
		Initial balance: 500.00
		Withdraw limit: 300.00
		Enter amount for withdraw: 800.00
		Withdraw error: The amount exceeds withdraw limit
		Enter account data
		Number: 8021
		Holder: Bob Brown
		Initial balance: 200.00
		Withdraw limit: 300.00
		Enter amount for withdraw: 250.00
		Withdraw error: Not enough balance
		 * 
 * */
public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		
	try {
			Conta conta;
			System.out.println("Entre com os dados da conta:");
			System.out.println("Numero:");
			int numeroConta = sc.nextInt(); 
			System.out.println("Titular:");
			String titularConta = sc.nextLine();
			sc.next();
			System.out.println("Valor inicial da conta:");
			double valorInicial = sc.nextDouble();
			
	 		System.out.println("Limite de Saque:");
	 		double limiteSaque = sc.nextDouble();
	 		
	 		
	 		conta = new Conta(numeroConta,titularConta,valorInicial, limiteSaque);
	 		 
	 		System.out.println();
	 		System.out.println("Entre com o valor do Saque:");
	 		double montante = sc.nextDouble();
	 		
	 		conta.saque(montante);
	 		
	 		System.out.println(conta.toString());
	 		
	 		
		} 

		catch (DomainException e ) {//excecoes personalizadas 
			System.out.println("Erro: " + e.getMessage());
			
		} 
		catch (RuntimeException e) {//excessão da Runtime
			System.out.println("Caractere Invalido");
	
		}

		sc.close();

	}


}
