package kz.bitlab.g139rest.repository;

import kz.bitlab.g139rest.entity.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook, Long> {

}
