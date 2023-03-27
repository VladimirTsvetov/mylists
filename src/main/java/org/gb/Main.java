package org.gb;

import org.gb.arraylist.ArrayList;
import org.gb.linkedlist.LinkedList;

public class Main {
    public static void main(String[] args) {

        //проверяем ArrayList
        ArrayList<Integer> integerArrayList = new ArrayList();


        for(int i = 0; i < 10; ++i) {
            integerArrayList.add(i, i);
        }

        for(int i = 0; i < integerArrayList.size(); ++i) {
            System.out.println(integerArrayList.get(i));
        }

        //проверяем LinkedList
        LinkedList<Integer> linkedList = new LinkedList();
        linkedList.addLast(10);
        linkedList.addLast(2);
        linkedList.addLast(22);
        linkedList.addLast(44);
        linkedList.addFirst(100);
        System.out.println("Размер равен " + linkedList.size());


        for(int i = 0; i < linkedList.size(); ++i) {
            System.out.println(linkedList.get(i));
        }

        System.out.println(linkedList.indexOf(22));
        System.out.println(linkedList.contains(44));
        linkedList.remove(0);

        for(int i = 0; i < linkedList.size(); ++i) {
            System.out.println(linkedList.get(i));
        }

        linkedList.removeElement(22);

        for(int i = 0; i < linkedList.size(); ++i) {
            System.out.println(linkedList.get(i));
        }

        linkedList.add(0, 333);

        for(int i = 0; i < linkedList.size(); ++i) {
            System.out.println(linkedList.get(i));
        }
    }
}