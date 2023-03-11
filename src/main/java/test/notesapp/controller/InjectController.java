package test.notesapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.notesapp.model.Note;
import test.notesapp.model.User;
import test.notesapp.service.NoteService;
import test.notesapp.service.UserService;

@RestController
@RequestMapping("/inject")
public class InjectController {
    private final UserService userService;
    private final NoteService noteService;

    public InjectController(UserService userService, NoteService noteService) {
        this.userService = userService;
        this.noteService = noteService;
    }

    @GetMapping
    public String inject() {
        User firstUser = new User();
        firstUser.setEmail("user1@gmail.com");
        firstUser.setPassword("12345678");
        userService.add(firstUser);
        User secondUser = new User();
        secondUser.setEmail("user2@gmail.com");
        secondUser.setPassword("12345678");
        userService.add(secondUser);
        User thirdUser = new User();
        thirdUser.setEmail("user3@gmail.com");
        thirdUser.setPassword("12345678");
        userService.add(thirdUser);
        Note firstNote = new Note();
        firstNote.setContent("this is first note");
        noteService.add(firstNote);

        return "putin huilo!";
    }
}
