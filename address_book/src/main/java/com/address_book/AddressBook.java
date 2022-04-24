package com.address_book;

import java.util.ArrayList;
import java.util.List;

/**
 * Address is a class that manages a List of Entry objects
 * hence the List<Entry> entries property
 *
 *
 */
public class AddressBook {
    private List<Entry> entries; /*This is protecting the property (entry)most important page which prevents the state of the property from modify/changing*/

    public AddressBook() {
        this.entries = new ArrayList<>(); /*ArrayList hold a list of specific datatype, so in the entry page, there will be a constructor method (line 11-15)to target to create an object*/
    }

    public void addEntry(Entry entry) { //The addEntry method is accessible via an AdressBook object. When we call it we pass as a parameter an Entry object and then we addit to the list of the AddressBook class
        this.entries.add(entry);
    }

    public void printEntries() {
        for (int i = 0; i < entries.size(); i++) {
            int i1 = i + 1;
            System.out.println("Entry " +  i1 + ": " + entries.get(i).toString());
        }
    }

    public boolean entryWithEmailNExists(String email) {
        for (Entry e : entries) {
            if (e.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public void removeEntry(String email) {
        for (int i = 0; i < entries.size(); i++) {
            if (email.equals(entries.get(i).getEmail())) {
                Entry entry = entries.get(i);
                entries.remove(entry);
                System.out.println("Entry removed: " + entry.toString());
            }
        }
    }

    public List<Entry> findByProperty(String property, int propertyIndex) {
        List<Entry> subListOfEntries = new ArrayList<>();
        if (propertyIndex == 0) { //firstname
            for (Entry e : entries) {
                if (e.getFirstName().toLowerCase().startsWith(property.toLowerCase())) {
                    subListOfEntries.add(e);
                }
            }
        } else if (propertyIndex == 1) { //lastName
            for (Entry e : entries) {
                if (e.getLastName().toLowerCase().startsWith(property.toLowerCase())) {
                    subListOfEntries.add(e);
                }
            }
        } else if (propertyIndex == 2) {
            for (Entry e : entries) {
                if (e.getPhoneNo().equals(property.toLowerCase())) {
                    subListOfEntries.add(e);
                }
            }
        } else if (propertyIndex == 3) {
            for (Entry e : entries) {
                if (e.getLastName().toLowerCase().startsWith(property.toLowerCase())) {
                    subListOfEntries.add(e);
                    return subListOfEntries; //there are no two entries with the same email;
                }
            }
        }
        return subListOfEntries;
    }

    public void removeContents() {
        this.entries.clear();
    }
}
