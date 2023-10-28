package com.example.db.account;

import com.example.db.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="account")
public class AccountEntity extends BaseEntity {
}
