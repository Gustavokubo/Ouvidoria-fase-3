package entities;

public class Elogio extends Manifestacao{
	
	
	public Elogio(String texto, Pessoa pessoa) {
		super(texto, pessoa);
		this.setTipo("Elogio");
	}

	@Override
	public String toString() {
		return "-> Tipo: " + getTipo() + "/ Elogio: " + getTexto() + "/ Dados da " + pessoa +"";
	}
	
}
