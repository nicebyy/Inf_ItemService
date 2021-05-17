package hello.itemservice.domain.item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {

    Item save(Item item);
    Optional<Item> findById(Long id);
    Optional<Item> findByName(String name);
    List<Item> findAll();
    void update(Long itemId, ItemForm updateParam);
}
