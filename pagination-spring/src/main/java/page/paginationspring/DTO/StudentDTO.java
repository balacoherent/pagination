package page.paginationspring.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class StudentDTO {

    private Integer id;

    private String name;

    private Integer age;

    private  Integer regNumber;
}
