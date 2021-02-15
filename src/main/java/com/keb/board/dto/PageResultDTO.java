package com.keb.board.dto;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class PageResultDTO<DTO, EN> {
    private List<DTO> dtoList;

    private int totalPage; //총 페이지 번호
    private int page; //현재 페이지 번호
    private int size; //목록 사이즈 기본 10개
    private int start, end; //현재 창에서 시작 페이지 번호, 끝 페이지 번호
    private boolean prev, next; //이전 다음 표시
    private List<Integer> pageList; //페이지 번호 목록


    public PageResultDTO(Page<EN> result, Function<EN, DTO> fn){
        dtoList=result.stream().map(fn).collect(Collectors.toList());
        totalPage=result.getTotalPages();
        makePageList(result.getPageable());

    }
    private void makePageList(Pageable pageable){
        this.page=pageable.getPageNumber()+1; //1로 시작할 수 있게
        this.size=pageable.getPageSize();

        int tempEnd=(int)(Math.ceil(page/10.0))*10; //지금 보이는 화면에서 끝 페이지
        start=tempEnd-9;
        prev=start>1;
        end= totalPage>tempEnd? tempEnd: totalPage; //예를 들어 총 43페이지면 43>40 해서 40을 지금 보이는 화면에서 끝 페이지가 된다.
        next=totalPage>tempEnd;

        pageList= IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
    }
}
