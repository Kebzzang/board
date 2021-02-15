package com.keb.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;



@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {
    private int page;
    private int size;
    private String type;
    private String keyword;
    public PageRequestDTO(){
        this.page=1; //기본값
        this.size=10; //기본값
    }
    //JPA쪽에서 사용하는 Pageable 타이의 객체를 생성하는 목적!
    //JPA를 이용하는 경우 페이지 번호가 0부터 시작한다는 점
    //정렬은 나중에 여러 선택지를 둘 수 있도록 별도 파라미터로 받도록 함
    public Pageable getPageable(Sort sort){

        return PageRequest.of(page-1, size, sort);
    }
}
