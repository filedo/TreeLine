package tree;

public class TreeView extends mvc.View{
	/**
	 * TreeModelを束縛する。
	 */
	protected TreeModel aTreeModel;
	/**
	 * TreeControllerを束縛する。
	 */
	protected TreeController aTreeController;
	
	public TreeView(TreeModel aTreeModel)
	{
		super(aTreeModel);
	}
	
	public TreeView(TreeModel aTreeModel,TreeController aTreeController)
	{		
		super(aTreeModel,aTreeController);
		this.aTreeModel=aTreeModel;
		this.aTreeController=aTreeController;
		this.aTreeController.setView(this);
		this.aTreeController.setModel(aTreeModel);
	}
}
