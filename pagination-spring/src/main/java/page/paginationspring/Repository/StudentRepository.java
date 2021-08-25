package page.paginationspring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import page.paginationspring.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
