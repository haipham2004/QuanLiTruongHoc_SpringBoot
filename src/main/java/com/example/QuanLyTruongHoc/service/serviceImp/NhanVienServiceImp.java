package com.example.QuanLyTruongHoc.service.serviceImp;

import com.example.QuanLyTruongHoc.entity.NhanVien;
import com.example.QuanLyTruongHoc.repository.NhanVienRepository;
import com.example.QuanLyTruongHoc.service.TruongHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienServiceImp implements TruongHocService<NhanVien,Integer> {

    private NhanVienRepository nhanVienRepository;

    @Autowired
    public NhanVienServiceImp(NhanVienRepository nhanVienRepository) {
        this.nhanVienRepository = nhanVienRepository;
    }


    @Override
    public List<NhanVien> getAll() {
        return null;
    }

    @Override
    public Optional<NhanVien> getOne(Integer id) {
        return Optional.empty();
    }

    @Override
    public NhanVien save(NhanVien nhanVien) {
        return null;
    }

    @Override
    public NhanVien update(NhanVien nhanVien) {
        return null;
    }

    @Override
    public void delete(Integer id) {
         nhanVienRepository.deleteById(id);
    }

    @Override
    public List<NhanVien> getList(Integer id) {
        return null;
    }

    @Override
    public List<NhanVien> getAllLazy() {
        return null;
    }

    @Override
    public NhanVien getOneLazy(Integer id) {
        return null;
    }
}
