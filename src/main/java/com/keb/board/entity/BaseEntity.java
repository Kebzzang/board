package com.keb.board.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value={AuditingEntityListener.class})
@Getter

abstract class BaseEntity {
    @CreatedDate
    @Column(name="regdate", updatable=false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(name="moddate")
    private LocalDateTime modDate;
}

/*데이터의 등록 시간과 수정 시간과 같이 자동으로 추가 변경되어야 하는 칼럼들을 위한 것
자동처리위해 어노테이션을 이용해 설정
엔티티 객체의 등록 시간과 최종 수정 시간을 담당하게 될 BaseEntity 클래스를 추상 클래스로 만든다.
@MappedSuperClass라는 어노테이션은 이 클래스를 테이블로 생성하지 않음.
실제 테이블은 BaseEntity 클래스를 상속한 엔티티의 클래스로 DB 테이블이 생성된다.
*/