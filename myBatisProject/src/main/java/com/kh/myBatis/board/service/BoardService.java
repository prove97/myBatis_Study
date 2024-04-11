package com.kh.myBatis.board.service;

import java.util.ArrayList;

import com.kh.myBatis.board.model.vo.Board;
import com.kh.myBatis.common.vo.PageInfo;

public interface BoardService {
	
	//게시판 리스트 조회
	public int selectListCount();
	public ArrayList<Board> selectList(PageInfo pi);
	
}
