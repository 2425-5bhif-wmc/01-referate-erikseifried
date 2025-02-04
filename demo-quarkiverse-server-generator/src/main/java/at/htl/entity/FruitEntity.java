package at.htl.entity;
import io.apicurio.api.beans.Fruit;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class FruitEntity extends PanacheEntity {
    @Column(nullable = false)
    public String name;

    public FruitEntity() {}

    public FruitEntity(Fruit fruit) {
        this.name = fruit.getName();
    }

    public Fruit toFruit() {
        Fruit fruit = new Fruit();
        fruit.setId(this.id); // ID aus PanacheEntity
        fruit.setName(this.name);
        return fruit;
    }
}