package MVC;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.Scrollable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * The Graphic user interface of the application.
 * @author shafeeq
 *
 */
public class GUI extends JFrame {

	private String introText = "Please insert Movie's ASIN // Product ID";

	private JPanel contentPane;
	private JTextField In;
	private JButton btnGo = new JButton("Go!");
	private JLabel movieScore = new JLabel("Movie Rating: ");
	private JLabel getScore = new JLabel();

	private JLabel lblOutput = new JLabel("<html>Reviews for this movie </html>");

	private JLabel lblRecommendedMoviesFrom = new JLabel("<html>Other movies recommended by these users: </html>");
	private JLabel MovieOut = new JLabel();
	private JLabel reviewsLabel = new JLabel();
	private JLabel moviesLabel = new JLabel();
	private static boolean dataInserted = false;

	Font f = new Font(Font.SERIF, Font.PLAIN, 15);
	Font fb = new Font(Font.SERIF, Font.BOLD, 15);

	/**
	 * Takes the rating value and covert it to a double that is rounded to 2 decimal places.
	 * @param value
	 * @return double
	 */
	private static double to2dp(double value) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	/**
	 * Takes in a StringBuilder and a review and populates the contents of the Review into the StringBuilder with appropriate HTML tags.
	 * @param sb
	 * @param r
	 * @return 
	 */
	private StringBuilder createReview(StringBuilder sb, Review r) {

		sb.append("User ID: ");
		sb.append(r.getUserID());
		sb.append("<div>");
		sb.append("Summary: ");
		sb.append(r.getReview_title());
		sb.append("<div>");
		sb.append("Details: ");
		sb.append(r.getReview_detail());
		sb.append("<div>");
		sb.append("Helpfulness Rating: ");
		sb.append(to2dp(r.getHelpfulness()) + "%");
		sb.append("<br>");
		sb.append("<br>");

		return sb;
	}
	
	/**
	 * Takes in a StringBuilder and an array of Movie names and populates the contents of the Review into the StringBuilder with appropriate HTML tags.
	 * @param recommendedMovies
	 * @param sb
	 * @return
	 */
	private StringBuilder otherMovies(String[] recommendedMovies, StringBuilder sb) {
				
		for (int i = 0; i < recommendedMovies.length; i++) {	
			sb.append(" * ");
			sb.append(recommendedMovies[i]);
			sb.append("<div>");
		}
				
		return sb;
	}
	
	/**
	 * Refreshes the GUI screen.
	 */
	public void refreshScreen() {
		
		this.repaint();
		this.revalidate();
	}

	/**
	 * Takes in a StringBuilder, adds "<html>" and "</html>" at the beginning and end respectively. The StringBuilder is then converted into a string and returned.
	 * 
	 * @param sb
	 * @return
	 */
	private String createHTMLString(StringBuilder sb) {

		String middle = sb.toString();

		StringBuilder sb2 = new StringBuilder();

		sb2.append("<html>");
		sb2.append(middle.toString());
		sb2.append("</html>");

		return sb2.toString();
	}
	
	/**
	 * Posts the data retrieved from the Movies Array and the Users Binary Search Tree into the form.
	 * @param result
	 * @param xpos
	 * @param ypos
	 * @param label
	 */
	private void postData(String result, int xpos, int ypos, JLabel label) {
		
		label.setText(result);
		label.setForeground(Color.ORANGE);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setBounds(xpos, ypos, 500, 600);
		contentPane.add(label);
	}	

	//Constructor.
	public GUI() {

		setFont(new Font("Dialog", Font.PLAIN, 10));
		setForeground(Color.ORANGE);
		setTitle("Amazon Movie Reviewer");
		setBackground(new Color(25, 25, 112));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(400,400));
		contentPane.setBackground(new Color(25, 25, 112));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		reviewsLabel.setBounds(22, 168, 500, 700);
		contentPane.add(reviewsLabel);



		this.setSize(800, 450);

		In = new JTextField();
		In.setForeground(new Color(255, 255, 255));
		In.setBackground(new Color(0, 0, 0));
		In.setText(introText);
		In.setBounds(12, 20, 350, 82);
		In.setFont(f);
		In.setMargin(new Insets(0, 20, 0, 0));
		contentPane.add(In);
		In.setColumns(10);
		In.addKeyListener(new KeyListener() {

			

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if (!dataInserted) {
					dataInserted = true;
					In.setText("");
				}

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if (In.getText().isEmpty()) {
					dataInserted = false;
					In.setText(introText);
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});

		btnGo.setFont(new Font("Dialog", Font.BOLD, 20));
		btnGo.setForeground(Color.WHITE);
		btnGo.setBackground(Color.ORANGE);
		btnGo.setBounds(370, 20, 114, 82);
		btnGo.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						if (dataInserted) {
							
							StringBuilder reviewBuilder = new StringBuilder();
							StringBuilder othermovies = new StringBuilder();
							String reviews = null;
							String movies = null;	
							String rating_string = null;
							
							String productID = In.getText();
							
							double rating = Model.getMovieRating(productID);
							
							if (rating > 0) {
								
								rating_string = Double.toString(to2dp(rating));
								getScore.setText(rating_string);
							} else {
								getScore.setText("");
							}
							
							
							//Find Reviews for this product
							ArrayList<Review> topreviews = Model.getTop2Reviews(productID);
							
							if (topreviews == null) {
								
								reviews = "Sorry, No good reviews available for product.";
								movies = "No data available.";
								
								
							} else {
								
								for (Review r : topreviews) {
									
									otherMovies(Model.binaryST.get(r.getUserID()), othermovies);
									
									createReview(reviewBuilder, r);
									
								}
								
								reviews = createHTMLString(reviewBuilder);
								movies = createHTMLString(othermovies);											

							}
							
							postData(reviews, 22, 168, reviewsLabel);
							postData(movies, 500, 100, moviesLabel);
						
							refreshScreen();
							
							
							
						
						}
						
					}
					
				});
		
		contentPane.add(btnGo);
		movieScore.setBounds(22, 68, 200, 100);
		movieScore.setFont(fb);
		movieScore.setVisible(true);
		movieScore.setForeground(Color.WHITE);
		contentPane.add(movieScore);

		getScore.setBounds(142, 68, 200, 100);
		getScore.setFont(f);
		getScore.setForeground(Color.ORANGE);
		getScore.setVisible(true);
		getScore.setForeground(Color.WHITE);
		contentPane.add(getScore);

		lblOutput.setFont(fb);
		lblOutput.setForeground(Color.WHITE);
		lblOutput.setBounds(22, 118, 350, 53);
		contentPane.add(lblOutput);
		


		lblRecommendedMoviesFrom.setFont(fb);
		lblRecommendedMoviesFrom.setForeground(Color.WHITE);
		lblRecommendedMoviesFrom.setBounds(500, 50, 300, 53);
		contentPane.add(lblRecommendedMoviesFrom);

		MovieOut.setForeground(Color.ORANGE);
		MovieOut.setVerticalAlignment(SwingConstants.TOP);
		MovieOut.setHorizontalAlignment(SwingConstants.LEFT);
		MovieOut.setBounds(269, 188, 200, 100);
		contentPane.add(MovieOut);
	}

}
