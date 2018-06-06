package dataStruct;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Design a data structure that allows O(1) time complexity to insert, delete and get most frequent element.
 * 
 * @author cy
 *
 */
class Node {
	int times;
	HashSet<Integer> set;
	Node pre;
	Node next;
	
	public Node(int value) {
		this.times = value;
		set = new HashSet<Integer>();
	}
}

public class FrequentCollection {
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	Node head;
	Node tail;
	
	//insert into map
	public void insert(int value) {
		if (map.containsKey(value)) {
			Node oldNode = map.get(value);
			oldNode.set.remove(value);
			if (oldNode.next != null) {
					map.put(value, oldNode.next);
					oldNode.next.set.add(value);
			} else {
				Node newNode = new Node(oldNode.times + 1);
				newNode.set.add(value);
				newNode.pre = oldNode;
				oldNode.next = newNode;
				map.put(value, newNode);
			}
		} else {
			if (head == null || tail == null) {
				Node newNode = new Node(1);
				newNode.set.add(value);
				map.put(value, newNode);
				tail = newNode;
				head = newNode;
			} else if (tail.times > 1) {
				Node newNode = new Node(1);
				newNode.set.add(value);
				newNode.next = tail;
				map.put(value, newNode);
				tail.pre = newNode;
				tail = newNode;
			} else {
				tail.set.add(value);
				map.put(value, tail);
			}
		}
		if (head.next != null) {
			head = head.next;
		}
	}
	
	//remove from map
	public void remove(int value) {
		if (map.containsKey(value)) {
			Node temp = map.get(value);
			temp.set.remove(value);
			map.remove(value);
			//times为出现的次数，如果times>1，说明插入的净次数大于1，所以删除时应该是将次数减一，而不是直接删除元素就结束，第一次就直接删除了，是不对的，同时这里不用
			//修改指针，因为while循环会处理指针
			if (temp.times != 1) {
				temp.pre.set.add(value);
				map.put(value, temp.pre);
			}
		}
		//此处条件不可颠倒，否则出现空指针异常
		while ( head != null && head.set.size() == 0) {
			head = head.pre;
		}
	}
	
	//getFrequentest element
	public int getFrequentest() {
		if(head == null)
			return -1;
		Iterator<Integer> iterator = head.set.iterator();
		return iterator.next();
	}
	
	//Demo
	public static void main(String[] args) {
		FrequentCollection fc = new FrequentCollection();
		/*System.out.println("frequentest element is : ");
		System.out.println(fc.getFrequentest());
		fc.insert(1);
		System.out.println(fc.getFrequentest());
		fc.remove(1);
		System.out.println(fc.getFrequentest());
		fc.insert(1);
		System.out.println(fc.getFrequentest());
		fc.insert(2);
		System.out.println(fc.getFrequentest());
		fc.insert(3);
		System.out.println(fc.getFrequentest());
		fc.insert(2);
		System.out.println(fc.getFrequentest());
		fc.insert(3);
		System.out.println(fc.getFrequentest());
		fc.insert(3);
		System.out.println(fc.getFrequentest());
		fc.insert(2);
		System.out.println(fc.getFrequentest());
		fc.insert(2);
		System.out.println(fc.getFrequentest());
		fc.remove(2);
		System.out.println(fc.getFrequentest());
		fc.remove(2);
		System.out.println(fc.getFrequentest());*/
		System.out.println("sfsf");
		fc.insert(1);
		fc.insert(2);
		fc.insert(2);
		fc.insert(2);
		fc.insert(2);
		/*	fc.insert(2);
		fc.insert(2);
		fc.insert(2);*/
		//fc.insert(3);
		fc.insert(3);
		fc.insert(3);
		fc.insert(3);
		fc.insert(4);
		fc.insert(4);
		System.out.println(fc.getFrequentest());
		//Iterator<Integer> iterator = fc.head.set.iterator();
		while (fc.tail!=null) {
			Iterator<Integer> iterator = fc.tail.set.iterator();
			System.out.println("sdfsdfsfsf");
			while (iterator.hasNext()) {
				
				System.out.print(iterator.next()+"   ");
			}
			fc.tail = fc.tail.next;
		}
		
	}
}
/*
 frequentest element is : 
-1
1
-1
1
1
1
2
2
3
2
2
2
3

 */

