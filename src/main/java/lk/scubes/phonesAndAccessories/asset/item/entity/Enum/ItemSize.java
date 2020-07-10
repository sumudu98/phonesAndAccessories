package lk.sanchana.bagShop.asset.item.entity.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@AllArgsConstructor
public enum ItemSize {
    S("Small"),
    M("Medium"),
    L("Large");

    private final String itemSize;
}
