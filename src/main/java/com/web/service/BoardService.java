package com.web.service;

import com.web.domain.Board;
import com.web.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    public List<Board> findBoardList() { return boardMapper.findBoardList(); }

    public int findBoardCount() { return  boardMapper.findBoardCount(); }

    public Board findBoard(int id) { return boardMapper.findBoard(id); }

    public void addBoard(Board board) { boardMapper.addBoard(board); }

    public int editBoard(Board board) { return boardMapper.editBoard(board); }

    public int delBoard(int id) { return boardMapper.delBoard(id); }

}
