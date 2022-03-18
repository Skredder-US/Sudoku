import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Sudoku {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Sudoku");
	    frame.setSize(316, 339);
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null);
	    
	    new SudokuBigSquare(frame, 0);
	    
	    frame.setVisible(true);
	}

}
