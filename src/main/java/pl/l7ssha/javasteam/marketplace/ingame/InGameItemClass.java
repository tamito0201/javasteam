package pl.l7ssha.javasteam.marketplace.ingame;

// pl.l7ssha.javasteam.marketplace.ingame
//
// Date created: 25 Apr 2018
// Author: Szymon 'l7ssha' Uglis

public class InGameItemClass {
    private String name;
    private int value;

    public InGameItemClass(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public InGameItemClass() {}

    /**
     * Undocumented
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Undocumented
     * @return String
     */
    public int getValue() {
        return value;
    }
}
