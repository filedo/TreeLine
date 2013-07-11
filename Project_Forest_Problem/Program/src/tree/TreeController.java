package tree;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 * ツリーコントローラー。
 */
public class TreeController extends mvc.Controller 
{
	
	/**
	 * TreeModelを束縛する。
	 */
	protected TreeModel aTreeModel;
	
	/**
	 * TreeViewを束縛する。
	 */
	protected TreeView aTreeView;

	/**
	 * 以前にマウスのボタンが押下された場所をPointのインスタンスとして束縛する。
	 */
	private Point previous;
	
	/**
	 * 現在にマウスのボタンが押下された場所をPointのインスタンスとして束縛する。
	 */
	private Point current;

	/**
	 * インスタンスを生成して応答する。
	 * すべてのインスタンス変数（aTreeModel, aTreeView, previous, current）をnull化する。
	 */
	public TreeController()
	{
		super();
		aTreeModel=null;
		aTreeView=null;
		previous = null;
		current = null;
	}
		
	/**
	 * 指定されたマウスイベントからマウスカーサの位置を獲得して、モデル座標系でのクリック位置を割り出して、
	 * Leafに位置座標の情報を送信する。
	 */
	public void mouseClicked(MouseEvent aMouseEvent)
	{
		//描画完了したら
		//if(aTreeModel.getMode() == TreeLiteral.END){
		Point aPoint = aMouseEvent.getPoint();
		aPoint.translate(view.scrollAmount().x, view.scrollAmount().y);
		//}
		return;
	}
	
	/**
	 * マウスカーサの形状を移動の形に変化させ、指定されたマウスイベントからマウスカーサの位置を獲得して、
	 * インスタンス変数currentに設定すると共に、以前のマウスカーサの位置からの差分を計算する。
	 * そして、その差分だけビューに対してスクロールを依頼し、その後にビューの再描画を依頼する。
	 * 最後にインスタンス変数previousをインスタンス変数currentに更新する。
	 */
	public void mouseDragged(MouseEvent aMouseEvent)
	{
		Cursor aCursor = Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR);
		Component aComponent = (Component)aMouseEvent.getSource();
		aComponent.setCursor(aCursor);
		current = aMouseEvent.getPoint();
		int x = current.x - previous.x;
		int y = current.y - previous.y;
		Point point = new Point(x, y);
		aTreeView.scrollBy(point);
		aTreeView.repaint();
		previous = current;
		return;
	}
	
	/**
	 * マウスカーサの形状を十字に変化させ、指定されたマウスイベントからマウスカーサの位置を獲得して、
	 * インスタンス変数currentに設定する共にインスタンス変数previousをインスタンス変数currentに更新する。
	 */
	public void mousePressed(MouseEvent aMouseEvent)
	{
		Cursor aCursor = Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);
		Component aComponent = (Component)aMouseEvent.getSource();
		aComponent.setCursor(aCursor);
		current = aMouseEvent.getPoint();
		previous = current;
		return;
	}

	/**
	 * マウスカーサの形状をデフォルトに戻し、指定されたマウスイベントからマウスカーサの位置を獲得して、
	 * インスタンス変数currentに設定する共にインスタンス変数previousをインスタンス変数currentに更新する。
	 */
	public void mouseReleased(MouseEvent aMouseEvent)
	{
		Cursor aCursor = Cursor.getDefaultCursor();
		Component aComponent = (Component)aMouseEvent.getSource();
		aComponent.setCursor(aCursor);
		current = aMouseEvent.getPoint();
		previous = current;
		return;
	}
	
	/**
	 *  指定されたモデルをインスタンス変数aTreeModelに設定する。
	 * @param aTreeModel
	 */
	public void setModel(TreeModel aTreeModel)
	{
		this.aTreeModel = aTreeModel;
        return;
	}
	
	/**
	 * 指定されたビューをインスタンス変数aTreeViewに設定し、
	 * ツリービューのマウスのリスナおよびモーションリスナそしてホイールリスナをこのコントローラにする。
	 * @param aTreeView
	 */
	public void setView(TreeView aTreeView)
	{
		this.aTreeView = aTreeView;
		aTreeView.addMouseListener(this);
		aTreeView.addMouseMotionListener(this);
		aTreeView.addMouseWheelListener(this);
        return;	
    }
}
