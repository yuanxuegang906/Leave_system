package com.qf.service;

import com.qf.pojo.Leave;
import com.qf.pojo.User;

import java.util.List;

public interface LeaveService {
    int addLeave(Leave leave);
    List<Leave> leaveList(User user);
    int updateLeave(Integer lid, User user);
    List<Leave> myLeave(String username);
}
