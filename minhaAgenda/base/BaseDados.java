package base;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import entidades.Contato;
import mensagem.Mensagem;

public class BaseDados {
	private static ArrayList<Contato> listaContatos = new ArrayList<Contato>();

//		adicionar,editar,remover e buscar
//		metodos static
//		nao agendar contato ja existente
//		so remover contato existente
//		so editar contato existente
//		buscar a partir do nome/telefone
	// deve haver reaproveitamento de código
//		exibir mensagem

	public static boolean isContato(Contato contato) {
		return listaContatos.contains(buscar(contato.getNome(), contato.getTelefone()));
	}

	// nomeAdicionar != null && telefoneAdicionar != null &&
	// !nomeAdicionar.isEmpty() && !telefoneAdicionar.isEmpty())

	public static boolean adicionar(Contato contato) {
		if (isContato(contato) == false && contato.getNome() != null && contato.getTelefone() != null && !contato.getNome().isEmpty()
				&& !contato.getTelefone().isEmpty()) {
			listaContatos.add(contato);
			Mensagem.exibirMensagem(Mensagem.ADDSUCESSO);
		} else
			Mensagem.exibirMensagem(Mensagem.ADDERRO);
		return false;
	}

	public static boolean remover(Contato contato) {
		if (contato == null) {
			Mensagem.exibirMensagem(Mensagem.VAZIO);
			return false;
		}
		if (isContato(contato) == true) {
			Mensagem.exibirMensagem(Mensagem.REMOVSUCESSO);
			return listaContatos.remove(contato);
		}
		if (!isContato(contato) == true) {
			Mensagem.exibirMensagem(Mensagem.ERROREMOVE);
		}
		return false;

	}

	public static boolean editar(Contato contatoOld, Contato contatoNew) {
		if (contatoOld == null || contatoNew == null)
			return false;
		if (contatoOld == contatoNew)
			return false;

		if (listaContatos.contains(contatoOld)) {
			int index = listaContatos.indexOf(contatoOld);
			listaContatos.set(index, contatoNew);
			Mensagem.exibirMensagem(Mensagem.EDITSUCESSO);
			return true;

		}
		Mensagem.exibirMensagem(Mensagem.EDITERRO);
		return false;
	}

	public static Contato buscar(String nome, String telefone) {
		if (nome == null && telefone == null)
			return null;

		for (Contato contatoCurrent : listaContatos) {
			if (contatoCurrent.getNome().equals(nome) && contatoCurrent.getTelefone().equals(telefone))
				return contatoCurrent;
		}
		return null;

	}

	public static void exibirTodosContatos() {
		StringBuilder htmlTable = new StringBuilder(
				"<html><table border='1'>" + "<tr><th>Nome</th><th>Telefone</th></tr>");

		for (Contato contato : listaContatos) {
			htmlTable.append("<tr><td>").append(contato.getNome()).append("</td><td>").append(contato.getTelefone())
					.append("</td></tr>");
		}

		htmlTable.append("</table></html>");

		JOptionPane.showMessageDialog(null, htmlTable.toString(), "Lista de Contatos", JOptionPane.PLAIN_MESSAGE);
	}

}
