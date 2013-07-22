package tree;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * 例題プログラム。
 */
public class Example extends Object
{
	/**
	 * TreeModel、TreeController、TreeViewクラスを作成。
	 * その後Windowを作成している。
	 */
	public static void main(String[] args)
	{
		String fileName = args[0];  
		
		TreeModel aTreeModel = new TreeModel(fileName);
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


