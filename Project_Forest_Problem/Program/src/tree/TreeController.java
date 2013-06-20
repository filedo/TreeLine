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
		
		// �N���b�N�����ʒu���W��Leaf�ɑ��M����(���c)
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
