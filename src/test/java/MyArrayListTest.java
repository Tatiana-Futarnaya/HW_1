import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Tatiana Futarnaya
 */
public class MyArrayListTest  {
    private  MyArray<String> myArray;
    private static ArrayList<String> list;
    private final String item="Spring";


    @BeforeClass
    public static void creatArrayList(){
        list=new ArrayList<>(Arrays.asList("Watermelon", "Cantaloupe", "Horned", "Crenshaw", "Honeydew",
                "Gac", "Bitter", "Winter", "Sprite", "Korean", "Canary", "Charentais"));
    }

    @Before
    public void creatMyArrayList(){
        myArray=new MyArrayList<>(String.class,0);
    }

    @Test
    public void testConstructor(){
        MyArray<String> array=new MyArrayList<>(String.class,0);
        Assert.assertNotNull(array);
    }

    @Test
    public void addAllShouldValues(){
        ArrayList<String> arrayList= new ArrayList<>(Arrays.asList("Mercedes","Volkswagen"));
        myArray.addAll(arrayList);
        MyArray<String> expectedList=new MyArrayList<>(String.class, 0);
        expectedList.addAll(arrayList);
        Assert.assertNotNull(myArray);
        Assert.assertEquals(myArray, expectedList);
    }

    @Test
    public void addShouldValues(){
        myArray.add("Ford");
        myArray.add("BMW");
        myArray.add("Lada");
        myArray.add("Audi");
        Assert.assertNotNull(myArray);
    }

    @Test
    public void addByIndexElementShouldDone(){
        boolean result=false;
        int oldSize= list.size();
        int index = 1;
        list.add(index,item);
        for(int i=0; i< list.size();i++){
            if(list.get(i).equals(item) && list.size()==oldSize+1){
                result=true;
                break;
            }
        }
        Assert.assertTrue( "Item not found",result);
    }



    @Test
    public void indexOfElementShould(){
        addByIndexElementShouldDone();
        boolean result=false;
        int indexE=list.indexOf(item);
        for (int i=0; i< list.size(); i++){
            if(i == indexE && list.get(i).equals(item)){
                result=true;
                break;
            }
        }
        Assert.assertTrue(result);
    }





    @Test
    public void deleteShouldByElement(){
        myArray.addAll(list);
        MyArray<String> expectedList=new MyArrayList<>(String.class, 0);
        expectedList.addAll(list);

        Assert.assertEquals(myArray,expectedList);

        for (int i=0; i< myArray.size(); i++){
            String itemDelete = "Cantaloupe";
            if(myArray.get(i).equals(itemDelete)){
                myArray.delete(itemDelete);
            }
        }

        Assert.assertNotEquals(expectedList,myArray);
    }


    @Test
    public void shouldGetElementByIndex(){
        myArray.addAll(list);
        String actual=myArray.get(5);
        String expected=list.get(5);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldSetElementByIndex(){
        myArray.addAll(list);
        myArray.set(5,item);

        Assert.assertEquals(item, myArray.get(5));
    }

    @Test
    public void shouldClearList(){
        myArray.addAll(list);
        myArray.clear();
        Assert.assertNotEquals(list.size(),0);
    }

    @Test
    public void sortShouldDone(){
        myArray.addAll(list);
        myArray.sort();
        MyArray<String> expectedList=new MyArrayList<>(String.class, 0);
        list.sort(Comparator.naturalOrder());
        expectedList.addAll(list);

        Assert.assertEquals(expectedList,myArray);
    }

    @Test
    public void shouldGetSize(){
        boolean result=false;
        int tmpSize= list.size();
        myArray.addAll(list);
        if(myArray.size()==tmpSize){
            result=true;
        }

        Assert.assertTrue(result);
    }

    @Test
    public void quickSortWithComparableShouldDone(){
        myArray.addAll(list);
        QuickSort.quickSort(myArray);
        MyArray<String> expectedList=new MyArrayList<>(String.class, 0);
        list.sort(Comparator.naturalOrder());
        expectedList.addAll(list);
        Assert.assertEquals(expectedList,myArray);
    }

    @Test
    public void quickSortWithComparatorShouldDone(){
        myArray.addAll(list);
        QuickSort.quickSort(myArray, Comparator.naturalOrder());
        MyArray<String> expectedList=new MyArrayList<>(String.class, 0);
        list.sort(Comparator.naturalOrder());
        expectedList.addAll(list);
        Assert.assertEquals(expectedList,myArray);
    }



}
