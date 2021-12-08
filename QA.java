import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QA extends JFrame {
	private static final int FRAME_WIDTH = 1500;
	private static final int FRAME_HEIGHT = 900;
	private static int ran;
	private JRadioButton a1, a2, a3, a4, b1, b2, b3, b4, c1, c2, c3, c4, d1, d2, d3, d4;
	private ButtonGroup group;
	private JLabel Ques, q;
	private ScrollPane scroll;
	private JButton submit, reset;
	// 创建一个JLayeredPane用于分层的。
	JLayeredPane layeredPane;
	// 创建一个Panel和一个Label用于存放图片，作为背景。
	JPanel jp;
	JLabel jl;
	ImageIcon image;

	// 创建一个按钮用于测试的。
	JButton jb;

	public QA() throws SQLException {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("TEST YOUR TRUE THINKING INSIDE");

		String path = "big.jpg";
		ImageIcon background = new ImageIcon(path);
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		JPanel imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

		Panel1();
		createNum();
		/*
		 * layeredPane = new JLayeredPane(); layeredPane.setOpaque(false); image = new
		 * ImageIcon("bounds.jpg");// 随便找一张图就可以看到效果。 //创建背景的那些东西 jp = new JPanel();
		 * jp.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		 * 
		 * jl = new JLabel(image); // jl.setBounds(0, 0, image.getIconWidth(),
		 * image.getIconHeight()); jp.add(jl); // 将jp放到最底层。 layeredPane.add(jp,
		 * JLayeredPane.DEFAULT_LAYER);
		 * 
		 * this.setLayeredPane(layeredPane); this.setSize(image.getIconWidth(),
		 * image.getIconHeight()); this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 * this.setLocation(image.getIconWidth(), image.getIconHeight());
		 */setVisible(true);

	}

	public void createNum() throws SQLException {
		Connection conn = Snoopy.getConnection();
		int random = 0;
		for (int i = 0; i < 1; i++) {
			random = (int) (Math.random() * 31);
		}
		System.out.println(random);
		PreparedStatement state = conn.prepareStatement("INSERT INTO 測驗(編號)  VALUES (?)");
		state.setInt(1, random);
		state.executeUpdate();
		ran = random;
	}

	public static int getRan() {
		return ran;
	}

	public JPanel Panel1() throws SQLException {
		Connection conn = Snoopy.getConnection();
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		submit = new JButton("送出");
		reset = new JButton("換掉重來");
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Test"));
		panel.setLayout(new GridLayout(21, 1));
		JPanel btnPan = new JPanel();
		btnPan.setLayout(new GridLayout(1, 2));
		btnPan.add(submit);
		btnPan.add(reset);
		add(btnPan, BorderLayout.SOUTH);
		try {
			Statement stat = conn.createStatement();
			ResultSet re1 = stat.executeQuery("SELECT * FROM 測驗1 ORDER BY RAND() LIMIT 1");
			while (re1.next()) {
				Ques = new JLabel("Question 1: " + re1.getString("題目"));
				a1 = new JRadioButton(re1.getString("選項1"));
				a2 = new JRadioButton(re1.getString("選項2"));
				a3 = new JRadioButton(re1.getString("選項3"));
				a4 = new JRadioButton(re1.getString("選項4"));
				group = new ButtonGroup();
				panel.add(Ques);
				group.add(a1);
				group.add(a2);
				group.add(a3);
				group.add(a4);
				panel.add(a1);
				panel.add(a2);
				panel.add(a3);
				panel.add(a4);
				add(panel);
			}
			ResultSet re2 = stat.executeQuery("SELECT * FROM 測驗2 ORDER BY RAND() LIMIT 1");
			while (re2.next()) {
				Ques = new JLabel("Question 2: " + re2.getString("題目"));
				b1 = new JRadioButton(re2.getString("選項1"));
				b2 = new JRadioButton(re2.getString("選項2"));
				b3 = new JRadioButton(re2.getString("選項3"));
				b4 = new JRadioButton(re2.getString("選項4"));
				group = new ButtonGroup();
				panel.add(Ques);
				group.add(b1);
				group.add(b2);
				group.add(b3);
				group.add(b4);
				panel.add(b1);
				panel.add(b2);
				panel.add(b3);
				panel.add(b4);
				add(panel);
			}
			ResultSet re3 = stat.executeQuery("SELECT * FROM 測驗3 ORDER BY RAND() LIMIT 1");
			while (re3.next()) {
				Ques = new JLabel("Question 3: " + re3.getString("題目"));
				c1 = new JRadioButton(re3.getString("選項1"));
				c2 = new JRadioButton(re3.getString("選項2"));
				c3 = new JRadioButton(re3.getString("選項3"));
				c4 = new JRadioButton(re3.getString("選項4"));
				group = new ButtonGroup();
				panel.add(Ques);
				group.add(c1);
				group.add(c2);
				group.add(c3);
				group.add(c4);
				panel.add(c1);
				panel.add(c2);
				panel.add(c3);
				panel.add(c4);
				add(panel);
			} // 測驗3、4還沒輸入完!
			ResultSet re4 = stat.executeQuery("SELECT * FROM 測驗4 ORDER BY RAND() LIMIT 1");
			while (re4.next()) {
				Ques = new JLabel("Question 4: " + re4.getString("題目"));
				d1 = new JRadioButton(re4.getString("選項1"));
				d2 = new JRadioButton(re4.getString("選項2"));
				d3 = new JRadioButton(re4.getString("選項3"));
				d4 = new JRadioButton(re4.getString("選項4"));
				group = new ButtonGroup();
				panel.add(Ques);
				group.add(d1);
				group.add(d2);
				group.add(d3);
				group.add(d4);
				panel.add(d1);
				panel.add(d2);
				panel.add(d3);
				panel.add(d4);
				add(panel);
			}

			class ButtonListener implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					try {
						setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						new QA();
					} catch (SQLException e1) {
					}
				}
			}
			reset.addActionListener(new ButtonListener());

			class SubButtonListener implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					ImageIcon warning = new ImageIcon("problem.png");
					if (a1.isSelected() || a2.isSelected() || a3.isSelected() || a4.isSelected()) {
						if (b1.isSelected() || b2.isSelected() || b3.isSelected() || b4.isSelected()) {
							if (c1.isSelected() || c2.isSelected() || c3.isSelected() || c4.isSelected()) {
								if (d1.isSelected() || d2.isSelected() || d3.isSelected() || d4.isSelected()) {
									ImageIcon img = new ImageIcon("p" + getRan() + ".jpg");
									JLabel la = new JLabel(img);
									JFrame frame = new JFrame();
									
									frame.add(la);
									frame.setBounds(300, 200, img.getIconWidth(), img.getIconHeight() + 20);
									frame.setVisible(true);
									frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
								} else
									JOptionPane.showMessageDialog(null, "不要逃避問題!!!","警告你喔", JOptionPane.WARNING_MESSAGE, warning);

							} else
								JOptionPane.showMessageDialog(null, "不要逃避問題!!!","警告你喔", JOptionPane.WARNING_MESSAGE, warning);
						} else
							JOptionPane.showMessageDialog(null, "不要逃避問題!!!","警告你喔", JOptionPane.WARNING_MESSAGE, warning);
					} else
						JOptionPane.showMessageDialog(null, "不要逃避問題!!!","警告你喔", JOptionPane.WARNING_MESSAGE, warning);

				}
			}
			submit.addActionListener(new SubButtonListener());
			stat.close();
			re1.close();
			re2.close();
			re3.close();
			re4.close();
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			return panel;
		} catch (Exception e) {

		} finally {
			conn.close();
		}
		return null;
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		QA frame = new QA();
		// frame.getGraphicsConfiguration().getDevice().setFullScreenWindow(frame);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}



}
