package lk.scubes_phone_and_accessories.asset.item.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemStatus {

    AVAILABLE("Available"),
    NOT_AVAILABLE("Not Available"),
    ORDERED("Ordered"),
    JUSTENTERED("Just Entered");

    private final String itemStatus;
}
