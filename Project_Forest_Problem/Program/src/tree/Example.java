package tree;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Example extends Object{
	
	public static void main(String[] args)
	{
		TreeModel aTreeModel = new TreeModel();
		TreeController aTreeController = new TreeController();
		TreeView aTreeView = new TreeView(aTreeModel, aTreeController);

		JFrame aWindow;
		aWindow = new JFrame("TreeLine");
		aWindow.getContentPane().add(aTreeView);
		aWindow.setMinimumSize(new Dimension(400, 300));
		aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aWindow.setSize(800, 800);
		aWindow.setLocation((200), (100));
		aWindow.setVisible(true);
	}
}


