package test.notesapp.service.mapper;

import org.springframework.stereotype.Component;
import test.notesapp.dto.request.UserRequestDto;
import test.notesapp.dto.response.UserResponseDto;
import test.notesapp.model.User;

@Component
public class UserMapper implements ResponseDtoMapper<UserResponseDto, User>,
        RequestDtoMapper<UserRequestDto, User> {
    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setEmail(user.getEmail());
        return responseDto;
    }

    @Override
    public User mapToModel(UserRequestDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }
}
