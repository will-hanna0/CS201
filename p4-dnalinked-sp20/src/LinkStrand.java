public class LinkStrand implements IDnaStrand {
    //test all these methods with TestStrand, except for charAt which is tested with TestIterator

    private class Node{
        String info;
        Node next;

        public Node(String s, Node n){
            info = s;
            next = n;
        }
    }

    private Node myFirst, myLast;
    private long mySize;
    private int myAppends;

    private Node myCurrent;
    private int myLocalIndex;
    private int myIndex;


    public LinkStrand(){
        this("");
    }

    public LinkStrand(String s) {
        initialize(s);
    }

    @Override
    public long size() {
        return mySize;
    }

    @Override
    public void initialize(String source) {
        myFirst = new Node(source, null);
        myLast = myFirst;
        mySize = source.length();
        myAppends = 0;

        myCurrent = myFirst;
        myLocalIndex = 0;
        myIndex = 0;
    }

    @Override
    public IDnaStrand getInstance(String source) {
        return new LinkStrand(source);
    }



    @Override
    public IDnaStrand append(String dna) {
        myLast.next = new Node(dna, null);
        myLast = myLast.next;
        myAppends++;
        mySize += dna.length();
        return this;
    }

    @Override
    public IDnaStrand reverse() {
        Node currentNode = myFirst;
        LinkStrand reversey = new LinkStrand("");
        Node reversyCurrent = null;
        Node reversyPrev = null;

        int counter = 0;
        while (currentNode != null) {
            StringBuilder hola = new StringBuilder(currentNode.info);
            hola.reverse();
            Node funNode = new Node(hola.toString(), null);
            if(counter == 0) {
                reversey.myLast = funNode;
                reversyCurrent = funNode;
                reversey.myFirst = reversyCurrent;
                reversyPrev = reversey.myLast;
                counter ++;
            }
            else{
                reversyCurrent = funNode;
                reversey.myFirst = reversyCurrent;
                reversyCurrent.next = reversyPrev;
            }
            currentNode = currentNode.next;
            reversyPrev = reversyCurrent;

        }
        reversey.mySize = this.mySize;
        return reversey;
    }

    @Override
    public int getAppendCount() {
        return myAppends;
    }

    @Override
    public char charAt(int index) {
        if(index <0 || index >= mySize) throw new IndexOutOfBoundsException();

        if(index < myIndex){
            myIndex = 0;
            myLocalIndex = 0;
            myCurrent = myFirst;
        }

        if(index == myIndex)return myCurrent.info.charAt(myLocalIndex);

        if(index > myIndex){
            while(myIndex != index){
                myIndex++;
                myLocalIndex++;
                if(myLocalIndex >= myCurrent.info.length()){
                    myLocalIndex = 0;
                    myCurrent = myCurrent.next;
                }
            }
        }
        return myCurrent.info.charAt(myLocalIndex);
    }


    @Override
    public String toString(){
        StringBuilderStrand returny = new StringBuilderStrand();
        Node holder = myFirst;
        while(myFirst != null){
            returny.append(myFirst.info);
            myFirst = myFirst.next;
        }
        myFirst = holder;
        return returny.toString();
    }

}
