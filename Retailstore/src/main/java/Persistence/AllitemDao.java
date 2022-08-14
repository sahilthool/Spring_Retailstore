package Persistence;

import Bean.Item;

public interface AllitemDao {
void showallitem();
boolean additem(Item allItem);
Item searchItem(int id);
boolean deleteitem(int id);
boolean updateQuantity(int item_id,int quantity);
}