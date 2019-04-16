package org.basic.modules.test.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 错误信息表
 * 
 * @author bladedance
 * @email bladedance@vip.qq.com
 * @date 2018-11-27 17:24:30
 */
@TableName("t_shop_error_log")
public class TShopErrorLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 操作（错误概述）
	 */
	private String operation;
	/**
	 * 来源1：电商接口
	 */
	private Integer source;
	/**
	 * 错误信息
	 */
	private String content;
	/**
	 * 是否解决
	 */
	private Boolean isSolve;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 修改人
	 */
	private String modifyBy;
	/**
	 * 修改时间
	 */
	private Date modifyDate;
	/**
	 * 版本
	 */
	private Long version;
	/**
	 * 是否已删除,0:未删除；1:已删除
	 */
	private Boolean isDeleted;

	/**
	 * 设置：主键id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：操作（错误概述）
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}
	/**
	 * 获取：操作（错误概述）
	 */
	public String getOperation() {
		return operation;
	}
	/**
	 * 设置：来源1：电商接口
	 */
	public void setSource(Integer source) {
		this.source = source;
	}
	/**
	 * 获取：来源1：电商接口
	 */
	public Integer getSource() {
		return source;
	}
	/**
	 * 设置：错误信息
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：错误信息
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：是否解决
	 */
	public void setIsSolve(Boolean isSolve) {
		this.isSolve = isSolve;
	}
	/**
	 * 获取：是否解决
	 */
	public Boolean getIsSolve() {
		return isSolve;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateBy() {
		return createBy;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：修改人
	 */
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	/**
	 * 获取：修改人
	 */
	public String getModifyBy() {
		return modifyBy;
	}
	/**
	 * 设置：修改时间
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getModifyDate() {
		return modifyDate;
	}
	/**
	 * 设置：版本
	 */
	public void setVersion(Long version) {
		this.version = version;
	}
	/**
	 * 获取：版本
	 */
	public Long getVersion() {
		return version;
	}
	/**
	 * 设置：是否已删除,0:未删除；1:已删除
	 */
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	/**
	 * 获取：是否已删除,0:未删除；1:已删除
	 */
	public Boolean getIsDeleted() {
		return isDeleted;
	}
}
