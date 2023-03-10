package test.notesapp.dto.request;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
public class UserRequestDto {
    @Indexed(unique = true)
    private String email;
    private String password;
}
