package com.example.QuanLyTruongHoc.service.serviceImp;

import com.example.QuanLyTruongHoc.entity.TheHocSinh;
import com.example.QuanLyTruongHoc.repository.TheHocSinhRepository;
import com.example.QuanLyTruongHoc.service.TruongHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheHocSinhServiceImp implements TruongHocService<TheHocSinh, Integer> {

    private TheHocSinhRepository theHocSinhRepository;

    @Autowired
    public TheHocSinhServiceImp(TheHocSinhRepository theHocSinhRepository) {
        this.theHocSinhRepository = theHocSinhRepository;
    }

    @Override
    public List<TheHocSinh> getAll() {
        return null;
    }

    @Override
    public Optional<TheHocSinh> getOne(Integer id) {
        return Optional.empty();
    }

    @Override
    public TheHocSinh save(TheHocSinh theHocSinh) {
        return null;
    }

    @Override
    public TheHocSinh update(TheHocSinh theHocSinh) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        theHocSinhRepository.deleteById(id);
    }

    @Override
    public List<TheHocSinh> getList(Integer id) {
        return null;
    }

    @Override
    public List<TheHocSinh> getAllLazy() {
        return null;
    }

    @Override
    public TheHocSinh getOneLazy(Integer id) {
        return null;
    }

    @Override
    public void softDeleteById(int id) {

    }
}
