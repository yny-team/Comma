package kr.or.comma.user.vo;

import java.sql.Date;

public class UserVO {

	private int user_no;
	private String user_id;//아이디
	private String user_email;//이메일
	private String user_name;//이름
	private String user_password;//비번
	private String user_intro;//자기소개
	private String user_profile;//프로필이미지
	private Date user_creat_dt;//생성날짜
	private String user_authority;//
	private boolean  user_enabled;//
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_intro() {
		return user_intro;
	}
	public void setUser_intro(String user_intro) {
		this.user_intro = user_intro;
	}
	public String getUser_profile() {
		return user_profile;
	}
	public void setUser_profile(String user_profile) {
		this.user_profile = user_profile;
	}
	public Date getUser_creat_dt() {
		return user_creat_dt;
	}
	public void setUser_creat_dt(Date user_creat_dt) {
		this.user_creat_dt = user_creat_dt;
	}
	public String getUser_authority() {
		return user_authority;
	}
	public void setUser_authority(String user_authority) {
		this.user_authority = user_authority;
	}
	public boolean isUser_enabled() {
		return user_enabled;
	}
	public void setUser_enabled(boolean user_enabled) {
		this.user_enabled = user_enabled;
	}
}
