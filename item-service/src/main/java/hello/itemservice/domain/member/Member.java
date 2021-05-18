package hello.itemservice.domain.member;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Member {

    private Long id;
    private String name;
    private int age;
    private MemberGrade grade;

}
