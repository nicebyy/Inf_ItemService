package hello.itemservice.domain.item.repository;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemForm;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class JpaItemRepository implements ItemRepository{

    private final EntityManager em;

    public JpaItemRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Item save(Item item) {
        em.persist(item);
        return item;
    }

    @Override
    public Optional<Item> findById(Long id) {
        Item item = em.find(Item.class, id);
        return Optional.ofNullable(item);
    }

    @Override
    public Optional<Item> findByName(String name) {
        return em.createQuery("select i from Item i where i.itemName=:name", Item.class)
                .setParameter("name",name)
                .getResultList()
                .stream().findAny();
    }

    @Override
    public List<Item> findAll() {
        return em.createQuery("select i from Item i",Item.class)
                .getResultList();
    }

    @Override
    public void update(Long itemId, ItemForm updateParam) {
        Optional<Item> item = findById(itemId);
        item.ifPresent(selectedItem->{
            selectedItem.setItemName(updateParam.getItemName());
            selectedItem.setQuantity(updateParam.getQuantity());
            selectedItem.setPrice(updateParam.getPrice());
            save(selectedItem);
        });

    }
}
