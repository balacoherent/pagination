package page.paginationspring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import page.paginationspring.BaseResponse.ApiResponse;
import page.paginationspring.BaseResponse.BaseResponse;
import page.paginationspring.DTO.StudentDTO;
import page.paginationspring.Entity.Student;
import page.paginationspring.Repository.StudentRepository;

import java.util.List;

@Service

public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public BaseResponse add(StudentDTO studentDTO){

        Student student= new Student();
        BaseResponse baseResponse = new BaseResponse();
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        student.setRegNumber(studentDTO.getRegNumber());
        studentRepository.save(student);
        baseResponse.setData(student);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        return baseResponse;

    }

    public Page<Student> findStudentWithPagination(int offset,int pageSize){
        ApiResponse apiResponse = new ApiResponse();
        Page<Student> students =studentRepository.findAll(PageRequest.of(offset, pageSize));
        return students;
    }
    public List<Student> findStudentWithSorting(String field){
        return studentRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }
}