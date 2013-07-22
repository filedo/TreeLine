package tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * ツリーモデル。
 */
public class TreeModel extends mvc.Model
{
    /**
     * 木を束縛する。
     */
    private Tree aTree;
    
    /**
     * インスタンスを生成して、テキストファイルを読み込む。
     */
    public TreeModel(String fileName)
    {
        super();
        aTree=new Tree();
        this.load(fileName);
    }
  
    /**
     * 木を応答する。
     * @return aTree 木
     */
    public Tree getTree()
    {
        return this.aTree;
    }
    
    /**
     * ファイルを読み込む。
     */
    public void load(String fileName)
    {
        //カレントディレクトリを取得 テスト用
        File currentDirectory = new File(".");
        System.out.println(currentDirectory.getAbsolutePath());
        
        String inFileName = "../../Requirement/texts/"+fileName;	 // 入力ファイル名
        
        try 
        {
            FileInputStream fis = new FileInputStream(inFileName);
            InputStreamReader isr = new InputStreamReader(fis , "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            
            String line;
            boolean nodes = false;
            boolean branches = false;
            boolean trees = false;
            TreeMap<Integer,String> nodesMap = new TreeMap<Integer,String>();
            ArrayList<Integer> nodeDepthList = new ArrayList<Integer>();
            
            while((line=br.readLine()) != null)
            {
                if(line.equals("trees:"))
                {
                    branches = false;
                    nodes = false;
                    trees = true;
                    line=br.readLine();
                }
                if(line.equals("nodes:"))
                {
                    branches = false;
                    nodes = true;
                    trees = false;
                    line=br.readLine();
                }
                if(line.equals("branches:"))
                {
                    branches = true;
                    nodes = false;
                    trees = false;
                    line=br.readLine();
                }
                if(trees)
                {
                    Integer nodeDepth = 0;
                    String nodeName;
                    
                    // 一行の中の改行文字を全て削除し、"|--"で分割
                    String[] item = line.replaceAll("\n","").split("\\|-- ");
                    if (item.length == 1) 
                    {
                        // 深さ0のとき
                        nodeDepth = 0;
                        nodeName = item[0];
                        nodeDepthList.add(nodeDepth);
                    }
                    else
                    {
                        // 深さ0以外のとき
                        // 深さ = 分割後の配列の長さ - 1
                        nodeDepth = item.length - 1;
                        nodeName = item[item.length - 1];
                        nodeDepthList.add(nodeDepth);
                    }
                }
                
                if(nodes)
                {
                    // 1行の中の改行文字を全て削除し、,で分割
                    String[] item = line.replaceAll("¥n", "").split(", ");
                    // 分割結果の0番目はキー, 1番目はノードの名前
                    Integer key = Integer.valueOf(item[0]);
                    String nodeName  = item[1];
                    // keyが初めて出てきたキーならば、TreeMapの値として追加
                    if(!nodesMap.containsKey(key))
                    {
                        nodesMap.put(key, nodeName);
                    }
                    Leaf aLeaf = new Leaf(key, nodeName);
                    aTree.addLeafList(aLeaf);
                }
                if(branches)
                {
                	String[] item = line.replaceAll("¥n","").split(", ");
                    Integer from = Integer.valueOf(item[0]);
                   	Integer to = Integer.valueOf(item[1]);
                   	try
                   	{
                   		Leaf aLeaf = aTree.getLeafList().get(from-1);
                   		Leaf childLeaf = aTree.getLeafList().get(to-1);
                   		aLeaf.addChildLeaf(childLeaf);
                   		childLeaf.addParent(aLeaf);
					} 
                   	catch (Exception e)
					{
						// TODO: handle exception
						e.printStackTrace();
					}
                   	Branch aBranch = new Branch(from,to);
                    aTree.setBranch(aBranch);
                    aTree.addBranchList(aBranch);
                }
            }
            // 子孫の情報を各葉に保存
            for (Leaf aLeaf : aTree.getLeafList()) 
            {
            	aLeaf.setDescendantLeaves();
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

