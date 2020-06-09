package com.soma.UserManagement.actuatorendpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
@Endpoint(id = "userManagementInfo")
public class UserManagementInfoEndPoint {
    private Map<String, Object> details;

    @ReadOperation
    public UserManagementInfo userManagementInfo() {
        details = new LinkedHashMap<>();
        details.put("App Location", "RMZ Office Building, Yelahanka, Bangalore, KA, IN, Asia, Earth, Solar System, Milkyway Galaxy, Universe - 560065");
        details.put("Status", "Reporting from RMZ Office");
        UserManagementInfo userManagementInfo = new UserManagementInfo();
        userManagementInfo.setHealthDetails(details);
        return userManagementInfo;
    }

    @ReadOperation
    public String userManagementInfoEndPointByName(@Selector String key, @Selector String key2) {
        return details != null ? details.get(key).toString() : "This is  the User Management Application";
    }

    // @WriteOperation // For post method
    // @DeleteOperation // For delete mapping

}
