package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
    
    
//    private final Logger log = LoggerFactory.getLogger(getClass()); @Slf4j 롬복 활용

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);

        log.trace("trace log ="+ name); // 이렇게 사용하면 안됨!! 로그레벨이 더 낮아져 출력이 안되더라도 의미없는 연산이 이루어짐, 메모리 낭비 o
        log.trace("trace log ={}", name); // 올바른 사용법 : 로그레벨이 낮으면 메서드 자체를 호출하지않음 메모리 낭비 x
        
        log.trace("trace log={}", name);
        log.debug("debug log={}", name); // 개발서버
        log.info("info log = {}", name); // 중요한 정보 운영시스템에서도 봐야함
        log.warn("warn log = {}", name); // 경고! 위험!
        log.error("error log = {}", name);// 에러! 확인해야함

        return "ok";
    }
}
