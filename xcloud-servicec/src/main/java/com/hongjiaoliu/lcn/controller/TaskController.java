package com.hongjiaoliu.lcn.controller;

import com.hongjiaoliu.lcn.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuhongjao
 * @date 2019/4/1 13:54
 */
@RestController
@RequestMapping("task")
public class TaskController {

	@Autowired
	TaskService taskService;

	@GetMapping(value = "/add/{taskContent}")
	public void add(@PathVariable("taskContent")String taskContent){
		taskService.add(taskContent);
	}

	@GetMapping(value = "/addWithRuntimeException/{taskContent}")
	public void addWithRuntimeException(@PathVariable("taskContent")String taskContent){
		taskService.addWithRuntimeException(taskContent);
	}
}
