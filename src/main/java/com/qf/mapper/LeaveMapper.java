package com.qf.mapper;

import com.qf.pojo.Leave;

import java.util.List;

/*
 * author:袁学港
 * Date:2019/7/10 9:51
 * info:
 * */
public interface LeaveMapper {
    int addLeave(Leave leave);
    List<Leave> leaveList(List<String> liblist);
    int updateLeave(Integer lid);
    List<Leave> myLeave(String username);
}
