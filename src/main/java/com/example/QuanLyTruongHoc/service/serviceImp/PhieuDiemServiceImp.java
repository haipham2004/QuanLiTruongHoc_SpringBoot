package com.example.QuanLyTruongHoc.service.serviceImp;

import com.example.QuanLyTruongHoc.entity.PhieuDiem;
import com.example.QuanLyTruongHoc.repository.PhieuDiemRepository;
import com.example.QuanLyTruongHoc.service.TruongHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PhieuDiemServiceImp implements TruongHocService<PhieuDiem, Integer> {

    private PhieuDiemRepository phieuDiemRepository;

    @Autowired
    public PhieuDiemServiceImp(PhieuDiemRepository phieuDiemRepository) {
        this.phieuDiemRepository = phieuDiemRepository;
    }

    @Override
    public List<PhieuDiem> getAll() {
        return null;
    }

    @Override
    public Optional<PhieuDiem> getOne(Integer id) {
        return Optional.empty();
    }

    @Override
    public PhieuDiem save(PhieuDiem phieuDiem) {
        return null;
    }

    @Override
    public PhieuDiem update(PhieuDiem phieuDiem) {
        return null;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        phieuDiemRepository.deleteById(id);
    }

    @Override
    public List<PhieuDiem> getList(Integer id) {
        return null;
    }

    @Override
    public List<PhieuDiem> getAllLazy() {
        return null;
    }

    @Override
    public PhieuDiem getOneLazy(Integer id) {
        return null;
    }

    @Override
    public void softDeleteById(int id) {

    }
}
