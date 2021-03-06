package hello.itemservice.domain.item;

import hello.itemservice.domain.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }



    public Item addItem(Item item)
    {
        return itemRepository.save(item);
    }
    public List<Item> findAll()
    {
        return itemRepository.findAll();
    }

    public Optional<Item> findOne(Long itemId)
    {
        return itemRepository.findById(itemId);
    }

    public void update(Long itemId,ItemForm updateParam)
    {
        itemRepository.update(itemId,updateParam);
    }

}
