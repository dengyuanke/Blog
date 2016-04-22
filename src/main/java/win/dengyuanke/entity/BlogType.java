package win.dengyuanke.entity;

/**
 * 博客类型实体
 * @author Administrator
 *
 */
public class BlogType {
private Integer id;//编号
private String typeName;//类型名字
private  Integer orderNo;//排序 从小到大
private Integer blogCount;//数量


public Integer getBlogCount() {
	return blogCount;
}

public void setBlogCount(Integer blogCount) {
	this.blogCount = blogCount;
}

public String getTypeName() {
	return typeName;
}

public void setTypeName(String typeName) {
	this.typeName = typeName;
}

public Integer getOrderNo() {
	return orderNo;
}

public void setOrderNo(Integer orderNo) {
	this.orderNo = orderNo;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

}
