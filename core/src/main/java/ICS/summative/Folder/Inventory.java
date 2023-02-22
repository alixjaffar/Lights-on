package ICS.summative.Folder;
// package ICS.summative;

/**
 * @Author: Waheed Magsi
 * @Description: this is the inventory class. It is where the items will be stored.
 */

// import java.util.HashMap;
// import java.util.Map;

// public class Inventory {

//     private Map<Items, Integer> inventoryItems;

//     public Inventory() {
//         inventoryItems = new HashMap<Items, Integer>();
//     }

//     public void addItem(Items item, int quantity) {
//         if (inventoryItems.containsKey(item)) {
//             inventoryItems.put(item, inventoryItems.get(item) + quantity);
//         } else {
//             inventoryItems.put(item, quantity);
//         }
//     }

//     public void removeItem(Items item, int quantity) {
//         if (inventoryItems.containsKey(item)) {
//             int newQuantity = inventoryItems.get(item) - quantity;
//             if (newQuantity > 0) {
//                 inventoryItems.put(item, newQuantity);
//             } else {
//                 inventoryItems.remove(item);
//             }
//         }
//     }

//     public void displayInventory() {
//         for (Items item : inventoryItems.keySet()) {
//             System.out.println(item.getName() + ": " + inventoryItems.get(item));
//         }
//     }
// }

