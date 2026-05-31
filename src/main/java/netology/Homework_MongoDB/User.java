package netology.Homework_MongoDB;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
// для создания геттеров.сеттеров
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;

    @NotBlank (message = "Имя обязательно")
    private String name;

    @NotBlank (message = "Email обязателен")
    @Email(message = "Неккоректный email")
    private String email;

    @Positive(message = "Возраст должен быть положительным")
    private Integer age;
}
