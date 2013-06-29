package tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

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
	
	public ArrayList<Leaf> load()
	{
	/*	String inFileName = "../../Requirement/texts/tree.txt";	 // 入力ファイル名

		try {
			FileInputStream fis = new FileInputStream(inFileName);
			InputStreamReader isr = new InputStreamReader(fis , "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			
			br.close();
			isr.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		return null;
		
	}
}
