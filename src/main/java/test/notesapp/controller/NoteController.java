package test.notesapp.controller;

import org.springframework.web.bind.annotation.*;
import test.notesapp.dto.request.NoteRequestDto;
import test.notesapp.dto.response.NoteResponseDto;
import test.notesapp.model.Note;
import test.notesapp.service.NoteService;
import test.notesapp.service.mapper.RequestDtoMapper;
import test.notesapp.service.mapper.ResponseDtoMapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;
    private final ResponseDtoMapper<NoteResponseDto, Note> responseDtoMapper;
    private final RequestDtoMapper<NoteRequestDto, Note> requestDtoMapper;

    public NoteController(NoteService noteService,
                          ResponseDtoMapper<NoteResponseDto, Note> responseDtoMapper,
                          RequestDtoMapper<NoteRequestDto, Note> requestDtoMapper) {
        this.noteService = noteService;
        this.responseDtoMapper = responseDtoMapper;
        this.requestDtoMapper = requestDtoMapper;
    }

    @GetMapping("/")
    public List<NoteResponseDto> getAllSortedByDateInReverseOrder() {
        return noteService.getAllSortedByDateInReverseOrder().stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public NoteResponseDto createNote(@RequestBody NoteRequestDto requestDto) {
        Note note = requestDtoMapper.mapToModel(requestDto);
        note.setLikes(0);
        note.setCreatingTime(LocalDateTime.now());
        noteService.add(note);
        return responseDtoMapper.mapToDto(note);
    }

    @PutMapping("/like")
    public NoteResponseDto addLike(@RequestParam String id) {
        Note note = noteService.get(id);
        noteService.addLike(note);
        noteService.update(note);
        return responseDtoMapper.mapToDto(note);
    }

    @PutMapping("/remove-like")
    public NoteResponseDto removeLike(@RequestParam String id) {
        Note note = noteService.get(id);
        noteService.removeLike(note);
        noteService.update(note);
        return responseDtoMapper.mapToDto(note);
    }
}
