package com.bdqn.zmj.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdqn.zmj.entity.News;


public class NewsDao extends BaseDao {
	
	//分页查询
	public List<News> getList(int start,int pageSize,int type){
		List<News> list = new ArrayList<News>();
		String sql = "";
		//说明是全查询
		if(type!=-1){
			sql = "SELECT * FROM news LIMIT ?,?";
			rs = executeQuery(sql, start,pageSize);
		}else{
			//说明是全查询
			sql = "SELECT*FROM news";
			rs = executeQuery(sql);
		}
			try {
				while(rs.next()){
					News news = new News();
					news.setNid(rs.getString("nid"));
					news.setNtitle(rs.getString("ntitle"));
					news.setNauthor(rs.getString("nauthor"));
					news.setNcreatedate(rs.getString("ncreateDate"));
					list.add(news);
				}
				return list;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		
	}
	 
