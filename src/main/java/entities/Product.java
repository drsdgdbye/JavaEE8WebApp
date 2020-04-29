package entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
@EqualsAndHashCode(of = {"id"})
public class Product implements Serializable {

    private static final long serialVersionUID = 1762949555278249803L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Float price;

    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(String title, String description, Float price, Category category) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
    }
}
