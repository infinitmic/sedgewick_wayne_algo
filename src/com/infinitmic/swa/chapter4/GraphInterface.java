package com.infinitmic.swa.chapter4;

public interface GraphInterface {
    int vertices();
    int edges();
    Iterable<Integer> adjacent(int vertex);
}
