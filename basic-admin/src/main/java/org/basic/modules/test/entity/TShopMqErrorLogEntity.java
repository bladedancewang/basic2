package org.basic.modules.test.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * mq消费错误表
 * 
 * @author bladedance
 * @email bladedance@vip.qq.com
 * @date 2018-11-27 17:24:30
 */
@TableName("t_shop_mq_error_log")
public class TShopMqErrorLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 队列描述
	 */
	private String summary;
	/**
	 * 队列名称
	 */
	private String queueName;
	/**
	 * 消息内容（json格式）
	 */
	private String content;
	/**
	 * 消息错误原因
	 */
	private String cause;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 创建人
	 */
	private String createBy;
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
	 * 设置：队列描述
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * 获取：队列描述
	 */
	public String getSummary() {
		return summary;
	}
	/**
	 * 设置：队列名称
	 */
	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}
	/**
	 * 获取：队列名称
	 */
	public String getQueueName() {
		return queueName;
	}
	/**
	 * 设置：消息内容（json格式）
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：消息内容（json格式）
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：消息错误原因
	 */
	public void setCause(String cause) {
		this.cause = cause;
	}
	/**
	 * 获取：消息错误原因
	 */
	public String getCause() {
		return cause;
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
