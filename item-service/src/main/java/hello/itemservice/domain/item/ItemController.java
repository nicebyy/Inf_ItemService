package hello.itemservice.domain.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public String items(Model model)
    {
        model.addAttribute("items",itemService.findAll());
        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model)
    {
        Item item = itemService.findOne(itemId).get();
        model.addAttribute("item",item);
        return "basic/item";
    }

    @GetMapping("/addItemForm")
    public String addForm()
    {
        return "basic/addItemForm";
    }

    //    @PostMapping("/add")
    public String addItemV1(@RequestParam String itemName,
                            @RequestParam int price,
                            @RequestParam Integer quantity,
                            Model model
    )
    {
        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);

        itemService.addItem(item);

        model.addAttribute("item",item);

        return "basic/item";
    }

    //    @PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item)
    {

        itemService.addItem(item);
//        model.addAttribute("item",item);

        return "basic/item";
    }

    /**
     * @ModelAttribute name 생략 가능
     * model.addAttribute(item); 자동 추가, 생략 가능
     * 생략시 model에 저장되는 name은 클래스명 첫글자만 소문자로 등록 Item -> item
     */
//    @PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item) {
        itemService.addItem(item);
        return "basic/item";
    }

    /**
     * @ModelAttribute 자체 생략 가능
     * model.addAttribute(item) 자동 추가
     */
//    @PostMapping("/add")
    public String addItemV4(Item item) { //상품 중복 등록문제 발생.
        itemService.addItem(item);
        return "basic/item";
    }

    /**
     * PRG - Post/Redirect/Get
     */
//    @PostMapping("/add")
    public String addItemV5(Item item) {
        itemService.addItem(item);
        return "redirect:/basic/items/" + item.getId();
    }

    @PostMapping("/addItemForm")
    public String addItemV6(Item item, RedirectAttributes redirectAttributes) {
        Item savedItem = itemService.addItem(item);
        redirectAttributes.addAttribute("itemId",savedItem.getId());
        redirectAttributes.addAttribute("status",true);
        return "redirect:/basic/items/{itemId}";

    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId,Model model)
    {
        Item item = itemService.findOne(itemId).get();
        model.addAttribute("item",item);
        return "basic/editItemForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId,@ModelAttribute ItemForm item)
    {
        itemService.update(itemId,item);
        return "redirect:/basic/items/{itemId}";
    }

    /*
    //테스트용 데이터
    @PostConstruct
    public void init()
    {
        itemService.addItem(new Item("itemA",10000,10));
        itemService.addItem(new Item("itemB",20000,20));
    }

     */
}
