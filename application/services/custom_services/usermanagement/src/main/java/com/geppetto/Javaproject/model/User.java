package com.geppetto.Javaproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;



@Entity
@Table(name ="User")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

@Id
private String id;

private String username;

private String email;

private String password;



}