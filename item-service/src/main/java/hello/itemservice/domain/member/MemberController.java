package hello.itemservice.domain.member;

import hello.itemservice.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/basic/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public String members(Model model)
    {
        model.addAttribute("members",memberService.findAll());
        return "basic/members";
    }

    @GetMapping("/addMemberForm")
    public String addForm()
    {
        return "basic/addMemberForm";
    }

    @PostMapping("/addMemberForm")
    public String addMember(@ModelAttribute Member member)
    {
        Member savedMember = memberService.addMember(member);
        return "redirect:/basic/members";
    }


}
