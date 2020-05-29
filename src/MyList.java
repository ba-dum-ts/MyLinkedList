public class MyList extends MyLinkedList {
    static MyLinkedList mll = new MyLinkedList();

    public void main(String args[]){
        mll.AddLast(420);
        mll.AddLast("sixty-nine");
        mll.AddLast(9.11);
        mll.AddLast('6' + '6' + '6');

        System.out.println("jag har endast kodat så att det fungerar. \nDet dock befinner inga försök i att rädda programmet från att crasha (jag hade ont om tid)");
        System.out.println();
        System.out.println();

        printList();
    }

    public void printList(){ // prints out list som ärver ur MyLinkedList
        if(First == null){
            return;
        }

        Node temporaryFirst = First;
        while(temporaryFirst != null){
            System.out.print(temporaryFirst.Data + " ---->");
            temporaryFirst = temporaryFirst.Next;
        }
    }
}
