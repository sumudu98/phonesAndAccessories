package scubes.phones_and_accessories.asset.brand.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scubes.phones_and_accessories.asset.item.entity.Item;
import scubes.phones_and_accessories.util.audit.AuditEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("Brand")
public class Brand extends AuditEntity {
    @NotNull
    @Size(min = 1, message = "This name length should be more than one character")
    private String name;
    @OneToMany(mappedBy = "brand")
    private List< Item > items;
}
