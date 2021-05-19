package hello.itemservice.domain.item.repository;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemForm;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryItemRepository implements ItemRepository{

    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(),item);
        return item;
    }

    @Override
    public Optional<Item> findById(Long id){
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Item> findByName(String name) {

        return store.values().stream()
                .filter(item->item.getItemName().equals(name))
                .findAny();
    }

    @Override
    public List<Item> findAll()
    {
        return new ArrayList<Item>(store.values());
    }
    @Override
    public void update(Long itemId, ItemForm updateParam)
    {
        Item findItem = findById(itemId).get();
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }
    public void clearStore()
    {
        store.clear();
    }
}
