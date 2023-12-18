package mensagem;

import javax.swing.JOptionPane;

public class Mensagem {

	public static final String ADDSUCESSO = "Contato Adicionado com Sucesso";
	public static final String ADDERRO = "Erro ao adicionar!";
	public static final String EDITSUCESSO = "contato atualizado com sucesso";
	public static final String EDITERRO = "Erro ao atualizar";
	public static final String REMOVSUCESSO = "removido com sucesso";
	public static final String ERROREMOVE = "Erro Contato inexistente";
	public static final String VAZIO = "Erro Campo Vazio!";

	public static void exibirMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
}
