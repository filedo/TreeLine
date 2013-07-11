package tree;

/**
 * ブランチ。
 */
public class Branch 
{

    /**
     * 枝の根元を束縛する。
     */
    private Integer from;

    /**
     * 枝の終端を束縛する。
     */
    private Integer to;
    
    /**
     * 始点と終点を指定してブランチを作るコンストラクタ。
     */
    public Branch(Integer from,Integer to)
    {
    	this.from=from;
    	this.to=to;
    }
    
    /**
     * 枝の根元を応答する。
     * @return
     */
    public Integer getBranchFrom()
    {
    	return this.from;
    }

    /**
     * 枝の根元を設定する。
     * @param from
     */
    public void setBranchFrom(Integer from)
    {
    	this.from = from;	
    	return;
    }

    /**
     * 枝の終端を応答する。
     * @return
     */
    public Integer getBranchTo()
    {
    	return this.to;
    }

    /**
     * 枝の終端を設定する。
     * @param to
     */
    public void setBranchTo(Integer to)
    {
    	this.to = to;
    	return;
    }
}