package com.web.mapper;

import com.web.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

   List<Board> findBoardList();

   int findBoardCount();

   Board findBoard(int id);

   void addBoard(Board board);

   int editBoard(Board board);

   int delBoard(int id);

}
