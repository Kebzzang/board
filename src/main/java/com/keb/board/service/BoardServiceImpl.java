package com.keb.board.service;

import com.keb.board.dto.BoardDTO;
import com.keb.board.dto.PageRequestDTO;
import com.keb.board.dto.PageResultDTO;
import com.keb.board.entity.Board;
import com.keb.board.entity.Member;
import com.keb.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService{
    private final BoardRepository repository;
    @Override
    public Long register(BoardDTO dto){
        log.info(dto);
        Board board=dtoToEntity(dto);
        repository.save(board);
        return board.getBno();

    }
    @Override
    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO){
        log.info(pageRequestDTO);

        Function<Object[], BoardDTO> fn=(en->entityToDTO((Board)en[0], (Member)en[1], (Long)en[2]));

        Page<Object[]> result=repository.getBoardWithReplyCount(pageRequestDTO.getPageable(Sort.by("bno").descending()));

        return new PageResultDTO<>(result, fn);

    }
}
