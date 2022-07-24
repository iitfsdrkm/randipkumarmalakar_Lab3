package in.randip;

import java.util.ArrayList;

class Node {
	int data;
	Node left;
	Node right;

}

public class SumofPairInBinarySearchTree {

	static boolean searchMultiplePair = true; // set to false if only one pair to be searched

	static ArrayList<Integer> arrList = new ArrayList<Integer>(); // works fine  

	static Node NewNode(int data)
	{
		Node temp = new Node();
		temp.data = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	static Node insert(Node root, int key)
	{
		if (root == null)
			return NewNode(key);
		if (key < root.data)
			root.left = insert(root.left, key);
		else
			root.right = insert(root.right, key);
		return root;
	}


	static void traverseInorder(Node node) {
		if (node == null) {
			return;
		}
		traverseInorder(node.left);
		arrList.add(node.data); // Add tree data to ArrayList
		traverseInorder(node.right);

		return;
	}

	static int pairCount=0;

	static void printSumOfPair(Node root, int sum) {

		traverseInorder(root);

		/*
		//For debug purpose to print the ArrayList data

		for(int i=0;i<arrList.size();i++) {
			System.out.print(arrList.get(i) + ", ");
		}
		 */

		int firstValue, secondValue;

		// Nested loop to find sum of two data elements if equal to Sum
		for(int i=0;i<arrList.size();i++) {
			firstValue = arrList.get(i);

			if(firstValue == sum) {
				// Single value is matching Sum so we don't check and go to next value by continue the loop
				continue;
			}

			for(int j=i+1;j<arrList.size();j++) {
				secondValue=arrList.get(j);

				if(secondValue == sum) {
					// Single value is matching Sum so we don't check and go to next value by continue the loop
					continue;
				}

				if(firstValue+secondValue == sum) {
					pairCount++;

					// If multiple pair is to be searched
					if(searchMultiplePair==true) {
						System.out.println("Pair " + pairCount + " is (" + firstValue + "," + secondValue + ") [for Sum: "+ sum + "]");
						continue;
					}
					else { //If only single pair is to be searched
						System.out.println("Pair is (" + firstValue + "," + secondValue + ") [for Sum: "+ sum + "]");
						return;
					}							

				}
			}
		}
		if(pairCount==0) {
			System.out.println("Pair Not Found [for Sum: " + sum + "]");			
		}

		return;


	}

	public static void main(String[] args) {

		Node root = null;
		root = insert(root, 40);
		root = insert(root, 20);
		root = insert(root, 60);
		root = insert(root, 10);
		root = insert(root, 30);
		root = insert(root, 50);
		root = insert(root, 70);

		int sum = 80;

		printSumOfPair(root,sum);

	}

}
