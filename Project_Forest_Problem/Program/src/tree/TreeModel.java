package tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
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
	load();
    }
    
    public void perform()
    {
	return;
    }
    
    /**
     * 現在のモードを応答する。
     * @return
     */
    public int getMode() 
    {
	return mode;
    }
    
    /**
     * 現在のモードを設定する。
     * @param mode
     */
    public void setMode(int mode) 
    {
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
	String inFileName = "tree.txt";	 // 入力ファイル名
	
	try {
	    FileInputStream fis = new FileInputStream(inFileName);
	    InputStreamReader isr = new InputStreamReader(fis , "UTF-8");
	    BufferedReader br = new BufferedReader(isr);
	    
	    String line;
	    boolean nodes = false;
	    boolean branches = false;
	    TreeMap<Integer,String> nodesMap = new TreeMap<Integer,String>();
	    TreeMap<Integer,ArrayList<Integer>> branchesMap = new TreeMap<Integer,ArrayList<Integer>>();
	    
	    while((line=br.readLine()) != null) 
		{
		    if(line.equals("nodes:"))
			{
			    nodes = true;
			    branches = false;
			    line=br.readLine();
			}
		    if(line.equals("branches:"))
			{
			    nodes = false;
			    branches = true;
			    line=br.readLine();
			}
		    if(nodes)
		    {
			// 1行の中の改行文字を全て削除し、,で分割
			String[] item = line.replaceAll("¥n", "").split(",");
			// 分割結果の0番目はキー, 1番目はノードの名前
			Integer key = Integer.valueOf(item[0]);
			String nodeName  = item[1];
			// keyが初めて出てきたキーならば、TreeMapの値として追加
			if(!nodesMap.containsKey(key))
			    {
				nodesMap.put(key, nodeName);
			    }
		    }
		/* if(branches)
		    {
		    	String[] item = line.replaceAll("¥n","").split(",");
		    	Integer from = Integer.valueOf(item[0]);
		    	Integer to = Integer.valueOf(item[1]);
		    	if(!branchesMap.containsKey(from))
		    	{
		    		branchesMap.put(from,new ArrayList<Integer>());
		    	}
		    	branchesMap.get(from).add(to);
		    }*/
		}
	    for ( Integer key : nodesMap.keySet() )
	    {
	    	String nodeName = nodesMap.get( key );
	    	aLeaf.setNodeName(nodeName);
	    	aTree.setLeafList(aLeaf);
	    	System.out.println(aTree.getLeafList().size());
	    	System.out.println( key + ": " +  nodeName );
	    }
	    
	    
	    br.close();
	    isr.close();
	    fis.close();
		}
	    catch (FileNotFoundException e) 
	{
	    e.printStackTrace();
	} catch (UnsupportedEncodingException e) 
	{
	    e.printStackTrace();
	} 
	catch (IOException e) 
	{
	    e.printStackTrace();
	}
	return;		
    }
}
