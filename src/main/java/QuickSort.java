import java.util.Comparator;

/**
 * @author Tatiana Futarnaya
 * Служебный класс быстрой сортировки коллекции MyArray, не предназначен для создания экземпляров
 */

public class QuickSort{

    /**
     * Закрытый конструктор служебного класса
     */
    private QuickSort() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Сортирует указанный список по возрастанию в соответствии с естественным порядком его элементов.
     * В нем проверяется, что список не равен null и содержит более одного элемента.
     * Если так, то вызывается рекурсивный метод quickSortWithComparable.
     * Если это не так, то сортировка не требуется и метод завершает работу.
     * Все элементы в списке должны реализовывать Comparable интерфейс.
     * @param list список для сортировки.
     * @param <E> класс объектов в списке.
     */
    public static <E extends Comparable<? super E>> void quickSort(MyArray<E> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        quickSortWithComparable(list,0,list.size() - 1);
    }

    /**
     * Метод производит быструю сортировку на вход принимает список list, а также нижний (left) и верхний (right) индексы.
     * Если left меньше right, происходит разделение массива с помощью метода partitionWithComparable,
     * а затем рекурсивно вызывается quickSortWithComparable для левой и правой части.
     * Все элементы в списке должны реализовывать Comparable интерфейс.
     * @param list список для сортировки.
     * @param left нижний индексы.
     * @param right верхний индексы.
     * @param <E> класс объектов в списке.
     */
    private static <E extends Comparable<? super E>> void quickSortWithComparable(MyArray<E> list, int left, int right){
        if (left < right) {
            int pivotIndex = partitionWithComparable(list, left, right);
            quickSortWithComparable(list, left, pivotIndex-1);
            quickSortWithComparable(list, pivotIndex + 1, right);
        }
    }


    /**
     * Вспомогательный метод, определяет положение опорного элемента и переставляет элементы так, чтобы элементы меньше
     * опорного находились слева от него, а большие — справа.
     * Этот метод возвращает индекс опорного элемента  типа int после перестановки.
     * @param list список для сортировки.
     * @param left нижний индексы.
     * @param right верхний индексы.
     * @param <E> класс объектов в списке.
     * @return возвращает индекс опорного элемента, когда он становится на свое окончательное место.
     */
    private static <E extends Comparable<? super E>> int partitionWithComparable(MyArray<E> list, int left, int right) {
        E pivot = list.get(right);
        int j = left;
        for (int i = left; i < right; i++) {
            if (list.get(i).compareTo(pivot) <= -1 || list.get(i).compareTo(pivot) <= 0) {
                swap(list, i, j++);
            }
        }
        swap(list, right, j);
        return j;
    }


    /**
     * Метод производит быструю сортировку в заданном пользователем порядке (пользователь указывает компоратор)
     * принимает MyArray в качестве аргумента и проверяет, что список не равен null и содержит более одного элемента.
     * Если так, то вызывается рекурсивный метод quickSortWithComparator.
     * Если это не так, то сортировка не требуется и метод завершает работу.
     * @param list представляет собой лист, который будет сортироваться
     * @param comparator представляет собой класс, реализованный пользователем, для указания требования сортировки
     * @param <E> класс объектов в списке.
     */
    public static <E> void quickSort(MyArray<E> list, Comparator<? super E> comparator) {
        if (list == null || list.size() <= 1) {
            return;
        }
        quickSortWithComparator(list, 0, list.size() - 1, comparator);
    }


    /**
     * Вспомогательный метод, который принимает список, нижний и верхний индексы.
     * В нем используется рекурсивный подход для разделения и сортировки списка.
     * @param list список для сортировки.
     * @param left нижний индексы.
     * @param right верхний индексы.
     * @param comparator представляет собой класс, реализованный пользователем, для указания требования сортировки.
     * @param <E> класс объектов в списке.
     */
    private static <E> void quickSortWithComparator(MyArray<E> list, int left, int right,
                                                    Comparator<? super E> comparator) {
        if (left < right) {
            int pivotIndex = partitionWithComparator(list, left, right, comparator);
            quickSortWithComparator(list, left, pivotIndex - 1, comparator);
            quickSortWithComparator(list, pivotIndex + 1, right, comparator);
        }
    }

    /**
     * Вспомогательный метод, определяет положение опорного элемента и переставляет элементы так, чтобы элементы меньше
     * опорного находились слева от него, а большие — справа.
     * В конце он помещает опорный элемент на свое окончательное место и возвращает индекс этого элемента типа int.
     * @param list список для сортировки.
     * @param left нижний индексы.
     * @param right верхний индексы.
     * @param comparator представляет собой класс, реализованный пользователем, для указания требования сортировки.
     * @param <E> класс объектов в списке.
     * @return возвращает индекс опорного элемента, когда он становится на свое окончательное место.
     */
    private static <E> int partitionWithComparator(MyArray<E> list, int left, int right,
                                                   Comparator<? super E> comparator) {
        E pivot = list.get(right);
        int j = left;
        for (int i = left; i < right; i++) {
            if (comparator.compare(list.get(i), pivot) <= 0) {
                swap(list, i, j++);
            }
        }
        swap(list, right, j);
        return j;
    }


    /**
     * Выполняет обмен элементами списка между двумя заданными индексами
     * @param list список для сортировки.
     * @param x индекс первого элемента.
     * @param y индекс второго элемента.
     * @param <E> класс объектов в списке.
     */
    private static <E> void swap(MyArray<E> list, int x, int y)  {
        E temp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, temp);
    }
}
