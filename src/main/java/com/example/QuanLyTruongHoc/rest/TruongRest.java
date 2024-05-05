package com.example.QuanLyTruongHoc.rest;


import com.example.QuanLyTruongHoc.entity.Truong;
import com.example.QuanLyTruongHoc.service.TruongHocService;
import com.example.QuanLyTruongHoc.service.serviceImp.TruongServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Truong")
public class TruongRest {

    private TruongHocService<Truong, Integer> truongServiceImp;


    @Autowired
    public TruongRest(@Qualifier("truongServiceImp") TruongServiceImp truongServiceImp) {
        this.truongServiceImp = truongServiceImp;
    }

    @GetMapping("HienThi")
    public List<Truong> getAll() {
        return truongServiceImp.getAll();
    }

    @GetMapping("HienThiLazy")
    public List<Truong> getAllLazy() {
        return truongServiceImp.getAllLazy();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Truong> getOne(@PathVariable("id") int id) {
        Optional<Truong> truong = truongServiceImp.getOne(id);
        if (truong.isPresent()) {
            return ResponseEntity.ok(truong.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Truong> save(@RequestBody Truong truong) {
        Truong truongSave = truongServiceImp.save(truong);
        return ResponseEntity.status(HttpStatus.CREATED).body(truongSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Truong> save(@RequestBody Truong truong, @PathVariable("id") int id) {
        Optional<Truong> truongTonTai = truongServiceImp.getOne(id);
        if (truongTonTai.isPresent()) {
            Truong truongUpdate = truongTonTai.get();
            truongUpdate.setTenTruong(truong.getTenTruong());
            truongUpdate.setDiaChi(truong.getDiaChi());
            truongUpdate.setSoDienThoai(truong.getSoDienThoai());
            truong = truongServiceImp.update(truongUpdate);
            return ResponseEntity.ok(truong);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        Optional<Truong> truongTonTai = truongServiceImp.getOne(id);
        if (truongTonTai.isPresent()) {
            truongServiceImp.delete(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleted/{id}")
    public ResponseEntity<?> softDeleteTruong(@PathVariable int id) {
        Optional<Truong> truongTonTai = truongServiceImp.getOne(id);
        if (truongTonTai.isPresent()) {
            truongServiceImp.softDeleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
