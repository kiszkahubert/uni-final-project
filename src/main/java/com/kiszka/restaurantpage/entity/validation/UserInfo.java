package com.kiszka.restaurantpage.entity.validation;

import com.kiszka.restaurantpage.entity.orderinfo.OrderDetails;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "usercredentials")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userkey")
    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
    @OneToMany(mappedBy = "user")
    private List<OrderDetails> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo userInfo = (UserInfo) o;

        return id == userInfo.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
