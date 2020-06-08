package com.soma.UserManagement.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "User")
public class User {
    @MongoId
    @Indexed(unique = true)
    private Long userId;
    private String userName;
    private String userAddress;
    private String userLocation;
}
