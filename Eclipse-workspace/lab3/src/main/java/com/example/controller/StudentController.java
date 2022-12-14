package com.example.controller;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Student;

@Controller
@RequestMapping("students")
public class StudentController {
	@ModelAttribute("genders")
	public Map<Boolean, String> getGenders() {
		Map<Boolean, String> genders = new HashMap<>();

		genders.put(true, "male");
		genders.put(false, "female");

		return genders;
	}

	@ModelAttribute("hobbies")
	public Map<String, String> getHobbies() {
		Map<String, String> hobbies = new HashMap<>();

		hobbies.put("M", "Music");
		hobbies.put("S", "Sports");

		return hobbies;
	}

	@ModelAttribute("faculties")
	public List<String> getFaculties() {
		return Arrays.asList("IT", "Web Design", "BA");
	}

	@Autowired
	ServletContext application;

	@GetMapping("new")
	public String newForm(Model model) {
		model.addAttribute("student", new Student());
		return "students/addOrEdit";
	}

	@PostMapping("saveOrUpdate")
	public String saveOrUpdate(@Validated @ModelAttribute("student") Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "students/addOrEdit";
		}
		
		if (student.getImageFile().isEmpty()) {
			String path = application.getRealPath("/");
			System.out.println("path: " + path);

			try {
				student.setImageUrl(student.getImageFile().getOriginalFilename());
				String filePath = path + "/images/" + student.getImageUrl();
				student.getImageFile().transferTo(Path.of(filePath));
				student.setImageFile(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("Student ID: " + student.getStudentId());
		System.out.println("Name: " + student.getName());
		return "students/detail";
	}
}
