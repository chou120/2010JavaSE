package com.sxt.bbs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sxt.bbs.bean.ProvinceCityBean;
import com.sxt.bbs.util.DBManager;

public class ProvinceCityDao {
	/**
	 * 获取省集合
	 * @return
	 */
	public static List<ProvinceCityBean>  getProvince() {
		String sql = "select * from bbsprovince";
		ResultSet rs = DBManager.queryDb(sql);
		List<ProvinceCityBean> list = new ArrayList<ProvinceCityBean>();
		list.add(new ProvinceCityBean("","--请选择省份--"));
		try {
			while (rs.next()) {
				ProvinceCityBean pcb = new ProvinceCityBean();
				pcb.setId(rs.getString("proid"));
				pcb.setName(rs.getString("proname"));
				list.add(pcb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close();
		}
		return list;
	}
	
	/**
	 * 获取市集合
	 * @param father
	 * @return
	 */
	public static List<ProvinceCityBean> getCity(String father) {
		String sql = "select * from bbscity where father = '" + father + "';";
		ResultSet rs = DBManager.queryDb(sql);
		List<ProvinceCityBean> list = new ArrayList<ProvinceCityBean>();
		list.add(new ProvinceCityBean("","--请选择城市--"));
		try {
			while (rs.next()) {
				ProvinceCityBean pcb = new ProvinceCityBean();
				pcb.setId(rs.getString("citid"));
				pcb.setName(rs.getString("citname"));
				list.add(pcb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close();
		}
		return list;
	}
	
}	
