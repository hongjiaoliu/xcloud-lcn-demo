package com.hongjiaoliu.lcn.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author liuhongjao
 * @date 2019/4/1 16:27
 */
@Data
@Document(collection = "Task_log")
public class TaskLogBean {
	private String logID;
	private String txGroupID;//事务组ID
	private String taskContent;
	private Integer status = 0 ;//0:未处理；1：添加中；2：添加完成；3：添加过程出错，等同于删除
	private Date created;
}
