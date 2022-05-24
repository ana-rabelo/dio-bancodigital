public class Conta implements IConta{

    private static final int AGENCIA = 1000;
    private static int CONTA_SEQ = 1000;

    protected int agencia;
    protected int numero;   
    protected double saldo;
    protected Cliente cliente;


    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA;
        this.numero = CONTA_SEQ++;
        this.saldo = 0;
        this.cliente = cliente;
    }


    @Override
    public void sacar(double valor) {
        if (valor > saldo) throw new RuntimeException("Saldo insuficiente para realizar essa transação.\n."); else saldo -= valor;    
    }

    @Override
    public void depositar(double valor) {
        saldo += valor * 0.95;        
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor); 
    }

    public void imprimirInfosComuns() {
        System.out.printf("Titular: %s\tCPF: %s\n", cliente.getNome(), cliente.getCpf());
        System.out.printf("Agência: %d\n", agencia);
        System.out.printf("Número da Conta: %d\n", numero);
        System.out.printf("Saldo da conta: %.2f\n", saldo);
    }


    @Override
    public void imprimirExtrato() {
        imprimirInfosComuns();        
    }
}
