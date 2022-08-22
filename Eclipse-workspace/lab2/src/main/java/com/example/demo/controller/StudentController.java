package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Student;

@Controller
@RequestMapping("students")
public class StudentController {
	@ModelAttribute("students")
	public List<Student> getStudents(){
		List<Student> list = new ArrayList<>();
		
		list.add(new Student("S01", "Hai"));
		list.add(new Student("S02", "Haiii"));
		return list;
	}
	
	@GetMapping("new")
	public String newForm() {
		return "students/new";
	}
	
	@PostMapping("saveOrUpdate")
	public String saveOrUpdate(@RequestParam("studentId") String studentId,
						@RequestParam("name") String name,
						Model model) {
		System.out.println("student ID: " + studentId);
		System.out.println("name : " + name);
		
		model.addAttribute("studentId", studentId);
		model.addAttribute("name", name);
		return "students/viewDetail";
	}
	
	@PostMapping("update")
	public String update(Student student, Model model) {
		System.out.println("update method");
		
		model.addAttribute("studentId", student.getStudentId());
		model.addAttribute("name", student.getName());
		return "students/viewDetail";
	}
	
	@GetMapping("edit/{studentId}")
	public String edit(@PathVariable("studentId") String studentId, Model model) {
		System.out.println("Edit student ID: " + studentId);
		
		Student student = new Student();
		
		student.setStudentId(studentId);
		student.setName("Hai");
		
		model.addAttribute("student", student);
		
		return "students/edit";
	}
	
	@RequestMapping("list")
	public String list() {
		return "students/list";
	}
	
	@RequestMapping("search")
	public String search() {
		return "students/search";
	}
}
