import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class SudokuButton extends JButton {
	
	public static final int SIZE = 33; // px
	public static final int FONTSIZE = 16;
	
	protected boolean isGray;
	
	public SudokuButton(int x, int y, int index) {
		super();
		
		isGray = false;
		
		setBounds(x + SIZE * (index % (SudokuSquare.NUM_BUTTONS / 3)),
				y + SIZE * (index / (SudokuSquare.NUM_BUTTONS / 3)), SIZE, SIZE);
	    setMargin(new Insets(0,0,0,0));
		setFont(new Font(SudokuSquare.FONTNAME, Font.PLAIN, FONTSIZE));
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusPainted(false);
	}
	
}
