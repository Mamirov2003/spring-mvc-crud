package uz.pdp.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.entity.Student;
import uz.pdp.repository.StudentRepository;

import java.util.List;

@Controller
public class ReadController {
//    @Autowired
//    StudentRepository studentRepository;
//
//    @RequestMapping(value = "/read", method = RequestMethod.GET)
//    public ModelAndView getAllStudents(ModelAndView model) {
//        List<Student> students = studentRepository.read();
//
//        System.out.println(students);
//        model.addObject("listStudent", students); //kalit so'z listStudent student bu bazadan kelgan list
//        model.setViewName("read");
//        return model;
//    }
//
//    //id 5
////    @GetMapping("/read/{id}")
////    @ResponseBody //string json
////    public String getById(@PathVariable("id") Integer ketmon) {
////        Student studentById = studentRepository.findStudentById(ketmon);
////        return "Student : " + studentById;
////    }
//
//    @GetMapping("/read/{email}") // /email
//    @ResponseBody //string json
//    public String getByEmail(@PathVariable String email) {
//        Student studentById = studentRepository.findStudentByEmail(email);
//        return "Student : " + studentById;
//    }
//
//    @GetMapping("/readParam") //?ketmon=N1&ketmon2=N2&ketmon3=N3
//    @ResponseBody
//    public String getByCourse(@RequestParam(value = "ketmon",defaultValue = "N1") String course) {
//        Student studentByCourse = studentRepository.findStudentByCourse(course);
//        return "Student  " + studentByCourse;
//    }



}
