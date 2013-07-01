package tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.TreeMap;

public class TreeModel extends mvc.Model{
	/**
	 * 現在のモードを束縛する。
	 */
	private int mode;
	/**
	 * 木を束縛する。
	 */
	private Tree aTree;
	/**
	 * 葉を束縛する。
	 */
	private Leaf aLeaf;
	
	public TreeModel()
	{
		super();
		aTree=new Tree();
		aLeaf=new Leaf();
		aLeaf.setNodeName("test");
		//load();
	}

	public void perform()
	{
		return;
	}

	/**
	 * 現在のモードを応答する。
	 * @return
	 */
	public int getMode() {
		return mode;
	}

	/**
	 * 現在のモードを設定する。
	 * @param mode
	 */
	public void setMode(int mode) {
		this.mode = mode;
	}
	/**
	 * 木を応答する。
	 * @return
	 */
	public Tree getTree()
	{
		return aTree;
	}
	/**
	 * 葉を応答する。
	 * @return
	 */
	public Leaf getLeaf()
	{
		return aLeaf;
	}
	
	public void load()
	{
	/*ちゃんと読み込めていない
	  
	 String inFileName = "tree.txt";	 // 入力ファイル名

		try {
			FileInputStream fis = new FileInputStream(inFileName);
			InputStreamReader isr = new InputStreamReader(fis , "UTF-8");
			BufferedReader br = new BufferedReader(isr);

	String line;
	TreeMap<Integer,String> aTreeMap = new TreeMap<Integer,String>();
	while((line=br.readLine()) != null) 
	{
		if(line.equals("nodes"))
		{
		// 1行の中の改行文字を全て削除し、タブで分割
		String[] item = line.replaceAll("\n", "").replaceAll(",","").split("\t");
		// 分割結果の0番目は画像ファイル名, 1番目は人数(Integerに変換)
		Integer key = Integer.valueOf(item[0]);
		String nodeName  = item[1];
		// keyが初めて出てきたキーならば、ArrayListを初期化してTreeMapの値として追加
		if(!aTreeMap.containsKey(key))
			{
			aTreeMap.put(key, nodeName);
		}
		}
	}
			System.out.println(aTreeMap.get(1));
			br.close();
			isr.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
		*/
	}
}
