package controller;

import javax.swing.JOptionPane;

import GustavoCruz.ListaSObject.Lista;
import model.morador;

public class ControleAcessoCarros {

	Lista[] vtlista = new Lista[10];

	public ControleAcessoCarros() {
		for (int i = 0; i < 10; i++) {
			vtlista[i] = new Lista();
		}
	}

	public void CadastraMorador() {
		morador m = new morador();

		m.setNome(JOptionPane.showInputDialog("Digite o nome do morador"));
		int ap = 0;
		do {
			ap = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do ap até 1099"));
		} while (ap > 1099 || ap < 100 );
		m.setNumap(ap);
		m.setModelo(JOptionPane.showInputDialog("Digite o modelo do Carro"));
		m.setCor(JOptionPane.showInputDialog("Digite a cor do Carro"));
		m.setPlaca(JOptionPane.showInputDialog("Digite a placa do carro"));

		TabelaEspalhamento(m);
	}

	private void TabelaEspalhamento(morador m) {
		int hash = HashCode(m.getNumap());
		if (vtlista[hash].isEmpty()) {
			vtlista[hash].addFirst(m);
		} else {
			try {
				vtlista[hash].addLast(m);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private int HashCode(int numap) {
		String n = Integer.toString(numap);
		int tam = n.length();
		int pos = 0;
		if (tam < 4) {
			String primeiro = n.substring(0, 1);
			int um = Integer.parseInt(primeiro);
			pos = um - 1;
		} else {
			String primeiros = n.substring(0, 2);
			int dois = Integer.parseInt(primeiros);
			pos = dois - 1;
		}

		return pos;
	}

	public void Consulta() {
		int numap = 0;
		do {
			numap = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do apartamento a ser consultado"));
		} while (numap > 1099);
		int hashcode = HashCode(numap);
		int tam = vtlista[hashcode].size();
		for(int i = 0; i < tam; i++) {
			try {
				morador m = (morador) vtlista[hashcode].get(i);
				if(m.getNumap() == numap) {
					System.out.println(m);
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void Excluir() {
		int numap = 0;
		do {
			numap = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do apartamento a ser excluido"));
		} while (numap > 1099);
		int hashcode = HashCode(numap);
		int tam = vtlista[hashcode].size();
		for(int i = 0; i < tam; i++) {
			try {
				morador m = (morador) vtlista[hashcode].get(i);
				if(m.getNumap()==numap) {
				vtlista[hashcode].remove(i);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void ListarPorAndar() {
		int numandar = 0;
		do {
			numandar = Integer.parseInt(JOptionPane.showInputDialog("Digite o andar a ser consultado (até 10 andares)"));
		} while(numandar < 1 || numandar > 10);
		int tam = vtlista[numandar - 1].size();
		System.out.println("Lista dos moradores do " + numandar + "° andar" );
		for(int i = 0; i < tam; i++) {
			morador m = new morador();
			try {
				m = (morador) vtlista[numandar - 1].get(i);
				System.out.println(m);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
