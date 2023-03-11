package test.notesapp.service;

import java.util.List;
import test.notesapp.model.Note;

public interface NoteService {
    Note add(Note note);

    Note get(String id);

    Note update(Note note);

    List<Note> getAllSortedByDateInReverseOrder();

    void addLike(Note note);

    void removeLike(Note note);

}
