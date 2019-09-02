package com.example.demo.repository;
@FunctionalInterface
public interface SetFields<T,N> {
    void set(T t, N n);
}
