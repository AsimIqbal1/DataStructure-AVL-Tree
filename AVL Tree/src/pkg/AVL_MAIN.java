package pkg;

public class AVL_MAIN {

	public static void main(String[] args) {
		  // TODO code application logic here
        avlNode avl = new avlNode();

        //inserting the data in Tree using helper function
        avl.insert(6);
        avl.insert(8);
        avl.insert(7);
        System.out.println("Final Self balanced AVL Tree:\n");
        avl.preOrderDisplay();
        
        System.out.println("\n\nDFS:");
        System.out.println(avl.DFS(9));
        System.out.println("\n\nDFS:");
        System.out.println(avl.DFS(6));
	}

}
