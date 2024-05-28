package com.CN.FitFusion.model;

import javax.persistence.*;
import lombok.*;
import java.util.*;
import com.CN.FitFusion.model.*;
import com.fasterxml.jackson.annotation.*;
//import com.CN.Gym.model.Role;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.stream.Collectors;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	String email;

	String password;

	int age;

	String gender;

	Long contactNo;

	// (ManyToMany)
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role", referencedColumnName = "id"))
	private Set<Role> roles = new HashSet<>();

	// (OneToMany)
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonManagedReference
	List<Exercise> exerciseList;

	// (OneToMany)
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonManagedReference
	List<Diet> diets;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public List<Exercise> getExerciseList() {
		return exerciseList;
	}

	public void setExerciseList(List<Exercise> exerciseList) {
		this.exerciseList = exerciseList;
	}

	public List<Diet> getDiets() {
		return diets;
	}

	public void setDiets(List<Diet> diets) {
		this.diets = diets;
	}

	public User(Long id, String email, String password, int age, String gender, Long contactNo, Set<Role> roles,
			List<Exercise> exerciseList, List<Diet> diets) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.contactNo = contactNo;
		this.roles = roles;
		this.exerciseList = exerciseList;
		this.diets = diets;
	}

	public User() {

	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return this.roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName()))
				.collect(Collectors.toList());
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

	@Override
	public String getUsername() {
		return email;
	}

}
