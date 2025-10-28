package kz.bitlab.g139rest.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import kz.bitlab.g139rest.entity.Brand;
import kz.bitlab.g139rest.entity.Notebook;
import kz.bitlab.g139rest.repository.NotebookRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotebookService {

    private final NotebookRepository notebookRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Notebook> dynamicSearch(Notebook notebook) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Notebook> query = cb.createQuery(Notebook.class);
        Root<Notebook> root = query.from(Notebook.class);

        List<Predicate> predicates = new ArrayList<>();

        String name = notebook.getName();
        if (name != null) {
            name = "%" + name.trim().toLowerCase() + "%";
            predicates.add(cb.like(cb.lower(root.get("name")), name));
        }

        String os = notebook.getOs();
        if (os != null) {
            os = os.toLowerCase().trim();
            predicates.add(cb.equal(cb.lower(root.get("os")), os));
        }

        String memory = notebook.getMemory();
        if (memory != null) {
            memory = memory.toLowerCase().trim();
            predicates.add(cb.equal(cb.lower(root.get("memory")), memory));
        }

        String ram = notebook.getRam();
        if (ram != null) {
            ram = ram.toLowerCase().trim();
            predicates.add(cb.equal(cb.lower(root.get("ram")), ram));
        }

        Double price = notebook.getPrice();
        if (price != null) {
            predicates.add(cb.le(root.get("price"), price));
        }

        Brand brand = notebook.getBrand();
        if (brand != null && brand.getId() != null) {
            predicates.add(cb.equal(root.get("brand"), brand));
        }

        Predicate[] array = predicates.toArray(new Predicate[0]);
        query.where(array);

        return entityManager.createQuery(query).getResultList();
    }
}
