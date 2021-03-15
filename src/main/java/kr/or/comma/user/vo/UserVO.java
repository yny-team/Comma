package kr.or.comma.user.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class UserVO implements UserDetails {

	private int userNo;
	
	@NotBlank
	@Pattern(regexp="^[a-z]{1}[a-z0-9]{5,15}$")
	private String userId;
	
	private String userEmail;
	
	@NotBlank
	@Pattern(regexp="^[a-z0-9A-Z_-]*")
	private String userEmailFirst;
	
	@NotBlank
	@Pattern(regexp="^[a-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[a-z]{2,3})$")
	private String userEmailEtc;
	
	@NotBlank
	@Pattern(regexp="^[가-힣]{2,7}$")
	private String userNames;
	
	@NotBlank										
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^*()-_?])[A-Za-z[0-9]!@#$%^*()-_?]{8,20}$")
	private String userPassword;
	
	private String userIntro;
	private String userProfile;
	private Date userCreateDt;
	private String userAuthority;
	private boolean userEnabled;
	
	public UserVO() {
		
	}
	
	public UserVO(int userNo, String userId, String userNames) {
		this.userNo = userNo;
		this.userId = userId;
		this.userNames = userNames;
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
	
	public String getUserEmailFirst() {
		return userEmailFirst;
	}

	public void setUserEmailFirst(String userEmailFirst) {
		this.userEmailFirst = userEmailFirst;
	}

	public String getUserEmailEtc() {
		return userEmailEtc;
	}

	public void setUserEmailEtc(String userEmailEtc) {
		this.userEmailEtc = userEmailEtc;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserNames() {
		return userNames;
	}

	public void setUserNames(String userNames) {
		this.userNames = userNames;
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
	
	public Date getUserCreateDt() {
		return userCreateDt;
	}

	public void setUserCreateDt(Date userCreateDt) {
		this.userCreateDt = userCreateDt;
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
		return "UserVO [userNo=" + userNo + ", userId=" + userId + ", userEmail=" + userEmail + ", userEmailFirst="
				+ userEmailFirst + ", userEmailEtc=" + userEmailEtc + ", userNames=" + userNames + ", userPassword="
				+ userPassword + ", userIntro=" + userIntro + ", userProfile=" + userProfile + ", userCreateDt="
				+ userCreateDt + ", userAuthority=" + userAuthority + ", userEnabled=" + userEnabled + "]";
	}

}

