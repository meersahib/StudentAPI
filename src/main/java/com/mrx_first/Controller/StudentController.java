package com.mrx_first.Controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrx_first.Repository.StudentRepository;
import com.mrx_first.model.Student;

@RestController
@RequestMapping
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	@PostMapping ("/Students")
	public String createNewStudent(@RequestBody Student student) {
		studentRepository.save(student);
		return "Student Created in database";
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> stuList = new ArrayList<>();
		studentRepository.findAll().forEach(stuList::add);
		return new ResponseEntity<List<Student>>(stuList,HttpStatus.OK);
	}
	
	@GetMapping("/students/{stuid}")
	public ResponseEntity<Student> getStudentId(@PathVariable long stuid){
		Optional<Student> stu = studentRepository.findById(stuid);
		if (stu.isPresent()) {
			return new ResponseEntity<Student>(stu.get(),HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/students/{stuid}")
	public String updateStudentById(@PathVariable long stuid, @RequestBody Student student) {
		Optional<Student> stu = studentRepository.findById(stuid);
		if(stu.isPresent()) {
			Student existStu = stu.get();
			existStu.setStuid(student.getStuid());
			existStu.setStu_name(student.getStu_name());
			existStu.setStu_rollno(student.getStu_rollno());
			existStu.setStu_email(student.getStu_email());
			existStu.setStu_address(student.getStu_address());
			studentRepository.save(existStu);
			return "Student Details against Id " + stuid +" Updated ";
			
			
		}
		else {
			return "Student Details does not exist for stuid  " + stuid;
		}
	}
	@DeleteMapping("/students/{stuid}")
	public String deleteStudentByStuId(@PathVariable Long stuid) {
		studentRepository.deleteById(stuid);
		return "Student Deleted Successfully";
	}
	@DeleteMapping ("/students")
	public String deleteAllStudent() {
		studentRepository.deleteAll();
		return "Student deleted Successfully...";
	}
}
