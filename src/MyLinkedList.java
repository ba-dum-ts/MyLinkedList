import java.util.NoSuchElementException;

public class MyLinkedList {
    public  Node First;
    private  Node Last;
    private  int Length;

    /*
        En länkad lista med noder som existerar endast för att bli ärvd
     */

    public class Node{ // en nod med värdet data som är kopplad med både elementet före samt efter
        public int Data;
        Node Previous;
        public Node Next;

        public Node(int data){ // konstruktor som begär en int för att kallas
            this.Data = data;
        }
    }

    public MyLinkedList(){ // reset
        this.First = null;
        this.Last = null;
        this.Length = 0;
    }

    public Node RemoveFirst(){ // tar bort första element samt deklarerar att första är nu elementet efter istället
        if(Length == 0){ // om listan är tom
            throw new NoSuchElementException();
        }

        Node temporaryFirst = First;
        if(First == Last){ // om det endast existerar en nod
            Last = null; // tar bort pekaren Last
        }

        else{ // tar bort kopplingen tillbaka mellan noderna
            First.Next.Previous = null;
        }
        First = First.Next; // om if sker: flyttar på first frammåt till null (tar alltså bort pekaren Next) // om else sker: flyttar på first frammåt till nästa element
        temporaryFirst.Next = null; // tar bort kopplingen framför mellan noderna
        Length--;

        return temporaryFirst;
    }

    public Node RemoveLast(){ // tar bort sista element
        if(Length == 0){ // om listan är tom
            throw new NoSuchElementException();
        }

        Node temporaryLast = Last;
        if(First == Last){ // om det endast existerar en nod
            First = null; // tar bort pekaren Next
        }

        else{ // tar bort kopplingen framför mellan noderna
            Last.Previous.Next = null;
        }
        Last = Last.Previous; // om if sker: flyttar på last backåt till null (tar alltså bort pekaren Last) // om else sker: flyttar på last backåt till nästa element
        temporaryLast.Previous = null; // tar bort kopplingen tillbaka mellan noderna
        Length--;

        return temporaryLast;
    }

    public <T> void AddLast(T data){ // skapar en generic element i slutet som (unironically) endast tar emot data typen integer
        Node newNode = new Node((Integer) data);

        if(Length == 0){ // om listan är tom
            First = newNode;
        }

        else{ // skapar en koppling mellan last och newNode
            newNode.Previous = Last;
            Last.Next = newNode;
        }
        Last = newNode; // om if sker: skapar en element var Last == First // om else sker: flyttar Last till senaste nod
        Length++;
    }

    public void InsertAt(int index) throws IndexOutOfBoundsException{
        Node newNode = new Node(index);
        newNode.Next = null;

        if(Length == 0){ // om listan är tom
            newNode.Previous = null;
            First = newNode;
            Last = newNode;
        }

        else if(Length == 1){ // om det endast består en element
            First.Next = newNode;
            Last = newNode;
            Last.Previous = First;
        }

        else{ // flyttar fram värdet på last
            newNode.Previous = Last;
            Last.Next = newNode;
            Last = newNode;
        }
        Length++;
    }

    public void RemoveAt(int index) throws IndexOutOfBoundsException{
        if((index > Length--) || (index < 0)){ // om index existerar i listan
            throw new NoSuchElementException();
        }

        else if(index == 0){ // om användaren försöker ta bort First
            Node node = First;
            First = node.Next;
            Length--;
        }

        else{ // tar bort element samt koppling emellan
            Node temporaryFirst = First;
            for(int n = 0; n < index; n++){
                temporaryFirst = temporaryFirst.Next;
            }
            Node node = temporaryFirst;
            temporaryFirst = node.Previous;
            temporaryFirst.Next = node.Next;

            node = null;
            Length--;
        }
    }
}
