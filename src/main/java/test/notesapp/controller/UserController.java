package test.notesapp.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import test.notesapp.dto.request.UserRequestDto;
import test.notesapp.dto.response.UserResponseDto;
import test.notesapp.model.User;
import test.notesapp.service.UserService;
import test.notesapp.service.mapper.RequestDtoMapper;
import test.notesapp.service.mapper.ResponseDtoMapper;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ResponseDtoMapper<UserResponseDto, User> responseDtoMapper;
    private final RequestDtoMapper<UserRequestDto, User> requestDtoMapper;

    public UserController(UserService userService,
                          ResponseDtoMapper<UserResponseDto, User> responseDtoMapper,
                          RequestDtoMapper<UserRequestDto, User> requestDtoMapper) {
        this.userService = userService;
        this.responseDtoMapper = responseDtoMapper;
        this.requestDtoMapper = requestDtoMapper;
    }

    @GetMapping("/")
    public List<UserResponseDto> gelAllUsers() {
        return userService.findAll().stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/id")
    public UserResponseDto getById(@RequestParam String id) {
        return responseDtoMapper.mapToDto(userService.get(id));
    }

    @GetMapping("/by-email")
    public UserResponseDto getByEmail(@RequestParam String email) {
        return responseDtoMapper.mapToDto(userService.findByEmail(email));
    }

    @DeleteMapping("/id")
    public void delete (@RequestParam String id) {
        userService.delete(userService.get(id));
    }

    @PutMapping("/id")
    public UserResponseDto update (@RequestParam String id,
                                   @RequestParam UserRequestDto requestDto) {
        User user = requestDtoMapper.mapToModel(requestDto);
        user.setId(id);
        User updatedUser = userService.update(user);
        return responseDtoMapper.mapToDto(updatedUser);
    }

}
