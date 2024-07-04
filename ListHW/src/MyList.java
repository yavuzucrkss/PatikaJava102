import java.util.Arrays;

public class MyList<T> {

    private T[] myList;
    private int size;
    public MyList(int capasity) {
        size = 0;
        this.myList = (T[]) new Object[capasity];
    }

    public MyList() {
        size = 0;
        this.myList = (T[]) new Object[10];
    }

    public int size(){
        return size;
    }

    public void add(T data){
        if(size == myList.length){
            resize(myList.length * 2);
        }
        myList[size++] = data;
    }

    public void resize(int newCapacity){
        T[] tempList = (T[]) new Object[newCapacity];
        System.arraycopy(myList,0,tempList,0,size);
        myList = tempList;
    }

    public int getCapacity(){
        return myList.length;
    }

    public T get(int index){
        if(index >= size && index < 0){
            return null;
        }
        return myList[index];
    }

    public void set(int index, T data){
        if(index >= size && index < 0){
           return;
        }

        myList[index] = data;
    }

    public void remove(int index){
        if (index >= size || index < 0) {
            return;
        }
        for(int i = index; i < size -1; i++){
            myList[i] = myList[i+1];
        }

        myList[--size] = null;
    }

    @Override
    public String toString() {
        return "MyList{" +
                "myList=" + Arrays.toString(myList) +
                '}';
    }
}
