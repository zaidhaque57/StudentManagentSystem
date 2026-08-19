package GenericInventoryManager;

import java.util.ArrayList;

class Inventory <T> {
    private ArrayList<T> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item){
        items.add(item);
        System.out.println("Added Item: " + item);
    }

    public void removeItem(T item) {
        if(items.remove(item)){
            System.out.println("Removed Item: " + item);
        }else{
            System.out.println("Error: Item " + item + " not found.");
        }
    }

    public void display(){
        if(items.isEmpty()){
            System.out.println("Inventory is empty.");
        }else{
            for(T item : items){
                System.out.println(" - " + item);
            }
        }
    }
}

