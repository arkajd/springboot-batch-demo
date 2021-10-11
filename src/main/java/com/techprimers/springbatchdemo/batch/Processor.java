package com.techprimers.springbatchdemo.batch;

import com.techprimers.springbatchdemo.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<User, User> {

    private static final Map<String, String> DEPT_NAMES = new HashMap<>();

    public Processor(){
        DEPT_NAMES.put("001", "Technology");
        DEPT_NAMES.put("002", "Operations");
        DEPT_NAMES.put("003", "Account");
    }

    @Override
    public User process(User user) throws Exception {
        user.setDept(DEPT_NAMES.get(user.getDept()));
        System.out.println("Department converted.");
        return user;
    }
}
