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
		
	}
	/**
	 * 樹上整列の座標を求める。
	 * @return
	 */
	public Point treeDesign()
	{
		return aPoint;
	}
}