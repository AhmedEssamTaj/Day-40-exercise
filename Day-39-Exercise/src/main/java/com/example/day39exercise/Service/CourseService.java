package com.example.day39exercise.Service;

import com.example.day39exercise.ApiResponse.ApiException;
import com.example.day39exercise.Model.Course;
import com.example.day39exercise.Model.Teacher;
import com.example.day39exercise.Repository.CourseRepository;
import com.example.day39exercise.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getAll(){
        return courseRepository.findAll();
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    // method to assign a teacher to a course
    public void assignCourseToTeacher (Integer courseId, Integer teacherId){
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        Course course = courseRepository.findCourseById(courseId);

        if (teacher == null || course == null){
            throw new ApiException("Cannot assign course to this teacher");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public void updateCourse (Course course){
        Course oldCourse = courseRepository.findCourseById(course.getId());
        if(oldCourse == null){
            throw new ApiException("no course with this id was found");
        }
        oldCourse.setName(course.getName());
        courseRepository.save(oldCourse);
    }

    public void deleteCourse(Integer id){
        Course course = courseRepository.findCourseById(id);
        if(course == null){
            throw new ApiException("no course with this id was found");
        }
        courseRepository.delete(course);
    }

}
