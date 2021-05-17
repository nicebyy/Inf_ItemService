package hello.itemservice.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryItemRepositoryTest {

    MemoryItemRepository memoryItemRepository = new MemoryItemRepository();

    @AfterEach
    void afterEach()
    {
        memoryItemRepository.clearStore();
    }

    @Test
    void save()
    {
        //given
        Item itemA = new Item("itemA", 10000, 10);
        //when
        Item savedItem = memoryItemRepository.save(itemA);
        //then
        Item findItem = memoryItemRepository.findById(savedItem.getId()).get();

        assertThat(findItem).isEqualTo(savedItem);
    }

    @Test
    void findAll()
    {
        //given
        Item itemA = new Item("itemA", 10000, 10);
        Item itemB = new Item("itemB", 20000, 10);

        //when
        memoryItemRepository.save(itemA);
        memoryItemRepository.save(itemB);

        //then
        List<Item> result = memoryItemRepository.findAll();
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(itemA,itemB);
    }


    @Test
    void updateItem()
    {
        //given
        Item itemA = new Item("itemA", 10000, 10);
        Item savedItem = memoryItemRepository.save(itemA);
        Long itemId = savedItem.getId();

        //when
        ItemForm updateParam = new ItemForm("itemB", 20000, 30);
        memoryItemRepository.update(itemId,updateParam);

        //then
        Item findItem = memoryItemRepository.findById(itemId).get();

        assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());

    }
}