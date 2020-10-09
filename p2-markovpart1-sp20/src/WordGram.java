
/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author Will Hanna
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		myToString = null;
		myHash = 0;

		for(int i = 0; i < size; i++){
			myWords[i] = source[i + start];
		}

		// TODO: initialize myWords
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return
	 */
	public int length(){
		return this.myWords.length;
	}


	/**
	 * Complete appropriate comment here
	 * @param o
	 * @return
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof WordGram) || o == null) {
			return false;
		}
		WordGram wg = (WordGram) o;
		if(! (this.myWords.length == (wg.myWords.length) && (this instanceof WordGram))) {
			return false;
		}
				for(int k = 0; k < this.myWords.length; k++) {
					if (!this.myWords[k].equals(wg.myWords[k])) {
						return false;
					}
				}

		return true;
	}




	@Override
	public int hashCode(){
		boolean tracker = false;
		if(tracker){
			return myHash;
		}
		else{
			myHash = this.toString().hashCode();
			tracker = true;
			return myHash;
		}



	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);
		for(int k = 0; k < myWords.length - 1; k++){
			wg.myWords[k] = myWords[k+1];
		}
		wg.myWords[myWords.length - 1] = last;

		return wg;
	}




	@Override
	public String toString(){
		int tscount = 0;
		if(tscount == 0) {
			myToString = String.join(" ", myWords);
			tscount += 1;
		}
		return myToString;
	}
}
