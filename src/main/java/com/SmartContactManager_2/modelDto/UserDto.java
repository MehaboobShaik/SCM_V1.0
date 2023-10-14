package com.SmartContactManager_2.modelDto;


import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto extends CommonObjectDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Email
	@Column(unique = true)
	private String email;
	@NotBlank 
	@NotEmpty(message = "name should not empty")
	@NotBlank(message = "name should not empty")
	@Pattern(message="Ex:Test@123" , regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
	private String password;
	private String image;
	@Size(min = 10 , max = 200,message = "Min charecters should be 10 and Max 200")
	private String description;
	private String enabled;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", image=" + image + ", description=" + description
				+ ", enabled=" + enabled + "]";
	}
	
	
}
