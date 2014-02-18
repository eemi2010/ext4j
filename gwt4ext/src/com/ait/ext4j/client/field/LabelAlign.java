package com.ait.ext4j.client.field;

public enum LabelAlign {

    LEFT("left"), TOP("top"), RIGHT("right");

    private String value;

    private LabelAlign(String align) {
        this.value = align;
    }

    public String getValue() {
        return this.value;
    }
}
