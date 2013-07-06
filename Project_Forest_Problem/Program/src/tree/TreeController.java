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
			System.out.println(aTreeModel.getTree().getLeafList().get(4).getNodeName());
			
			return;
		}

		public void mouseDragged(MouseEvent aMouseEvent)
		{
			return;
		}
		/**
		 *  指定されたモデルをインスタンス変数aTreeModelに設定する。
		 * @param aTreeModel
		 */
		public void setModel(TreeModel aTreeModel){
			this.aTreeModel = aTreeModel;
            return;
		}
		/**
		 *  指定されたビューをインスタンス変数aTreeViewに設定する。
		 * @param aTreeView
		 */
		public void setView(TreeView aTreeView){
			this.aTreeView = aTreeView;
            return;
		}
}
