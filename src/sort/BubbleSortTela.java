package sort;


import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * <h1>Constrói e torna visível uma GUI para aprendizado de Bubble Sort de forma lúdica<h1>
 * 
 * @author Dahan Shuster
 */
@SuppressWarnings("serial")
public class BubbleSortTela extends JFrame {
	
	public BubbleSortTela() {
		listaDescricoesDasEtapas = new ArrayList<>();
	}
	
	private JPanel contentPane;
	private JPanel quadroOutputs;
	private JPanel quadroInput;
	
	private JTextField inputArrayList;
	private JButton botaoEnviar;
	private JLabel abreColchetes, fechaColchetes;
	
	private List listaEtapas;
	private JLabel textoDescricao;
	private JLabel textoOutput;
	
	ArrayList<String> listaDescricoesDasEtapas;
	
	private void processarInput(ArrayList<Integer> arrayList) {
		if (arrayList != null) {
			listaEtapas.setForeground(Color.BLACK);
			chamarMetodoBubble(arrayList);
		} else {
			listaEtapas.removeAll();
			listaEtapas.setForeground(Color.RED);
			listaEtapas.add("ArrayList inválido.");
		}
		
		
	}
	
	

	private void chamarMetodoBubble(ArrayList<Integer> arrayList) {
			ArrayList<String> etapas = Sort.bubbleVerboso(arrayList);mostrarResultados(etapas);
	}
	
	private void mostrarResultados(ArrayList<String> etapas) {
		listaEtapas.removeAll();
		listaDescricoesDasEtapas.clear();
		for (String etapa : etapas) {
			String[] textosEtapa = etapa.split(";");
			listaEtapas.add(textosEtapa[0]);
			listaDescricoesDasEtapas.add(textosEtapa[1]);
		}
		
	}

 	public void montarTela() {
		// Configurando aparência da tela
		this.setSize(450, 450);

		// Configurando comportamento da tela
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Configurando componentes
		
		configurarContentPane();
		configurarQuadroInputs();
		configurarQuadroOutputs();
		
	}

	private void configurarContentPane() {
		contentPane = new JPanel(null);
		this.setContentPane(contentPane);
		
	}
	
	private void configurarQuadroInputs() {
		quadroInput = new JPanel();
		quadroInput.setLayout(new FlowLayout());
		quadroInput.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		quadroInput.setBounds(25, 10, 400, 80);
		quadroInput.setBackground(new Color(230, 230, 230));
		quadroInput.setBorder(new TitledBorder(new LineBorder(null),  "Input de dados"));

		configurarColcheteEsquerdo();
		configurarTextFieldInput();
		configurarColcheteDireito();
		configurarBotaoEnviar();
		
		contentPane.add(quadroInput);
		
	}

	private void configurarColcheteEsquerdo() {
		abreColchetes = new JLabel("[");
		 quadroInput.add(abreColchetes);
		
	}

	private void configurarTextFieldInput() {
		inputArrayList = new JTextField();
		inputArrayList.setColumns(20);
		
		inputArrayList.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent k) {
				if (k.getKeyCode() == KeyEvent.VK_ENTER)
					botaoEnviar.doClick();
				else if (k.getKeyCode() == KeyEvent.VK_DOWN)
					listaEtapas.requestFocus();;
			}
		
		});
		
		quadroInput.add(inputArrayList);
		
	}
	
	private void configurarColcheteDireito() {
		fechaColchetes = new JLabel("]");
		 quadroInput.add(fechaColchetes);
		
	}

	private void configurarBotaoEnviar() {
		botaoEnviar = new JButton("Bubble!");
		botaoEnviar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> arrayList = transformarInputEmArrayList();
				BubbleSortTela.this.processarInput(arrayList);
				
			}

			private ArrayList<Integer> transformarInputEmArrayList() {
				ArrayList<Integer> output = new ArrayList<>();
				String[] numeros = inputArrayList.getText().split("\\,");
				for (String numero : numeros) {
					try {
						output.add(Integer.parseInt(numero.trim()));
					} catch (NumberFormatException ex) {
						return null;
					}
				}
				return output;
			}
		});
		quadroInput.add(botaoEnviar);
	}

	private void configurarQuadroOutputs() {
		quadroOutputs = new JPanel(null);
		quadroOutputs.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		quadroOutputs.setBounds(25, 100, 400, 300);
		quadroOutputs.setBackground(new Color(230,230,230));
		quadroOutputs.setBorder(new TitledBorder(new LineBorder(null),  "Etapas realizadas + Output"));
		
		configurarListaEtapas();
		configurarDescricao();
		configurarTextFieldOutput();
		
		contentPane.add(quadroOutputs);
		
	}

	private void configurarListaEtapas() {
		listaEtapas = new List();
		listaEtapas.setBounds(10, 25, 230, 200); 
		
		listaEtapas.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				textoDescricao.setText(listaDescricoesDasEtapas.get(listaEtapas.getSelectedIndex()));
				
			}
		});
		
		listaEtapas.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent k) {
				if (k.getKeyCode() == KeyEvent.VK_UP)
					inputArrayList.requestFocus();;
			}
		
		});
		
		quadroOutputs.add(listaEtapas);
	}

	private void configurarDescricao() {
		textoDescricao = new JLabel("<html>Clique em uma etapa para ver sua descrição.</html>");
		textoDescricao.setBounds(250, 75, 140, 100);
		
		quadroOutputs.add(textoDescricao);
	}
	
	private void configurarTextFieldOutput() {
		textoOutput = new JLabel("<html>Preencha o campo de texto com uma lista de inteiros separados por vírgula e clique em 'enviar'</html>");
		textoOutput.setBounds(10, 235, 400, 40);
		
		quadroOutputs.add(textoOutput);
	}

	
	public void mostrarTela() {
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
}
