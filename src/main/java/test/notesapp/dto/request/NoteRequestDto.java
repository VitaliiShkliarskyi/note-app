package test.notesapp.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoteRequestDto {
    private String content;
    private int likes;
    private LocalDateTime creatingTime;
}
