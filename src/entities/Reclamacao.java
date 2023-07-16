package entities;

public class Reclamacao extends Manifestacao {

	public Reclamacao(String texto, Pessoa pessoa) {
		super(texto, pessoa);
		this.setTipo("Reclamacao");
	}

	@Override
	public String toString() {
		return "-> Tipo: " + getTipo() + "/ Reclamação: " + getTexto() + "/ Dados da " + pessoa +"";
	}
	
	
	
}
