package tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;

public class TreeModel extends mvc.Model{
    /**
     * 現在のモードを束縛する。
     */
    private int mode;
    /**
     * 木を束縛する。
     */
    private Tree aTree;
    
    public TreeModel()
    {
        super();
        aTree=new Tree();
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
        return;
    }
    /**
     * 木を応答する。
     * @return
     */
    public Tree getTree()
    {
        return this.aTree;
    }
    
    /**
     * ファイルを読み込む。
     */
    public void load()
    {
        //カレントディレクトリを取得 テスト用
        File currentDirectory = new File(".");
        System.out.println(currentDirectory.getAbsolutePath());
        
        String inFileName = "Project_Forest_Problem/Requirement/texts/tree.txt";	 // 入力ファイル名
        
        try {
            FileInputStream fis = new FileInputStream(inFileName);
            InputStreamReader isr = new InputStreamReader(fis , "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            
            String line;
            boolean nodes = false;
            boolean branches = false;
            boolean tree = false;
            TreeMap<Integer,String> nodesMap = new TreeMap<Integer,String>();
            TreeMap<Integer,ArrayList<Integer>> branchesMap = new TreeMap<Integer,ArrayList<Integer>>();
            ArrayList<Integer> nodeDepthList = new ArrayList<Integer>();
            
            while((line=br.readLine()) != null)
            {
                if(line.equals("trees:"))
                {
                    branches = false;
                    nodes = false;
                    tree = true;
                    line=br.readLine();
                }
                if(line.equals("nodes:"))
                {
                    branches = false;
                    nodes = true;
                    tree = false;
                    line=br.readLine();
                }
                if(line.equals("branches:"))
                {
                    branches = true;
                    nodes = false;
                    tree = false;
                    line=br.readLine();
                }
                if(tree)
                {
                    Integer nodeDepth = 0;
                    String nodeName;
                    
                    // 一行の中の改行文字を全て削除し、"|--"で分割
                    String[] item = line.replaceAll("\n","").split("\\|-- ");
                    if (item.length == 1) {
                        // 深さ0のとき
                        nodeDepth = 0;
                        nodeName = item[0];
                        nodeDepthList.add(nodeDepth);
                    }else{
                        // 深さ0以外のとき
                        // 深さ = 分割後の配列の長さ - 1
                        nodeDepth = item.length - 1;
                        nodeName = item[item.length - 1];
                        nodeDepthList.add(nodeDepth);
                    }
                    //		System.out.println(nodeDepthList.size());
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
                }
                if(branches)
                {
                    /*Branch aBranch = new Branch();
                    aTree.setBranch(aBranch);
                    String[] item = line.replaceAll("¥n","").split(", ");
                    Integer from = Integer.valueOf(item[0]);
                   	Integer to = Integer.valueOf(item[1]);
                   	aTree.getBranch().setBranchFrom(from);
                    aTree.getBranch().setBranchTo(to);
                    aTree.addBranchList(aBranch);*/
                	String[] item = line.replaceAll("¥n","").split(", ");
                    Integer from = Integer.valueOf(item[0]);
                   	Integer to = Integer.valueOf(item[1]);
                   	Branch aBranch = new Branch(from,to);
                    aTree.setBranch(aBranch);
                    aTree.addBranchList(aBranch);
                }
            }
            for ( Integer key : nodesMap.keySet() )
            {
             /*   Leaf aLeaf=new Leaf();
                aTree.setLeaf(aLeaf);
                String nodeName = nodesMap.get( key );
                Integer nodeDepth = nodeDepthList.get(key-1);
                aTree.getLeaf().setNodeName(nodeName);
                aTree.getLeaf().setNodeNumber(key);
                aTree.getLeaf().setNodeDepth(nodeDepth);
                aTree.addLeafList(aLeaf);*/
            	 String nodeName = nodesMap.get( key );
                 Integer nodeDepth = nodeDepthList.get(key-1);
                 Leaf aLeaf=new Leaf(key,nodeName,nodeDepth);
                 aTree.setLeaf(aLeaf);
                 aTree.addLeafList(aLeaf);
            }
            
            System.out.println
            (aTree.getLeafList().get(4).getNodeNumber()+":"+
             aTree.getLeafList().get(4).getNodeName()+":"+
             aTree.getLeafList().get(4).getNodeDepth());
            System.out.println
           (aTree.getBranchList().get(4).getBranchFrom()+":"+aTree.getBranchList().get(4).getBranchTo());
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

