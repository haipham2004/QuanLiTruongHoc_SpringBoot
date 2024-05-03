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
@Table(name="PhieuDiem")
public class PhieuDiem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PhieuDiemID")
    private int PhieuDiemId;

    @ManyToOne
    @JoinColumn(name="HocSinhID")
    private HocSinh hocSinh;

    @ManyToOne
    @JoinColumn(name="MonHocID")
    private MonHoc monHoc;

    @Column(name="NgayKiemTra")
    private Date ngayKiemTra;

    @Column(name="Diem")
    private float diem;
}

