package crud.application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TutorialsRepository extends JpaRepository<Tutorials, Long> {
    //@Query annotation  — its value attribute contains the JPQL or SQL to execute.
    @Query("SELECT tut FROM Tutorials tut WHERE CONCAT(tut.name,tut.content,tut.author) LIKE %?1%")
    public List<Tutorials> search(String keyword);
}
