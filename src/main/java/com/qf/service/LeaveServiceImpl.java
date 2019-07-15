package com.qf.service;

import com.qf.mapper.LeaveMapper;
import com.qf.pojo.Leave;
import com.qf.pojo.User;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * author:袁学港
 * Date:2019/7/10 10:14
 * info:
 * */
@Service
public class LeaveServiceImpl implements LeaveService{
    @Autowired
    private LeaveMapper leaveMapper;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private HistoryService historyService;
    @Override
    public int addLeave(Leave leave) {
        int i = leaveMapper.addLeave(leave);
        Integer lid = leave.getLid();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("student",leave.getUser().getUsername());
        map.put("teacher","Chen");
        map.put("manager","Jiao");
        map.put("boss","Wang");
        long starttime = leave.getStartdate().getTime();
        long endtime = leave.getEnddate().getTime();
        long time = endtime - starttime;
        int day= (int) (time/(24*60*60*1000));
        map.put("day",day);
        runtimeService.startProcessInstanceByKey("qfleave",lid+"",map);
        String id = taskService.createTaskQuery().taskAssignee(leave.getUser().getUsername())
                .singleResult().getId();
        taskService.complete(id);
        return i;
    }

    @Override
    public List<Leave> leaveList(User user) {
        List<String> lidlist = new ArrayList<String>();
        List<Leave> rlist = null;
        try{
            List<Task> list = taskService.createTaskQuery().taskAssignee(user.getUsername()).list();
            for (Task task:list){
                String processInstanceId = task.getProcessInstanceId();
                String businessKey = historyService.createHistoricProcessInstanceQuery()
                        .processInstanceId(processInstanceId)
                        .singleResult()
                        .getBusinessKey();
                lidlist.add(businessKey);
                rlist = leaveMapper.leaveList(lidlist);
            }
        }catch (Exception e){

        }


        return rlist;
    }

    @Override
    public int updateLeave(Integer lid, User user) {
        System.out.println("lid = " + lid);
        String processInstanceId = historyService.createHistoricProcessInstanceQuery()
                .processInstanceBusinessKey(lid + "")
                .singleResult().getId();
        String id = historyService.createHistoricTaskInstanceQuery()
                .processInstanceId(processInstanceId)
                .taskAssignee(user.getUsername())
                .singleResult().getId();
        taskService.complete(id);
        int i = leaveMapper.updateLeave(lid);
        return i;
    }

    @Override
    public List<Leave> myLeave(String username) {
        List<Leave> leaves = leaveMapper.myLeave(username);
        return leaves;
    }
}
