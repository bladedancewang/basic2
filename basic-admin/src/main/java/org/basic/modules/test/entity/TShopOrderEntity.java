package org.basic.modules.test.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单中心-订单表
 * 
 * @author bladedance
 * @email bladedance@vip.qq.com
 * @date 2018-11-27 17:24:30
 */
@TableName("t_shop_order")
public class TShopOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 外部订单id
	 */
	private String outOrderId;
	/**
	 * 用户名
	 */
	private String account;
	/**
	 * 订单状态（pendingPayment 等待付款 completed 订单已完成）
	 */
	private String status;
	/**
	 * 订单详情json
	 */
	private String orderInfo;
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
	 * 设置：外部订单id
	 */
	public void setOutOrderId(String outOrderId) {
		this.outOrderId = outOrderId;
	}
	/**
	 * 获取：外部订单id
	 */
	public String getOutOrderId() {
		return outOrderId;
	}
	/**
	 * 设置：用户名
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * 获取：用户名
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * 设置：订单状态（pendingPayment 等待付款 completed 订单已完成）
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：订单状态（pendingPayment 等待付款 completed 订单已完成）
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：订单详情json
	 */
	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}
	/**
	 * 获取：订单详情json
	 */
	public String getOrderInfo() {
		return orderInfo;
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
