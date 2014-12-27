package com.spring.demo.integration.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.biz.dto.User;

@Service("userStationMap")
public class UserStationMap {
	private static  Map<String,String> userIdmap = new HashMap<String,String>();
	private static Map<String,String> userNamemap = new HashMap<String,String>();
	private static Set<String> stations =new HashSet<String>();
	@Autowired
	public  UserDAO userDAO;
	public void init(){
		List<User> users = userDAO.queryAllUserList();
		for(User u : users){
			userIdmap.put(u.getDeptName(), u.getUserId());
			userNamemap.put(u.getDeptName(), u.getUserName());
			if(u.getDeptName()!=null){
				stations.add(u.getDeptName());
			}
		}
	}
	public String getUserIdByStation(String station){
		if(userIdmap.get(station)==null){
			init();
		}
		
		return userIdmap.get(station);
	}
	public String getUserNameByStation(String station){
		if(userNamemap.get(station)==null){
			init();
		}
		return userNamemap.get(station);
	}
	public List<String> getAllStations(){
		if(stations.iterator().hasNext()==false){
			init();
		}
		List<String> list = new ArrayList<String>();
		list.addAll(stations);
		return list;
	}
}
