package tree;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class TreeView extends mvc.View{
	/**
	 * TreeModelを束縛する。
	 */
	protected TreeModel aTreeModel;
	/**
	 * TreeControllerを束縛する。
	 */
	protected TreeController aTreeController;
	
	public TreeView(TreeModel aTreeModel)
	{
		super(aTreeModel);
	}
	
	public TreeView(TreeModel aTreeModel,TreeController aTreeController)
	{		
		super(aTreeModel,aTreeController);
		this.aTreeModel=aTreeModel;
		this.aTreeController=aTreeController;
		this.aTreeController.setView(this);
		this.aTreeController.setModel(aTreeModel);
	}
	public void paintComponent(Graphics aGraphics)
	{
		int width;
		int height;
		int n=0;
		width = this.getWidth();
		height = this.getHeight();
		aGraphics.setColor(Color.white);
		aGraphics.fillRect(0, 0, width, height);
		for ( Leaf aLeaf : aTreeModel.getTree().getLeafList() )
		{
		aLeaf.setDefaultPosition(n);
		this.add(aLeaf);
		n++;
	    }
		return;
	}
}
