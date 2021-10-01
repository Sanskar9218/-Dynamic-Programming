class Node{
	int data, height;
	Node left;
	Node right;
	public Node()
	{
		height = 1;
	}
}

public class AvlTree {
	Node root;
	
	int height(Node n)
	{
		if(n == null)
		{
			return 0;
		}
		else {
			return n.height;
		}
	}
	
	int max(int a, int b)
	{
		return (a>b) ? a : b;
	}
	
	int getBalance(Node n)
	{
		if(n == null)
		{
			return 0;
		}
		return height(n.left) - height(n.right);
	}
	
	Node rightRotate(Node n)
	{
		Node x = n.left;
		Node y = x.right;
		
		x.right = n;
		n.left = y;
		
		n.height = max(height(n.left), height(n.right))+1;
		x.height = max(height(x.left), height(x.right))+1;
		
		return x;
	}
	
	Node leftRotate(Node n)
	{
		Node x = n.right;
		Node y = x.left;
		
		x.left = n;
		n.right = y;
		
		n.height = max(height(n.left), height(n.right))+1;
		x.height = max(height(x.left), height(x.right))+1;
		
		return x;
	}
	
	Node insert(Node n, int d)
	{
		if(n == null)
		{
			Node newNode = new Node();
			newNode.data = d;
			return newNode;
		}
		
		if(n.data > d)
		{
			n.left = insert(n.left, d);
		}
		else if(n.data < d)
		{
			n.right = insert(n.right, d);
		}
		
		n.height = max(height(n.left), height(n.right))+1;
		
		int bal = getBalance(n);
		
		if(bal > 1 && d < n.left.data)
		{
			return rightRotate(n);
		}
		else if(bal < -1 && d > n.right.data)
		{
			return leftRotate(n);
		}
		else if(bal > 1 && d > n.left.data)
		{
			n.left = leftRotate(n.left);
			return rightRotate(n);
		}
		else if(bal < -1 && d < n.right.data)
		{
			n.right = rightRotate(n.right);
			return leftRotate(n);
		}
		
		return n;
	}
	
	int findMin(Node p)
	{
		int min = 0;
		if(p.left == null)
		{
			return p.data;
		}
		if(p.left != null)
		{
			min = findMin(p.left);
		}
		return min;
	}
	
	Node delete(Node p, int key)
	{
		if(p == null)
		{
			return p;
		}
		if(key > p.data)
		{
			p.right = delete(p.right, key);
		}
		else if(key < p.data)
		{
			p.left = delete(p.left, key);
		}
		else {
			if(p.left == null)
			{
				return p.right;
			}
			else if(p.right == null)
			{
				return p.left;
			}
			else {
				p.data = findMin(p.right);
				p.right = delete(p.right, p.data);
			}
		}
		
		p.height = max(height(p.left), height(p.right))+1;
		
		int bal = getBalance(p);
		
		if(bal > 1 && getBalance(p.left) >= 0)
		{
			return rightRotate(p);
		}
		else if(bal < -1 && getBalance(p.right) <= 0)
		{
			return leftRotate(p);
		}
		else if(bal > 1 && getBalance(p.left) < 0)
		{
			p.left = leftRotate(p.left);
			return rightRotate(p);
		}
		else if(bal < -1 && getBalance(p.right) > 0)
		{
			p.right = rightRotate(p.right);
			return leftRotate(p);
		}
		
		return p;
	}
	
	void preOrder(Node n) { 
        if (n != null) { 
            System.out.print(n.data + " "); 
            preOrder(n.left); 
            preOrder(n.right); 
        } 
    } 
	
	public static void main(String args[])
	{
		AvlTree tree = new AvlTree(); 
		
		tree.root = tree.insert(tree.root, 9);  
        tree.root = tree.insert(tree.root, 5);  
        tree.root = tree.insert(tree.root, 10);  
        tree.root = tree.insert(tree.root, 0);  
        tree.root = tree.insert(tree.root, 6);  
        tree.root = tree.insert(tree.root, 11);  
        tree.root = tree.insert(tree.root, -1);  
        tree.root = tree.insert(tree.root, 1);  
        tree.root = tree.insert(tree.root, 2);  
        
        System.out.println("Preorder traversal of constructed tree is : "); 
        tree.preOrder(tree.root);
        
        tree.root = tree.delete(tree.root, 10); 
        System.out.println("Preorder traversal after deletion of 10 :");  
        tree.preOrder(tree.root);  
	}
}
