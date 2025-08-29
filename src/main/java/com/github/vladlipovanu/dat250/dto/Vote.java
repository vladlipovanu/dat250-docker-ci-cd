package com.github.vladlipovanu.dat250.dto;

import java.time.Instant;

public class Vote  implements java.io.Serializable {
    private Instant publishedAt;

    public Vote () { // does nothing atm
        }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }
}
