package kz.bitlab.g139rest.controller;

import kz.bitlab.g139rest.entity.Notebook;
import kz.bitlab.g139rest.service.NotebookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/notebooks")
@RequiredArgsConstructor
public class NotebookController {

    private final NotebookService notebookService;

    @PostMapping("/dynamic-search") // нельзя использовать @GetMapping с @RequestBody. Ограничение у мобильного разработчика
    public ResponseEntity<List<Notebook>> dynamicSearch(@RequestBody Notebook notebook) {
        try {
            List<Notebook> notebooks = notebookService.dynamicSearch(notebook);
            return new ResponseEntity<>(notebooks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
