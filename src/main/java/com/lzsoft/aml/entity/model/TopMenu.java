package com.lzsoft.aml.entity.model;

import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.lzsoft.aml.entity.base.BaseEO;

@Entity
@Table(name = "core_topmenu")
@Repository("topmenu")
public class TopMenu extends BaseEO  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private Date cdate;
	private Date mdate;
	private int parentid;
	private String menuname;
	private String menuurl;
	private String menutarget;
	private int sequence;
	private int state;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Primary
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "CDATE", nullable = true)
	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	@Column(name = "MDATE", nullable = true)
	public Date getMdate() {
		return mdate;
	}

	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}

	@Column(name = "PARENTID", nullable = true)
	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	@Column(name = "MENUNAME", nullable = true)
	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	@Column(name = "MENUURL", nullable = true)
	public String getMenuurl() {
		return menuurl;
	}

	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl;
	}

	@Column(name = "MENUTARGET", nullable = true)
	public String getMenutarget() {
		return menutarget;
	}

	public void setMenutarget(String menutarget) {
		this.menutarget = menutarget;
	}

	@Column(name = "SEQUENCE", nullable = true)
	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	@Column(name = "STATE", nullable = true)
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	@Transient
	public Object getPrimaryKey() {
		return this.id;
	}
	public static Comparator<TopMenu> comparator = new Comparator<TopMenu>(){
		public int compare(TopMenu t1, TopMenu t2) {
			// 先排parentid
			if (t1.parentid != t2.parentid) {
				return t1.parentid - t2.parentid;
			} else {
				// parentid相同则按sequence排序
				// if(!t1.sequence.equals(t2.sequence)){
				// return t2.name.compareTo(t1.sequence);
				// }
				if (t1.sequence!=t2.sequence) {
					return t1.sequence-t2.sequence;
				} else {
					// sequence也相同则按id排序
					return t1.id - t2.id;
				}
			}
		}
	    };

}
