import java.util.HashMap;
import java.util.HashSet;

public class MainCollections {
    public static void main(String[] args) {

        // (1)
        String [] words = {"apple", "banana", "kiwi", "lemon", "mango",
                "orange", "papaya", "pear", "melon", "banana",
                "papaya", "lemon", "banana", "melon", "banana"};

        HashSet<String> setWords = new HashSet<>();
        for (String hw: words)
            setWords.add(hw);
        System.out.println(setWords);

        HashMap<String, Integer> mapWords = new HashMap<>();
        for (String mw: words) {
            Integer in =  mapWords.put(mw, 1);
            if (in != null)
                mapWords.put(mw, ++in);
        }
        System.out.println(mapWords);
        // (2)
        PhoneBook myBook = new PhoneBook();
        myBook.add("Иванов", "253-14-45", "ivanoff@mail.ru");
        myBook.add("Иванов", "256-15-55", "ivanoff@yandex.ru");
        myBook.add("Петров", "252-12-25", "petro@mail.ru");
        myBook.printNumber("Иванов");
        myBook.printMail("Петров");


    }
}