package tree;

import java.awt.Point;
import java.util.ArrayList;

public class Tree 
{
    /**
     * Leafのインスタンスたちを束縛する。
     */
    private ArrayList<Leaf> aLeafList;
    /**
     * Branchのインスタンスたちを束縛する。
     */
    private ArrayList<Branch> aBranchList;
    /**
     * 枝を束縛する。
     */
    private Branch aBranch;
    /**
     * 葉を束縛する。
     */
    private Leaf aLeaf;
    
    /**
     * 樹上整列の座標を束縛する。
     */
    private Point aPoint;
    
    public Tree()
    {
    	aLeafList = new ArrayList<Leaf>();	
    	aBranchList = new ArrayList<Branch>();
    }
    /**
     * 樹上整列の座標を求める。
     * @return
     */
    public Point treeDesign()
    {
    	return aPoint;
    }
    /**
     * 葉を設定する。
     * @param aLeaf
     */
    public void setLeaf(Leaf aLeaf)
    {
        this.aLeaf = aLeaf;
        return;
    }
    /**
     * 葉を応答する。
     * @return
     */
    public Leaf getLeaf()
    {
        return this.aLeaf;
    }
    /**
     * 葉をリストに追加する。
     * @param aLeaf
     */
    public void addLeafList(Leaf aLeaf)
    {
        aLeafList.add(aLeaf);
        return;
    }
    /**
     * 葉のリストを応答する。
     * @return
     */
    public ArrayList<Leaf> getLeafList()
    {
		return this.aLeafList;
    }
    /**
     * 枝を応答する。
     * @return
     */
	public Branch getBranch() 
	{
		return aBranch;
	}
	/**
	 * 枝を設定する。
	 * @param aBranch
	 */
	public void setBranch(Branch aBranch) 
	{
		this.aBranch = aBranch;
		return;
	}
	/**
	 * 枝のリストを応答する。
	 * @return
	 */
	public ArrayList<Branch> getBranchList()
	{
		return aBranchList;
	}
	/**
	 * 枝をリストに追加する。
	 * @param aBranch
	 */
	public void addBranchList(Branch aBranch) 
	{
		aBranchList.add(aBranch);
		return;
	}
}