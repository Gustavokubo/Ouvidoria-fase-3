package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Manifestacao {

	Pessoa pessoa;
	private String texto;
	private String tipo;

	public Manifestacao(String texto, Pessoa pessoa) {
		this.texto = texto;
		this.pessoa = pessoa;
	}

	// Método para inserir manifestações no banco de dados MySQL.
	public void inserirManifestacao(Connection con) {
		String sql = "insert into manifestacoes (tipo, texto, pessoa_ID) values (?, ?, ?)";
		try {
			PreparedStatement s = con.prepareStatement(sql);
			s.setString(1, tipo);
			s.setString(2, texto);
			s.setInt(3, this.pessoa.getPessoaID(con));
			s.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Método para listar manifestações cadastradas.
	public static void listarManifestacao(Connection con) {
	    String sql = "SELECT * FROM manifestacoes";
	    try {
	        PreparedStatement s = con.prepareStatement(sql);
	        ResultSet resultado = s.executeQuery();

	        if (!resultado.isBeforeFirst()) {
	            System.out.println("Não consta manifestação na base de dados.");
	        } else {
	            while (resultado.next()) {
	                System.out.printf("ID: %d, tipo: %s, texto: %s, %s%n", resultado.getInt("ID"),
	                        resultado.getString("tipo"), resultado.getString("texto"),
	                        Pessoa.listarPessoabyID(con, resultado.getInt("pessoa_ID")));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	//Método para deletar manifestações por tipo e todas.
	public static void deletarmanifestacao(Connection con, int id) {

		Scanner sc = new Scanner(System.in);
		id = sc.nextInt();
		String sql;
		if (id == 0) {
			sql = "truncate manifestacoes";
		} else {
			sql = "delete from manifestacoes where id = " + id;
		}
		
		try {
			Statement s = con.createStatement();
			int rowsAffected = s.executeUpdate(sql);
			if (rowsAffected >= 0) {
				System.out.println("Manifestação deletada com sucesso!");
			} else {
				System.out.println("Não existem manifestações para deletar!");
			}

		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao deletar a manifestação!");
			e.printStackTrace();
			sc.close();
		}
		
		
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	}
