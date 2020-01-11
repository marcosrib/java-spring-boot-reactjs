package com.estudo.minhasfinancas.model;

import java.util.List;

public class UserDto {
private String name;
private Long idUser;
private Long idModule;
private List<Profile> profile;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Long getIdUser() {
	return idUser;
}
public void setIdUser(Long idUser) {
	this.idUser = idUser;
}
public Long getIdModule() {
	return idModule;
}
public void setIdModule(Long idModule) {
	this.idModule = idModule;
}
public List<Profile> getProfile() {
	return profile;
}
public void setProfile(List<Profile> profile) {
	this.profile = profile;
}




}
