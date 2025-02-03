package at.htl.resource;

import at.htl.api.FruitsResource;
import at.htl.api.beans.Fruit;
import at.htl.boundary.FruitRepository;
import at.htl.entity.FruitEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class FruitResource implements FruitsResource{

    @Inject
    FruitRepository fruitRepository;

    @Override
    public List<Fruit> getAllFruits() {
        return fruitRepository.listAll().stream()
                .map(FruitEntity::toFruit)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Fruit addFruit(Fruit fruit) {
        FruitEntity entity = new FruitEntity(fruit);
        fruitRepository.persist(entity);
        return entity.toFruit();
    }
}

