package hello.itemservice.domain.item;

import lombok.Data;

@Data
public class ItemForm{

    private String itemName;
    private Integer price;
    private Integer quantity;

    public ItemForm(){}

    public ItemForm(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}