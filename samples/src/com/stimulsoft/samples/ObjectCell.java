package com.stimulsoft.samples;


/**
 * Copyright Stimulsoft
 */
public class ObjectCell {
    public String val;

    @Override
    public boolean equals(Object obj) {
        return val.equals(((ObjectCell) obj).val);
    }

    public String toString() {
        return val;
    }

    public ObjectCell(String val) {
        this.val = val;
    }
}
