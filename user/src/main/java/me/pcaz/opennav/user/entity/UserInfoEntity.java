package me.pcaz.opennav.user.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "user_user_info")
public class UserInfoEntity extends UserEntity{
}
