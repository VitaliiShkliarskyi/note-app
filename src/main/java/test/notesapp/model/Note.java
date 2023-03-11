package test.notesapp.model;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Note {
    @Id
    private String id;
    private String content;
    private int likes;
    private LocalDateTime creatingTime;
}
