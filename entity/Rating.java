package com.company.entity;

public enum Rating {
    one(1),
    two(2),
    three(3),
    four(4),
    five(5),
    six (6),
    seven (7),
    eight(8),
    nine(9),
    ten(10);

    private int val;

    private Rating(int val) { this.val = val; }
    public int getVal() { return val; }

}
