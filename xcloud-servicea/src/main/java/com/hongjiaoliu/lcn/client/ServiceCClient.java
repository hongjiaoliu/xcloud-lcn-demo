package com.hongjiaoliu.lcn.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author liuhongjao
 * @date 2019/4/1 14:03
 */
@FeignClient(name = "S3")
public interface ServiceCClient {

	@GetMapping(value = "task/add/{taskContent}")
	public void add(@PathVariable("taskContent")String taskContent);

	@GetMapping(value = "task/addWithRuntimeException/{taskContent}")
	public void addWithRuntimeException(@PathVariable("taskContent")String taskContent);
}
