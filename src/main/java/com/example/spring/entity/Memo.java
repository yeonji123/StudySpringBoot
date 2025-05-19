package com.example.spring.entity;

import lombok.*;
import jakarta.persistence.*;


@Entity
// @Entity : Spring Data JPA는 반드시 어노테이션을 추가해야만 한다
@Table(name="tb1_memo")
// @Entity와 같이 사용할 수 있는 어노테이션, 생성되는 테이블이름이 tb1_memo 테이블로 생성됩니다.
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;
    // @Entity가 붙은 클래스는 Primary Key에 해당하는 특정 필드를 @Id로 지정
    // @GeneratedValue : 자동으로 생성되는 번호를 사용

    @Column(length = 200, nullable=false)
    private String memoText;
}
