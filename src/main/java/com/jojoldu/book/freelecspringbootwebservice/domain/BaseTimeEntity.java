package com.jojoldu.book.freelecspringbootwebservice.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass       // 1
@EntityListeners(AuditingEntityListener.class)      // 2
public abstract class BaseTimeEntity {

    @CreatedDate            // 3
    private LocalDateTime createdDate;

    @LastModifiedDate       // 4
    private LocalDateTime modifiedDate;
    
    /*
        1. JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 해당 필드들도 자식의 컬럼으로 인식하도록 함
        2. BaseTimeEntity 클래스에 Auditing 기능을 포함시킴
        3. Entity가 생성되어 저장될 때 시간이 자동으로 저장됨
        4. 조회한 Entity의 값을 변경할 때 시간이 자동으로 저장됨
     */
}
