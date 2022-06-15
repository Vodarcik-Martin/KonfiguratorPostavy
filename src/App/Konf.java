package App;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.JTextArea; 
import javax.swing.ButtonGroup;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class Konf extends JFrame {

	   private JPanel contentPane;
	   private JPanel card;
	   private JPanel panel1, panel3;
	   private JPanel panel2;
	   private CardLayout cards;
	   private JButton btnMuz;
	   private JPanel panel4;
	   private JPanel panel5;
	   private JPanel panel6;
	   private JTextField tfVahaZ;
	   private JTextField tfVyskaZ;
	   private JTextField tfVyskaM;
	   private JTextField tfVahaM;
	   private JButton btnZena;
	   private JButton btnZenaT1;
	   private JButton btnZenaT2;
	   private JButton btnZenaT3;
	   private JButton btnZenaT4;
	   private JButton btnPokracovatZ;
	   private JRadioButton rdbtnPribrat_1;
	   private JRadioButton rdbtnChudnut_1;
	   private JButton btnPokracovatM;
	   private JButton btnMuzT1;
	   private JButton btnMuzT2;
	   private JButton btnMuzT3;
	   private JButton btnMuzT4;
	   private JRadioButton rdbtnChudnut;
	   private JRadioButton rdbtnPribrat;
	   private JButton btnPotvrdit;
	   private JButton btnPotvrdit_1;
	   private JTextArea taOdporucanie;
	   private JTextArea taBMI;
	   private JTextArea taBMI_1;
	   private JTextArea taOdporucanie_1;
	   private final ButtonGroup buttonGroup = new ButtonGroup();
	   private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	   private JLabel lblCielovaVaha;
	   private JTextField tfCielZ;
	   private JTextField tfCielM;
	   private JLabel lblCielovaVaha_1;
	   private JSlider slider;
	   private JSpinner spinner;
	   private int btn=0;
	   private JButton btnVysledok;
	
	   public static void main(String[] args) {
	   	try {
	   		UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
	   	} catch (Throwable e) {
	   		e.printStackTrace();
	   	}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Konf frame = new Konf();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Konf() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Konf.class.getResource("/Icon/icons8_weightlifting_25px.png")));
		setTitle("Konfigurátor postavy");
		
		initComponents();
		createEvents();
		
		
	}

	private void createEvents() {
		
		 
		   
		   
		btnZena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cards.next(card);
			}
		});
		
		btnMuz.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				cards.previous(card);
			}

		});
		
		btnZenaT1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				cards.next(card);
				btn=1;
			}
		});
		
		btnZenaT2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cards.next(card);
				btn=2;
			}
		});
		
		btnZenaT3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cards.next(card);
				btn=3;
			}
		});
		
		btnZenaT4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cards.next(card);
				btn=4;
			}
		});
		
		btnMuzT1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cards.previous(card);
				btn=1;
			}
		});
		
		btnMuzT2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cards.previous(card);
				btn=2;
			}
		});
		
		btnMuzT3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cards.previous(card);
				btn=3;
			}
		});
		
		btnMuzT4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cards.previous(card);
				btn=4;
			}
		});
		
		btnPotvrdit.addActionListener(new ActionListener() {
			
			
				public void actionPerformed(ActionEvent e) {
					try {
					double vyska= Integer.parseInt(tfVyskaZ.getText());
					int vaha= Integer.parseInt(tfVahaZ.getText());
							vyska= vyska/ 100;
					double vysledok = vaha/ (vyska*vyska);
					String vypis= " "+ vysledok;
					taBMI.setText(vypis);
					
					if(vysledok < 18.5) {
						taOdporucanie.setText("podvýživa, odporúčame pribrať");
					
					}else if(vysledok > 18.5 && vysledok < 25) {
						taOdporucanie.setText("ideálna váha");						
					
					}else if(vysledok > 25 && vysledok < 30) {
						taOdporucanie.setText("mierna nadváha, odporúčame schudnúť");
					
					}else {
						taOdporucanie.setText("obezita, odporúčame schudnúť");
					}
					}catch(ArithmeticException ae) {
						ae.getMessage();
						taBMI.setText("Chyba skus znova");
					}
					
					catch (InputMismatchException im) {
						im.getMessage();
						taBMI.setText("Chyba skus znova");
					}catch(Exception ex) {
						ex.getMessage();
						taBMI.setText("Chyba skus znova");
					}
				
				
			}
		});
		
		btnPotvrdit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				
				double vyska= Integer.parseInt(tfVyskaM.getText());
				int vaha= Integer.parseInt(tfVahaM.getText());
						vyska= vyska/ 100;
				double vysledok = vaha/ (vyska*vyska);
				String vypis= " "+ vysledok;
				taBMI_1.setText(vypis);
				
				if(vysledok < 18.5) {
					taOdporucanie_1.setText("podvýživa, odporúčame pribrať");
				
				}else if(vysledok > 18.5 && vysledok < 25) {
					taOdporucanie_1.setText("ideálna váha");						
				
				}else if(vysledok > 25 && vysledok < 30) {
					taOdporucanie_1.setText("mierna nadváha, odporúčame schudnúť");
				
				}else {
					taOdporucanie_1.setText("obezita, odporúčame schudnúť");
				}
				}catch(ArithmeticException ae) {
					ae.getMessage();
					taBMI_1.setText("Chyba skus znova");
				}
				
				catch (InputMismatchException im) {
					im.getMessage();
					taBMI_1.setText("Chyba skus znova");
				}catch(Exception ex) {
					ex.getMessage();
					taBMI_1.setText("Chyba skus znova");
				}
				
			}
		});
		
		btnPokracovatZ.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				try {
				int vyska= Integer.parseInt(tfVyskaZ.getText());
				int vaha= Integer.parseInt(tfVahaZ.getText());
				int cielZ= Integer.parseInt(tfCielZ.getText());
				if(vyska != 0 && vaha != 0 && cielZ != 0) {
					cards.next(card);
				}else JOptionPane.showMessageDialog(null, "Údaje sa nesmú rovnať 0", "POZOR", JOptionPane.PLAIN_MESSAGE);
				
				
				switch(btn) {
				
				case 1: btnZenaT1.isSelected();
						btnVysledok.setIcon(new ImageIcon(Konf.class.getResource("/Icon/figurtypen-frauen6.jpg")));
						spinner.setValue(cielZ);
						break;
					
				case 2: btnZenaT2.isSelected();
						btnVysledok.setIcon(new ImageIcon(Konf.class.getResource("/Icon/figurtypen-frauen3.jpg")));
						spinner.setValue(cielZ);
						break;
						
				case 3: btnZenaT3.isSelected();
						btnVysledok.setIcon(new ImageIcon(Konf.class.getResource("/Icon/figurtypen-frauen4.jpg")));
						spinner.setValue(cielZ);
						break;
						
				case 4: btnZenaT4.isSelected();
						btnVysledok.setIcon(new ImageIcon(Konf.class.getResource("/Icon/figurtypen-frauen2.jpg")));
						spinner.setValue(cielZ);
						
				}}catch(ArithmeticException ae) {
					ae.getMessage();
					}
				
				catch (InputMismatchException im) {
					im.getMessage();
					
					
				}catch(Exception ex) {
					ex.getMessage();
					JOptionPane.showMessageDialog(null, "Vyskytla sa chyba! Skontrolujte údaje.", "POZOR", JOptionPane.PLAIN_MESSAGE);
					
				}}
			
		});
		
		btnPokracovatM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				int vyska= Integer.parseInt(tfVyskaM.getText());
				int vaha= Integer.parseInt(tfVahaM.getText());
				int cielM= Integer.parseInt(tfCielM.getText());
				if(vyska != 0 && vaha != 0 && cielM != 0) {
					cards.previous(card);
					
				}else JOptionPane.showMessageDialog(null, "Údaje sa nesmú rovnať 0", "POZOR", JOptionPane.PLAIN_MESSAGE);
				
				
				switch(btn) {
				
				case 1: btnMuzT1.isSelected();
						btnVysledok.setIcon(new ImageIcon(Konf.class.getResource("/Icon/Snimek1-obrazovky-2020-10-30-v-14.36.56-768x402.png")));
						spinner.setValue(cielM);
						break;
					
				case 2: btnMuzT2.isSelected();
						btnVysledok.setIcon(new ImageIcon(Konf.class.getResource("/Icon/Snimek-obrazovky-2020-10-30-v-14.36.56-768x401.png")));
						spinner.setValue(cielM);
						break;
						
				case 3: btnMuzT3.isSelected();
						btnVysledok.setIcon(new ImageIcon(Konf.class.getResource("/Icon/Snimek-obrazovky-2020-10-30-v-14.36.56-768x403.png")));
						spinner.setValue(cielM);
						break;
						
				case 4: btnMuzT4.isSelected();
						btnVysledok.setIcon(new ImageIcon(Konf.class.getResource("/Icon/Snimek-obrazovky-2020-10-30-v-14.36.56-500x370.png")));
						spinner.setValue(cielM);
						
				
				}}catch(ArithmeticException ae) {
					ae.getMessage();
					}
				
				catch (InputMismatchException im) {
					im.getMessage();
					
					
				}catch(Exception ex) {
					ex.getMessage();
					JOptionPane.showMessageDialog(null, "Vyskytla sa chyba! Skontrolujte údaje.", "POZOR", JOptionPane.PLAIN_MESSAGE);
					
				}
}			
		});

		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				slider.setValue((int)spinner.getValue());	
			}
		});
		
			slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				spinner.setValue(slider.getValue());
			}
		});
		
		
	}

	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
	
		Container pane = this.getContentPane();
		pane.setLayout(new BorderLayout());
		
		cards = new CardLayout();
		card = new JPanel();
		card.setLayout(cards);
	

		panel1 = new JPanel();
		panel1.setLayout(null);
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel3 = new JPanel();
		
		
		card.add(panel1);
		
		btnZena = new JButton("");
		btnZena.setIcon(new ImageIcon(Konf.class.getResource("/Icon/icons8_female_96px.png")));
		
		btnZena.setBounds(85, 199, 137, 132);
		panel1.add(btnZena);
		
		btnMuz = new JButton("");
		btnMuz.setIcon(new ImageIcon(Konf.class.getResource("/Icon/icons8_male_96px.png")));
		
		btnMuz.setBounds(453, 199, 137, 132);
		panel1.add(btnMuz);
		
		JLabel lblNewLabel = new JLabel("Vitajte v konfigurátore postavy");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(75, 18, 543, 49);
		panel1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("zvoľte pohlavie");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(186, 94, 266, 49);
		panel1.add(lblNewLabel_1);
		card.add(panel2, "druhý");
		
		JLabel lblNewLabel_2 = new JLabel("Zvoľte typ postavy");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2.setBounds(189, 6, 339, 105);
		panel2.add(lblNewLabel_2);
		
		btnZenaT1 = new JButton("");
				
		btnZenaT1.setIcon(new ImageIcon(Konf.class.getResource("/Icon/figurtypen-frauen6.jpg")));
		btnZenaT1.setPreferredSize(new Dimension(33, 6));
		btnZenaT1.setBounds(62, 138, 126, 286);
		panel2.add(btnZenaT1);
		
		btnZenaT2 = new JButton("");

		btnZenaT2.setIcon(new ImageIcon(Konf.class.getResource("/Icon/figurtypen-frauen3.jpg")));
		btnZenaT2.setPreferredSize(new Dimension(33, 6));
		btnZenaT2.setBounds(218, 138, 126, 286);
		panel2.add(btnZenaT2);
		
		btnZenaT3 = new JButton("");
				
		btnZenaT3.setIcon(new ImageIcon(Konf.class.getResource("/Icon/figurtypen-frauen4.jpg")));
		btnZenaT3.setPreferredSize(new Dimension(33, 6));
		btnZenaT3.setBounds(374, 138, 126, 286);
		panel2.add(btnZenaT3);
		
		btnZenaT4 = new JButton("");
				
		btnZenaT4.setIcon(new ImageIcon(Konf.class.getResource("/Icon/figurtypen-frauen2.jpg")));
		btnZenaT4.setPreferredSize(new Dimension(33, 6));
		btnZenaT4.setBounds(530, 138, 126, 286);
		panel2.add(btnZenaT4);
		card.add(panel3, "třetí");
		panel3.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Zadajte parametre");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_1.setBounds(194, 6, 339, 59);
		panel3.add(lblNewLabel_2_1);
		
		JLabel iblVyska = new JLabel("výška: ");
		iblVyska.setFont(new Font("Tahoma", Font.PLAIN, 16));
		iblVyska.setBackground(Color.WHITE);
		iblVyska.setBounds(6, 94, 50, 29);
		panel3.add(iblVyska);
		
		JLabel lblVha = new JLabel("váha: ");
		lblVha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVha.setBackground(Color.WHITE);
		lblVha.setBounds(6, 133, 50, 29);
		panel3.add(lblVha);
		
		JLabel lblBmi = new JLabel("BMI: ");
		lblBmi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBmi.setBackground(Color.WHITE);
		lblBmi.setBounds(6, 173, 50, 29);
		panel3.add(lblBmi);
		
		JLabel lblOdporanie = new JLabel("odporúčanie:");
		lblOdporanie.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOdporanie.setBackground(Color.WHITE);
		lblOdporanie.setBounds(6, 212, 93, 29);
		panel3.add(lblOdporanie);
		
		rdbtnChudnut = new JRadioButton("chudnúť");
		buttonGroup_1.add(rdbtnChudnut);
		rdbtnChudnut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnChudnut.setBounds(0, 257, 113, 28);
		panel3.add(rdbtnChudnut);
		
		rdbtnPribrat = new JRadioButton("pribrať");
		buttonGroup_1.add(rdbtnPribrat);
		rdbtnPribrat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnPribrat.setBounds(147, 258, 113, 28);
		panel3.add(rdbtnPribrat);
		
		btnPokracovatZ = new JButton("pokračovať");
		
		btnPokracovatZ.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPokracovatZ.setBounds(268, 362, 213, 67);
		panel3.add(btnPokracovatZ);
		
		tfVahaZ = new JTextField();
		tfVahaZ.setText("0");
		tfVahaZ.setToolTipText("v kilogramoch");
		tfVahaZ.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfVahaZ.setColumns(10);
		tfVahaZ.setBounds(114, 134, 265, 29);
		panel3.add(tfVahaZ);
		
		tfVyskaZ = new JTextField();
		tfVyskaZ.setText("0");
		tfVyskaZ.setToolTipText("v centimetroch");
		tfVyskaZ.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfVyskaZ.setColumns(10);
		tfVyskaZ.setBounds(114, 94, 265, 29);
		panel3.add(tfVyskaZ);
		
		btnPotvrdit = new JButton("potvrdiť");
			
		btnPotvrdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPotvrdit.setBounds(410, 133, 104, 29);
		panel3.add(btnPotvrdit);
		
		taBMI = new JTextArea();
		taBMI.setFont(new Font("Tahoma", Font.PLAIN, 15));
		taBMI.setEditable(false);
		taBMI.setBounds(114, 173, 265, 25);
		panel3.add(taBMI);
		
		taOdporucanie = new JTextArea();
		taOdporucanie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		taOdporucanie.setEditable(false);
		taOdporucanie.setBounds(114, 212, 332, 25);
		panel3.add(taOdporucanie);
		
		lblCielovaVaha = new JLabel("cieľová váha:");
		lblCielovaVaha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCielovaVaha.setBackground(Color.WHITE);
		lblCielovaVaha.setBounds(6, 308, 107, 29);
		panel3.add(lblCielovaVaha);
		
		tfCielZ = new JTextField();
		tfCielZ.setText("0");
		tfCielZ.setToolTipText("v kilogramoch");
		tfCielZ.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfCielZ.setColumns(10);
		tfCielZ.setBounds(114, 308, 265, 29);
		
		panel3.add(tfCielZ);
		pane.add(card, BorderLayout.CENTER);
		
		panel4 = new JPanel();
		panel4.setOpaque(false);
		card.add(panel4, "name_1862952960281900");
		panel4.setLayout(null);
		
		slider = new JSlider();
		slider.setValue(0);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setFont(new Font("Tahoma", Font.PLAIN, 15));
		slider.setMinimum(40);
		slider.setMaximum(120);
		slider.setBounds(219, 393, 286, 43);
		panel4.add(slider);
		
		spinner = new JSpinner();
		spinner.setToolTipText("kilogramy");
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spinner.setBounds(92, 403, 68, 33);
		panel4.add(spinner);
		
		btnVysledok = new JButton("");
		btnVysledok.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVysledok.setEnabled(false);
		btnVysledok.setBounds(267, 19, 168, 349);
		panel4.add(btnVysledok);
		
		panel5 = new JPanel();
		card.add(panel5, "name_1863055557297000");
		panel5.setLayout(null);
		
		JLabel iblVyska_1 = new JLabel("výška: ");
		iblVyska_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		iblVyska_1.setBackground(Color.WHITE);
		iblVyska_1.setBounds(6, 77, 50, 29);
		panel5.add(iblVyska_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Zadajte parametre");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_1_1.setBounds(194, 0, 339, 67);
		panel5.add(lblNewLabel_2_1_1);
		
		tfVyskaM = new JTextField();
		tfVyskaM.setText("0");
		tfVyskaM.setToolTipText("v centimetroch");
		tfVyskaM.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfVyskaM.setColumns(10);
		tfVyskaM.setBounds(114, 77, 265, 29);
		panel5.add(tfVyskaM);
		
		tfVahaM = new JTextField();
		tfVahaM.setText("0");
		tfVahaM.setToolTipText("v kilogramoch");
		tfVahaM.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfVahaM.setColumns(10);
		tfVahaM.setBounds(114, 117, 265, 29);
		panel5.add(tfVahaM);
		
		JLabel lblVha_1 = new JLabel("váha: ");
		lblVha_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVha_1.setBackground(Color.WHITE);
		lblVha_1.setBounds(6, 116, 50, 29);
		panel5.add(lblVha_1);
		
		JLabel lblBmi_1 = new JLabel("BMI: ");
		lblBmi_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBmi_1.setBackground(Color.WHITE);
		lblBmi_1.setBounds(6, 156, 50, 29);
		panel5.add(lblBmi_1);
		
		JLabel lblOdporanie_1 = new JLabel("odporúčanie:");
		lblOdporanie_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOdporanie_1.setBackground(Color.WHITE);
		lblOdporanie_1.setBounds(0, 195, 93, 29);
		panel5.add(lblOdporanie_1);
		
		rdbtnChudnut_1 = new JRadioButton("chudnúť");
		buttonGroup.add(rdbtnChudnut_1);
		rdbtnChudnut_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnChudnut_1.setBounds(0, 247, 113, 28);
		panel5.add(rdbtnChudnut_1);
		
		rdbtnPribrat_1 = new JRadioButton("pribrať");
		buttonGroup.add(rdbtnPribrat_1);
		rdbtnPribrat_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnPribrat_1.setBounds(147, 248, 113, 28);
		panel5.add(rdbtnPribrat_1);
		
		btnPokracovatM = new JButton("pokračovať");
		
		btnPokracovatM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPokracovatM.setBounds(268, 366, 213, 67);
		panel5.add(btnPokracovatM);
		
		btnPotvrdit_1 = new JButton("potvrdiť");
		
		btnPotvrdit_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPotvrdit_1.setBounds(416, 116, 104, 29);
		panel5.add(btnPotvrdit_1);
		
		taBMI_1 = new JTextArea();
		taBMI_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		taBMI_1.setEditable(false);
		taBMI_1.setBounds(114, 156, 265, 25);
		panel5.add(taBMI_1);
		
		taOdporucanie_1 = new JTextArea();
		taOdporucanie_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		taOdporucanie_1.setEditable(false);
		taOdporucanie_1.setBounds(114, 200, 325, 25);
		panel5.add(taOdporucanie_1);
		
		lblCielovaVaha_1 = new JLabel("cieľová váha:");
		lblCielovaVaha_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCielovaVaha_1.setBackground(Color.WHITE);
		lblCielovaVaha_1.setBounds(0, 294, 107, 29);
		
		panel5.add(lblCielovaVaha_1);
		
		tfCielM = new JTextField();
		tfCielM.setText("0");
		tfCielM.setToolTipText("v kilogramoch");
		tfCielM.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfCielM.setColumns(10);
		tfCielM.setBounds(114, 295, 265, 29);
		panel5.add(tfCielM);
		
		panel6 = new JPanel();
		card.add(panel6, "name_1863118821239300");
		panel6.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Zvoľte typ postavy");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_3.setBounds(192, 6, 330, 49);
		panel6.add(lblNewLabel_3);
		
		btnMuzT1 = new JButton("");
				
		btnMuzT1.setIcon(new ImageIcon(Konf.class.getResource("/Icon/Snimek1-obrazovky-2020-10-30-v-14.36.56-768x402.png")));
		btnMuzT1.setPreferredSize(new Dimension(33, 6));
		btnMuzT1.setBounds(60, 132, 126, 286);
		panel6.add(btnMuzT1);
		
		btnMuzT2 = new JButton("");
				
		btnMuzT2.setIcon(new ImageIcon(Konf.class.getResource("/Icon/Snimek-obrazovky-2020-10-30-v-14.36.56-768x401.png")));
		btnMuzT2.setPreferredSize(new Dimension(33, 6));
		btnMuzT2.setBounds(216, 132, 126, 286);
		panel6.add(btnMuzT2);
		
		btnMuzT3 = new JButton("");
		
		btnMuzT3.setIcon(new ImageIcon(Konf.class.getResource("/Icon/Snimek-obrazovky-2020-10-30-v-14.36.56-768x403.png")));
		btnMuzT3.setPreferredSize(new Dimension(33, 6));
		btnMuzT3.setBounds(372, 132, 126, 286);
		panel6.add(btnMuzT3);
		
		btnMuzT4 = new JButton("");
		
		btnMuzT4.setIcon(new ImageIcon(Konf.class.getResource("/Icon/Snimek-obrazovky-2020-10-30-v-14.36.56-500x370.png")));
		btnMuzT4.setPreferredSize(new Dimension(33, 6));
		btnMuzT4.setBounds(528, 132, 126, 286);
		panel6.add(btnMuzT4);}
	}
