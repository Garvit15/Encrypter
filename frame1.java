import java.awt.*;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.UIManager;

public class frame1 extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel contentPane;
	private JPasswordField pwdPassword;
	protected Window frame;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel lblPassword;
	private JLabel lblLogin;
	private JLabel lblWelcome;
	private JLabel jb;

	
	/**
	 * Launch the application.
	 */
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1 frame = new frame1();
					frame.setUndecorated(true);
					frame.getRootPane().setWindowDecorationStyle(1); // Values from 1 to 8 only
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
	
	void create()
	{
		frame2 frame2 = new frame2();
		frame2.setUndecorated(true);
		frame2.getRootPane().setWindowDecorationStyle(1);
		frame2.setVisible(true);
		this.setVisible(false);
	}
	
	void create1()
	{
		passChange pass = new passChange();
		pass.setUndecorated(true);
		pass.getRootPane().setWindowDecorationStyle(1);
		pass.setVisible(true);
		this.setVisible(false);
		
		//messageShow("Not yet Coded" , "Message");
	}
	
  
	public void clock(JLabel jb)
	{
		Clock c1=new Clock(jb);
		Thread t1=new Thread(c1);
		t1.start();
	}
	
	public void messageShow( String message , String label_of_message)
	{
		JOptionPane optionpane = new JOptionPane(message , JOptionPane.DEFAULT_OPTION);
		JDialog dialog = optionpane.createDialog(label_of_message);
		optionpane.setBackground(contentPane.getBackground());
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);
	}
	
	public String check() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/p.properties");
		Properties prop = new Properties();
		prop.load(fis);
		//return prop.getProperty("password");
		char c[] = prop.getProperty("version").toCharArray();
		for(int i=0;i<c.length;i++)
		{
			if(i==0 || i==c.length-1)
			{
				continue;
			}
			else
			c[i] = (char)(c[i] -  i) ;
		}
		String pwdchk = new String(c,1,(c.length-2));
		System.out.println(pwdchk);
		return pwdchk;
	}
	
	
	public frame1() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(frame1.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		setResizable(false);
		setTitle("ENCRYPTER v1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 300);
		contentPane = new JLabel();
		Image img0=new ImageIcon(this.getClass().getResource("/background.png")).getImage();
		contentPane.setIcon(new ImageIcon(img0));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setToolTipText("");
		contentPane.setBorder(UIManager.getBorder("TextArea.border"));
		setContentPane(contentPane);
		
		pwdPassword = new JPasswordField("PASSWORD");
		pwdPassword.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		pwdPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				pwdPassword.setBackground(Color.BLACK);
				pwdPassword.setForeground(Color.WHITE);
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				pwdPassword.setBackground(new Color(25, 25, 112));
				pwdPassword.setForeground(Color.WHITE);
			}
		});
		pwdPassword.setEchoChar('#');
		pwdPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pwdPassword.selectAll();
			}
		});
		pwdPassword.setBackground(new Color(25, 25, 112));
		pwdPassword.setForeground(Color.WHITE);
		
		JButton btnDone = new JButton("Done");
		Image img2=new ImageIcon(this.getClass().getResource("/ok1.png")).getImage();
		btnDone.setIcon(new ImageIcon(img2));
		btnDone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnDone.setBackground(Color.orange);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnDone.setBackground(new Color(0, 51, 102));
			}
		});
		btnDone.setForeground(Color.BLACK);
		btnDone.setBackground(new Color(0, 51, 102));
		
		btnDone.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String pwd = String.copyValueOf(pwdPassword.getPassword());;
				 
				String use =textField.getText() ;
				
				if(use.equals(""))
				{	
					messageShow("User Name field is Empty" , "Warning");
				}
				
				else if(pwd.equals(""))
				{	
						messageShow("Password field is Enmpty" , "Warning");
				} else
					try {
						if("test".equals(use) && check().equals(pwd))
						{
							create();
						}
						
						else if(!("test".equals(use) && check().equals(pwd)))
						{
							messageShow("Either User Name or Password is Wrong" , "Failure");
							char c1[] = ".test.".toCharArray();
							for(int i=0;i<c1.length;i++)
							{
								if(i==0 || i==(c1.length-1))
								{
									continue;
								}
								else
								{c1[i] = (char)(c1[i] +  i);}
								System.out.println("" + c1[i]);
							}
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		
		textField = new JTextField();
		textField.setBackground(new Color(25, 25, 112));
		textField.setForeground(Color.WHITE);
		textField.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				textField.setBackground(Color.BLACK);
				textField.setForeground(Color.WHITE);
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				textField.setBackground(new Color(25, 25, 112));
				textField.setForeground(Color.WHITE);
			}
		});
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField.selectAll();
			}
		});
		textField.setBackground(Color.BLACK);
		textField.setForeground(Color.WHITE);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("User Name");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.ORANGE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblLogin = new JLabel("LOGIN");
		lblLogin.setOpaque(true);
		lblLogin.setBackground(new Color(72, 61, 139));
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		

		lblWelcome = new JLabel("Welcome !!");
		lblWelcome.setOpaque(true);
		lblWelcome.setBackground(new Color(51, 51, 51));
		lblWelcome.setIcon(null);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblWelcome.setForeground(new Color(173, 216, 230));
		
		JLabel lblChangePassword = new JLabel("Change Password ");
		lblChangePassword.setBackground(new Color(65, 105, 225));
		lblChangePassword.setOpaque(true);
		lblChangePassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				create1();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				//lblChangePassword.setOpaque(true);
				lblChangePassword.setBackground(Color.orange);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblChangePassword.setBackground(new Color(65, 105, 225));
				//lblChangePassword.setOpaque(false);
			}
		});
		lblChangePassword.setForeground(Color.RED);
		lblChangePassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		

		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img3=new ImageIcon(this.getClass().getResource("/welcome.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img3));
		
		jb = new JLabel("");
		jb.setForeground(Color.BLACK);
		jb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		clock(jb);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
					.addComponent(lblChangePassword)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(152)
					.addComponent(btnDone)
					.addContainerGap(233, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(62)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblPassword))
					.addGap(57)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(pwdPassword, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
							.addGap(126))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(304, Short.MAX_VALUE)
					.addComponent(jb, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(19)
									.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblChangePassword)))
							.addGap(29)
							.addComponent(lblLogin))
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(pwdPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnDone)
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addComponent(jb, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
		}
	
public JLabel getLblNewLabel() {
		return lblNewLabel;
	}
		
}
