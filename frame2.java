import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class frame2 extends JFrame {
	
	private static final long serialVersionUID = 1L;
     int flag =0;
     long key = 0;
     private JLabel contentPane;
     private JTextField textField;
	
	JFileChooser chooser = new JFileChooser();
	private JButton btnDecrypt;
	private JButton btnEncrypt;
	private JTextField txtEnterKey;
	private JLabel lblDoNotForget;
	private JLabel lblBack;
	private JLabel jb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame2 frame = new frame2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}
	
	void fileEncrypter() throws IOException
	{
		String loc = "";
		loc = textField.getText();
		key = Long.parseLong(txtEnterKey.getText());
		String fileloc = loc.substring(0,loc.lastIndexOf(File.separator));
		FileInputStream fi1 = new FileInputStream(loc);
		FileOutputStream fo1 = new FileOutputStream(fileloc +"/catch.txt");
		int x;
		while((x=fi1.read())!= -1)
		{
			fo1.write((char)x);
		}
		FileInputStream fi2 = new FileInputStream(fileloc +"/catch.txt");
		FileOutputStream fo2 = new FileOutputStream(loc);
		int y;
		while((y=fi2.read())!= -1)
		{
			fo2.write((char)((int)y + key*11));
		}
		fi1.close();
		fi2.close();
		fo1.close();
		fo2.close();
		File f = new File(fileloc +"/catch.txt");
		f.delete();;
		this.dispose();
		
		messageShow("SUCCESS" , "Success");
	}
	
	
	void fileDecrypter() throws IOException
	{
		String loc = "";
		loc = textField.getText();
		key = Integer.parseInt(txtEnterKey.getText());
		String fileloc = loc.substring(0,loc.lastIndexOf(File.separator));
		FileInputStream fi1 = new FileInputStream(loc);
		FileOutputStream fo1 = new FileOutputStream(fileloc +"/catch.txt");
		int x;
		while((x=fi1.read())!= -1)
		{
			fo1.write((char)x);
		}
		FileInputStream fi2 = new FileInputStream(fileloc +"/catch.txt");
		FileOutputStream fo2 = new FileOutputStream(loc);
		int y;
		while((y=fi2.read())!= -1)
		{
			fo2.write((char)((int)y - key*11));
		}
		fi1.close();
		fi2.close();
		fo1.close();
		fo2.close();
		File f = new File(fileloc +"/catch.txt");
		f.delete();
		this.dispose();
		
		messageShow("SUCCESS!!" , "Success");
		
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
	
	public void messageShow( String message , String label_of_message)
	{
		JOptionPane optionpane = new JOptionPane(message , JOptionPane.DEFAULT_OPTION);
		JDialog dialog = optionpane.createDialog(label_of_message);
		optionpane.setBackground(contentPane.getBackground());
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);
	}
	
	public frame2() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(frame2.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		setTitle("ENCRYPTER v1.0");
		setBackground(new Color(123, 104, 238));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JLabel();
		//Image img0=new ImageIcon(this.getClass().getResource("/background.png")).getImage();
		//contentPane.setIcon(new ImageIcon(img0));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(123, 104, 238));
		contentPane.setBorder(UIManager.getBorder("EditorPane.border"));
		setContentPane(contentPane);
		
		JButton btnChooseAFile = new JButton("Choose a File");
		btnChooseAFile.setForeground(Color.BLACK);
		btnChooseAFile.setBackground(new Color(0, 0, 205));
		btnChooseAFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnChooseAFile.setBackground(Color.orange);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnChooseAFile.setBackground(new Color(0, 0, 205));
			}
		});
		btnChooseAFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = chooser.showOpenDialog(null);
				File fileobj = chooser.getSelectedFile();
				if(result == JFileChooser.APPROVE_OPTION)
				{
					textField.setText("" + fileobj.getPath());
					flag=1;      //
				}
				else if(result == JFileChooser.CANCEL_OPTION)
				{
					textField.setText(" ");
				}
			}
		});
		
		textField = new JTextField();
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
		textField.setBackground(new Color(25, 25, 112));
		textField.setForeground(Color.WHITE);
		textField.setColumns(10);
		
		btnDecrypt = new JButton("Decrypt");
		btnDecrypt.setForeground(Color.BLACK);
		btnDecrypt.setBackground(new Color(0, 0, 205));
		btnDecrypt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnDecrypt.setBackground(Color.orange);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnDecrypt.setBackground(new Color(0, 0, 205));
			}
		});
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag == 0)
				{
					messageShow("Choose a File First" , "Error");
				}
				else if(flag == 1)
				{
					if(txtEnterKey.getText().equals("Enter Key..") || txtEnterKey.getText().equals(""))
					{
							messageShow("Enter Key First" , "Error");
					}
					else
					{
						try {
							fileDecrypter();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
		
		btnEncrypt = new JButton("Encrypt");
		btnEncrypt.setForeground(Color.BLACK);
		btnEncrypt.setBackground(new Color(0, 0, 205));
		btnEncrypt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnEncrypt.setBackground(Color.orange);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnEncrypt.setBackground(new Color(0, 0, 205));
			}
		});
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag == 0)
				{
					messageShow("Choose a File First" , "Error");
				}
				else if(flag == 1)
				{
					if(txtEnterKey.getText().equals("Enter Key..")  || txtEnterKey.getText().equals(""))
					{
							messageShow("Enter Key First" , "Error");
					}
					else{
						try {
							fileEncrypter();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			}
		});
		
		txtEnterKey = new JTextField();
		txtEnterKey.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		txtEnterKey.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				int x=ke.getKeyCode();
				if(x >= KeyEvent.VK_0 && x <= KeyEvent.VK_9)
				{}
				else if(x == KeyEvent.VK_BACK_SPACE || x == KeyEvent.VK_DELETE || x == KeyEvent.VK_RIGHT || x == KeyEvent.VK_LEFT)
				{}
				else
				{
					ke.consume();
				}
			}
		});
		txtEnterKey.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtEnterKey.setText("");
				//txtEnterKey.setForeground(Color.WHITE);
				txtEnterKey.setBackground(Color.BLACK);
				txtEnterKey.setForeground(Color.WHITE);
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				txtEnterKey.setBackground(new Color(25, 25, 112));
				txtEnterKey.setForeground(Color.WHITE);
			}
		});
		txtEnterKey.setForeground(Color.CYAN);
		txtEnterKey.setBackground(new Color(25, 25, 112));
		txtEnterKey.setText("Enter Key..");
		txtEnterKey.setColumns(10);
		
		lblDoNotForget = new JLabel("** Do Not Forget Key");
		//Image img2=new ImageIcon(this.getClass().getResource("/key.png")).getImage();
		//lblDoNotForget.setIcon(new ImageIcon(img2));
		lblDoNotForget.setBackground(new Color(0, 51, 102));
		lblDoNotForget.setOpaque(true);
		lblDoNotForget.setForeground(Color.RED);
		lblDoNotForget.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblBack = new JLabel("");
		//Image img1=new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
		//lblBack.setIcon(new ImageIcon(img1));
		lblBack.setOpaque(true);
		lblBack.setBackground(new Color(0, 0, 128));
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
				lblBack.setBackground(new Color(0, 0, 128));
				//lblBack.setOpaque(false);
			}
		});
		lblBack.setForeground(Color.RED);
		lblBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		jb = new JLabel("");
		jb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		clock(jb);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(92, Short.MAX_VALUE)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
					.addGap(80))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(176, Short.MAX_VALUE)
					.addComponent(btnChooseAFile)
					.addGap(171))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addComponent(txtEnterKey, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(54)
							.addComponent(lblDoNotForget))
						.addComponent(lblBack))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDecrypt)
								.addComponent(btnEncrypt))
							.addGap(38))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(jb, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblBack)
					.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnChooseAFile)
					.addGap(33)
					.addComponent(btnEncrypt)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(txtEnterKey, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDoNotForget))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(btnDecrypt)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(jb, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
