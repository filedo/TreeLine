package tree;

import java.awt.Point;
import java.awt.event.MouseEvent;

public class TreeController extends mvc.Controller {
	
	protected TreeModel aTreeModel;
	
	protected TreeView aTreeView;

		public TreeController()
		{
			super();
		}
		
		/**
		 * 指定されたマウスイベントからマウスカーサの位置を獲得して、モデル座標系でのクリック位置を割り出して、
		 * Leafに位置座標の情報を送信する。
		 */
		public void mouseClicked(MouseEvent aMouseEvent)
		{
			Point aPoint = aMouseEvent.getPoint();
			aPoint.translate(view.scrollAmount().x, view.scrollAmount().y);
			// Leaf.???(aPoint)
			return;
		}

		public void mouseDragged(MouseEvent aMouseEvent)
		{
			return;
		}
		
}
