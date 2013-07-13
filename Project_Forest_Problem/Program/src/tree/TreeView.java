package tree;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

/**
 * ツリービュー。
 */
public class TreeView extends mvc.View
{
	/**
	 * TreeModelを束縛する。
	 */
	protected TreeModel aTreeModel;
	
	/**
	 * TreeControllerを束縛する。
	 */
	protected TreeController aTreeController;
	
	/**
	 * スクロール量としてPointのインスタンスを束縛する。
	 */
	private Point offset;
	
	/**
	 * インスタンスを生成して応答する。
	 * 指定されたツリーモデルの依存物となり、ツリーコントローラを作り、ツリーモデルとツリービューを設定し、スクロール量を(0, 0)に設定する。
	 * @param aTreeModel
	 * @param aTreeController
	 */
	public TreeView(TreeModel aTreeModel,TreeController aTreeController)
	{		
		super(aTreeModel,aTreeController);
		this.aTreeModel=aTreeModel;
		this.aTreeController=aTreeController;
		this.aTreeController.setView(this);
		this.aTreeController.setModel(aTreeModel);
		offset = new Point(0, 0);
	}
	
	private void calcPosition(Leaf aLeaf, int count)
	{
		if (aLeaf.isRoot())
		{	
			if (!aLeaf.getChildLeaves().isEmpty()) {
//				for (Leaf childLeaf : aLeaf.getChildLeaves()) {
//					calcPosition(childLeaf);	
//				}
				calcPosition(aLeaf.getChildLeaves().get(0), 0);
			}
		}
		else
		{	
			System.out.println(aLeaf.getNodeName());
			Leaf parentLeaf = aLeaf.getParentLeaf();
			Rectangle parentLeafPos = parentLeaf.getPosition();
			int x = parentLeafPos.x + parentLeafPos.width + TreeLiteral.WIDTH_INTERVAL;
			int y = parentLeafPos.y + (parentLeafPos.height + TreeLiteral.HEIGHT_INTERVAL) * count;
			aLeaf.setPosition(x, y);
			this.add(aLeaf);
			if (!aLeaf.getChildLeaves().isEmpty())
			{	
//				calcPosition(aLeaf.getChildLeaves().get(0));
				int i=0;
				for (Leaf childLeaf : aLeaf.getChildLeaves()) {
					calcPosition(childLeaf, i);
					
					i++;
				}
				
//				int childsize = aLeaf.getChildLeaves().size();
//				int center = (aLeaf.getPosition().height * childsize + TreeLiteral.HEIGHT_INTERVAL * (childsize - 1)) / childsize;
//				y = center - (aLeaf.getPosition().height / 2);
//				aLeaf.setPosition(x, y);
			}else{
				return;
			}
		}
		this.add(aLeaf);
		aLeaf.outPosition();
	}
	/**
	 * 指定されたグラフィクスに背景色（白色）でツリービュー全体を塗り、
	 * その後にスクロール量（offset）を考慮してリーフとブランチを描画する。
	 */
	public void paintComponent(Graphics aGraphics)
	{
		int width;
		int height;
		int n=0;
		width = this.getWidth();
		height = this.getHeight();
		aGraphics.setColor(Color.white);
		aGraphics.fillRect(0, 0, width, height);
		System.out.println(aTreeModel.getTree().getLeafList().size());
		for ( Leaf aLeaf : aTreeModel.getTree().getLeafList() )
		{
			if (aLeaf.isRoot()) {
				aLeaf.setDefaultPosition(0, offset.x, offset.y);
				calcPosition(aLeaf, 0);
			} 
//			aLeaf.setDefaultPosition(n,offset.x,offset.y);
//			this.add(aLeaf);
			n++;
	    }
		for ( Branch aBranch : aTreeModel.getTree().getBranchList() )
		{
			aGraphics.setColor(Color.black);
			Leaf from = aTreeModel.getTree().getLeafList().get(aBranch.getBranchFrom()-1);
			Leaf to = aTreeModel.getTree().getLeafList().get(aBranch.getBranchTo()-1);
			aGraphics.drawLine(from.getBounds().x+from.getSize().width, from.getBounds().y+from.getSize().height/2,
								to.getBounds().x, to.getBounds().y+to.getSize().height/2);
		}
		return;
	}

	/**
	 * スクロール量（offsetの逆向きの大きさ）を応答する。
	 */
	public Point scrollAmount()
	{
		int x = 0 - offset.x;
		int y = 0 - offset.y;
		return (new Point(x, y));
	}
	
	/**
	 * スクロール量を指定された座標分だけ相対スクロールする。
	 */
	public void scrollBy(Point aPoint)
	{
		int x = offset.x + aPoint.x;
		int y = offset.y + aPoint.y;
		this.scrollTo(new Point(x, y));
		return;
	}

	/**
	 * スクロール量を指定された座標に設定（絶対スクロール）する。
	 */
	public void scrollTo(Point aPoint)
	{
		offset = aPoint;
		return;
	}

}
