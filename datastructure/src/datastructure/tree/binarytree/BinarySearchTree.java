package datastructure.tree.binarytree;

public class BinarySearchTree {
	
	private TreeNode root;
	
	public void insert(Integer data) {
		if (null == root) {
			root = new TreeNode(data);
		} else {
			root.insert(data);
		}
	}

	public Integer getSmallest() {
		
		if (root != null) {
			return root.getSmallest();
		} else {
			return null;
		}
		
	}
	
	public Integer getLargest() {
		
		if (root != null) {
			return root.getLargest();
		} else {
			return null;
		}
		
	}
	
	public TreeNode find(Integer data) {

		if (null != root) {
			return root.find(data);
		}
		
		return null;
	}
	
	public void traverseInOrder() {
		
		if (null != root) {
			root.traverseInOrder();
		}
		System.out.println();
	}
	
	public void delete(Integer data) {
		TreeNode current = this.root;
		TreeNode parent = this.root;
		boolean isLeftChild = false;
		
		if (null == current) {
			return;
		}
		
		while (null != current && current.getData() != data) {
			parent = current;
			
			if (data < current.getData()) {
				current = current.getLeftChild();
				isLeftChild = true;
			} else {
				current = current.getRightChild();
				isLeftChild = false;
			}
		}
		
		if (null == current) {
			return;
		} else if (null == current.getLeftChild() && null == current.getRightChild()) { // Case 1. Node to be deleted is a leaf.
			
			if (current == root) {
				root = null;
			} else if (isLeftChild) {
				parent.setLeftChild(null);
			} else {
				parent.setRightChild(null);
			}
			
		} else if (null == current.getRightChild()) { // Case 2. Node to be deleted has one child node.
			
			if (current == root) {
				root = current.getLeftChild();
			} else if (isLeftChild) {
				parent.setLeftChild(current.getLeftChild());
			} else {
				parent.setRightChild(current.getLeftChild());
			}
			
		} else if (null == current.getLeftChild()) {
			
			if (current == root) {
				root = current.getRightChild();
			} else if (isLeftChild) {
				parent.setLeftChild(current.getRightChild());
			} else {
				parent.setRightChild(current.getRightChild());
			}
			
		} else { // Case 3. Node to be deleted has two children.
			TreeNode successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.setLeftChild(successor);
			} else {
				parent.setRightChild(successor);
			}
			successor.setLeftChild(current.getLeftChild());
		}
		
	}
	
	public TreeNode getSuccessor(TreeNode node) {
		TreeNode parentOfSuccessor = node;
		TreeNode successor = node;
		TreeNode current = node.getRightChild();
		
		while (null != current) {
			parentOfSuccessor = successor;
			successor = current;
			current = current.getLeftChild();
		}

		// Successor has a right child.
		if (null != successor.getRightChild() && successor != node.getRightChild()) {
			parentOfSuccessor.setLeftChild(successor.getRightChild());
			successor.setRightChild(node.getRightChild());
		}
		
		return successor;
	}
	
}
