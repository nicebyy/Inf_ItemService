package hello.itemservice.domain.item.repository;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemForm;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {

    Item save(Item item);
    Optional<Item> findById(Long id);
    Optional<Item> findByName(String name);
    List<Item> findAll();
    void update(Long itemId, ItemForm updateParam);
}
