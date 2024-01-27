package com.projetofinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class batalhaFinalForm extends JFrame {
	
	
	public batalhaFinalForm() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("A Batalha Final");
		setSize(1000, 1000);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		
		
	
		//listmodels para fazer display das listas
		DefaultListModel<Heroi> listModelHerois = new DefaultListModel<>();
		DefaultListModel<Besta> listModelBestas = new DefaultListModel<>();
		
		//Jlist para ter onde fazer display das listas
		JList <Heroi> jListHerois = new JList<>(listModelHerois);
		JList <Besta> jListBestas = new JList<>(listModelBestas);
		
		
		
		//Listas e JScroll
		List<Heroi> listaHerois = new ArrayList<>();
		JScrollPane scrollPaneHerois = new JScrollPane(jListHerois);
		List<Besta> listaBestas = new ArrayList<>();
		JScrollPane scrollPaneBestas = new JScrollPane(jListBestas);
		
		
		
		
		//Informações dos Herois a adicionar
		JLabel nomeDoHeroi = new JLabel("Nome:");
		JTextField nomeDoHeroiInput = new JTextField(20);
		
		JLabel tipoDoHeroi = new JLabel("Tipo:");
		String[] tipoDoHeroiInput = {"Humano", "Elfo", "Hobbit"};
		JComboBox<String> tipoHeroiComboBox = new JComboBox<>(tipoDoHeroiInput);
		
		JLabel vidaDoHeroi = new JLabel("Vida:");
		JTextField vidaDoHeroiInput = new JTextField(10);
		vidaDoHeroiInput.setText("0");
		
		JLabel armaduraDoHeroi = new JLabel("Armadura:");
		JTextField armaduraDoHeroiInput = new JTextField(10);
		armaduraDoHeroiInput.setText("0");
		
		
		JButton adicionarHeroiButton = new JButton("Adicionar");
		
		
		//botao adicionar à lista de herois
		adicionarHeroiButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				String nome = nomeDoHeroiInput.getText();
				String tipo = (String) tipoHeroiComboBox.getSelectedItem();
				try{
					int vida = Integer.parseInt(vidaDoHeroiInput.getText());
					int armadura = Integer.parseInt(armaduraDoHeroiInput.getText());
					
					Heroi novoHeroi = new Heroi(nome, vida, armadura, tipo);
					listaHerois.add(novoHeroi);
					listModelHerois.addElement(novoHeroi);
					
					nomeDoHeroiInput.setText("");
					tipoHeroiComboBox.setSelectedIndex(0);
				} catch (NumberFormatException ex){
					JOptionPane.showMessageDialog(null, "Por favor insira um valor numérico para a VIDA e ARMADURA do Herói", "Input Error", JOptionPane.ERROR_MESSAGE);
				}
				
				vidaDoHeroiInput.setText("0");
				armaduraDoHeroiInput.setText("0");
			}
		});
		
		//Informações das Bestas a adicionar
		JLabel nomeDaBesta = new JLabel("Nome:");
		JTextField nomeDaBestaInput = new JTextField(20);
		
		JLabel tipoDaBesta = new JLabel("Tipo:");
		String[] tipoDaBestaInput = {"Troll", "Orque"};
		JComboBox<String> tipoBestaComboBox = new JComboBox<>(tipoDaBestaInput);
		
		JLabel vidaDaBesta = new JLabel("Vida:");
		JTextField vidaDaBestaInput = new JTextField(10);
		vidaDaBestaInput.setText("0");
		
		JLabel armaduraDaBesta = new JLabel("Armadura:");
		JTextField armaduraDaBestaInput= new JTextField(10);
		armaduraDaBestaInput.setText("0");
		
		JButton adicionarBestaButton = new JButton("Adicionar");
		
		
		
		
		//botao adicionar à lista de bestas
		
		adicionarBestaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String nome = nomeDaBestaInput.getText();
				String tipo = (String) tipoBestaComboBox.getSelectedItem();
				try{
					int vida = Integer.parseInt(vidaDaBestaInput.getText());
					int armadura = Integer.parseInt(armaduraDaBestaInput.getText());
					
					Besta novaBesta = new Besta(nome, vida, armadura, tipo);
					listaBestas.add(novaBesta);
					listModelBestas.addElement(novaBesta);
					nomeDaBestaInput.setText("");
					tipoBestaComboBox.setSelectedIndex(0);
				} catch (NumberFormatException ex){
					JOptionPane.showMessageDialog(null, "Por favor insira um valor numérico para a VIDA e ARMADURA da Besta", "Input Error", JOptionPane.ERROR_MESSAGE);
				}
				
				vidaDaBestaInput.setText("0");
				armaduraDaBestaInput.setText("0");
			}
		});
		
		
		//Panel para ver a lista de Herois e Panel para botões
		JPanel panelHerois = new JPanel(new BorderLayout());
		panelHerois.setBorder(BorderFactory.createTitledBorder("Heróis"));
		JPanel panelHeroisButtons = new JPanel();
		
		
		JButton subirHeroiButton = new JButton("Subir");
		panelHeroisButtons.add(subirHeroiButton);
		
		//subir o heroi na lista, se o index for >=1, sendo 0, nao pode subir mais
		subirHeroiButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int selectedIndex = jListHerois.getSelectedIndex();
				if (selectedIndex >= 1) {
					Heroi heroiSelecionado = listModelHerois.remove(selectedIndex);
					listModelHerois.add(selectedIndex - 1, heroiSelecionado);
					jListHerois.setSelectedIndex(selectedIndex - 1);
				}
			}
		});
		
		
		
		JButton descerHeroiButton = new JButton("Descer");
		panelHeroisButtons.add(descerHeroiButton);
		
		//descer o heroi na lista, se houver algum index maior
		descerHeroiButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = jListHerois.getSelectedIndex();
				int listSize = listModelHerois.size();
				if (selectedIndex >= 0 && selectedIndex < listSize -1) {
					Heroi heroiSelecionado = listModelHerois.remove(selectedIndex);
					listModelHerois.add(selectedIndex + 1, heroiSelecionado);
					jListHerois.setSelectedIndex(selectedIndex + 1);
				}
			}
		});
		
		JButton eliminarHeroiButton = new JButton("Eliminar");
		panelHeroisButtons.add(eliminarHeroiButton);
		
		//eliminar o heroi da lista
		eliminarHeroiButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = jListHerois.getSelectedIndex();
				listModelHerois.remove(selectedIndex);
			}
		});
		
		
		//Painel para ver a lista de Bestas e Panel para botões
		JPanel panelBestas = new JPanel(new BorderLayout());
		panelBestas.setBorder(BorderFactory.createTitledBorder("Bestas"));
		JPanel panelBestasButtons = new JPanel();
		
		
		JButton subirBestaButton = new JButton("Subir");
		panelBestasButtons.add(subirBestaButton);
		
		//subir a besta na lista, se o index for >=1, sendo 0, nao pode subir mais
		subirBestaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = jListBestas.getSelectedIndex();
				if (selectedIndex >= 1) {
					Besta bestaSelecionada = listModelBestas.remove(selectedIndex);
					listModelBestas.add(selectedIndex - 1, bestaSelecionada);
					jListBestas.setSelectedIndex(selectedIndex - 1);
				}
			}
		});
		
		
		JButton descerBestaButton = new JButton("Descer");
		panelBestasButtons.add(descerBestaButton);
		
		//descer uma besta na lista, se houver um index maior
		descerBestaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = jListBestas.getSelectedIndex();
				int listSize = listModelBestas.size();
				if (selectedIndex >= 0 && selectedIndex < listSize -1){
					Besta bestaSelecionada = listModelBestas.remove(selectedIndex);
					listModelBestas.add ( selectedIndex + 1, bestaSelecionada);
					jListBestas.setSelectedIndex(selectedIndex + 1);
				}
			}
		});
		
	
		JButton eliminarBestaButton = new JButton("Eliminar");
		panelBestasButtons.add(eliminarBestaButton);
		
		//eliminar a besta da lista
		eliminarBestaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = jListBestas.getSelectedIndex();
				listModelBestas.remove(selectedIndex);
			}
		});
		
		
		JTextArea infoTextArea = new JTextArea(50, 50); //
		infoTextArea.setEditable(false); // Impede que o texto seja editado pelo usuário
		
		JScrollPane infoLuta = new JScrollPane(infoTextArea);
		infoLuta.setPreferredSize(new Dimension(800, 300));
		
		JButton lutarButton = new JButton("Lutar");
		lutarButton.setPreferredSize(new Dimension(100, 50));
		
		lutarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ao chamar o metodo com 3 atributos, entra no correspondente ao que faz "print"
				//no Form com infoTextArea
				Luta.fight(listaHerois, listaBestas, infoTextArea);
			}
			
		});
		
		
		
		
		//--------------------------Adicionar ao JFRAME ------------------
		
		
		//Novo panelTopo, com os panels para adicionar o novo Heroi e a nova Besta
		
		
		JPanel panelTopo= new JPanel(new FlowLayout());
		
		
		//panel para adicionar herois
		JPanel addHerois = new JPanel(new GridLayout(2,1));
		panelTopo.add(addHerois);
		
		
		//Panel para escrever as infos do novo heroi
		JPanel novoHeroi = new JPanel(new GridLayout(4, 2));
		novoHeroi.setBorder(BorderFactory.createTitledBorder("Heróis"));
		
		
		//adicionar tudo ao painel envolvente (novoHeroi)
		novoHeroi.add(nomeDoHeroi);
		novoHeroi.add(nomeDoHeroiInput);
		novoHeroi.add(tipoDoHeroi);
		novoHeroi.add(tipoHeroiComboBox);
		novoHeroi.add(vidaDoHeroi);
		novoHeroi.add(vidaDoHeroiInput);
		novoHeroi.add(armaduraDoHeroi);
		novoHeroi.add(armaduraDoHeroiInput);
		
		//adicionar o botao
		JPanel adicionarHeroisButtonPanel = new  JPanel(new FlowLayout());
		adicionarHeroisButtonPanel.add(adicionarHeroiButton);
		
		addHerois.add(novoHeroi);
		addHerois.add(adicionarHeroisButtonPanel);
		
		
		
		//--------------------//
		
		
		//panel para adicionar bestas
		JPanel addBesta = new JPanel(new GridLayout(2,1));
		panelTopo.add(addBesta);
		
		//Panel para escrever as infos do novo heroi
		
		JPanel novaBesta = new JPanel(new GridLayout(4, 2));
		novaBesta.setBorder(BorderFactory.createTitledBorder("Bestas"));
		
		
		//adicionar tudo ao panel envolvente (novaBesta)
		novaBesta.add(nomeDaBesta);
		novaBesta.add(nomeDaBestaInput);
		novaBesta.add(tipoDaBesta);
		novaBesta.add(tipoBestaComboBox);
		novaBesta.add(vidaDaBesta);
		novaBesta.add(vidaDaBestaInput);
		novaBesta.add(armaduraDaBesta);
		novaBesta.add(armaduraDaBestaInput);
		
		//adicionar o botao
		JPanel adicionarBestasButtonPanel = new  JPanel();
		adicionarBestasButtonPanel.add(adicionarBestaButton);
		
		
		addBesta.add(novaBesta);
		addBesta.add(adicionarBestasButtonPanel);
		
		
		//----------------------------Termina Painel do Topo-----------------------//
		
		//----------------------------Inicia Painel de Baixo -----------------------//
		
		
		panelHerois.add(scrollPaneHerois, BorderLayout.NORTH);
		panelHerois.add(panelHeroisButtons, BorderLayout.SOUTH);
		
		panelBestas.add(scrollPaneBestas, BorderLayout.NORTH);
		panelBestas.add(panelBestasButtons, BorderLayout.SOUTH);
		
		//panel que contem as listas e botões associados
		JPanel panelListas = new JPanel (new GridLayout(1,2));
		panelListas.add(panelHerois);
		panelListas.add(panelBestas);
		
		//botão lutar colocado no seu panel para poder adquirir as caracteristicas
		// descritas quando criado (PreferredSize)
		JPanel panelButton = new JPanel();
		panelButton.add(lutarButton);
		
		
		JPanel panelLuta = new JPanel(new BorderLayout());
		panelLuta.add(panelButton, BorderLayout.NORTH);
		panelLuta.add(infoLuta, BorderLayout.SOUTH);
		
		
		// JPanel com as listas e o panel com as informaçoes da luta
		JPanel panelBaixo = new JPanel(new BorderLayout());
		panelBaixo.setBorder(BorderFactory.createTitledBorder("Luta"));
		panelBaixo.add(panelListas, BorderLayout.NORTH);
		panelBaixo.add(panelLuta, BorderLayout.SOUTH);
		
		//adicionar todos os paineis ao JFrame
		getContentPane().add(panelTopo, BorderLayout.NORTH);
		getContentPane().add(panelBaixo, BorderLayout.SOUTH);
		
		
		Color antiflashWhite = new Color(239, 241, 243);
		getContentPane().setBackground( antiflashWhite);
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new batalhaFinalForm().setVisible(true);
			
		});
	}
}
