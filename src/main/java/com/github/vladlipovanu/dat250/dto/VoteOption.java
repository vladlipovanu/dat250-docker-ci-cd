package com.github.vladlipovanu.dat250.dto;

public class VoteOption implements java.io.Serializable {
    private String caption;
    private int presentationOrder;

    public VoteOption() { // does nothing atm
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getPresentationOrder() {
        return presentationOrder;
    }

    public void setPresentationOrder(int presentationOrder) {
        this.presentationOrder = presentationOrder;
    }
}
