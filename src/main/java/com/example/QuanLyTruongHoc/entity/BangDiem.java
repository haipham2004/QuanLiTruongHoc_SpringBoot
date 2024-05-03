package com.example.QuanLyTruongHoc.entity;

import jakarta.persistence.CascadeType;
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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name="BangDiem")
public class BangDiem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BangDiemID")
    private int bangDiemId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="HocSinhID")
    private HocSinh hocSinh;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="monHocID")
    private MonHoc monHoc;

    @Column(name="KyHoc")
    private String kyHoc;

    @Column(name="Diem")
    private double diem;



}
