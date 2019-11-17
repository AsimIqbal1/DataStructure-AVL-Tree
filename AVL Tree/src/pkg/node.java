package pkg;

public class node {
	public node right,left;
    protected int data;
    protected int BF;
    protected int height;
    
    public node(int data){
        right = null;
        left = null;
        this.data = data;
        this.height = -1;
    }
}
