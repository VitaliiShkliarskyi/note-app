package test.notesapp.dto.response;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class NoteResponseDto {
    private String id;
    private String content;
    private int likes;
    private LocalDateTime creationTime;
}
