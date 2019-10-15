package datastructure.tree.binarytree;

public class TreeNode {
	
	private Integer data;
	private TreeNode leftChild;
	private TreeNode rightChild;

	public TreeNode(Integer data) {
		super();
		this.data = data;
	}
	
	public Integer getSmallest() {
		
		if (null == this.leftChild) {
			return data;
		} else {
			return this.leftChild.getSmallest();
		}
		
	}
	
	public Integer getLargest() {
		
		if (null == this.rightChild) {
			return data;
		} else {
			return this.rightChild.getLargest();
		}
		
	}
	
	public TreeNode find(Integer data) {	
		if (data < this.data && null != leftChild) {
			return leftChild.find(data);
		} else if (data > this.data && null != rightChild) {
			return rightChild.find(data);
		} else if (data == this.data) {
			return this;
		} else {
			return null;
		}
	}
	
	public void traverseInOrder() {
		if (null != this.leftChild) {
			this.leftChild.traverseInOrder();
		}
		System.out.print(this.toString() + " ");
		if (null != this.rightChild) {
			this.rightChild.traverseInOrder();
		}
	}
	
	public void insert(Integer data) {
		if (data >= this.data) {
			
			if (null == this.rightChild) {
				this.rightChild = new TreeNode(data);
			} else {
				this.rightChild.insert(data);
			}
			
		} else {
			
			if (null == this.leftChild) {
				this.leftChild = new TreeNode(data);
			} else {
				this.leftChild.insert(data);
			}
			
		}
	}
	
	public Integer getData() {
		return data;
	}
	public TreeNode getLeftChild() {
		return leftChild;
	}
	public TreeNode getRightChild() {
		return rightChild;
	}
	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}
	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return String.valueOf(this.data);
	}
}
