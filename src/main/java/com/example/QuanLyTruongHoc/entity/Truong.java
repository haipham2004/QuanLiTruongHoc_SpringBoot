package com.example.QuanLyTruongHoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="Truong")
public class Truong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TruongID")
    private int truongId;

    @Column(name="TenTruong")
    private String tenTruong;

    @Column(name="DiaChi")
    private String diaChi;

    @Column(name="SoDienThoai")
    private String soDienThoai;

    @OneToMany(mappedBy = "truong",cascade =CascadeType.ALL)
    @JsonIgnore
    private List<Lop> lop;

    @Column(name="deleted")
    private boolean deleted;
}
