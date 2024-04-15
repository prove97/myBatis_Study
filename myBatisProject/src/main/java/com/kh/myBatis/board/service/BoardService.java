package com.kh.myBatis.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.myBatis.board.model.vo.Board;
import com.kh.myBatis.board.model.vo.Reply;
import com.kh.myBatis.common.vo.PageInfo;

public interface BoardService {
	
	//게시글 리스트 조회
	public int selectListCount();
	public ArrayList<Board> selectList(PageInfo pi);
	
	//게시글 검색
	public int selectSearchCount(HashMap<String, String> map);
	ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi);

	//게시글 상세 조회 / 게시글 조회수 + 1
	public Board increaseCount(int boardNo);
	
	//게시글 댓글 리스트 조회
	public ArrayList<Reply> selectReplyList(int boardNo);
	

}
