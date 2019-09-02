package com.example.demo.repository;
@FunctionalInterface
public interface ListSave<T> {
    void save(T t);
}
