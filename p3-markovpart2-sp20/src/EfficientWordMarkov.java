import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class EfficientWordMarkov extends BaseWordMarkov {
   private  Map<WordGram, ArrayList<String>> myMap;

public EfficientWordMarkov(int order){
    super(order);
    myMap = myMap = new HashMap<>();
}

public EfficientWordMarkov(){
    this(3);
}


    @Override
    public void setTraining(String text) {
        myWords = text.split("\\s+");
        myMap.clear();



        for(int i = 0; i < myWords.length - myOrder + 1; i++){
            ArrayList<String> stringy = new ArrayList<>();
            WordGram grammy = new WordGram(myWords,i,myOrder);
            if(myMap.get(grammy) != null){
                stringy.addAll(myMap.get(grammy));
            }
            if(myWords.length -(i + myOrder) == 0){
                stringy.add(PSEUDO_EOS);
            }
            else {
                stringy.add(myWords[i + myOrder]);
            }
            myMap.put(grammy, stringy);
        }
    }


    public ArrayList<String> getFollows(WordGram grammy) {
        if(myMap.get(grammy) != null){
            return myMap.get(grammy);
        }
        else{
            throw new NoSuchElementException(grammy + " not in map");
        }

    }
}
