package test.notesapp.service.mapper;

import org.springframework.stereotype.Component;
import test.notesapp.dto.request.NoteRequestDto;
import test.notesapp.dto.response.NoteResponseDto;
import test.notesapp.model.Note;

@Component
public class NoteMapper implements RequestDtoMapper<NoteRequestDto, Note>,
        ResponseDtoMapper<NoteResponseDto, Note> {
    @Override
    public Note mapToModel(NoteRequestDto dto) {
        Note note = new Note();
        note.setContent(dto.getContent());
        note.setCreatingTime(dto.getCreatingTime());
        return null;
    }

    @Override
    public NoteResponseDto mapToDto(Note note) {
        NoteResponseDto responseDto = new NoteResponseDto();
        responseDto.setId(note.getId());
        responseDto.setContent(note.getContent());
        responseDto.setLikes(note.getLikes());
        responseDto.setCreationTime(note.getCreatingTime());
        return responseDto;
    }
}
