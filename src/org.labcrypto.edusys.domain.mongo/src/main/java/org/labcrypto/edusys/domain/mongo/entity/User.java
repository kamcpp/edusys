package org.labcrypto.edusys.domain.mongo.entity;

import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

	public static class Role {
		private ObjectId id;
		private String name;

		public ObjectId getId() {
			return id;
		}

		public void setId(ObjectId id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	public static class Profile {

		public enum GenderType {
			NotClear(0), Male(1), Female(2), Others(3);

			private int code;

			private GenderType(int code) {
				this.code = code;
			}

			public int getCode() {
				return code;
			}
		}

		@Id
		private ObjectId id;
		private long birthDate;
		private GenderType gender;
		private String persianName;
		private String englishName;
		private String persianFamily;
		private String englishFamily;
		private String fatherName;
		private String nationalCode;
		private String shSh;
		private String shLocation;
		private String phone1;
		private String phone2;
		private String phone3;
		private String email1;
		private String email2;
		private String webUrl1;
		private String webUrl2;
		private String address1;
		private String address2;
		private String description;

		public ObjectId getId() {
			return id;
		}

		public void setId(ObjectId id) {
			this.id = id;
		}

		public long getBirthDate() {
			return birthDate;
		}

		public void setBirthDate(long birthDate) {
			this.birthDate = birthDate;
		}

		public GenderType getGender() {
			return gender;
		}

		public void setGender(GenderType gender) {
			this.gender = gender;
		}

		public String getPersianName() {
			return persianName;
		}

		public void setPersianName(String persianName) {
			this.persianName = persianName;
		}

		public String getEnglishName() {
			return englishName;
		}

		public void setEnglishName(String englishName) {
			this.englishName = englishName;
		}

		public String getPersianFamily() {
			return persianFamily;
		}

		public void setPersianFamily(String persianFamily) {
			this.persianFamily = persianFamily;
		}

		public String getEnglishFamily() {
			return englishFamily;
		}

		public void setEnglishFamily(String englishFamily) {
			this.englishFamily = englishFamily;
		}

		public String getFatherName() {
			return fatherName;
		}

		public void setFatherName(String fatherName) {
			this.fatherName = fatherName;
		}

		public String getNationalCode() {
			return nationalCode;
		}

		public void setNationalCode(String nationalCode) {
			this.nationalCode = nationalCode;
		}

		public String getShSh() {
			return shSh;
		}

		public void setShSh(String shSh) {
			this.shSh = shSh;
		}

		public String getShLocation() {
			return shLocation;
		}

		public void setShLocation(String shLocation) {
			this.shLocation = shLocation;
		}

		public String getPhone1() {
			return phone1;
		}

		public void setPhone1(String phone1) {
			this.phone1 = phone1;
		}

		public String getPhone2() {
			return phone2;
		}

		public void setPhone2(String phone2) {
			this.phone2 = phone2;
		}

		public String getPhone3() {
			return phone3;
		}

		public void setPhone3(String phone3) {
			this.phone3 = phone3;
		}

		public String getEmail1() {
			return email1;
		}

		public void setEmail1(String email1) {
			this.email1 = email1;
		}

		public String getEmail2() {
			return email2;
		}

		public void setEmail2(String email2) {
			this.email2 = email2;
		}

		public String getWebUrl1() {
			return webUrl1;
		}

		public void setWebUrl1(String webUrl1) {
			this.webUrl1 = webUrl1;
		}

		public String getWebUrl2() {
			return webUrl2;
		}

		public void setWebUrl2(String webUrl2) {
			this.webUrl2 = webUrl2;
		}

		public String getAddress1() {
			return address1;
		}

		public void setAddress1(String address1) {
			this.address1 = address1;
		}

		public String getAddress2() {
			return address2;
		}

		public void setAddress2(String address2) {
			this.address2 = address2;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
	}

	// TODO
	public static class Teacher {
		@Id
		private ObjectId id;
	}

	@Id
	private ObjectId d;
	private String username;
	private String accountEmail;
	private String hashedPassword;
	private boolean active;
	private Profile profile;
	private Set<Role> roles;

	public ObjectId getD() {
		return d;
	}

	public void setD(ObjectId d) {
		this.d = d;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccountEmail() {
		return accountEmail;
	}

	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Set<Role> getRoles() {
		if (roles == null) {
			roles = new HashSet<Role>();
		}
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
