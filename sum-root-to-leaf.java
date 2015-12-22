public int sumNumbers(TreeNode root) {
    int result = 0;
    if(root==null)
        return result;
 
    ArrayList<ArrayList<TreeNode>> all = new ArrayList<ArrayList<TreeNode>>();
    ArrayList<TreeNode> l = new ArrayList<TreeNode>();
    l.add(root);
    dfs(root, l, all);
 
    for(ArrayList<TreeNode> a: all){
        StringBuilder sb = new StringBuilder();
        for(TreeNode n: a){
            sb.append(String.valueOf(n.val));
        }
        int currValue = Integer.valueOf(sb.toString());
        result = result + currValue;
    }
 
    return result;
}
 
public void dfs(TreeNode n, ArrayList<TreeNode> l,  ArrayList<ArrayList<TreeNode>> all){
    if(n.left==null && n.right==null){
        ArrayList<TreeNode> t = new ArrayList<TreeNode>();
        t.addAll(l);
        all.add(t);
    }
 
    if(n.left!=null){
        l.add(n.left);
        dfs(n.left, l, all);
        l.remove(l.size()-1);
    }
 
    if(n.right!=null){
        l.add(n.right);
        dfs(n.right, l, all);
        l.remove(l.size()-1);
    }
 
}