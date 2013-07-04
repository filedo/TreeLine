package tree;

public class Leaf {
    
    /**
     * ノードの名前を束縛する。
     */
    private String nodeName;
    /**
     * ノードの番号を束縛する。
     */
    private Integer nodeNumber;
    
    public Leaf()
    {
        this.nodeNumber=null;
        this.nodeName=null;
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
}
