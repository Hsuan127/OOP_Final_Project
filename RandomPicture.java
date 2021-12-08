import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class RandomPicture extends JFrame{
	private static final int FRAME_HEIGHT = 360;
	private static final int FRAME_WIDTH = 180;
	ImageIcon image;
	ImageIcon image1;
	JPanel panel;
	JLabel label;
	JLabel label1 = new JLabel();
	JLayeredPane layeredPane;
	JButton button;
	
	public RandomPicture() {
		layeredPane=new JLayeredPane();
		image=new ImageIcon("780.jpeg");
		panel=new JPanel();
		panel.setBounds(0,0,image.getIconWidth(),image.getIconHeight()); 
		label=new JLabel(image);
		panel.add(label);
		
		button=new JButton("點擊獲取你的幸運花！");
		button.setLocation(280,400);
		button.setSize(200,100);
		button.setOpaque(true);

		class buttonListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int random=0;
			     for(int i=0;i<1;i++) {
			      random = (int) (Math.random()*13);
			   }
			     image1=new ImageIcon("photo"+random+".png");
			     Picture a = new Picture();
			     JLabel b = new JLabel(image1);
			     a.add(b);
			     a.setVisible(true);
			     a.setBounds(250,120,image1.getIconWidth(),image1.getIconHeight());
			     a.setDefaultCloseOperation(a.DISPOSE_ON_CLOSE);
			}
			
		}	
		button.addActionListener(new buttonListener());

		JPanel panel1 = new JPanel();
		panel.add(label);
		panel.add(button);
		
		label1.setIcon(image1);
	    panel1.add(label1);
		panel1.setOpaque(false);
		layeredPane.add(panel,JLayeredPane.DEFAULT_LAYER);
		layeredPane.add(button,JLayeredPane.MODAL_LAYER);
		layeredPane.add(panel1,JLayeredPane.MODAL_LAYER);
		
		
		this.setLayeredPane(layeredPane);
		this.setSize(image.getIconWidth(),image.getIconHeight());
		this.setLocation(image.getIconWidth()/2,image.getIconHeight()/2);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true); 
	}
	
	public static void main(String[] args) throws SQLException {
		  // TODO Auto-generated method stub
		
		new RandomPicture();

		 }

}

