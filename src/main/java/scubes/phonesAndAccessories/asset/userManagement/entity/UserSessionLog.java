package scubes.phonesAndAccessories.asset.userManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scubes.phonesAndAccessories.asset.userManagement.entity.Enum.UserSessionLogStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSessionLog {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    private int failureAttempts;

    @Column( updatable = false, nullable = false )
    private LocalDateTime createdAt;

    @Enumerated( EnumType.STRING )
    private UserSessionLogStatus userSessionLogStatus;

    @ManyToOne
    private User user;
}
