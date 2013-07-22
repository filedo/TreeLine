package tree;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 *リーフ。
 */
public class Leaf extends JLabel implements MouseListener
{
    
    /**
     * ノードの名前を束縛する。
     */
    private String nodeName;
    
    /**
     * ノードの番号を束縛する。
     */
    private Integer nodeNumber;
    
    /**
     * ノードの深さを束縛する。
     */
    private Integer nodeDepth;

    /**
     * 次のノードの番号を束縛する。
     */
	private ArrayList<Integer> nextNodeNumber;
	
	/**
	 * 葉に親がいるかどうか
	 */
	private boolean root = true;
	
	/**
	 * 親を束縛する。
	 */
	private Leaf parentLeaf;
	
	/**
	 * 子を束縛する。
	 */
    private ArrayList<Leaf> childLeaves;
    
    /**
     * 子孫を束縛するTreeMap<String:葉の名前, Leaf:葉>
     */
     private TreeMap<String, Leaf> descendantLeaves; 
    
    /**
     * ノードの番号,名前,深さを指定して葉を作るコンストラクタ。
     * @param nodeNumber
     * @param nodeName
     * @param nodeDepth
     */
    public Leaf(Integer nodeNumber,String nodeName,Integer nodeDepth)
    {
        this.nodeNumber=nodeNumber;
        this.nodeName=nodeName;
        this.nodeDepth=nodeDepth;
        this.nextNodeNumber=new ArrayList<Integer>();
        this.childLeaves=new ArrayList<Leaf>();
        this.descendantLeaves=new TreeMap<String, Leaf>();
        this.setText(nodeName);
        this.setFont(new Font("Serif", Font.PLAIN, TreeLiteral.FONT_SIZE));
        this.setBorder(new LineBorder(Color.BLACK,TreeLiteral.BORDERLINE_SIZE,false));
        this.setSize(this.getPreferredSize());
		this.addMouseListener(this);	    	
     }
    
    /**
     * ノードの番号、名前を指定して葉を作るコンストラクタ。
     * ノードの深さを指定しない。
     * @param nodeNumber ノード番号
     * @param nodeName	ノードの名前
     */
    public Leaf(Integer nodeNumber, String nodeName)
    {
    	this(nodeNumber, nodeName, null);
    	System.out.println(nodeNumber + " " + nodeName +  "ノードの深さが未設定です。");
    }
    
    public boolean isRoot() {
    	return this.root;
    }
    
    /**
     * 葉に親を束縛する。
     * 親がいれば根では無いので、rootをfalseにする。
     * @param aLeaf 葉の親
     */
    public void addParent(Leaf aLeaf) { 
    	this.parentLeaf = aLeaf;
    	this.root = false;
    }
    
    /**
     * 葉に子の情報を追加する。
     * @param leaf 葉の子
     */
    public void addChildLeaf(Leaf aLeaf)
    {
    	childLeaves.add(aLeaf);
    } 
    
    public Leaf getParentLeaf() {
    	return this.parentLeaf;
    }
    
    /**
     * 子の情報を返す。
     * @return 子の葉(Leaf)のArrayList
     */
    public ArrayList<Leaf> getChildLeaves()
    {
    	return this.childLeaves;
    }
    
    /**
     * ある葉が持つ子孫を全てTreeMapに登録するための再帰メソッド
     * @param aLeaf 葉
     * @param descendantLeaves 葉を登録するTreeMap
     */
    private void addDescendantMap(Leaf aLeaf, TreeMap<String, Leaf> descendantLeaves)
    {
    	// 子がいる限りこのメソッドを再帰呼び出しする。
    	for (Leaf aChildLeaf : aLeaf.getChildLeaves()) 
    	{
    		this.addDescendantMap(aChildLeaf, descendantLeaves);
    	}
    	// ダブり防止の為、自分(最初にこのメソッドを呼んだ葉)は登録しないようにする。
    	if (aLeaf != this) 
    	{
    		descendantLeaves.put(aLeaf.getNodeName(), aLeaf);
    	}
    	return;
    }
    
    /**
     * 葉が持つ子孫を葉の名前をキーとし、葉を値としてTreeMapに追加する。
     * 葉に子供の情報を持たせてから呼ぶ。
     */
    public void setDescendantLeaves()
    {
    	this.addDescendantMap(this, this.descendantLeaves);
    	// デバッグ用
    	System.out.println("  " + this.nodeName);
    	for (Map.Entry<String, Leaf> entry: this.descendantLeaves.entrySet())
    	{
    		System.out.println("   " + entry.getKey() + " : " + entry.getValue());
		}
    }
    
    /**
     * この葉の子孫を取得する。
     * @return 子孫が登録されたTreeMap <葉の名前, 葉への参照>
     */
    public TreeMap<String, Leaf> getDescendantLeaves()
    {
    	return this.descendantLeaves;
    }
    
    public void outPosition() {
    	System.out.println("x="+this.getX()+" y="+this.getY()+" width="+this.getWidth()+" height="+this.getHeight()+" :"+nodeName);
    	return;
    }
    
    public void setPosition(int x, int y)
    {	
    	this.setBounds(x ,y, this.getWidth(), this.getHeight());
    }
    
    /**
     * 樹上整列前のノードの位置を設定する。nはノード数。
     * @param n
     */
    public void setDefaultPosition(int n,int x,int y)
    {
    	this.setBounds(0 + x , (this.getHeight() * n + TreeLiteral.HEIGHT_INTERVAL * n) + y, this.getWidth(), this.getHeight());
//    	System.out.println("x="+this.getX()+" y="+this.getY()+" width="+this.getWidth()+" height="+this.getHeight()+" :"+nodeName);
    	return;
    }
    
    /**
     * ノードの位置を応答する。
     * @return Rectangle ノードの位置(x, y)、幅(width)、高さ(height)
     */
    public Rectangle getPosition()
    {
    	return this.getBounds();
    }
    
    /**
     * ノードの名前を応答する。
     * @return
     */
    public String getNodeName()
    {
    	return this.nodeName;
    }
    
    /**
     * ノードの名前を設定する。
     * @param nodeName
     */
    public void setNodeName(String nodeName) 
    {
    	this.nodeName = nodeName;
        return;
    }
    /**
     * ノードの番号を応答する。
     * @return
     */
    public Integer getNodeNumber() 
    {
    	return this.nodeNumber;
    }
    /**
     * ノードの番号を設定する。
     * @param nodeNumber
     */
    public void setNodeNumber(Integer nodeNumber)
    {
    	this.nodeNumber = nodeNumber;
        return;
    }
    
    public void setNextNodeNumber(Integer nextNodeNumber)
    {
    	nextNodeNumber++;
    	this.nextNodeNumber.add(nextNodeNumber);
    	return;
    }
    public ArrayList<Integer> getNextNodeNumber()
    {
    	return nextNodeNumber;
    }
    
    /**
     * ノードの深さを応答する。
     * @return
     */
	public Integer getNodeDepth()
	{
		return nodeDepth;
	}
	/**
	 * ノードの深さを設定する。
	 * @param nodeDepth
	 */
	public void setNodeDepth(Integer nodeDepth)
	{
		this.nodeDepth = nodeDepth;
		return;
	}	
	
	/**
	 * ノードの名前を標準出力する。
	 */
	 public void mouseClicked(MouseEvent aMouseEvent)
	 {
	    System.out.println(nodeName);
	 }
	 
	 /**
	  *何もしない。 
	  */
	public void mouseExited(MouseEvent aMouseEvent) 
	{
		
	}
	
	/**
	 * マウスカーサの形状をデフォルトに戻す。
	 */
	public void mousePressed(MouseEvent aMouseEvent) 
	{
		Cursor aCursor = Cursor.getDefaultCursor();
		Component aComponent = (Component)aMouseEvent.getSource();
		aComponent.setCursor(aCursor);
	}
	
	/**
	 * マウスカーサの形状を手に変化させる。
	 */
	public void mouseReleased(MouseEvent aMouseEvent)
	{
		Cursor aCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
		Component aComponent = (Component)aMouseEvent.getSource();
		aComponent.setCursor(aCursor);		
	}
	
	/**
	 * マウスカーサの形状を手に変化させる。
	 */
	public void mouseEntered(MouseEvent aMouseEvent) 
	{
		Cursor aCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
		Component aComponent = (Component)aMouseEvent.getSource();
		aComponent.setCursor(aCursor);	
	}

}
