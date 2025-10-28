package kz.bitlab.g139rest.service;

import kz.bitlab.g139rest.entity.Notebook;
import kz.bitlab.g139rest.repository.notebook.NotebookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotebookService {

    private final NotebookRepository notebookRepository;

    public List<Notebook> dynamicSearch(Notebook notebook) {
        return notebookRepository.dynamicSearch(notebook);
    }
}
