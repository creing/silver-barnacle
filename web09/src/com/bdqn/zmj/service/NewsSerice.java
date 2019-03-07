package com.bdqn.zmj.service;


import java.util.List;

import com.bdqn.zmj.dao.NewsDao;
import com.bdqn.zmj.entity.News;
import com.bdqn.zmj.util.Page;

public class NewsSerice {
		NewsDao dao = new NewsDao();
		
		public Page<News> getList(int currentPage,int PageSize){
			//将当页面转换成起始索引，每页大小*(当前页-1)=起始索引
			int start = PageSize*(currentPage-1);
			List<News> list =dao.getList(start, PageSize, 0);
			
			//封装分页对象
			Page<News> p = new Page<>();
			p.setCurrentPage(currentPage);
			p.setPageSize(PageSize);
			
			//怎么得到总条数？？
			int total = dao.getList(0, 0, -1).size();
	
			p.setTotal(total);
			p.setTotalPage((int) Math.ceil(total*1.0/PageSize));
			p.setData(list);
			return p;
			
		}
}
 