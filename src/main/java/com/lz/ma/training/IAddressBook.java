package com.lz.ma.training;

/**
 * Assume one name has only one phone number
 * 
 * @param address
 *            book item class
 */
public interface IAddressBook<T> {
    /**
     * user can look up the item by name
     * 
     * @param name
     * @return the result item or null if the specific name item does not exist
     */
    T lookupByName(String name);

    /**
     * user can look up the item by phone number
     * 
     * @param number
     * @return the result item or null if the specific number item does not exist
     */
    T lookupByNumber(String number);

    /**
     * user can insert new item into the existing address book
     * 
     * @param item
     */
    void intertItem(T item);

    /**
     * the user can delete item by name
     * 
     * @param name
     * @return the deleted item or null if the specific name item does not exist
     */
    T deleteItemByName(String name);

    /**
     * the user can delete item by phone number
     * 
     * @param number
     * @return the deleted item or null if the specific number item does not exist
     */
    T deleteItemByNumber(String number);

    /**
     * get the number of items
     * 
     * @return the number of stored items
     */
    int getItemsSize();

    /**
     * Print all items stored in addressbook
     * 
     * @return the printed string
     */
    public String printAllItems();
}
