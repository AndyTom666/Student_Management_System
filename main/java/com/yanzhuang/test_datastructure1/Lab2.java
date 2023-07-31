package com.yanzhuang.test_datastructure1;

//modified by LI Yu on Feb. 2

class Item {
    int key;
    Item prev;
    Item next;

    Item(int k) {
        key=k;
        prev=null;
        next=null;
    }

}

class LinkedList {

    Item head;

    LinkedList() {
        head=null;
    }

    Item Search(int k) {
        Item x=head;
        while (x!=null && x.key!=k)
            x=x.next;
        return x;
    }

    void Insert(Item x) {
        x.prev=null;
        x.next=head;
        if (head!=null)
            head.prev=x;
        head=x;
    }

    void Delete(Item x) {
        if (x.prev!=null)
            x.prev.next=x.next;
        else
            head=x.next;
        if (x.next!=null)
            x.next.prev=x.prev;
    }

    //prints  all the keys in the  linked list
    void Print() {
        System.out.print("Contents in the linked list:[");
        //1: _________
        Item cur=head;
        while(cur!=null)
        {
            System.out.print("\t"+cur.key);
            cur=cur.next;
        }
        System.out.println("\t]");
    }

    //reverses the order of  items in the linked list.
    void Reverse() {
        //2: _________
        Item x=head;
        while(x!=null)
        {
            Item temp=x.prev;
            x.prev=x.next;
            x.next=temp;
            head=x;
            x=x.prev;

        }
    }

}
class StackSimulation
{
    LinkedList L1;
    StackSimulation()
    {
        L1=new LinkedList();
    }
    void push(Item x)
    {
        L1.Insert(x);
    }
    Item pop()
    {
        Item s=L1.head;
        L1.Delete(s);
        return s;
    }
    void Print() {
        L1.Print();
    }

}

public class Lab2 {
    static void TestPrint(){
        LinkedList L=new LinkedList();

        Item a=new Item(3);
        Item b=new Item(2);
        Item c=new Item(5);
        Item d=new Item(8);
        Item e=new Item(1);

        L.Insert(a);
        L.Insert(b);
        L.Insert(c);
        L.Insert(d);
        L.Insert(e);

        //test Print()
        L.Print();
        System.out.println("\n*** TestPrint method finished *** \n");
    }

    static  void TestReverse(){
        LinkedList L=new LinkedList();

        Item a=new Item(3);
        Item b=new Item(2);
        Item c=new Item(5);
        Item d=new Item(8);
        Item e=new Item(1);

        L.Insert(a);
        L.Insert(b);
        L.Insert(c);
        L.Insert(d);
        L.Insert(e);

        //test Reverse()
        L.Reverse();
        L.Print();
        System.out.println("\n*** TestReverse method finished *** \n");
    }
    static  void TestStack(){
        StackSimulation s=new StackSimulation();

        Item a=new Item(3);
        Item b=new Item(2);
        Item c=new Item(5);
        Item d=new Item(8);
        Item e=new Item(1);

        s.push(a);
        s.push(b);
        s.push(c);
        s.push(d);
        s.push(e);
        s.Print();
        System.out.println(s.pop().key);
        s.pop();
        s.Print();

    }

    public static void main(String[] args) {
        TestPrint();
        TestReverse();
        TestStack();
    }

}
