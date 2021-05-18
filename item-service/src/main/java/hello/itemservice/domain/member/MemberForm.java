package hello.itemservice.domain.member;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class MemberForm {

    private String name;
    private MemberGrade grade;
    private int age;

    public MemberForm(){};

    public MemberForm(String name,int age,MemberGrade grade)
    {
        this.name=name;
        this.grade=grade;
        this.age=age;
    }
}
