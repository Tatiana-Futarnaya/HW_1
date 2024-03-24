import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;


/**
 * @author Tatiana Futarnaya
 * @param <E> тип значения в классе {@code MyArrayList<E>}, который  имплементирует интерфейс {@code MyArray<E>}
 */


public class MyArrayList<E>  implements MyArray<E> {
    private E[] values;

    /**
     * Создает новый объект MyArrayList без указанния значений.
     */
    @SuppressWarnings("unchecked")
    public MyArrayList(Class<E> clazz, int capacity) {
        values = (E[]) Array.newInstance(clazz, capacity);
    }

    @Override
    public void addAll(Collection<? extends E> e) {
        if (e == null) {
            return;
        }
        if (e.isEmpty()) {
            return ;
        }
        for (E item : e) {
            add(item);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean add(E e) {
        E[] temp = values;
        values = (E[]) Array.newInstance(e.getClass(),temp.length + 1);
        System.arraycopy(temp, 0, values, 0, temp.length);
        values[values.length - 1] = e;
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void add(int index, E e) {
            E[] temp = values;
            values = (E[]) Array.newInstance(e.getClass(),temp.length + 1);

            if (index == 0) {
                values[index] = e;
                System.arraycopy(temp, 0, values, 1, temp.length);
            } else if (index == values.length - 1) {
                System.arraycopy(temp, 0, values, 0, temp.length);
                values[values.length - 1] = e;
            } else {
                System.arraycopy(temp, 0, values, 0, index);
                values[index] = e;
                System.arraycopy(temp, index, values, index + 1, temp.length - 2);
            }
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < values.length; i++) {
            if (e == values[i]) {
                return i;
            }
        }
        return -1;
    }


    @SuppressWarnings("unchecked")
    @Override
    public void delete(E e) {
            E[] temp = values;
            int indexE = indexOf(e);
            values = (E[]) Array.newInstance(e.getClass(),temp.length - 1);
            System.arraycopy(temp, 0, values, 0, indexE);
            int amountElemsAfterIndex = temp.length - indexE - 1;
            System.arraycopy(temp, indexE + 1, values, indexE, amountElemsAfterIndex);
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }


    @Override
    public void set(int index, E e) {
        values[index] = e;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        values = (E[]) new Object[0];
    }

    @Override
    public void sort() {
        Arrays.sort(values);
    }



    @Override
    public String toString() {
        return Arrays.toString(values);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyArrayList<?> that = (MyArrayList<?>) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }
}