package test.notesapp.repository;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import test.notesapp.model.Note;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {
    List<Note> findAll(Sort sort);
}
