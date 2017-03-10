package com.lzsoft.aml.web.systemmanager;

import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.richfaces.component.UIExtendedDataTable;

import com.lzsoft.aml.common.Constants;
import com.lzsoft.aml.entity.model.UserInfo;
import com.lzsoft.aml.entity.model.querymodel.UserQueryBean;
import com.lzsoft.aml.exception.ManagerException;
import com.lzsoft.aml.service.systemmanager.IUserService;
import com.lzsoft.aml.util.DateUtil;
import com.lzsoft.aml.util.PasswordDESUtil;
import com.lzsoft.aml.web.BaseBean;

@ManagedBean(name="userMBean")
@ViewScoped
public class UserManagerBean extends BaseBean{
	@ManagedProperty("#{userinfo}")
	private UserInfo user;
	
	@ManagedProperty("#{userQueryBean}")
	private UserQueryBean querybean;
	
	@ManagedProperty("#{userService}")
	private IUserService userService;
	
	private List<UserInfo> users;
	int i=0;
	
	
	private Collection<Object> selection;

	public void selectionListener(AjaxBehaviorEvent event) {
		UIExtendedDataTable dataTable = (UIExtendedDataTable) event
				.getComponent();
		Object originalKey = dataTable.getRowKey();
		user=null;
		for (Object selectionKey : selection) {
			dataTable.setRowKey(selectionKey);
			if (dataTable.isRowAvailable()) {
				user=(UserInfo) dataTable.getRowData();
			}
		}
		dataTable.setRowKey(originalKey);
	}

	public List<UserInfo> getUsers() {

//		System.out.println(i++);//datatables会多次预加载（这个问题比较麻烦，还没真正有办法解决）
		synchronized (this) {

			if (querybean.isSelected()) {
				try {
					users=this.userService.findByQuerybean(this.querybean);
					querybean.setSelected(false);
				} catch (ManagerException e) {
					e.printStackTrace();
					addWorningMessage("","查询用户失败",false,2);
				} catch (Exception e) {
					e.printStackTrace();
					addWorningMessage("","查询用户失败"+e.getMessage(),false,3);
				}
			} else if (null == users) {
				users=this.userService.findAll();
			}
		}
		return users;
	}

	public void deleteRecord(UserInfo user) {
			this.userService.delete(user);
			this.users.remove(user);//同步(users)
	}
	
	public void deleteRecordByID() {
	}
	
	public void add(){
		
			try {
				if(user.getId()==0){
					user.setExpire(DateUtil.getCurrentDate("yyyy-MM-dd"));
				user.setPassword(PasswordDESUtil.getEncrypt(Constants.DEFAULT_PASSWORD));
				this.userService.save(user);
				querybean.setSelected(true);
				addWorningMessage("dataForm","ID为："+user.getUsername()+"的用户创建完成！",false,0);
				}else{
					updateUser();
				}
			} catch (Exception e) {
				e.printStackTrace();
				addWorningMessage("",
						"用户[" + user.getUsername() + "]新增失败."+e.getMessage(), false,2);
			}
		
	}
	
	public void removeRecord() {
		for (UserInfo user : users) {
			if (currentId == user.getId()) {
				this.userService.delete(user);
				this.users.remove(user);// 同步(users)
				addWorningMessage("dataForm","ID为："+user.getUsername()+"的用户已经删除！",false,0);
				break;
			}
		}
	}
	public void goEdit(UserInfo user ) {
		this.user=user;
	}
	public void updateUser( ) {
		this.userService.update(this.user);
		this.user=this.userService.find(user.getClass(),user.getId());
		addWorningMessage("dataForm","用户ID为："+user.getUsername()+"的内容已经保存！",false,0);
	}
	
	public void resetPassword() {
		try {
			user.setPassword(PasswordDESUtil.getEncrypt(Constants.DEFAULT_PASSWORD));
			user.setExpire(DateUtil.getCurrentDate("yyyy-MM-dd"));
			this.userService.update(this.user);
			addWorningMessage("dataForm","用户名为：    "+user.getUsername()+"    的密码已经重置！",false,0);
		} catch (Exception e) {
			e.printStackTrace();
			addWorningMessage("",
					"用户[" + user.getUserid() + "]重置密码失败."+e.getMessage(), false,2);
			
		}
		
	}
	
	public void reset(){
				querybean.setUsername(null);
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public UserQueryBean getQuerybean() {
		return querybean;
	}

	public void setQuerybean(UserQueryBean querybean) {
		this.querybean = querybean;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setUsers(List<UserInfo> users) {
		this.users = users;
	}   
}
