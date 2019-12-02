import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class passChange extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JLabel jb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					passChange frame = new passChange();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}
	
	void create()
	{
		this.setVisible(false);
		frame1 frame = new frame1();
		frame.setVisible(true);
	}
	
	

	/**
	 * Create the frame.
	 */
	public void clock(JLabel jb)
	{
		Clock c1=new Clock(jb);
		Thread t1=new Thread(c1);
		t1.start();
	}
	
	public void close_frame_pass()
	{
		this.setVisible(false);
		
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
		System.out.println(fis);
		Properties prop = new Properties();
		prop.load(fis);
		String s = prop.getProperty("version");
//		for(int i=0;i<c.length;i++)
//		{
//			if(i==0 || i==c.length-1)
//			{
//				continue;
//			}
//			else
//			c[i] = (char)(c[i] -  i) ;
//		}
//		String pwdchk = new String(c,1,(c.length-2));
//		//System.out.println(pwdchk);
		return s;
	}
	
	
	public passChange() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(passChange.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		setTitle("ENCRYPTER v1.0");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 210);
		contentPane = new JLabel();
		contentPane.setForeground(Color.BLACK);
		Image img0=new ImageIcon(this.getClass().getResource("/background.png")).getImage();
		contentPane.setIcon(new ImageIcon(img0));
		contentPane.setBackground(new Color(123, 104, 238));
		contentPane.setBorder(UIManager.getBorder("TextArea.border"));
		setContentPane(contentPane);
		
		JLabel lblEnterOldPassword = new JLabel("Enter Old Password");
		lblEnterOldPassword.setForeground(Color.ORANGE);
		lblEnterOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblEnterNewPassword = new JLabel("Enter New Password");
		lblEnterNewPassword.setForeground(Color.ORANGE);
		lblEnterNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setForeground(Color.ORANGE);
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		passwordField = new JPasswordField("");
		passwordField.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		passwordField.setBackground(new Color(25, 25, 112));
		passwordField.setEchoChar('#');
		passwordField.setForeground(Color.WHITE);
		
		passwordField_1 = new JPasswordField("");
		passwordField_1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		passwordField_1.setBackground(new Color(25, 25, 112));
		passwordField_1.setEchoChar('#');
		passwordField_1.setForeground(Color.WHITE);
		
		passwordField_2 = new JPasswordField("");
		passwordField_2.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		passwordField_2.setBackground(new Color(25, 25, 112));
		passwordField_2.setEchoChar('#');
		passwordField_2.setForeground(Color.WHITE);
		//Image img1=new ImageIcon(this.getClass().getResource("/ok1.png")).getImage();
		
		JLabel lblChangePassword = new JLabel("Change Password");
		Image img2=new ImageIcon(this.getClass().getResource("/cp1.png")).getImage();
		lblChangePassword.setIcon(new ImageIcon(img2));
		lblChangePassword.setForeground(Color.WHITE);
		lblChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblBack = new JLabel("");
		Image img3=new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
		lblBack.setIcon(new ImageIcon(img3));
		//lblBack.setBackground(new Color(0, 0, 139));
		//lblBack.setOpaque(true);
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				create();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				//lblBack.setOpaque(true);
				lblBack.setBackground(Color.orange);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblBack.setBackground(new Color(0, 0, 139));
				//lblBack.setOpaque(false);
			}
		});
		lblBack.setForeground(Color.RED);
		lblBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		jb = new JLabel("");
		jb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		clock(jb);
		
		
		JButton btnSubmit = new JButton("Submit");
		Image img4=new ImageIcon(this.getClass().getResource("/ok1.png")).getImage();
		btnSubmit.setIcon(new ImageIcon(img4));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println(valueOf(passwordField_1.getPassword()));
				String s1,s2,s3;
				s1 = new String(passwordField.getPassword());
				s2 = new String(passwordField_1.getPassword());
				s3 = new String(passwordField_2.getPassword());
				try {
					if(s1.equals(check()))  //old password
					{
						if(s2.equals(""))
						{
							messageShow("'Enter New Password' field is empty" , "Error");
						}
						else if(s3.equals(""))
						{
							messageShow("'Confirm Password' field is empty" , "Error");
						}
						else if(s2.length() < 4)
						{
							messageShow("Password cannot be less than 4 digit" , "Error");
						}
						else if(s2.length() > 10)
						{
							messageShow("Password cannot be more than 10 digit" , "Error");
						}
						else if(!(s2.equals(s3)))
						{
							messageShow("'Enter New Password' field do not match with 'Confirm Password' field" , "Error");
						}
						else if(s2.equals(s3))
						{
							FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/p.properties");
							Properties prop = new Properties();
							prop.load(fis);
							fis.close();
							
							FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"/p.properties");
							String pass = String.valueOf(passwordField_2.getPassword());
							prop.setProperty("version", pass);
							prop.store(fos, null);
							fos.close();
							messageShow("SUCCESS!!" , "Success");
							close_frame_pass();
						}
					}
					else
					{
						messageShow("Incorrect Password! Try Again.." , "Error");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblBack)
							.addGap(101)
							.addComponent(lblChangePassword))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(58)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnterNewPassword)
								.addComponent(lblEnterOldPassword)
								.addComponent(lblConfirmPassword))
							.addGap(42)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
								.addComponent(passwordField_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
								.addComponent(passwordField_2, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))
						.addComponent(jb, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(160, Short.MAX_VALUE)
					.addComponent(btnSubmit)
					.addGap(144))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblChangePassword)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEnterOldPassword)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEnterNewPassword)
								.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblConfirmPassword)
								.addComponent(passwordField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSubmit)
							.addGap(10)
							.addComponent(jb))
						.addComponent(lblBack))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
