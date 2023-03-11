package test.notesapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Note {
    @Id
    private String id;
    private String content;
    private int likes;
    private LocalDateTime creatingTime;
}
