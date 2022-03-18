import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class SudokuBigSquare {

	public static final int NUM_SQUARES = SudokuSquare.NUM_BUTTONS;
	
	public SudokuBigSquare(JFrame frame, int index) {
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK, 3));
		frame.add(panel); 
		
		for (int i = 0; i < NUM_SQUARES; i++) {
			new SudokuSquare(frame, i);
		}
	}
	
}
