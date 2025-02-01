package at.htl.resource;

import at.htl.api.FruitsResource;
import at.htl.api.beans.Fruit;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class FruitResource implements FruitsResource{
    private final List<Fruit> fruitList = new ArrayList<>();

    @Override
    public List<Fruit> getAllFruits() {
        return fruitList;
    }

    @Override
    public Fruit addFruit(Fruit fruit) {
        fruitList.add(fruit);
        return fruit;
    }
}

