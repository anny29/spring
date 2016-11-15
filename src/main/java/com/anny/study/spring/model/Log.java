/**
 * 
 */
package com.anny.study.spring.model;

import java.util.Date;

/**
 * @Description: TODO
 * @author: Anny
 * @time: 2016年11月14日下午4:35:24
 */
public class Log {
	private int id;
	private String info;
	private String sttm;
	
	public Log() {
		
	}

	public Log(String info, String sttm) {
		this.info = info;
		this.sttm = sttm;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getSttm() {
		return sttm;
	}

	public void setSttm(String sttm) {
		this.sttm = sttm;
	}

}
