package scubes.phones_and_accessories.asset.user_management.entity.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserSessionLogStatus {
    LOGGED("User Logged"),
    LOGOUT("User Logout"),
    FAILURE("Failure");

    private final String userSessionLogStatus;
}
