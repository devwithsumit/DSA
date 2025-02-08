package Stack.Implementation;
//
import java.util.EmptyStackException;

class MyStack{
    private int[] arr;
    private int index;
    private void copyArray(int elem){
        int n = arr.length;
        int[] newArr = new int[n * 2];
        System.arraycopy(arr, 0, newArr, 0, n);
        arr = newArr;
    }
    MyStack(){
        arr = new int[5];
        index = 0;
    }
    void push(int elem){
        if(index >= arr.length){
            copyArray(elem);
        }
        arr[index] = elem;
        index++;
    }

    int pop(){
        if(index == 0){
            throw new EmptyStackException();
        }
        index--;
        return arr[index];
    }
    int peek(){
        if(index == 0){
            throw new EmptyStackException();
        }
        return arr[index - 1];
    }
    int size(){
        return this.index;
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder("[");
        for(int i = 0; i < index; i++){
            ans.append(arr[i]);
            if(i != index - 1){
                ans.append(", ");
            }
        }
        ans.append("]");
        return ans.toString();
    }
}
public class ArrayImplementationOfStack {

    public static void main(String[] args) {
        MyStack st = new MyStack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        System.out.println(st);
        System.out.println("size: " + st.size());
        System.out.println("peek: " + st.peek());


        System.out.println("pop: " + st.pop());
        System.out.println(st);
        System.out.println("size: " + st.size());
        System.out.println("peek: " + st.peek());

        while(st.size() > 0){
            st.pop();
        }
        System.out.println(st);
        System.out.println(st.size());
//        System.out.println(st.peek());
//        System.out.println(st.peek());
    }
}
