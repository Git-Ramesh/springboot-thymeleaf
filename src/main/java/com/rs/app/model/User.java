package com.rs.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {
	private static final long serialVersionUID = 2740988562183180191L;
	private Long id;
	@NotEmpty
	private String name;
	@NotEmpty
	@Email
	private String email;
	@Range(min = 18, max = 100, message = "Age out of range")
	private Integer age;
	@NotEmpty
	private String address;
	@NotEmpty
	private List<String> countries = new ArrayList<>();
	@NotEmpty
	private List<String> languages = new ArrayList<>();

	public User(String name, String email, Integer age, String address) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.address = address;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (!(o instanceof User)) {
			return false;
		}
		User other = (User) o;
		return Objects.equals(this.email, other.getEmail());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.email);
	}
}
