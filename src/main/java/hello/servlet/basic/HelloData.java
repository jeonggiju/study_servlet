package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

/**
 * 자바 클래스에서 getter, setter 로 접근하는 것을 자바 프로퍼티 접근법이라고 한다.
 * 이를 쓰기보단 lombok 을 쓰는 것이 좋다.
 * */
@Getter @Setter
public class HelloData {
    private String username;
    private int age;


}
