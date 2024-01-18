public class ITIStringBuffer {

    /* Buffer list */
    private SinglyLinkedList<String> buffer;
    private String str = "";

    public ITIStringBuffer() {
        /* New buffer */
        this.buffer = new SinglyLinkedList<String>();
    }

    public ITIStringBuffer(String  firstString){
        /* New buffer */
        this.buffer = new SinglyLinkedList<String>();

        /* Convert string to character array */
        char[] ch = firstString.toCharArray();

        /* Populate buffer list with character array */
        for(char c : ch) {
            String s = Character.toString(c);
            this.buffer.add(s);
        }
    }

    public void append(String nextString){
        /* Add string to buffer list */
        this.buffer.add(nextString);
    }

    public String toString(){
        str = "";

        for(String s : this.buffer) {
            str = str.concat(s);
        }
        return str;
    }

}
 