import java.util.*;

public class EfficientMarkov extends BaseMarkov {
	private Map<String,ArrayList<String>> myMap;

	public EfficientMarkov(int order){
		super(order);
		myMap = new HashMap<String,ArrayList<String>>();
	}

	public EfficientMarkov(){
		this(3);
	}

	@Override
	public void setTraining(String text) {
		super.setTraining(text);
		myMap.clear();




		String currentKey = "";
		ArrayList<String> followingValues;

		for(int j = 0; j < myText.length() - myOrder + 1; j ++){
				currentKey = myText.substring(j, j + myOrder);
				followingValues = new ArrayList<>();
				if (myMap.containsKey(currentKey)) {
					followingValues = myMap.get(currentKey);
				}
					if(myText.length() - (j + myOrder) == 0){
						followingValues.add(PSEUDO_EOS);
					}
					else {
						followingValues.add(myText.substring(j + myOrder, j + myOrder + 1));
					}
			myMap.put(currentKey, followingValues);

			}


	}

	public ArrayList<String> getFollows(String key) {
		if(myMap.get(key) != null){
			return myMap.get(key);
		}
		else{
			throw new NoSuchElementException(key + " not in map");
		}
	}
}	
