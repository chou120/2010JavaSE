package com.sxt.bbs.service;

import java.util.List;

import com.sxt.bbs.bean.ProvinceCityBean;
import com.sxt.bbs.dao.ProvinceCityDao;
import com.sxt.bbs.dao.UserDao;


public class DwrService {
	/**
	 * 检查用户是否存在
	 * @param uname
	 * @return
	 */
	public boolean checkUserExist(String uname) {
		return UserDao.searchByUname(uname)==null ? false : true;		
	}
	
	/**
	 * 拿到省份
	 * @return
	 */
	public List<ProvinceCityBean> getProvince() {
		return ProvinceCityDao.getProvince();
	}
	
	/**
	 * 拿到市
	 * @return
	 */
	public List<ProvinceCityBean> getCity(String father) {
		return ProvinceCityDao.getCity(father);
	}
}
