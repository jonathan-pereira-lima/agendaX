package app;

import javax.swing.JOptionPane;

import base.BaseDados;
import entidades.Contato;

public class Main {

	public static void main(String[] args) {
		int opcao;

		do {
			String menu = "Escolha uma opção:\n" + "1. Adicionar Contato\n" + "2. Remover Contato\n"
					+ "3. Editar Contato\n" + "4. Exibir Todos os Contatos\n" + "0. Sair";

			try {
				opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

				switch (opcao) {
				case 1:
					String nomeAdicionar = JOptionPane.showInputDialog("Digite o nome do contato:");
					String telefoneAdicionar = JOptionPane.showInputDialog("Digite o telefone do contato:");
					BaseDados.adicionar(new Contato(nomeAdicionar, telefoneAdicionar));
					break;
				case 2:
					String nomeRemover = JOptionPane.showInputDialog("Digite o nome do contato:");
					String telefoneRemover = JOptionPane.showInputDialog("Digite o telefone do contato:");
					BaseDados.remover(BaseDados.buscar(nomeRemover, telefoneRemover));
					break;
				case 3:
					String nomeOLD = JOptionPane.showInputDialog("Digite o nome do contato que deseja modificar:");
					String telefoneOLD = JOptionPane
							.showInputDialog("Digite o telefone do contato que deseja modificar:");

					String nomeNEW = JOptionPane.showInputDialog("Digite o novo nome:");
					String telefoneNEW = JOptionPane.showInputDialog("Digite o novo telefone:");

					BaseDados.editar(new Contato(nomeOLD, telefoneOLD), new Contato(nomeNEW, telefoneNEW));

					// Lógica para edição
					break;
				case 4:
					BaseDados.exibirTodosContatos();
					break;
				case 0:
					JOptionPane.showMessageDialog(null, "Saindo do programa.");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção inválida.");
					break;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Por favor, insira uma opção válida (número inteiro).");
				opcao = -1;
			}
		} while (opcao != 0);

	}

}
