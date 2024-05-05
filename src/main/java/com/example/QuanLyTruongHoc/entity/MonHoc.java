package com.example.QuanLyTruongHoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name="MonHoc")
public class MonHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MonHocID")
    private int monHocId;

    @Column(name="TenMonHoc")
    private String tenMonHoc;

    @Column(name="GiaoVienPhuTrach")
    private String giaoVienPhuTrach;

    @JsonIgnore
    @OneToMany(mappedBy = "monHoc",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},orphanRemoval = true)
    List<BangDiem> bangDiemList;

    @JsonIgnore
    @OneToMany(mappedBy = "monHoc",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},orphanRemoval = true)
    List<PhieuDiem> phieuDiemList;

}
