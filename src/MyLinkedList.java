import java.util.NoSuchElementException;

public class MyLinkedList<T extends Number>{
    public Node firstNode;
    private Node lastNode;
    private int lengthOfList;

    /*
        En länkad lista med noder som existerar endast för att bli ärvd
     */

    public class Node{ // en nod med värdet data som är kopplad med både elementet före samt efter
        public T middleNode;
        public Node previousNode;
        public Node nextNode;

        public Node(T currentNode){ // konstruktor som begär en int för att kallas
            this.middleNode = currentNode;
        }
    }

    public MyLinkedList(){ // reset
        this.firstNode = null;
        this.lastNode = null;
        this.lengthOfList = 0;
    }

    public Node RemoveFirst(){ // tar bort första element samt deklarerar att första är nu elementet efter istället
        if(lengthOfList == 0){ // om listan är tom
            throw new NoSuchElementException();
        }

        Node temporaryFirst = firstNode;
        if(firstNode == lastNode){ // om det endast existerar en nod
            lastNode = null; // tar bort pekaren Last
        }

        else{ // tar bort kopplingen tillbaka mellan noderna
            firstNode.nextNode.previousNode = null;
        }
        firstNode = firstNode.nextNode; // om if sker: flyttar på first frammåt till null (tar alltså bort pekaren Next) // om else sker: flyttar på first frammåt till nästa element
        temporaryFirst.nextNode = null; // tar bort kopplingen framför mellan noderna
        lengthOfList--;

        return temporaryFirst;
    }

    public Node RemoveLast(){ // tar bort sista element
        if(lengthOfList == 0){ // om listan är tom
            throw new NoSuchElementException();
        }

        Node temporaryLast = lastNode;
        if(firstNode == lastNode){ // om det endast existerar en nod
            firstNode = null; // tar bort pekaren Next
        }

        else{ // tar bort kopplingen framför mellan noderna
            lastNode.previousNode.nextNode = null;
        }
        lastNode = lastNode.previousNode; // om if sker: flyttar på last backåt till null (tar alltså bort pekaren Last) // om else sker: flyttar på last backåt till nästa element
        temporaryLast.previousNode = null; // tar bort kopplingen tillbaka mellan noderna
        lengthOfList--;

        return temporaryLast;
    }

    public void AddLast(T data){ // skapar en generic element i slutet
        Node newNode = new Node(data);

        if(lengthOfList == 0){ // om listan är tom
            firstNode = newNode;
        }

        else{ // skapar en koppling mellan last och newNode
            newNode.previousNode = lastNode;
            lastNode.nextNode = newNode;
        }
        lastNode = newNode; // om if sker: skapar en element var Last == First // om else sker: flyttar Last till senaste nod
        lengthOfList++;
    }

    public void InsertAt(T index) throws IndexOutOfBoundsException{
        Node newNode = new Node(index);
        newNode.nextNode = null;

        if(lengthOfList == 0){ // om listan är tom
            newNode.previousNode = null;
            firstNode = newNode;
            lastNode = newNode;
        }

        else if(lengthOfList == 1){ // om det endast består en element
            firstNode.nextNode = newNode;
            lastNode = newNode;
            lastNode.previousNode = firstNode;
        }

        else{ // flyttar fram värdet på last
            newNode.previousNode = lastNode;
            lastNode.nextNode = newNode;
            lastNode = newNode;
        }
        lengthOfList++;
    }

    public void RemoveAt(int index) throws IndexOutOfBoundsException{
        if((index > lengthOfList--) || (index < 0)){ // om index existerar i listan
            throw new NoSuchElementException();
        }

        else if(index == 0){ // om användaren försöker ta bort First
            Node node = firstNode;
            firstNode = node.nextNode;
            lengthOfList--;
        }

        else{ // tar bort element samt koppling emellan
            Node temporaryFirst = firstNode;
            for(int n = 0; n < index; n++){
                temporaryFirst = temporaryFirst.nextNode;
            }
            Node node = temporaryFirst;
            temporaryFirst = node.previousNode;
            temporaryFirst.nextNode = node.nextNode;
            lengthOfList--;
        }
    }
}
