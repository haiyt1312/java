package com.example.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.model.SinhVien;

public interface SinhVienService {
	List<SinhVien> getAllSinhViens();
	void save(SinhVien sinhVien);
	SinhVien getSinhVienById(int id);
	void deleteSinhVienById(int id);
	Page<SinhVien> findPaginated(int pageNo, int pageSize);
}
