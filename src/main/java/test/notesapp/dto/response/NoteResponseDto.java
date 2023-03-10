package test.notesapp.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoteResponseDto {
    private String id;
    private String content;
    private int likes;
    private LocalDateTime creationTime;
}
