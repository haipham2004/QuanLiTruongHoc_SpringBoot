package com.example.QuanLyTruongHoc.service.serviceImp;

import com.example.QuanLyTruongHoc.entity.HocSinh;
import com.example.QuanLyTruongHoc.repository.HocSinhRepository;
import com.example.QuanLyTruongHoc.service.TruongHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HocSinhServiceImp implements TruongHocService<HocSinh, Integer> {

    private HocSinhRepository hocSinhRepository;

    @Autowired
    public HocSinhServiceImp(HocSinhRepository hocSinhRepository) {
        this.hocSinhRepository = hocSinhRepository;
    }

    @Override
    public List<HocSinh> getAll() {
        return null;
    }

    @Override
    public Optional<HocSinh> getOne(Integer id) {
        return Optional.empty();
    }

    @Override
    public HocSinh save(HocSinh hocSinh) {
        return null;
    }

    @Override
    public HocSinh update(HocSinh hocSinh) {
        return null;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        hocSinhRepository.deleteById(id);
    }

    @Override
    public List<HocSinh> getList(Integer id) {
        return null;
    }

    @Override
    public List<HocSinh> getAllLazy() {
        return null;
    }

    @Override
    public HocSinh getOneLazy(Integer id) {
        return null;
    }
}
