package in.suman.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import in.suman.model.Student;
import in.suman.repository.StudentRepository;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @GetMapping("/students")
    public String getAllStudents(Model model) {
        // Get the list of students from the database
        List<Student> students = studentRepository.findAll();
        // Sort the list in ascending order based on ID
        Collections.sort(students, Comparator.comparingLong(Student::getId));
        // Add the list of students to the model
        model.addAttribute("students", students);
        return "students";
    }

    
    @PostMapping("/students/new")
    @ResponseBody
    public ResponseEntity<String> saveStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return ResponseEntity.ok("Student created successfully");
    }

    @GetMapping("/students/edit/{id}")
    @ResponseBody
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/students/edit/{id}")
    @ResponseBody
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @ModelAttribute Student student) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setEmail(student.getEmail());
            studentRepository.save(existingStudent);
            return ResponseEntity.ok("Student updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/students/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
}