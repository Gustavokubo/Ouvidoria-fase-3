package entities;

public class Sugestao extends Manifestacao {

	public Sugestao( String texto, Pessoa pessoa) {
		super(texto, pessoa);
		this.setTipo("Sugestao");
	}

	@Override
	public String toString() {
		return "-> Tipo: " + getTipo() + "/ Sugestão: " + getTexto() + "/ Dados da " + pessoa +"";
	}

	
}
