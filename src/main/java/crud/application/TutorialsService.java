package crud.application;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //similar to @Component, indicates that an annotated class is a service class.
@Transactional //important aspects such as transaction propagation are handled automatically.
public class TutorialsService {

    @Autowired // marks a constructor, field, or setter method to be autowired by Spring dependency injection.
    private TutorialsRepository repo;

    public List<Tutorials> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        //If the searching form is equal to null, invoke the default findAll() member function
        return repo.findAll();
    }

    public void save(Tutorials tutorial) {
        repo.save(tutorial);
    }

    public Tutorials get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
