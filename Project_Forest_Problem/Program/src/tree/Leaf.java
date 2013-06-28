package tree;

public class Leaf {

	/**
	 * ノードの名前を束縛する。
	 */
	private String nodeName;

	/**
	 * ノードの名前を応答する。
	 * @return
	 */
	public String getNodeName() {
		return nodeName;
	}

	/**
	 * ノードの名前を設定する。
	 * @param nodeName
	 */
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	
}
