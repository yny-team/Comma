package kr.or.comma.user.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class UserVO implements UserDetails {

	private int userNo;
	private String userId;
	private String userEmail;
	private String userName;
	private String userPassword;
	private String userIntro;
	private String userProfile;
	private Date userCreate_dt;
	private String userAuthority;
	private boolean userEnabled;
	
	public UserVO() {
		
	}
	
	public UserVO(int userNo, String userId, String userName) {
		this.userNo = userNo;
		this.userId = userId;
		this.userName = userName;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		auth.add(new SimpleGrantedAuthority(userAuthority));
		return auth;
	}

	@Override
	public String getPassword() {
		return userPassword;
	}

	@Override
	public String getUsername() {
		return userId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return userEnabled;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserIntro() {
		return userIntro;
	}

	public void setUserIntro(String userIntro) {
		this.userIntro = userIntro;
	}

	public String getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}

	public Date getUserCreate_dt() {
		return userCreate_dt;
	}

	public void setUserCreate_dt(Date userCreate_dt) {
		this.userCreate_dt = userCreate_dt;
	}

	public String getUserAuthority() {
		return userAuthority;
	}

	public void setUserAuthority(String userAuthority) {
		this.userAuthority = userAuthority;
	}

	public boolean isUserEnabled() {
		return userEnabled;
	}

	public void setUserEnabled(boolean userEnabled) {
		this.userEnabled = userEnabled;
	}

	@Override
	public String toString() {
		return "UserVO [userNo=" + userNo + ", userId=" + userId + ", userEmail=" + userEmail + ", userName=" + userName
				+ ", userPassword=" + userPassword + ", userIntro=" + userIntro + ", userProfile=" + userProfile
				+ ", userCreate_dt=" + userCreate_dt + ", userAuthority=" + userAuthority + ", userEnabled="
				+ userEnabled + "]";
	}

}
