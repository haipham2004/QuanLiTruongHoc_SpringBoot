package com.example.QuanLyTruongHoc.service;

import com.example.QuanLyTruongHoc.entity.Lop;

import java.util.List;
import java.util.Optional;

public interface TruongHocService<E,K> {

    public List<E> getAll();

    public Optional<E> getOne(K id);

    public E save(E e);

    public E update(E e);

    public void delete(K id);

    public List<E> getList(K id);

    public List<E> getAllLazy();

    public E getOneLazy(K id);
}
