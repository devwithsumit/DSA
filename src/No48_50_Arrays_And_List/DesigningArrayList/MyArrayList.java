package No48_50_Arrays_And_List.DesigningArrayList;

public class MyArrayList {
    private int[] data;
    private int end;

    public MyArrayList() {
        data = new int[10];
        end = -1;
    }

    public MyArrayList(int capacity) {
        data = new int[capacity];
        end = -1;
    }

    public void add(int val) {
        if (end + 1 >= data.length) {
            reallocate();
        }
        data[++end] = val;
    }

    public void add(int index, int val) {
        //edge case
        if (index < 0 || index > end + 1) {
            throw new IndexOutOfBoundsException("Index not found " + index + " length " + (end + 1));
        }
        // if size is exhausted
        if (end + 1 == data.length) {
            reallocate();
        }
        //shifting
        for (int i = end + 1; i > index; i--) {
            data[i] = data[i - 1];
        }
        // add element at given index or position
        data[index] = val;
        end++;
    }

    public int remove(int index) {
        //edge case for invalid index
        if (index < 0 || index > end) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length: " + (end + 1));
        }
        //storing the value to be removed so that we can return it later
        int ans = data[index];
        //shifting
        for (int i = index; i <= end; i++) {
            data[i] = data[i + 1];
        }
        end--;
        return ans;
    }

    public int size() {
        return end + 1;
    }

    public int get(int index) {
        if (index < 0 || index > end) {
            throw new IndexOutOfBoundsException("Index : " + index + " out of bounds for length : " + end + 1);
        }
        return data[index];
    }

    //reallocation method (for class use only)
    private void reallocate() {
        int[] temp = new int[data.length * 2];
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
//        System.out.println(Arrays.toString(data));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= end; i++) {
            sb.append(data[i]);
            if (i != end) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
