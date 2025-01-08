package com.jexpression.spotlightzim.model;

public enum Rating {
    ONE_STAR(1),
    TWO_STARS(2),
    THREE_STARS(3),
    FOUR_STARS(4),
    FIVE_STARS(5);

    private final int rating;

    Rating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}
