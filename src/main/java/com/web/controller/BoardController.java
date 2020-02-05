package com.web.controller;

import com.web.domain.Board;
import com.web.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/board")
public class BoardController {

    final Logger L = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BoardService boardService;

    @GetMapping(value = {"/list"})
    //@ResponseBody
    public List<Board> getBoardList() throws Exception {
        return boardService.findBoardList();
    }

    @GetMapping(value = {"", "/"})
    //@ResponseBody
    public Board getBoard(@RequestParam int id) throws Exception {
        return boardService.findBoard(id);
    }

    @PostMapping(value = {"/add"})
    public ResponseEntity addBoard(@RequestBody Board board) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        board.setReg_date(sdf.format(new GregorianCalendar().getTime()));

        boardService.addBoard(board);

        HashMap<String, Object> result = new HashMap<>();
        if(board.getId() == null) {
            result.put("errcode", "200");
            result.put("errmsg", "오류");
        } else {
            result.put("errcode", "100");
            result.put("errmsg", "");
            result.put("board_id", board.getId());
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = {"/edit"})
    public ResponseEntity editBoard(@RequestBody Board board) throws Exception {
        int v = boardService.editBoard(board);

        HashMap<String, Object> result = new HashMap<>();
        if(v == 0) {
            result.put("errcode", "200");
            result.put("errmsg", "오류");
        } else {
            result.put("errcode", "100");
            result.put("errmsg", "");
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = {"/del"})
    public ResponseEntity delBoard(@RequestParam int id) throws Exception {
        int v = boardService.delBoard(id);

        HashMap<String, Object> result = new HashMap<>();
        if(v == 0) {
            result.put("errcode", "200");
            result.put("errmsg", "오류");
        } else {
            result.put("errcode", "100");
            result.put("errmsg", "");
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}

