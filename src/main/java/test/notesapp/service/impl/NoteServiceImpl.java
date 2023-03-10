package test.notesapp.service.impl;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import test.notesapp.model.Note;
import test.notesapp.repository.NoteRepository;
import test.notesapp.service.NoteService;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    private static final Sort DESC_BY_DATE =
            Sort.by(Sort.Direction.DESC, "creationTime");
    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note add(Note note) {
        return noteRepository.insert(note);
    }

    @Override
    public Note get(String id) {
        return noteRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Note with id " + id + " not found"));
    }

    @Override
    public Note update(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public List<Note> getAllSortedByDateInReverseOrder() {
        return noteRepository.findAll(DESC_BY_DATE);
    }

    @Override
    public void addLike(Note note) {
        int likes = note.getLikes();
        note.setLikes(++likes);
        noteRepository.save(note);
    }

    @Override
    public void removeLike(Note note) {
        int likes = note.getLikes();
        if (likes > 0) {
            note.setLikes(--likes);
            noteRepository.save(note);
        }
    }
}
