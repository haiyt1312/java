package com.example.service;

import java.util.List;
import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.model.SinhVien;
import com.example.repository.SinhVienRepository;

@Service
public class SinhVienServiceImpl implements SinhVienService{

	@Autowired
	private SinhVienRepository sinhVienRepository;
	
	@Override
	public List<SinhVien> getAllSinhViens() {
		return sinhVienRepository.findAll();
	}

	@Override
	public void save(SinhVien sinhVien) {
		this.sinhVienRepository.save(sinhVien);
	}

	@Override
	public SinhVien getSinhVienById(int id) {
		Optional<SinhVien> optional = sinhVienRepository.findById(id);
		SinhVien sinhVien = null;
		if(optional.isPresent()) {
			sinhVien = optional.get();
		}else {
			throw new RuntimeException("Không tìm thấy id: " + id);
		}
		return sinhVien;
	}

	@Override
	public void deleteSinhVienById(int id) {
		this.sinhVienRepository.deleteById(id);
	}

	@Override
	public Page<SinhVien> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return this.sinhVienRepository.findAll(pageable);
	}

}
