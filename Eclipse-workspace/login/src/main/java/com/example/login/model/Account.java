/**
 * 
 */
package com.example.login.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Admin
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {
	@Id
	@NotEmpty
	@Column(name = "username", length = 30)
	private String username;
	
	@NotEmpty
	@Column(name = "password", length = 30)
	private String password;
}
