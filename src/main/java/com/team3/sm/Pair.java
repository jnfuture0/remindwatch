package com.team3.sm;

class Pair<L,R> {
    final L left;
    final R right;

    private Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    static <L,R> Pair<L,R> of(L left, R right){
        return new Pair<L,R>(left, right);
    }
}
