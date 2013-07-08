package tree;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Leaf extends JLabel{
    
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
    
    public Leaf(Integer nodeNumber,String nodeName,Integer nodeDepth)
    {
        this.nodeNumber=nodeNumber;
        this.nodeName=nodeName;
        this.nodeDepth=nodeDepth;
        this.setText(nodeName);
        this.setFont(new Font("Serif", Font.PLAIN, TreeLiteral.FONT_SIZE));
        this.setBorder(new LineBorder(Color.BLACK,TreeLiteral.BORDERLINE_SIZE,false));
        this.setSize(this.getPreferredSize());
    }
    /**
     * 樹上整列前のノードの位置を設定する。nはノード数。
     * @param n
     */
    public void setDefaultPosition(int n)
    {
    	this.setBounds(0 , this.getHeight() * n + TreeLiteral.HEIGHT_INTERVAL * n, this.getWidth(), this.getHeight());
    	System.out.println("x="+this.getX()+" y="+this.getY()+" width="+this.getWidth()+" height="+this.getHeight()+" :"+nodeName);
    	return;
    }
    /**
     * ノードの名前を応答する。
     * @return
     */
    public String getNodeName() {
	return this.nodeName;
    }
    
    /**
     * ノードの名前を設定する。
     * @param nodeName
     */
    public void setNodeName(String nodeName) {
	this.nodeName = nodeName;
        return;
    }
    /**
     * ノードの番号を応答する。
     * @return
     */
    public Integer getNodeNumber() {
	return this.nodeNumber;
    }
    /**
     * ノードの番号を設定する。
     * @param nodeNumber
     */
    public void setNodeNumber(Integer nodeNumber) {
	this.nodeNumber = nodeNumber;
        return;
    }
    /**
     * ノードの深さを応答する。
     * @return
     */
	public Integer getNodeDepth() {
		return nodeDepth;
	}
	/**
	 * ノードの深さを設定する。
	 * @param nodeDepth
	 */
	public void setNodeDepth(Integer nodeDepth) {
		this.nodeDepth = nodeDepth;
		return;
	}   
}
