package page.paginationspring.Controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import page.paginationspring.BaseResponse.ApiResponse;
import page.paginationspring.BaseResponse.BaseResponse;
import page.paginationspring.DTO.StudentDTO;
import page.paginationspring.Entity.Student;
import page.paginationspring.Service.StudentService;


import java.util.List;


@RestController
@RequestMapping("/student")

public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/pagination/{offset}/{pageSize}")
    private ApiResponse<Page<Student>> getStudentWithPagination
            (@PathVariable int offset,@PathVariable int pageSize){
        Page<Student> studentWithPagination = studentService.findStudentWithPagination (offset, pageSize);
        return  new ApiResponse<>(studentWithPagination.getSize(),studentWithPagination);

    }

    @GetMapping("/{field}")
    private ApiResponse<List<Student>> getStudentsWithSort(@PathVariable String field){
        List<Student> allStudents = studentService.findStudentWithSorting(field);
        return new ApiResponse<>(allStudents.size(),allStudents);
    }

    @PostMapping("/addStudent")
    public BaseResponse add(@RequestBody StudentDTO studentDTO){
        return studentService.add(studentDTO);
    }
}
