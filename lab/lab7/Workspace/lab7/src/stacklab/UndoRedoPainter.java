package stacklab;

import java.util.*;


public class UndoRedoPainter extends Painter
{
	public UndoRedoPainter()
	{
		setUndoButtonEnabled(false);
		setRedoButtonEnabled(false);
	}
	// Called when the user pushes the Undo button.
	void undo()
	{
		setRedoButtonEnabled(true);
		Stack<Circle> undoStack = this.getHistory();
		if(!undoStack.isEmpty())
		{
			Circle undoCircle = undoStack.pop();
			this.getUndoHistory().push(undoCircle);
			repaint();
		}
		else
			setUndoButtonEnabled(false);
	}


	// Called when the user pushes the Redo button.
	void redo()
	{
		Stack<Circle> undoHist = this.getUndoHistory();
		if(!undoHist.isEmpty())
		{
			Circle redoCircle = undoHist.pop();
			this.getHistory().push(redoCircle);
			repaint();
		}
		else
			setRedoButtonEnabled(false);

	}
	
	
	public static void main(String[] args)
	{
		new UndoRedoPainter().setVisible(true);
	}
}
