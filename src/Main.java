public class Main {
    public static void main(String[] args) {
        Cliente joao = new Cliente("Joãozinho", "123456789-00");
		
		Conta corrente = new ContaCorrente(joao);
		Conta poupanca = new ContaPoupanca(joao);

		corrente.depositar(100);
		corrente.transferir(80, poupanca);
		
		corrente.imprimirExtrato();
		poupanca.imprimirExtrato();
    }
}
