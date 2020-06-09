package com.soma.UserManagement.actuatorendpoints;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserManagementInfo {
        private Map<String, Object> healthDetails;
}