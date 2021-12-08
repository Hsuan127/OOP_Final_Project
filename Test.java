import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;

public class Test extends JFrame {
	// 创建一个JLayeredPane用于分层的。
	JLayeredPane layeredPane;
	// 创建一个Panel和一个Label用于存放图片，作为背景。
	JPanel jp;
	JLabel jl;
	ImageIcon image;

	// 创建一个按钮用于测试的。
	JButton jb;
	ArrayList list = new ArrayList();

	public static void main(String[] args) throws SQLException {
		new Test();
	}

	public Test() throws SQLException {
		layeredPane = new JLayeredPane();
		image = new ImageIcon("圖片/z.jpg");// 随便找一张图就可以看到效果。
		// 创建背景的那些东西
		jp = new JPanel();
		jp.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());

		jl = new JLabel(image);
//		jl.setBounds(0,0,image.getIconWidth(),image.getIconHeight());
		jp.add(jl);

		// 创建一个测试按钮
		jb = new JButton("测试按钮");
		jb.setBounds(100, 100, 100, 100);

		JButton btn = null;
		JButton pageL = null;
		JButton pageR = null;
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(80, 100, image.getIconWidth() / 2 - 100, image.getIconHeight() - 100);
		JPanel panel2 = new JPanel();
		panel2.setOpaque(false);
		panel2.setBounds(550, 100, image.getIconWidth() / 2 - 100, image.getIconHeight() - 100);

		JPanel panel3 = new JPanel();
		panel3.setOpaque(false);
		panel3.setBounds(80, 100, image.getIconWidth() / 2 - 100, image.getIconHeight() - 100);
		JPanel panel4 = new JPanel();
		panel4.setOpaque(false);
		panel4.setBounds(550, 100, image.getIconWidth() / 2 - 100, image.getIconHeight() - 100);

		// panel.setSize(image.getIconWidth() / 2, image.getIconHeight());
		// panel.setLayout(new GridLayout(3,3));
		String pic = null;

		class BtnListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Icon p = ((JButton) (e.getSource())).getIcon();
				String info = p.toString();
				for (int n = 0; n <= 31; n++) {
					if (info.equals("icon/p" + n + ".jpg")) {
						String path = "圖片/p" + n + ".jpg";
						ImageIcon image = new ImageIcon(path);
						JLabel a = new JLabel(image);
						PictureFrame frame = new PictureFrame();
						frame.add(a);
						frame.setBounds(300, 200, image.getIconWidth() + 15, image.getIconHeight() + 25);
						frame.setVisible(true);
						frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
					}
				}
			}
		}

		Connection conn = Snoopy.getConnection();
		ResultSet result = conn.createStatement().executeQuery("SELECT * FROM `測驗`");
		while (result.next()) {
			String i = result.getString("編號");
			if (list.contains(i) != true) {
				list.add(i);
				if (list.size() <= 9) {
					String path = "icon/p" + i + ".jpg";
					Icon icon = new ImageIcon(path);
					btn = new JButton(icon);
					btn.addActionListener(new BtnListener());
					panel.add(btn);
				} else if (list.size() > 9 && list.size() <= 18) {
					String path = "icon/p" + i + ".jpg";
					Icon icon = new ImageIcon(path);
					btn = new JButton(icon);
					btn.addActionListener(new BtnListener());
					panel2.add(btn);
				} else if (list.size() > 18 && list.size() <= 27) {
					String path = "icon/p" + i + ".jpg";
					Icon icon = new ImageIcon(path);
					btn = new JButton(icon);
					btn.addActionListener(new BtnListener());
					panel3.add(btn);
				} else if (list.size() > 27 && list.size() <= 36) {
					String path = "icon/p" + i + ".jpg";
					Icon icon = new ImageIcon(path);
					btn = new JButton(icon);
					btn.addActionListener(new BtnListener());
					panel4.add(btn);
				}
			}
		}

		Icon icon = new ImageIcon("圖片/R.png");

		JPanel panelB = new JPanel();
		panelB.setOpaque(false);
		panelB.setBounds(850, 580, icon.getIconWidth(), icon.getIconHeight());
		pageR = new JButton(icon);
		pageR.setLocation(100, 100);
		pageR.setOpaque(false);
		pageR.setContentAreaFilled(false);
		pageR.setBorder(null);

		Icon icon2 = new ImageIcon("圖片/L.png");
		JPanel panelA = new JPanel();
		panelA.setOpaque(false);
		panelA.setBounds(100, 580, icon.getIconWidth(), icon.getIconHeight());
		pageL = new JButton(icon2);
		pageL.setLocation(100, 100);
		pageL.setOpaque(false);
		pageL.setContentAreaFilled(false);
		pageL.setBorder(null);
		panelA.add(pageL);
		panelA.setVisible(false);
		panelB.add(pageR);

		class PageRListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setVisible(false);
				panel2.setVisible(false);
				panel3.setVisible(true);
				panel4.setVisible(true);
				panelA.setVisible(true);
			}

		}
		class PageLListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setVisible(true);
				panel2.setVisible(true);
				panel3.setVisible(false);
				panel4.setVisible(false);
				panelA.setVisible(false);
			}
		}
		pageR.addActionListener(new PageRListener());
		pageL.addActionListener(new PageLListener());
		

		getContentPane().setLayout(null);
		// 将jp放到最底层。
		layeredPane.add(jp, JLayeredPane.DEFAULT_LAYER);
		// 将jb放到高一层的地方
		// layeredPane.add(jb,JLayeredPane.MODAL_LAYER);
		layeredPane.add(panel, JLayeredPane.MODAL_LAYER);
		layeredPane.add(panelA, JLayeredPane.MODAL_LAYER);
		layeredPane.add(panelB, JLayeredPane.MODAL_LAYER);
		layeredPane.add(panel2, JLayeredPane.MODAL_LAYER);
		layeredPane.add(panel3, JLayeredPane.MODAL_LAYER);
		layeredPane.add(panel4, JLayeredPane.MODAL_LAYER);

		this.setLayeredPane(layeredPane);
		this.setSize(image.getIconWidth(), image.getIconHeight());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setLocation(image.getIconWidth(),image.getIconHeight());
		this.setVisible(true);
	}
}
