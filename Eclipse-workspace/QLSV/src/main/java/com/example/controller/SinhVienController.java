package com.example.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.SinhVien;
import com.example.service.SinhVienService;

@Controller
@RequestMapping("/")
public class SinhVienController {
	@Autowired
	private SinhVienService sinhVienService;
	
	@GetMapping("home")
	public String viewHomePage(Model model) {
		model.addAttribute("listSinhVien", sinhVienService.getAllSinhViens());
		return "index";
//		return findPaginated(1, model);
	}
	
	@GetMapping("themSinhVien")
	public String add(Model model) {
		SinhVien sinhVien = new SinhVien();
		model.addAttribute("sinhVien", sinhVien);
		return "new_sinhVien";
	}
	
	@PostMapping("saveSinhVien")
	public String saveSinhVien(@ModelAttribute("sinhVien") SinhVien sinhVien) {
		sinhVienService.save(sinhVien);
		return "redirect:/home";
	}
	
	@GetMapping("updateSinhVien/{id}")
	public String updateSinhVien(@PathVariable (value = "id") int id, Model model) {
		SinhVien sinhVien = sinhVienService.getSinhVienById(id);
		model.addAttribute("sinhVien", sinhVien);
		return "update_sinhVien";
	}
	
	@GetMapping("deleteSinhVien/{id}")
	public String deleteSinhVien(@PathVariable (value = "id") int id, Model model) {
		this.sinhVienService.deleteSinhVienById(id);
		return "redirect:/home";
	}
	
	/*
	 * @GetMapping("/page/{pageNo}") public String findPaginated(@PathVariable
	 * (value = "pageNo") int pageNo, Model model) { int pageSize = 5;
	 * 
	 * Page<SinhVien> page = sinhVienService.findPaginated(pageNo, pageSize);
	 * List<SinhVien> listSinhVien = page.getContent();
	 * 
	 * model.addAttribute("currentPage", pageNo); model.addAttribute("totalPages",
	 * page.getTotalPages()); model.addAttribute("totalItems",
	 * page.getTotalElements()); model.addAttribute("listSinhVien", listSinhVien);
	 * return "index"; }
	 */
}
