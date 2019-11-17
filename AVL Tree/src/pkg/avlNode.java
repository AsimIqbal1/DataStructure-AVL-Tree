package pkg;

public class avlNode {
private node root;
    
	private int getHeight(node n){
		if(n == null){
                    return -1;
                }
                
                return 1+ Integer.max(getHeight(n.left),getHeight (n.right));
	}
	
        private int size(node n){
            if(n == null)return -1;
            return 1+size(n.left)  + size(n.right);
        }
    public void insert(int data){
        root = insert(root,data);
    }
    
    private node insert(node n, int data){
    	// make a new node first, in order to insert in tree
        node newnode = new node(data);
        if (n == null){
            root = newnode;
            return root;
        }
//        node root = n;
        node current = n;
        node parent;
        // insertion procedure follows BST
        while(true){
        	parent = current;
        	if(data<current.data){
        		current = current.left;
        		if(current == null){
        			parent.left = newnode;
        			break;
        		}
        	}
        	
        	else if(data>current.data){
        		current = current.right;
        		if(current == null){
        			parent.right = newnode;
        			break;
        		}
        	}
        	else return n;
        }
        //1 is added bcoz above we have added one node at its right or left
//        int x,y;
//        x = getHeight(n.left);
//        y = getHeight(n.right);
//        if(x>y)n.height = 1 + x;
//        else n.height = 1 + y;
        //n.height = getHeight(n);
        //System.out.println("Height = "+n.height);
        
        //updateBF() returns the balance factor of the parent nodes of inserted one
        int bal = updateBF(n);
        System.out.println("BF = "+bal);
        
        
        //If balance factor is not in the range {-1,0,1} ?
        //If yes, apply possible rotations
        if((bal > 1) && data < n.left.data){
        	System.out.println("Current State of Tree: \n");
        	preOrderDisplay(n);
        	System.out.println("RR");
        	n = RRrotation(n);
        }
        
        else if((bal <-1) && data > n.right.data){
        	System.out.println("Current State of Tree: \n");
        	preOrderDisplay(n);
        	System.out.println("LL");
        	n = LLrotation(n);
        }
        
        else if((bal > 1) && data > n.left.data){
        	System.out.println("Current State of Tree: \n");
        	preOrderDisplay(n);
        	n.left = LLrotation(n.left);
        	n = RRrotation(n);
        }
        
        else if((bal < -1) && data < n.right.data){
        	System.out.println("Current State of Tree: \n");
        	preOrderDisplay(n);
        	n.right = RRrotation(n.right);
        	n = LLrotation(n);
        }
        
        return n;
    }
    
    public boolean DFS(int data){
    	return DFS(root,data);
    }
    public boolean DFS(node n, int data){
    	
    	node current = n;
    	
    	if(current.data == data)return true;
    	
    	while(current!=null){
    		if(data < n.data){
    			current = current.left;
    			if(current == null)break;
    			if(current.data == data){
    				return true;
    			}
    		}
    		
    		else if(data > n.data){
    			current = current.right;
    			if(current == null)break;
    			if(current.data == data){
    				return true;
    			}
    		}
    	}
    	
    	return false;
    }
    
    
    public void preOrderDisplay(){
        preOrderDisplay(root);
    }
    
    private void preOrderDisplay(node root){
        
        if(root!=null){
        	System.out.println(root.data);
            preOrderDisplay(root.left);           
            preOrderDisplay(root.right);
        }
    }
    
    
    private int updateBF(node n){
    	
    	if(n==null)return 0;
    	else{
    		int x = getHeight(n.left) - getHeight(n.right);
    		return x;
    	}
    }
    
    public node RRrotation(node pivot){
    	System.out.println("Applying Right Rotation");
    	node a = pivot.left;
    	pivot.left = a.right;
    	a.right = pivot;
    	pivot = a;
    	preOrderDisplay(pivot);
    	return pivot;
    	
    }
    
    public node LLrotation(node pivot){
    	System.out.println("Applying Left Rotation");
    	node a = pivot.right;
    	pivot.right = a.left;
    	a.left = pivot;
    	pivot = a;
    	preOrderDisplay(pivot);
    	return pivot;
    }
}
