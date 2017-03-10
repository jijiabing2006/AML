package com.lzsoft.aml.entity.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.lzsoft.aml.entity.base.BaseEO;

@Entity
@Table(name="core_user")
@Repository("userinfo")
public class UserInfo extends BaseEO{
	
	private static final long serialVersionUID = -6760143057040149837L;
	
	private int id;
    private String userid;
    private String password;
    private String newpassword;
    private String state;
    private String bkid;
    private String subbkid;
    private String username;
    private String historypwd;
   	private Date expire;
    private Date logindate;
    private Date loginoutdate;
    private Date lastmofdate;
    private Long errorcounts;
    private String email;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Primary
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    @Column(name="USERID", unique = true, nullable = false)
    public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

    @Column(name="PASSWORD",  nullable = false)
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }   
    @Column(name="USERNAME", nullable = false)
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

    @Column(name="STATE", nullable = true)
    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	  @Column(name="BKID", nullable = false)
	public String getBkid() {
		return bkid;
	}
	public void setBkid(String bkid) {
		this.bkid = bkid;
	}
	 @Column(name="SUBBKID", nullable = true)
	 public String getSubbkid() {
			return subbkid;
		}

		public void setSubbkid(String subbkid) {
			this.subbkid = subbkid;
		}

	 @Column(name="EXPIRE", nullable = true)
	public Date getExpire() {
		return expire;
	}
	public void setExpire(Date expire) {
		this.expire = expire;
	}
	 @Column(name="LOGINDATE", nullable = true)
	public Date getLogindate() {
		return logindate;
	}

	public void setLogindate(Date logindate) {
		this.logindate = logindate;
	}
	 @Column(name="LOGINOUTDATE", nullable = true)
	public Date getLoginoutdate() {
		return loginoutdate;
	}

	public void setLoginoutdate(Date loginoutdate) {
		this.loginoutdate = loginoutdate;
	}
	 @Column(name="HISTORYPWD", nullable = true)
    public String getHistorypwd() {
		return historypwd;
	}

	public void setHistorypwd(String historypwd) {
		this.historypwd = historypwd;
	}
	
	 @Column(name="LASTMOFDATE", nullable = true)
	public Date getLastmofdate() {
		return lastmofdate;
	}

	public void setLastmofdate(Date lastmofdate) {
		this.lastmofdate = lastmofdate;
	}
    @Column(name="EMAIL", nullable = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="ERRORCOUNTS", nullable = true)
	public Long getErrorcounts() {
		return errorcounts;
	}

	public void setErrorcounts(Long errorcounts) {
		this.errorcounts = errorcounts;
	}
	@Transient
	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	@Override
    public String toString() {
        StringBuffer strBuff = new StringBuffer();
        strBuff.append("id : ").append(getId());
        strBuff.append(", userid : ").append(getUserid());
        strBuff.append(", username : ").append(getUsername());
        strBuff.append(", password : ").append(getPassword());
        return strBuff.toString();
    }

	@Override
	@Transient
	public Object getPrimaryKey() {
		return  this.id;
	}
}
