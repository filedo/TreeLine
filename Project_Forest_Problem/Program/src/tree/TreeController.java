package tree;

import java.awt.Point;
import java.awt.event.MouseEvent;

public class TreeController extends mvc.Controller {

		public TreeController()
		{
			super();
		}
		
		// クリックした位置座標をLeafに送信する(安田)
		public void mouseClicked(MouseEvent aMouseEvent)
		{
			Point aPoint = aMouseEvent.getPoint();
			aPoint.translate(view.scrollAmount().x, view.scrollAmount().y);
			// Leaf.???(aPoint)
			return;

	}

}
