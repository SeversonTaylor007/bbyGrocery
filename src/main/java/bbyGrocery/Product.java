package bbyGrocery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
class Product {

    private @Id @GeneratedValue Long id;
    private String name;
    private Integer quantity;
    private Float price;

    Product(String name, Integer quantity, Float price) {

        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Float price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Product))
            return false;
        Product product = (Product) o;
        return Objects.equals(this.id, product.id) && Objects.equals(this.name, product.name)
                && Objects.equals(this.quantity, product.quantity)
                && Objects.equals(this.price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.quantity, this.price);
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + this.id + ", name='" + this.name + '\'' + ", quantity='" + this.quantity + ", price='" + this.price + '\'' + '}';
    }
}