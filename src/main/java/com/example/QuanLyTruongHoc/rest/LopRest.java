package com.example.QuanLyTruongHoc.rest;

import com.example.QuanLyTruongHoc.entity.Lop;
import com.example.QuanLyTruongHoc.entity.Truong;
import com.example.QuanLyTruongHoc.service.TruongHocService;
import com.example.QuanLyTruongHoc.service.serviceImp.LopServiceImp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/Lop")
public class LopRest {

     private TruongHocService<Lop,Integer> lopServiceImp;

    @Autowired
    public LopRest(LopServiceImp lopServiceImp) {
        this.lopServiceImp = lopServiceImp;
    }

    @GetMapping("/HienThi")
    public List<Lop> getAll() {
        return lopServiceImp.getAll();
    }

    @GetMapping("/HienThiLazy")
    public List<Lop> getAll2() {
        return lopServiceImp.getAllLazy();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lop> getOne(@PathVariable("id") int id) {
        Lop lopTonTai = lopServiceImp.getOneLazy(id);
        if(lopTonTai!=null){
            return ResponseEntity.ok(lopTonTai);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Lop> save(@RequestBody Lop lop) {
        Lop lopSave = lopServiceImp.save(lop);
        return ResponseEntity.status(HttpStatus.CREATED).body(lopSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Lop lop, @PathVariable("id") int id) {
        Lop lopTonTai = lopServiceImp.getOneLazy(id);
        if (lopTonTai!=null) {
            lopTonTai.setTenLop(lop.getTenLop());
            lopTonTai.setKhoiHoc(lop.getKhoiHoc());
            lopTonTai.setNienKhoa(lop.getNienKhoa());
            lopTonTai.setGiaoVienChuNhiem(lop.getGiaoVienChuNhiem());
            lopTonTai.setTruong(lop.getTruong());
            lop = lopServiceImp.update(lopTonTai);
            return ResponseEntity.ok(lop);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
// Chúng ta phải cashCase:remove ở những bảng chứa khoá chính nhé

    @DeleteMapping("/{id}")
    @JsonIgnore
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        Lop lopTonTai=lopServiceImp.getOneLazy(id);
        if(lopTonTai!=null){
            lopServiceImp.delete(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
