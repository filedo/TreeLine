package tree;

public class Branch {

    /**
     * 枝の根元を束縛する。
     */
    private int from;

    /**
     * 枝の終端を束縛する。
     */
    private int to;
    
    /**
     * Branchのコンストラクタ。
     */
    public Branch()
    {
	this.from=0;
	this.to=0;
    }
    
    /**
     * 枝の根元を応答する。
     * @return
     */
    public int getBranchFrom(){
	return this.from;
    }

    /**
     * 枝の根元を設定する。
     * @param from
     */
    public void setBranchFrom(int from){
	this.from = from;
	return;
    }

    /**
     * 枝の終端を応答する。
     * @return
     */
    public int getBranchTo(){
	return this.to;
    }

    /**
     * 枝の終端を設定する。
     * @param to
     */
    public void setBranchTo(int to){
	this.to = to;
	return;
    }



}