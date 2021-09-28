package com.taory.page;

public enum MenuItems {
    INDETAIL("подробно"),
    BRIEFLY("кратко");

    private String desc;

    MenuItems(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
