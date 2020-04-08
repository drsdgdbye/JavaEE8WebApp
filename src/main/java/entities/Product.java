package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product implements Serializable {

    private static final long serialVersionUID = 1762949555278249803L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private BigDecimal price;

    private String description;

    public Product(String title, String description, BigDecimal price) {
        this.title = title;
        this.price = price;
        this.description = description;
    }
}
