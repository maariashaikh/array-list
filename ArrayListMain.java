import java.util.Iterator;

public class ArrayListMain {
    public static void main(String[] args){
        
        ArrayList arrayList = new ArrayList();

        insertNumbers(arrayList, 10);
        
        printElements(arrayList);

        removeElements(arrayList);
        
        addNumbersInProperOrder(arrayList, 10);
        
        printElements(arrayList);

    }// main
    
    private static void insertNumbers(List arrayList, int n){
        for( int i = 0 ; i < n ; i++){
            arrayList.insert(0, i);
        }
        System.out.println("Numbers added to the first location in the list");
    }  
    
    private static void printElements(ArrayList arrayList){
        // print elements of list
        System.out.println("Following are the Items in the list :");
        Iterator iterator = arrayList.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println("\n");
    }
    
    private static void removeElements(List arrayList){
        System.out.println("********************");
        int originalSize = arrayList.getSize();
        // remove elements of list
        for(int i = 0 ; i < originalSize; i++){
            System.out.println("\n\nRemoving element " + arrayList.get(0) + " from the list ... ");
            arrayList.remove(0);
            if (arrayList.isEmpty()){
                System.out.println("No remaining elements.\n");
            }else {
                System.out.println("Remaining elements are => ");
                for(int j = 0 ; j < arrayList.getSize(); j++){
                    System.out.print("Index:" + j + " â€“ Element:" + arrayList.get(j) + "  ");
                }// for
            }
        }// for  
        System.out.println("********************\n");
    }
    
    private static void addNumbersInProperOrder(List arrayList, int n){
        for( int i = 0 ; i < n ; i++){
            arrayList.append(i);
        }
        System.out.println("Numbers added again to the list (in proper order)");
    }

}


