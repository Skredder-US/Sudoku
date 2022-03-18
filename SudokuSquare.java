import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class SudokuSquare {
	
	public static final int BORDER_THICKNESS = 1; // px
	public static final String FONTNAME = "Segio UI";
	public static final int NUM_BUTTONS = 9;
	
	public SudokuSquare(JFrame frame, int index) {
		JLayeredPane lp = frame.getLayeredPane();
		
		JLabel label = new JLabel("", SwingConstants.CENTER);
		int size = 3 * SudokuButton.SIZE;
		int x = size * (index % (NUM_BUTTONS / 3));
		int y = size * (index / (NUM_BUTTONS / 3));
		label.setBounds(x, y, size, size);
		label.setBorder(new LineBorder(Color.BLACK, BORDER_THICKNESS));
		label.setFont(new Font(FONTNAME, Font.PLAIN, 4 * SudokuButton.FONTSIZE));
		lp.add(label);
		
		SudokuButton[] buttons = new SudokuButton[NUM_BUTTONS];
		for (int i = 0; i < NUM_BUTTONS; i++) {
			buttons[i] = new SudokuButton(x, y, i);

			SudokuButton button = buttons[i];
			buttons[i].addMouseListener(new MouseAdapter() {
				
				@Override
				public void mousePressed(MouseEvent e) {
					if (SwingUtilities.isLeftMouseButton(e)) {
						String number = button.getText();
						if (label.getText().equals(number)) {
							label.setText("");
						} else {
							label.setText(number);
						}
					} else if (SwingUtilities.isRightMouseButton(e)) {
						if (button.isGray) {
							button.setForeground(Color.BLACK);
						} else {
							button.setForeground(Color.GRAY);
						}
						button.isGray = !button.isGray;
					}
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					for (int i = 0; i < NUM_BUTTONS; i++) {
						if (!buttons[i].isGray) {
							buttons[i].setText("");
						}
					}
				}
				
				@Override
	            public void mouseEntered(MouseEvent e) {
					for (int i = 0; i < NUM_BUTTONS; i++) {
						buttons[i].setText("" + (i + 1));
					}
	            } 
				
            });
            
			lp.add(buttons[i], 0);
		}
	}
	
}
