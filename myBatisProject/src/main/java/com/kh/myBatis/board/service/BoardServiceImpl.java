package com.kh.myBatis.board.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.kh.myBatis.board.model.dao.BoardDao;
import com.kh.myBatis.board.model.vo.Board;
import com.kh.myBatis.common.template.Template;
import com.kh.myBatis.common.vo.PageInfo;

public class BoardServiceImpl implements BoardService{

	private BoardDao bDao = new BoardDao();
	
	@Override
	public int selectListCount() {
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = bDao.selectListCount(sqlSession);
		
		sqlSession.close();
		return listCount;
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = bDao.selectList(sqlSession, pi);
		
		sqlSession.close();
		return list;
	}
	
	
	

}
