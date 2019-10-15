package datastructure.tree.binarytree;

public class BinarySerachTreeTest {

	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		
		binarySearchTree.insert(12);
		binarySearchTree.insert(25);
		binarySearchTree.insert(27);
		binarySearchTree.insert(33);
		binarySearchTree.insert(34);
		binarySearchTree.insert(39);
		binarySearchTree.insert(40);
		binarySearchTree.insert(52);
		binarySearchTree.insert(60);
		binarySearchTree.insert(65);
		binarySearchTree.insert(72);
		binarySearchTree.insert(78);
		binarySearchTree.insert(90);
		
		binarySearchTree.traverseInOrder();

	}

}
