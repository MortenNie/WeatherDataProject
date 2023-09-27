package dat;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User {

    @Id
    @Column(name = "name")
    private String userName;

    @Column(name = "password")
    private int password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<WeatherEntity> weatherEntitySet= new HashSet<>();

    public User(String name, int password) {
        this.userName = name;
        this.password = password;
    }
}
