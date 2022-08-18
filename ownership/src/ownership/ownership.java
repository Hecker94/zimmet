package ownership;

import static javax.swing.JOptionPane.showMessageDialog;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ownership extends JFrame {

	private JPanel contentPane;
	private JTextField text_adsoyad;
	private JTextField text_sifre;
	static String adsoyad;
	static String þifre;
	static String kullanici;
	static String hesap_sayisi;
	String a;
	int b,bir=1,sýfýr=0;
	int c=0;
	int boyut=0;
	String h;
	int hesapturusayisi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ownership frame = new ownership();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ownership() {
		setTitle("GIRIS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(650, 100, 481, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("G\u0130R\u0130\u015E");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(202, 11, 56, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Kullan\u0131c\u0131 T\u00FCr\u00FC");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(187, 73, 97, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(89, 162, 97, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u015Eifre :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(89, 204, 97, 20);
		contentPane.add(lblNewLabel_3);
		
		text_adsoyad = new JTextField();
		text_adsoyad.setFont(new Font("Tahoma", Font.BOLD, 11));
		text_adsoyad.setBounds(202, 163, 145, 20);
		contentPane.add(text_adsoyad);
		text_adsoyad.setColumns(10);
		
		text_sifre = new JTextField();
		text_sifre.setFont(new Font("Tahoma", Font.BOLD, 11));
		text_sifre.setBounds(202, 205, 145, 20);
		contentPane.add(text_sifre);
		text_sifre.setColumns(10);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 108, 445, 43);
		contentPane.add(panel);
		
		JRadioButton admin = new JRadioButton("Admin");
		panel.add(admin);
		
		JRadioButton kullanýcý = new JRadioButton("Kullanýcý");
		panel.add(kullanýcý);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(admin);
		bg.add(kullanýcý);
		
		JButton btnNewButton = new JButton("G\u0130R\u0130\u015E YAP");
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(202, 260, 145, 23);
		contentPane.add(btnNewButton);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(admin.isSelected()) {
					kullanici=String.valueOf(bir);
				}
				else if(kullanýcý.isSelected()) {
					kullanici=String.valueOf(sýfýr);
				}
				else {
					showMessageDialog(null, "Kullanýcý türünü seçmelisiniz!");
					ownership pro=new ownership();
					pro.setVisible(true);
					setVisible(false);
					return;
				}
				adsoyad=text_adsoyad.getText();
				þifre=text_sifre.getText();
				String sorgu="select count(k_adsoyad) as giris from kisiler where k_adsoyad='"+adsoyad+"' and k_sifre='"+þifre+"' and k_admin='"+kullanici+"'";
				ResultSet myres=baglanti.yap();
				myres=baglanti.sorgula(sorgu);
				try {
					while(myres.next()) {
						if(myres.getInt("giris")==1) {
							if(kullanici.equals(String.valueOf(bir))) {
								admin adm=new admin();
								adm.setVisible(true);
							} else if(kullanici.equals(String.valueOf(sýfýr))) {
								kullanýcý kul=new kullanýcý();
								kul.setVisible(true);
							}
						}
						else {
							showMessageDialog(null,"Hatalý Giriþ !!!");
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		
	}

}
