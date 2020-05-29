public class MyList extends MyLinkedList{
    static MyLinkedList<Number> mll = new MyLinkedList<>();
    private static MyLinkedList<Number>.Node First;

    public static void main(String[] args){
        mll.AddLast(420);
        mll.AddLast(9.11);

        System.out.println("jag har kodat så att det fungerar. \nDet dock befinner inga försök i att rädda programmet från att crasha (jag hade ont om tid)");
        System.out.println();
        System.out.println();

        printList();
    }

    public static void printList(){ // prints out list som ärver ur MyLinkedList
        if(First == null){
            return;
        }
        setFirst(First);
        Node temporaryFirst = First;
        while(temporaryFirst != null){
            System.out.print(temporaryFirst.Data + " ---->");
            temporaryFirst = temporaryFirst.Next;
        }
    }

    public static void setFirst(MyLinkedList<Number>.Node first) {
        First = first;
    }
}