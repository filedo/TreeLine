package tree;

import java.awt.Point;
import java.util.ArrayList;

public class Tree {
	/**
	 * Leafのインスタンスたちを束縛する。
	 */
	private ArrayList<Leaf> aLeafList;
	
	/**
	 * 樹上整列の座標を束縛する。
	 */
	private Point aPoint;
	
	public Tree()
	{
		aLeafList = new ArrayList<Leaf>();		
	}
	/**
	 * 樹上整列の座標を求める。
	 * @return
	 */
	public Point treeDesign()
	{
		return aPoint;
	}
	
	public void setLeafList(Leaf aLeaf)
	{
		aLeafList.add(aLeaf);
	}
	public ArrayList<Leaf> getLeafList()
	{
		return aLeafList;
	}
}