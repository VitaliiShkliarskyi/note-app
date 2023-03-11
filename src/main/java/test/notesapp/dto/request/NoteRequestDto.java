package test.notesapp.dto.request;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class NoteRequestDto {
    private String content;
    private int likes;
    private LocalDateTime creatingTime;
}
