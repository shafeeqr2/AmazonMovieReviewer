import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;


public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField In;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setFont(new Font("Dialog", Font.PLAIN, 10));
		setForeground(Color.ORANGE);
		setTitle("Amazon Movie Reviewer");
		setBackground(new Color(25, 25, 112));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 25, 112));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		In = new JTextField();
		In.setForeground(new Color(255, 255, 255));
		In.setBackground(new Color(0, 0, 0));
		In.setText("Type the movie\n you would like to\n search for...");
		In.setBounds(12, 12, 300, 100);
		contentPane.add(In);
		In.setColumns(10);
		
		JButton EXIT = new JButton("X");
		EXIT.setFont(new Font("Dialog", Font.BOLD, 5));
		EXIT.setBackground(Color.WHITE);
		EXIT.setForeground(Color.RED);
		EXIT.setBounds(394, 210, 25, 25);
		contentPane.add(EXIT);
		
		JButton btnGo = new JButton("Go!");
		btnGo.setFont(new Font("Dialog", Font.BOLD, 20));
		btnGo.setForeground(Color.WHITE);
		btnGo.setBackground(Color.ORANGE);
		btnGo.setBounds(320, 20, 114, 82);
		contentPane.add(btnGo);
		
		JLabel lblOutput = new JLabel("<html>Reviews from<br> other users:</html>");
		lblOutput.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblOutput.setForeground(Color.WHITE);
		lblOutput.setBounds(42, 124, 200, 53);
		contentPane.add(lblOutput);
		
		JLabel ScoreOut = new JLabel("<html>First line<br>Second line</html>");
		ScoreOut.setForeground(Color.ORANGE);
		ScoreOut.setHorizontalAlignment(SwingConstants.LEFT);
		ScoreOut.setVerticalAlignment(SwingConstants.TOP);
		ScoreOut.setBounds(42, 188, 200, 100);
		contentPane.add(ScoreOut);
		
		JLabel lblRecommendedMoviesFrom = new JLabel("<html>Recommended Movies<br> from other users:</html>");
		lblRecommendedMoviesFrom.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblRecommendedMoviesFrom.setForeground(Color.WHITE);
		lblRecommendedMoviesFrom.setBounds(269, 124, 200, 53);
		contentPane.add(lblRecommendedMoviesFrom);
		
		JLabel MovieOut = new JLabel("<html>First line<br>Second line</html>");
		MovieOut.setForeground(Color.ORANGE);
		MovieOut.setVerticalAlignment(SwingConstants.TOP);
		MovieOut.setHorizontalAlignment(SwingConstants.LEFT);
		MovieOut.setBounds(269, 188, 200, 100);
		contentPane.add(MovieOut);
	}
}
