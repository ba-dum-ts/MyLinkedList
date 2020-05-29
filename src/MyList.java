public class MyList extends MyLinkedList{
    static MyLinkedList<Number> mll = new MyLinkedList<>();

    public static void main(String[] args){
        mll.AddLast(420);
        mll.AddLast(9.11);

        System.out.println();
        System.out.println();

        printList();
    }

    public static void printList(){ // prints out list som ärver ur MyLinkedList
        if(mll.firstNode == null){
            return;
        }

        Node temporaryFirst = mll.firstNode;

        if(temporaryFirst != null){
            System.out.print("null <-- ");
            while(temporaryFirst != null){
                System.out.print(temporaryFirst.middleNode + " --> ");
                temporaryFirst = temporaryFirst.nextNode;
            }
            System.out.print("null");
        }
    }
}