package tree;

public class TreeView extends mvc.View{
	
	protected TreeModel aTreeModel;
	
	protected TreeController aTreeController;
	
	public TreeView(TreeModel aTreeModel,TreeController aTreeController)
	{		
		super(aTreeModel,aTreeController);
		
	}
}
