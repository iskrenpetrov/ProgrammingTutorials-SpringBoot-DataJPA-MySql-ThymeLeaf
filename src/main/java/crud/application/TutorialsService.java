package crud.application;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TutorialsService {

    @Autowired
    private TutorialsRepository repo;

    public List<Tutorials> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

//    public Page<Tutorials> listAll(String keyword,int pageNum) {
//
//        Pageable pageable = PageRequest.of(pageNum - 1, 5);
//        if (keyword != null) {
//            return (Page<Tutorials>) repo.search(keyword);
//        }
//        return repo.findAll(pageable);
//    }

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
