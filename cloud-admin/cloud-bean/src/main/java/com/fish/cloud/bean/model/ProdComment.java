package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 商品评论
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_prod_comment")
public class ProdComment extends Model<ProdComment> {

    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
	@TableId(value="comment_id", type= IdType.AUTO)
	private Long commentId;
    /**
     * 商品Id
     */
	@TableField("prod_id")
	private Long prodId;
    /**
     * 订单Id
     */
	@TableField("order_id")
	private Long orderId;
    /**
     * 订单项Id
     */
	@TableField("order_item_id")
	private Long orderItemId;
    /**
     * 评论用户Id
     */
	@TableField("user_id")
	private String userId;
    /**
     * 评论内容
     */
	private String content;
    /**
     * 评价(0好评 1中评 2差评)
     */
	private Integer evaluate;
    /**
     * 得分，0-5分
     */
	private Integer score;
    /**
     * 有用的计数
     */
	@TableField("useful_nums")
	private Integer usefulNums;
    /**
     * 晒图的json字符串
     */
	private String imgs;
    /**
     * 是否匿名(1:是  0:否)
     */
	@TableField("is_anonymous")
	private Integer isAnonymous;
    /**
     * IP来源
     */
	@TableField("post_ip")
	private String postIp;
    /**
     * 是否显示，1:为显示，0:待审核， -1：不通过审核，不显示。 如果需要审核评论，则是0,，否则1
     */
	private Integer status;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 是否回复 0:未回复  1:已回复
     */
	@TableField("is_reply")
	private Integer isReply;
    /**
     * 店铺回复
     */
	@TableField("reply_content")
	private String replyContent;
    /**
     * 回复时间
     */
	@TableField("reply_time")
	private Date replyTime;


	public Long getCommentId() {
		return commentId;
	}

	public ProdComment setCommentId(Long commentId) {
		this.commentId = commentId;
		return this;
	}

	public Long getProdId() {
		return prodId;
	}

	public ProdComment setProdId(Long prodId) {
		this.prodId = prodId;
		return this;
	}

	public Long getOrderId() {
		return orderId;
	}

	public ProdComment setOrderId(Long orderId) {
		this.orderId = orderId;
		return this;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public ProdComment setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public ProdComment setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public String getContent() {
		return content;
	}

	public ProdComment setContent(String content) {
		this.content = content;
		return this;
	}

	public Integer getEvaluate() {
		return evaluate;
	}

	public ProdComment setEvaluate(Integer evaluate) {
		this.evaluate = evaluate;
		return this;
	}

	public Integer getScore() {
		return score;
	}

	public ProdComment setScore(Integer score) {
		this.score = score;
		return this;
	}

	public Integer getUsefulNums() {
		return usefulNums;
	}

	public ProdComment setUsefulNums(Integer usefulNums) {
		this.usefulNums = usefulNums;
		return this;
	}

	public String getImgs() {
		return imgs;
	}

	public ProdComment setImgs(String imgs) {
		this.imgs = imgs;
		return this;
	}

	public Integer getIsAnonymous() {
		return isAnonymous;
	}

	public ProdComment setIsAnonymous(Integer isAnonymous) {
		this.isAnonymous = isAnonymous;
		return this;
	}

	public String getPostIp() {
		return postIp;
	}

	public ProdComment setPostIp(String postIp) {
		this.postIp = postIp;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public ProdComment setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public ProdComment setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Integer getIsReply() {
		return isReply;
	}

	public ProdComment setIsReply(Integer isReply) {
		this.isReply = isReply;
		return this;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public ProdComment setReplyContent(String replyContent) {
		this.replyContent = replyContent;
		return this;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public ProdComment setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.commentId;
	}

}
