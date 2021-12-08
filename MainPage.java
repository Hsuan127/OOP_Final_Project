import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class MainPage extends JFrame {
	// 创建一个JLayeredPane用于分层的。
	JLayeredPane layeredPane;
	// 创建一个Panel和一个Label用于存放图片，作为背景。
	
	JPanel jp;
	JLabel jl;
	ImageIcon image;
	ImageIcon fortune;
	JPanel panel;
	JPanel info;
	JPanel allPanel;
	private final static int FIELD_WIDTH = 10;

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		// TODO Auto-generated method stub
		new MainPage();
		String filepath = "Bossa-nova-beat-music-loop (online-audio-converter.com).wav";
		musicStuff musicObject = new musicStuff();
		musicObject.playMusic(filepath);
	}
	
	

	public MainPage() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		
		layeredPane = new JLayeredPane();
		image = new ImageIcon("Crystal ball.png");// 随便找一张图就可以看到效果。
		// 创建背景的那些东西
		jp = new JPanel();
	
		jp.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());

		jl = new JLabel(image);
		// jl.setBounds(0,0,image.getIconWidth(),image.getIconHeight());
		jp.add(jl);

        layeredPane = new JLayeredPane();
        panel = new JPanel();
		panel.setSize(image.getIconWidth(), image.getIconHeight());
		panel.setLayout(null);
		JButton mainPage = new JButton(new ImageIcon("mainpage.png"));
		mainPage.setBounds(10, 680, 160, 50);
		JButton flowerPage = new JButton(new ImageIcon("flowerbutton.png"));
		flowerPage.setBounds(180, 680, 160, 50);
		JButton quizPage = new JButton(new ImageIcon("quizpage.png"));
		quizPage.setBounds(430, 680, 160, 50);
		JButton collectPage = new JButton(new ImageIcon("collectpage.png"));
		collectPage.setBounds(600, 680, 160, 50);
		panel.add(mainPage);
		panel.add(flowerPage);
		panel.add(quizPage);
		panel.add(collectPage);
		panel.setOpaque(false);

		Border raisedbevel;
		raisedbevel = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.blue, Color.black);
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "today");
		p.put("text.month", "month");
		p.put("text.year", "year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());

		
		JLabel nameLabel = new JLabel("名字");
		JLabel birthLabel = new JLabel("生日");
		nameLabel.setForeground(Color.WHITE);
		birthLabel.setForeground(Color.WHITE);
		final JTextField nameTextField = new JTextField(FIELD_WIDTH);
		
		ImageIcon icon = new ImageIcon("submitbt.png");
		ImageIcon icon2 = new ImageIcon("resetbt.png");

		JButton submitButton = new JButton();
		submitButton.setSize(100, 60);
		// Set image to size of JButton...
		
		int offset = submitButton.getInsets().left;
		submitButton.setIcon(resizeIcon(icon, submitButton .getWidth() - offset, submitButton.getHeight() - offset));
		JButton resetButton = new JButton();
		resetButton.setSize(100, 60);
		int offset2 = resetButton.getInsets().left;
		resetButton.setIcon(resizeIcon(icon2, resetButton .getWidth() - offset2, resetButton.getHeight() - offset2));
		info = new JPanel();
		info.setLayout(new GridBagLayout());
		GridBagConstraints c0 = new GridBagConstraints();
		c0.gridx = 0;
		c0.gridy = 0;
		c0.gridwidth = 1;
		c0.gridheight = 1;
		c0.weightx = 0;
		c0.weighty = 0;
		c0.fill = GridBagConstraints.NONE;
		c0.anchor = GridBagConstraints.WEST;
		info.add(nameLabel, c0);
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 0;
		c1.gridy = 2;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx = 0;
		c1.weighty = 0;
		c1.fill = GridBagConstraints.NONE;
		c1.anchor = GridBagConstraints.WEST;
		info.add(birthLabel, c1);
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 2;
		c2.gridy = 0;
		c2.gridwidth = 3;
		c2.gridheight = 1;
		c2.weightx = 0;
		c2.weighty = 0;
		c2.fill = GridBagConstraints.BOTH;
		c2.anchor = GridBagConstraints.WEST;
		info.add(nameTextField, c2);
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 2;
		c3.gridy = 2;
		c3.gridwidth = 3;
		c3.gridheight = 1;
		c3.weightx = 0;
		c3.weighty = 0;
		c3.fill = GridBagConstraints.BOTH;
		c3.anchor = GridBagConstraints.WEST;
		info.add(datePicker, c3);
		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridx = 1;
		c4.gridy = 4;
		c4.gridwidth = 2;
		c4.gridheight = 1;
		c4.weightx = 0;
		c4.weighty = 0;
		c4.fill = GridBagConstraints.NONE;
		c4.anchor = GridBagConstraints.CENTER;
		info.add(submitButton, c4);
		GridBagConstraints c5 = new GridBagConstraints();
		c5.gridx = 3;
		c5.gridy = 4;
		c5.gridwidth = 2;
		c5.gridheight = 1;
		c5.weightx = 0;
		c5.weighty = 0;
		c5.fill = GridBagConstraints.NONE;
		c5.anchor = GridBagConstraints.CENTER;
		info.add(resetButton, c5);
		// info.setPreferredSize(new Dimension(300, 200));
		info.setBorder(raisedbevel);
		info.setBackground(new Color(225,173,247));
		// image2=new ImageIcon("purple-pink.jpg");
		// bg = new JLabel(image2);
		// info.add(bg);
		// info.setLocation(300, 300);
		info.setBounds(240, 240, 300, 200);
		// info.setOpaque(false);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		class infoActionListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				        ImageIcon fortune = new ImageIcon("wheel-of-fortune.png");
				        JPanel panel = new JPanel();
				        panel.setBackground(new Color(255,204,204));
				        panel.setSize(new Dimension(200, 160));
				        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
				        int random = 0;
				        for (int i = 0; i < 3; i++) {
				         random = (int) (Math.random() * 6);
				         list.add(random);
				        }
				        
				        double a = list.get(0);
				        double b = list.get(1);
				        double c = list.get(2);
				        double d = Math.ceil(((a+b+c)/3));
				        String ah = lucky(a);
				        String bh = lucky(b);
				        String ch = lucky(c);
				        String dh = lucky(d);
				        JLabel label1=new JLabel("親愛的"+nameTextField.getText()+", "+"\n"+"您今日的運勢是...");
				        JLabel label = new JLabel("整體運勢:"+dh);
				        JLabel label2 = new JLabel("學業運勢:"+ah);
				        JLabel label3 = new JLabel("財富運勢:"+bh);
				        JLabel label4 = new JLabel("愛情運勢:"+ch);
				        
				        
				        label1.setPreferredSize(new Dimension(250, 40));
				        label1.setFont(new Font("Arial", Font.BOLD, 15));
				        label1.setAlignmentX(CENTER_ALIGNMENT);
				        panel.add(label1);
				        label.setPreferredSize(new Dimension(200, 40));
				        label.setFont(new Font("Arial", Font.BOLD, 15));
				        label.setAlignmentX(CENTER_ALIGNMENT);
				        panel.add(label);
				        label2.setPreferredSize(new Dimension(200, 40));
				        label2.setFont(new Font("Arial", Font.BOLD, 15));
				        label2.setAlignmentX(CENTER_ALIGNMENT);
				        panel.add(label2);
				        label3.setPreferredSize(new Dimension(200, 40));
				        label3.setFont(new Font("Arial", Font.BOLD, 15));
				        label3.setAlignmentX(CENTER_ALIGNMENT);
				        panel.add(label3);
				        label4.setPreferredSize(new Dimension(200, 40));
				        label4.setFont(new Font("Arial", Font.BOLD, 15));
				        label4.setAlignmentX(CENTER_ALIGNMENT);
				        panel.add(label4);
				        
				        if(!nameTextField.getText().equals("") && model.getValue()!=null) {
				        	UIManager.put("OptionPane.minimumSize",new Dimension(400, 200));
				        	JOptionPane.showMessageDialog(jp, panel, "今日運勢", JOptionPane.PLAIN_MESSAGE, fortune);
				        }
				        else {
				        	ImageIcon warning = new ImageIcon("problem.png");
				        	JOptionPane.showMessageDialog(jp, "請輸入資料！", "警告你喔", JOptionPane.WARNING_MESSAGE,warning);
				        }
			
				//fortune = new ImageIcon("wheel-of-fortune-png.png");
				//JOptionPane.showMessageDialog(jp, "今日！", "今日運勢", JOptionPane.INFORMATION_MESSAGE, fortune);
			}
		}
		ActionListener listener1 = new infoActionListener();
		submitButton.addActionListener(listener1);

		JPanel allPanel = new JPanel();
		allPanel.setLayout(null);
		allPanel.add(info);
		allPanel.add(panel);
		
		setContentPane(allPanel);
		
		// getContentPane().setBounds(300, 300, 200, 100);
		((JComponent) getContentPane()).setOpaque(false);
		// getContentPane().add(info);

		// 将jp放到最底层。
		
		layeredPane.add(jp, JLayeredPane.DEFAULT_LAYER);
		// 将jb放到高一层的地方
		// layeredPane.add(panel,JLayeredPane.MODAL_LAYER);
		layeredPane.add(getContentPane(), JLayeredPane.MODAL_LAYER);
		
		
		class RListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nameTextField.setText("");
				model.setValue(null);
			}
			
		}
		ActionListener listenerr = new RListener();
		resetButton.addActionListener(listenerr);
		class HListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ImageIcon warning = new ImageIcon("stupid.png");
	        	JOptionPane.showMessageDialog(jp, "你已經在首頁囉！", "警告你喔", JOptionPane.WARNING_MESSAGE,warning);
			}
			
		}
		ActionListener listenerh = new HListener();
		mainPage.addActionListener(listenerh);
		class QAListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					QA qaFrame = new QA();
					add(qaFrame);
					qaFrame.setVisible(true);
					qaFrame.setDefaultCloseOperation(QA.DISPOSE_ON_CLOSE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		}
		ActionListener listenerqa = new QAListener();
		quizPage.addActionListener(listenerqa);
		class FlowerListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					RandomPicture flowerFrame = new RandomPicture();
					flowerFrame.setVisible(true);
					flowerFrame.setDefaultCloseOperation(RandomPicture.DISPOSE_ON_CLOSE);
					flowerFrame.setDefaultCloseOperation(Picture.DISPOSE_ON_CLOSE);
				}
		}
		ActionListener listenerf = new FlowerListener();
		flowerPage.addActionListener(listenerf);
		class CListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Test collectFrame = new Test();
					collectFrame.setVisible(true);
					collectFrame.setDefaultCloseOperation(QA.DISPOSE_ON_CLOSE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		}
		ActionListener listenerc = new CListener();
		collectPage.addActionListener(listenerc);
		 
		this.setTitle("得意的一天");
		this.setLayeredPane(layeredPane);
		this.setSize(image.getIconWidth(), image.getIconHeight());
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent e) {
			        int result=JOptionPane.showConfirmDialog((Component)e.getSource(), 
			                   "確定要結束程式嗎?",
			                   "別離開啦",
			                   JOptionPane.YES_NO_OPTION,
			                   JOptionPane.WARNING_MESSAGE);
			        if (result==JOptionPane.YES_OPTION) {System.exit(0);}
			        }  
			      });
	
		this.setLocation(image.getIconWidth()/2, image.getIconHeight()/2);
		this.setVisible(true);
		
	}
	private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	    Image img = icon.getImage();  
	    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	    return new ImageIcon(resizedImage);
	}
	 String heart = null;
	 public String lucky(double n) {
		 if(n==0) {
			 heart = "明天會更好！";
		 }
		 else if(n==1) {
     		heart = "♥";
     	}else if(n==2) {
     		heart = "♥♥";
     	}else if(n==3) {
     		heart = "♥♥♥";
     	}else if(n==4) {
     		heart = "♥♥♥♥";
     	}else if(n==5) {
     		heart = "♥♥♥♥♥";
     	}
     	return heart;
     }


}
