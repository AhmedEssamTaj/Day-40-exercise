package com.example.day39exercise.Controller;

import com.example.day39exercise.ApiResponse.ApiResponse;
import com.example.day39exercise.Model.Teacher;
import com.example.day39exercise.Repository.TeacherRepository;
import com.example.day39exercise.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/teacher")
@AllArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get-all")
    public ResponseEntity getAll (){
        return ResponseEntity.status(200).body(teacherService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully added teacher"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id,@RequestBody @Valid Teacher teacher) {
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully updated teacher"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully deleted teacher"));
    }

    @GetMapping("/get-teacher/{id}")
    public ResponseEntity getTeacherById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.getTeacherDetails(id));
    }

    @GetMapping("/get-teacher-course/{courseId}")
    public ResponseEntity getTeacherNameByCourse (@PathVariable Integer courseId){
        return ResponseEntity.status(200).body(teacherService.getTeacherNameByCourse(courseId));
    }

}
