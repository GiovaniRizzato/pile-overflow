package br.com.giovanirizzato.treeelo.model.security;

public enum UserRole {
	ADMIN("admin"),
	USER("user");
  
	private String role;
  
	UserRole(String role) {
	  this.role = role;
	}
  
	public String getValue() {
	  return role;
	}
  }