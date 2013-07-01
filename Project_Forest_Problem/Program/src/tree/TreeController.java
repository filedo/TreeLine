package tree;

import java.awt.Point;
import java.awt.event.MouseEvent;

public class TreeController extends mvc.Controller {
	
	/**
	 * TreeModelを束縛する。
	 */
	protected TreeModel aTreeModel;
	
	/**
	 * TreeViewを束縛する。
	 */
	protected TreeView aTreeView;

		public TreeController()
		{
			super();
			aTreeModel=null;
			aTreeView=null;
		}
		
		/**
		 * 指定されたマウスイベントからマウスカーサの位置を獲得して、モデル座標系でのクリック位置を割り出して、
		 * Leafに位置座標の情報を送信する。
		 */
		public void mouseClicked(MouseEvent aMouseEvent)
		{
			Point aPoint = aMouseEvent.getPoint();
			aPoint.translate(view.scrollAmount().x, view.scrollAmount().y);
			System.out.println(aPoint);
			System.out.println(aTreeModel.getLeaf().getNodeName());
			
			return;
		}

		public void mouseDragged(MouseEvent aMouseEvent)
		{
			return;
		}
		public void setModel(TreeModel aTreeModel){
			this.aTreeModel = aTreeModel;
		}
		public void setView(TreeView aTreeView){
			this.aTreeView = aTreeView;
		}
}
