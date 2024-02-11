package opentracinglearning.simpleapi.controller;

import opentracinglearning.simpleapi.model.Note;
import opentracinglearning.simpleapi.repository.NoteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoteController {

    private final NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping("/notes")
    public List<Note> getNotes() {
        return noteRepository.getAllNotes();
    }
}
