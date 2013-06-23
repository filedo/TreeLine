package tree;

public class TreeModel extends mvc.Model{
	/**
	 * 現在のモードを束縛する。
	 */
	private int mode;
	
	public TreeModel()
	{
		super();
	}

	public void perform()
	{
		return;
	}

	/**
	 * 現在のモードを応答する。
	 * @return
	 */
	public int getMode() {
		return mode;
	}

	/**
	 * 現在のモードを設定する。
	 * @param mode
	 */
	public void setMode(int mode) {
		this.mode = mode;
	}
	
}
