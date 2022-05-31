import java.time.LocalDate;

public class Main {

	public static void main(String[] args) throws SaldoInsuficienteException, TempoInsuficienteException {

		Cliente danilo = new Cliente("Danilo Arruda", "333222555-89");
		
		Conta cc = new ContaCorrente(danilo);
		Conta poupanca = new ContaPoupanca(danilo);

		cc.depositar(200);
		cc.transferir(100, poupanca);

		cc.imprimirExtrato();
		poupanca.imprimirExtrato();

		//Adicionando titulo de capitalizacao
		TituloDeCapitalizacao t1 = new TituloDeCapitalizacao();
		t1.contratarInvestimento(poupanca, 200.00, LocalDate.parse("2022-03-25"));
		t1.resgatarInvestimento(LocalDate.parse("2022-06-15"));
		
		poupanca.imprimirExtrato();

	}

}
