package No48_50_Arrays_And_List.DesigningArrayList;


public class Implementation {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(7);
        list.add(2);

        //printing list and it's size
        System.out.println(list);
        System.out.println("Size: " + list.size());

        // adding element at particular index
        list.add(1, 100);
        System.out.println(list);
        System.out.println("Size: " + list.size());

        //removing element and printing the element removed
        System.out.println("removed element: " + list.remove(0));

        //removing 0th element one by one until array becomes empty
        while (list.size() > 0) {
            list.remove(0);
        }
        System.out.println(list);
        System.out.println(list.size());
    }
}
