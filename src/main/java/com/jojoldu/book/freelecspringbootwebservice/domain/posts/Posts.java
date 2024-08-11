package com.jojoldu.book.freelecspringbootwebservice.domain.posts;

import com.jojoldu.book.freelecspringbootwebservice.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity     // 1
@Getter
@NoArgsConstructor      // 2
public class Posts extends BaseTimeEntity {

    @Id     // 3
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // 4
    private Long id;

    @Column(length = 500, nullable = false)     // 5
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder        // 6
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    /*
        1. 테이블과 링크될 클래스임을 나타냄. 기본값으로 클래스의 camelCase 이름을 under_score 네이밍으로 매칭
        2. 기본 생성자 자동 추가
        3. 해당 테이블의 PK를 나타냄
        4. PK 생성 규칙을 나타냄 (AUTO, IDENTITY, SEQUENCE, TABLE)
        5. 테이블의 컬럼을 나타냄. 굳이 설정하지 않아도 됨. 사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있을 경우 사용 (사이즈 확장, 타입 변경 등)
        6. 해당 클래스의 빌더 패턴 클래스를 생성. 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
     */
}
