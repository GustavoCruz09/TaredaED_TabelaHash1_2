package view;

import javax.swing.JOptionPane;

import controller.ControleAcessoCarros;

public class Principal {

	public static void main(String[] args) {
		ControleAcessoCarros ctrl = new ControleAcessoCarros();
		int opc = 0;

		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(
					"DIGITE A OPCAO DESEJADA\n 1 - Cadastrar Morador\n 2 - Consultar Pelo Numero do Ap.\n 3 - Excluir Morador\n 4 - Listar Moradores do Andar\n 9 - Finaliazar"));

			switch (opc) {
			case 1:
				ctrl.CadastraMorador();
				break;
			case 2: 
				ctrl.Consulta();
				break;
			case 3:
				ctrl.Excluir();
				break;
			case 4:
				ctrl.ListarPorAndar();
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Programa Finalizado");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcao Invalida");
				break;
			}
		} while (opc != 9);

	}

}
