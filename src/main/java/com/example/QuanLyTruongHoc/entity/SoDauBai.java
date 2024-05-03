package com.example.QuanLyTruongHoc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name="SoDauBai")
public class SoDauBai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SoDauBaiID")
    private int soDauBaiId;

    @ManyToOne
    @JoinColumn(name="LopID")
    private Lop lop;

    @ManyToOne
    @JoinColumn(name="NhanVienID")
    private NhanVien nhanVien;

    @Column(name="NgayGiangDay")
    private Date ngayGiangDay;

    @Column(name="NoiDungBaiGiang")
    private String noiDungBaiGiang;


}
