package tree;

import java.awt.Point;
import java.util.ArrayList;

public class Tree {
    /**
     * Leafのインスタンスたちを束縛する。
     */
    private ArrayList<Leaf> aLeafList;
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
}