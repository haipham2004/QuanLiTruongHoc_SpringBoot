package com.example.QuanLyTruongHoc.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrolResponse {

    public int status;
    public String message;
    public Date timestamp;

    public ErrolResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date(System.currentTimeMillis());
    }
}
