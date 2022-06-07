package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.entity.Student;
import uz.pdp.repository.StudentRepository;

@Controller //bean + http zaproslar bilan ishlashini bildirib turish
//@RequestMapping("/student")  /student/add
public class CreateController {

//    @Autowired
//    StudentRepository studentRepository;
//
//    //page qaytaryapti bu optimal emas
////    @RequestMapping(value = "/create", method = RequestMethod.GET)
////    @ResponseBody // json format
//    public ModelAndView getSaveStudent(ModelAndView mv) {
//        mv.setViewName("create");
//        return mv;
//    }
//
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public ModelAndView saveStudent(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("course") String course, ModelAndView mv) {
//
//        Student student = Student.builder().name(name).email(email).course(course).build();
//
//        int num = studentRepository.create(student);
//
//        if (num == 0) {
//            mv.addObject("ketmon", "Student qo'shishda xatolik");
//        } else {
//            mv.addObject("ketmon", "Student added!");
//        }
//
//        mv.setViewName("create"); //create.jsp ni   web papkadam qidiradi
//        return mv;
//    }

    //ishlamadi
//    @PostMapping("/add")
//    @ResponseBody
//    public String saveStudent(@RequestBody Student requestStudent) {
//
//        Student student = Student.builder().name(requestStudent.getName()).email(requestStudent.getEmail())
//                .course(requestStudent.getCourse()).build();
//
//        int num = studentRepository.create(student);
//        return num > 0 ? "Added! " : "Error";
//    }


}
