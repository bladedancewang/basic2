package org.basic.modules.test.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 支付中心-电商支付流水表
 * 
 * @author bladedance
 * @email bladedance@vip.qq.com
 * @date 2018-11-27 17:24:30
 */
@TableName("t_shop_payment_log")
public class TShopPaymentLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键Id
	 */
	@TableId
	private Long id;
	/**
	 * 支付编号
	 */
	private String sn;
	/**
	 * 会员账号
	 */
	private String account;
	/**
	 * 外部订单id
	 */
	private String outOrderId;
	/**
	 * 支付金额，单位分
	 */
	private BigDecimal amount;
	/**
	 * U币数量，单位个
	 */
	private String ubCount;
	/**
	 * 第三方支付流水号
	 */
	private String tradeNo;
	/**
	 * 支付方式(支付宝：alipay，微信:wechat)
	 */
	private String paymentType;
	/**
	 * 支付状态（wait 等待付款 success 支付成功 failed 支付失败 canceled 支付取消 closed 支付关闭）
	 */
	private String status;
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
	 * 设置：主键Id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键Id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：支付编号
	 */
	public void setSn(String sn) {
		this.sn = sn;
	}
	/**
	 * 获取：支付编号
	 */
	public String getSn() {
		return sn;
	}
	/**
	 * 设置：会员账号
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * 获取：会员账号
	 */
	public String getAccount() {
		return account;
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
	 * 设置：支付金额，单位分
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * 获取：支付金额，单位分
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * 设置：U币数量，单位个
	 */
	public void setUbCount(String ubCount) {
		this.ubCount = ubCount;
	}
	/**
	 * 获取：U币数量，单位个
	 */
	public String getUbCount() {
		return ubCount;
	}
	/**
	 * 设置：第三方支付流水号
	 */
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	/**
	 * 获取：第三方支付流水号
	 */
	public String getTradeNo() {
		return tradeNo;
	}
	/**
	 * 设置：支付方式(支付宝：alipay，微信:wechat)
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	/**
	 * 获取：支付方式(支付宝：alipay，微信:wechat)
	 */
	public String getPaymentType() {
		return paymentType;
	}
	/**
	 * 设置：支付状态（wait 等待付款 success 支付成功 failed 支付失败 canceled 支付取消 closed 支付关闭）
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：支付状态（wait 等待付款 success 支付成功 failed 支付失败 canceled 支付取消 closed 支付关闭）
	 */
	public String getStatus() {
		return status;
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
