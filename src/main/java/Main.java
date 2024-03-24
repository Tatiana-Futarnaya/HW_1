import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Tatiana Futarnaya
 */
public class Main {

        public static final Logger logger= Logger.getLogger(Main.class.getName());

        public static void main(String[] args) {

        ArrayList<String> list=new ArrayList<>(Arrays.asList("Mercedes","Volkswagen"));
        MyArrayList<String> myArrayList=new MyArrayList<>(String.class, 0);


        myArrayList.addAll(list);

        myArrayList.add("Ford");
        myArrayList.add("BMW");
        myArrayList.add("Lada");
        myArrayList.add("Audi");

        Comparator<String> comparator = Comparator.naturalOrder();


        logger.log(Level.INFO, myArrayList::toString);

        QuickSort.quickSort(myArrayList, comparator);
        logger.log(Level.INFO, myArrayList::toString);


        ArrayList<String> tmpList=new ArrayList<>(Arrays.asList("Watermelon", "Cantaloupe", "Horned", "Crenshaw", "Honeydew",
                "Gac", "Bitter", "Winter", "Sprite", "Korean", "Canary", "Charentais"));

        MyArrayList<String> arrayList=new MyArrayList<>(String.class, 0);
        arrayList.addAll(tmpList);

        logger.log(Level.INFO, arrayList::toString);
        QuickSort.quickSort(arrayList);
        logger.log(Level.INFO, arrayList::toString);



    }
}
