import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TituloDeCapitalizacao {

    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private Conta conta;
    private double contribuicao;
    

    
    public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public double getContribuicao() {
		return contribuicao;
	}

	public void setContribuicao(double contribuicao) {
		this.contribuicao = contribuicao;
	}

	//M�todo criado para a assinatura do contrato
    public void contratarInvestimento(Conta conta, double contribuicao, LocalDate dataInicial) {
        this.setConta(conta);
        this.setContribuicao(contribuicao);
        this.setDataInicial(dataInicial);
    }

    //Metodo criado para o resgate do Investimento
    //S� � permitido o resgate ap�s 12 meses do contrato
    //O montante do investimento � juros composto a 1% ao m�s
    public double resgatarInvestimento(LocalDate dataFinal) throws TempoInsuficienteException {
    	this.setDataFinal(dataFinal);
    	
    	//Pega a diferen�a entre os meses
    	long meses = getDataInicial().until(getDataFinal(), ChronoUnit.MONTHS);

        if (meses < 12) {
            throw new TempoInsuficienteException("Voc� n�o pussui tempo de contribui��o suficiente. Faltam: " + (12 - meses) + " meses para o resgate");
        }
        
        //Calculo do juros composto
        double investimento = contribuicao * Math.pow((1 + 0.1), meses);
        //Deposito do montante na conta informada no contrato
        conta.depositar(investimento);
        return investimento;
        
    }
    

}


