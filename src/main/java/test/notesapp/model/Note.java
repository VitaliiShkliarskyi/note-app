package test.notesapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;

@Data
public class Note {
    @Id
    private String id;
    private String content;
    private int likes;
    private LocalDateTime creatingTime;
}
