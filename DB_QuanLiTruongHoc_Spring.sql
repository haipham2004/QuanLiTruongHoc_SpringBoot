CREATE DATABASE Spring_QuanLyTruongHoc
go
use Spring_QuanLyTruongHoc
go
--Date:02-05-2024 lúc 00g16p
--Trường THPT YKA 2019-2022
-- Thanh xuân mãi đẹp của tôi: Hải Phạm YKA
-- Tạo bảng Truong
CREATE TABLE Truong (
    TruongID INT identity(1,1) PRIMARY KEY,
    TenTruong NVARCHAR(100),
    DiaChi NVARCHAR(200),
    SoDienThoai NVARCHAR(15),
	deleted bit --1:true 2:false
);

-- Tạo bảng Lớp
CREATE TABLE Lop (
    LopID INT identity(1,1) PRIMARY KEY,
    TenLop NVARCHAR(50),
    KhoiHoc NVARCHAR(20),
    NienKhoa NVARCHAR(10),
    GiaoVienChuNhiem NVARCHAR(100),
    TruongID INT,
    CONSTRAINT FK_Truong_Lop FOREIGN KEY (TruongID) REFERENCES Truong(TruongID),
	deleted bit
);

-- Tạo bảng Nhân viên
CREATE TABLE NhanVien (
    NhanVienID INT identity(1,1) PRIMARY KEY,
    TenNhanVien NVARCHAR(100),
    VaiTro NVARCHAR(50),
    LopID INT,
    CONSTRAINT FK_Lop_NhanVien FOREIGN KEY (LopID) REFERENCES Lop(LopID),
	deleted bit
);

-- Tạo bảng Phụ huynh
CREATE TABLE PhuHuynh (
    PhuHuynhID INT identity(1,1) PRIMARY KEY,
    TenPhuHuynh NVARCHAR(100),
    ThongTinLienLac NVARCHAR(200),
	deleted bit
);

-- Tạo bảng Học sinh
CREATE TABLE HocSinh (
    HocSinhID INT identity(1,1) PRIMARY KEY,
    TenHocSinh NVARCHAR(100),
    LopID INT,
    PhuHuynhID INT,
    CONSTRAINT FK_Lop_HocSinh FOREIGN KEY (LopID) REFERENCES Lop(LopID),
	CONSTRAINT FK_Lop_PhuHuynh FOREIGN KEY (PhuHuynhID) REFERENCES PhuHuynh(PhuHuynhID),
	deleted bit
);

-- Tạo bảng Môn học
CREATE TABLE MonHoc (
    MonHocID INT identity(1,1) PRIMARY KEY,
    TenMonHoc NVARCHAR(100),
    GiaoVienPhuTrach NVARCHAR(100),
	deleted bit
);

-- Tạo bảng Bảng điểm
CREATE TABLE BangDiem (
    BangDiemID INT identity(1,1) PRIMARY KEY,
    HocSinhID INT,
    MonHocID INT,
    KyHoc NVARCHAR(20),
    Diem FLOAT,
    CONSTRAINT FK_HocSinh_BangDiem FOREIGN KEY (HocSinhID) REFERENCES HocSinh(HocSinhID),
    CONSTRAINT FK_MonHoc_BangDiem FOREIGN KEY (MonHocID) REFERENCES MonHoc(MonHocID),
	deleted bit
);

-- Tạo bảng Sổ đầu bài
CREATE TABLE SoDauBai (
    SoDauBaiID INT identity(1,1)  PRIMARY KEY,
    LopID INT,
    NhanVienID INT,
    NgayGiangDay DATE,
    NoiDungBaiGiang NVARCHAR(100),
    CONSTRAINT FK_Lop_SoDauBai FOREIGN KEY (LopID) REFERENCES Lop(LopID),
    CONSTRAINT FK_NhanVien_SoDauBai FOREIGN KEY (NhanVienID) REFERENCES NhanVien(NhanVienID),
	deleted bit
);

-- Tạo bảng Sổ học bạ
CREATE TABLE SoHocBa  (
    SoHocBaID INT identity(1,1)  PRIMARY KEY,
    HocSinhID INT,
    HocLuc NVARCHAR(50),
    HanhKiem NVARCHAR(50),
    NhanXet NVARCHAR(100),
    CONSTRAINT FK_HocSinh_SoHocBa FOREIGN KEY (HocSinhID) REFERENCES HocSinh(HocSinhID),
	deleted bit
);

-- Tạo bảng Phiếu điểm
CREATE TABLE PhieuDiem (
    PhieuDiemID INT identity(1,1)  PRIMARY KEY,
    HocSinhID INT,
    MonHocID INT,
    NgayKiemTra DATE,
    Diem FLOAT,
    CONSTRAINT FK_HocSinh_PhuongDiem FOREIGN KEY (HocSinhID) REFERENCES HocSinh(HocSinhID),
    CONSTRAINT FK_MonHoc_PhuongDiem FOREIGN KEY (MonHocID) REFERENCES MonHoc(MonHocID),
	deleted bit
);

INSERT INTO Truong (TenTruong, DiaChi, SoDienThoai, deleted) VALUES
(N'Trường THPT Yên Khánh A', N'Khánh Hội, Yên Khánh, Ninh Bình', '0334294889', 0),
(N'Trường A', N'Địa chỉ A', '1234567890', 0),
(N'Trường B', N'Địa chỉ B', '0987654321', 0),
(N'Trường C', N'Địa chỉ C', '0123456789', 0),
(N'Trường D', N'Địa chỉ D', '9876543210', 0),
(N'Trường E', N'Địa chỉ E', '5555555555', 0),
(N'Trường F', N'Địa chỉ F', '6666666666', 0),
(N'Trường G', N'Địa chỉ G', '7777777777', 0),
(N'Trường H', N'Địa chỉ H', '8888888888', 0),
(N'Trường I', N'Địa chỉ I', '9999999999', 0);

-- Chèn dữ liệu vào bảng Lop
INSERT INTO Lop (TenLop, KhoiHoc, NienKhoa, GiaoVienChuNhiem, TruongID, deleted) VALUES
(N'Lớp 1', N'10', N'2019-2022', N'GV A', 1, 0),
(N'Lớp 2', N'10', N'2019-2022', N'GV B', 2, 0),
(N'Lớp 3', N'11', N'2019-2022', N'GV C', 3, 0),
(N'Lớp 4', N'11', N'2019-2022', N'GV D', 4, 0),
(N'Lớp 5', N'12', N'2019-2022', N'GV E', 5, 0),
(N'Lớp 6', N'12', N'2019-2022', N'GV F', 6, 0),
(N'Lớp 7', N'10', N'2019-2022', N'GV G', 7, 0),
(N'Lớp 8', N'11', N'2019-2022', N'GV H', 8, 0),
(N'Lớp 9', N'12', N'2019-2022', N'GV I', 9, 0),
(N'Lớp 12D', N'12', N'2019-2022', N'GV Phạm Ngọc Lan', 10, 0);

-- Chèn dữ liệu vào bảng Nhân viên
INSERT INTO NhanVien (TenNhanVien, VaiTro, LopID, deleted) VALUES
(N'Nhân viên A', N'Giao viên', 1, 0),
(N'Nhân viên B', N'Giao viên', 2, 0),
(N'Nhân viên C', N'Giao viên', 3, 0),
(N'Nhân viên D', N'Giao viên', 4, 0),
(N'Nhân viên E', N'Giao viên', 5, 0),
(N'Nhân viên F', N'Giao viên', 6, 0),
(N'Nhân viên G', N'Giao viên', 7, 0),
(N'Nhân viên H', N'Giao viên', 8, 0),
(N'Nhân viên I', N'Giao viên', 9, 0),
(N'Nhân viên J', N'Giao viên', 10, 0);

-- Chèn dữ liệu vào bảng Phụ huynh
INSERT INTO PhuHuynh (TenPhuHuynh, ThongTinLienLac, deleted) VALUES
(N'Phụ huynh A', N'Địa chỉ A - SĐT A', 0),
(N'Phụ huynh B', N'Địa chỉ B - SĐT B', 0),
(N'Phụ huynh C', N'Địa chỉ C - SĐT C', 0),
(N'Phụ huynh D', N'Địa chỉ D - SĐT D', 0),
(N'Phụ huynh E', N'Địa chỉ E - SĐT E', 0),
(N'Phụ huynh F', N'Địa chỉ F - SĐT F', 0),
(N'Phụ huynh G', N'Địa chỉ G - SĐT G', 0),
(N'Phụ huynh H', N'Địa chỉ H - SĐT H', 0),
(N'Phụ huynh I', N'Địa chỉ I - SĐT I', 0),
(N'Phụ huynh J', N'Địa chỉ J - SĐT J', 0);

-- Chèn dữ liệu vào bảng Học sinh
INSERT INTO HocSinh (TenHocSinh, LopID, PhuHuynhID, deleted) VALUES
(N'Học sinh A', 1, 1, 0),
(N'Học sinh B', 1, 2, 0),
(N'Học sinh C', 2, 3, 0),
(N'Học sinh D', 2, 4, 0),
(N'Học sinh E', 3, 5, 0),
(N'Học sinh F', 3, 6, 0),
(N'Học sinh G', 4, 7, 0),
(N'Học sinh H', 5, 8, 0),
(N'Học sinh I', 6, 9, 0),
(N'Học sinh J', 7, 10, 0);

-- Chèn dữ liệu vào bảng Môn học
INSERT INTO MonHoc (TenMonHoc, GiaoVienPhuTrach, deleted) VALUES
(N'Môn học A', N'GV A', 0),
(N'Môn học B', N'GV B', 0),
(N'Môn học C', N'GV C', 0),
(N'Môn học D', N'GV D', 0),
(N'Môn học E', N'GV E', 0),
(N'Môn học F', N'GV F', 0),
(N'Môn học G', N'GV G', 0),
(N'Môn học H', N'GV H', 0),
(N'Môn học I', N'GV I', 0),
(N'Môn học J', N'GV J', 0);

-- Chèn dữ liệu vào bảng BangDiem
INSERT INTO BangDiem (HocSinhID, MonHocID, KyHoc, Diem, deleted) VALUES
(1, 1, N'Kỳ 1', 8.5, 0),
(2, 1, N'Kỳ 1', 9.0, 0),
(3, 2, N'Kỳ 1', 7.5, 0),
(4, 2, N'Kỳ 1', 8.0, 0),
(5, 3, N'Kỳ 1', 6.5, 0),
(6, 3, N'Kỳ 1', 7.0, 0),
(7, 4, N'Kỳ 1', 5.5, 0),
(8, 4, N'Kỳ 1', 6.0, 0),
(9, 5, N'Kỳ 1', 9.5, 0),
(10, 5, N'Kỳ 1', 10.0, 0);

-- Chèn dữ liệu vào bảng Sổ đầu bài
INSERT INTO SoDauBai (LopID, NhanVienID, NgayGiangDay, NoiDungBaiGiang, deleted) VALUES
(1, 1, '2024-01-01', N'Bài giảng A', 0),
(2, 2, '2024-01-01', N'Bài giảng B', 0),
(3, 3, '2024-01-01', N'Bài giảng C', 0),
(4, 4, '2024-01-01', N'Bài giảng D', 0),
(5, 5, '2024-01-01', N'Bài giảng E', 0),
(6, 6, '2024-01-01', N'Bài giảng F', 0),
(7, 7, '2024-01-01', N'Bài giảng G', 0),
(8, 8, '2024-01-01', N'Bài giảng H', 0),
(9, 9, '2024-01-01', N'Bài giảng I', 0),
(10, 10, '2024-01-01', N'Bài giảng J', 0);

-- Chèn dữ liệu vào bảng Sổ học bạ
INSERT INTO SoHocBa (HocSinhID, HocLuc, HanhKiem, NhanXet, deleted) VALUES
(1, N'Tốt', N'Tốt', N'Nhan xet A', 0),
(2, N'Tốt', N'Tốt', N'Nhan xet B', 0),
(3, N'Trung bình', N'Trung bình', N'Nhan xet C', 0),
(4, N'Trung bình', N'Trung bình', N'Nhan xet D', 0),
(5, N'Yếu', N'Yếu', N'Nhan xet E', 0),
(6, N'Yếu', N'Yếu', N'Nhan xet F', 0),
(7, N'Tốt', N'Tốt', N'Nhan xet G', 0),
(8, N'Tốt', N'Tốt', N'Nhan xet H', 0),
(9, N'Tốt', N'Tốt', N'Nhan xet I', 0),
(10, N'Tốt', N'Tốt', N'Nhan xet J', 0);

-- Chèn dữ liệu vào bảng Phiếu điểm
INSERT INTO PhieuDiem (HocSinhID, MonHocID, NgayKiemTra, Diem, deleted) VALUES
(1, 1, '2024-01-01', 8.5, 0),
(2, 1, '2024-01-01', 9.0, 0),
(3, 2, '2024-01-01', 7.5, 0),
(4, 2, '2024-01-01', 8.0, 0),
(5, 3, '2024-01-01', 6.5, 0),
(6, 3, '2024-01-01', 7.0, 0),
(7, 4, '2024-01-01', 5.5, 0),
(8, 4, '2024-01-01', 6.0, 0),
(9, 5, '2024-01-01', 9.5, 0),
(10, 5, '2024-01-01', 10.0, 0);

-- Chèn dữ liệu vào bảng Thẻ học sinh
INSERT INTO TheHocSinh (HocSinhID, HoTen, AnhDaiDien, ThongTinLienLac, deleted) VALUES
(1, N'Học sinh A', NULL, N'Thông tin liên lạc A', 0),
(2, N'Học sinh B', NULL, N'Thông tin liên lạc B', 0),
(3, N'Học sinh C', NULL, N'Thông tin liên lạc C', 0),
(4, N'Học sinh D', NULL, N'Thông tin liên lạc D', 0),
(5, N'Học sinh E', NULL, N'Thông tin liên lạc E', 0),
(6, N'Học sinh F', NULL, N'Thông tin liên lạc F', 0),
(7, N'Học sinh G', NULL, N'Thông tin liên lạc G', 0),
(8, N'Học sinh H', NULL, N'Thông tin liên lạc H', 0),
(9, N'Học sinh I', NULL, N'Thông tin liên lạc I', 0),
(10, N'Học sinh J', NULL, N'Thông tin liên lạc J', 0);
