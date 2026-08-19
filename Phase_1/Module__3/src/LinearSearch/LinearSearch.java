package LinearSearch;

public class LinearSearch {
    public static void main(String[] args) {

        int [] numbers = {10,20,70,10,50};
        int target = 30;
        boolean found = false;

        for(int i=1; i<numbers.length; i++){

            if(numbers[i] == target){
                found = true;
                System.out.println("Found at index "+ i);
                break;
            }
        }
        if(!found){
            System.out.println("Not Found");
        }
    }
}
