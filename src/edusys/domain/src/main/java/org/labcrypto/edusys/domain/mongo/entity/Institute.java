package org.labcrypto.edusys.domain.mongo.entity;

import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.labcrypto.edusys.domain.mongo.entity.User.Teacher;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Institute {

	public static class Department {

		public static class Group {

			public static class Course {

				public static class CourseResource {
					@Id
					private ObjectId id;
					@Transient
					private Course course;

					public ObjectId getId() {
						return id;
					}

					public void setId(ObjectId id) {
						this.id = id;
					}

					public Course getCourse() {
						return course;
					}

					public void setCourse(Course course) {
						this.course = course;
					}
				}

				public static class CourseSyllabus {
					@Id
					private ObjectId id;
					@Transient
					private Course course;

					public ObjectId getId() {
						return id;
					}

					public void setId(ObjectId id) {
						this.id = id;
					}

					public Course getCourse() {
						return course;
					}

					public void setCourse(Course course) {
						this.course = course;
					}
				}

				public static class CoursePlan {

					public static class CoursePlanModification {
						@Id
						private ObjectId id;
						private boolean daysNotClear;
						private boolean onSaturdays;
						private boolean onSundays;
						private boolean onMondays;
						private boolean onTuesdays;
						private boolean onWednesdays;
						private boolean onThursdays;
						private boolean onFridays;
						private boolean timesNotClear;
						private int startHourOnSaturdays;
						private int endHourOnSaturdays;
						private int startHourOnSundays;
						private int endHourOnSundays;
						private int startHourOnMondays;
						private int endHourOnMondays;
						private int startHourOnTuesdays;
						private int endHourOnTuesdays;
						private int startHourOnWednesdays;
						private int endHourOnWednesdays;
						private int startHourOnThursdays;
						private int endHourOnThursdays;
						private int startHourOnFridays;
						private int endHourOnFridays;
						private Boolean priceNotClear;
						private int price;
						private Integer maximumRegisters;
						private long modificationTime;
						private boolean active;
						@Transient
						private CoursePlan coursePlan;

						public ObjectId getId() {
							return id;
						}

						public void setId(ObjectId id) {
							this.id = id;
						}

						public boolean isDaysNotClear() {
							return daysNotClear;
						}

						public void setDaysNotClear(boolean daysNotClear) {
							this.daysNotClear = daysNotClear;
						}

						public boolean isOnSaturdays() {
							return onSaturdays;
						}

						public void setOnSaturdays(boolean onSaturdays) {
							this.onSaturdays = onSaturdays;
						}

						public boolean isOnSundays() {
							return onSundays;
						}

						public void setOnSundays(boolean onSundays) {
							this.onSundays = onSundays;
						}

						public boolean isOnMondays() {
							return onMondays;
						}

						public void setOnMondays(boolean onMondays) {
							this.onMondays = onMondays;
						}

						public boolean isOnTuesdays() {
							return onTuesdays;
						}

						public void setOnTuesdays(boolean onTuesdays) {
							this.onTuesdays = onTuesdays;
						}

						public boolean isOnWednesdays() {
							return onWednesdays;
						}

						public void setOnWednesdays(boolean onWednesdays) {
							this.onWednesdays = onWednesdays;
						}

						public boolean isOnThursdays() {
							return onThursdays;
						}

						public void setOnThursdays(boolean onThursdays) {
							this.onThursdays = onThursdays;
						}

						public boolean isOnFridays() {
							return onFridays;
						}

						public void setOnFridays(boolean onFridays) {
							this.onFridays = onFridays;
						}

						public boolean isTimesNotClear() {
							return timesNotClear;
						}

						public void setTimesNotClear(boolean timesNotClear) {
							this.timesNotClear = timesNotClear;
						}

						public int getStartHourOnSaturdays() {
							return startHourOnSaturdays;
						}

						public void setStartHourOnSaturdays(
								int startHourOnSaturdays) {
							this.startHourOnSaturdays = startHourOnSaturdays;
						}

						public int getEndHourOnSaturdays() {
							return endHourOnSaturdays;
						}

						public void setEndHourOnSaturdays(int endHourOnSaturdays) {
							this.endHourOnSaturdays = endHourOnSaturdays;
						}

						public int getStartHourOnSundays() {
							return startHourOnSundays;
						}

						public void setStartHourOnSundays(int startHourOnSundays) {
							this.startHourOnSundays = startHourOnSundays;
						}

						public int getEndHourOnSundays() {
							return endHourOnSundays;
						}

						public void setEndHourOnSundays(int endHourOnSundays) {
							this.endHourOnSundays = endHourOnSundays;
						}

						public int getStartHourOnMondays() {
							return startHourOnMondays;
						}

						public void setStartHourOnMondays(int startHourOnMondays) {
							this.startHourOnMondays = startHourOnMondays;
						}

						public int getEndHourOnMondays() {
							return endHourOnMondays;
						}

						public void setEndHourOnMondays(int endHourOnMondays) {
							this.endHourOnMondays = endHourOnMondays;
						}

						public int getStartHourOnTuesdays() {
							return startHourOnTuesdays;
						}

						public void setStartHourOnTuesdays(
								int startHourOnTuesdays) {
							this.startHourOnTuesdays = startHourOnTuesdays;
						}

						public int getEndHourOnTuesdays() {
							return endHourOnTuesdays;
						}

						public void setEndHourOnTuesdays(int endHourOnTuesdays) {
							this.endHourOnTuesdays = endHourOnTuesdays;
						}

						public int getStartHourOnWednesdays() {
							return startHourOnWednesdays;
						}

						public void setStartHourOnWednesdays(
								int startHourOnWednesdays) {
							this.startHourOnWednesdays = startHourOnWednesdays;
						}

						public int getEndHourOnWednesdays() {
							return endHourOnWednesdays;
						}

						public void setEndHourOnWednesdays(
								int endHourOnWednesdays) {
							this.endHourOnWednesdays = endHourOnWednesdays;
						}

						public int getStartHourOnThursdays() {
							return startHourOnThursdays;
						}

						public void setStartHourOnThursdays(
								int startHourOnThursdays) {
							this.startHourOnThursdays = startHourOnThursdays;
						}

						public int getEndHourOnThursdays() {
							return endHourOnThursdays;
						}

						public void setEndHourOnThursdays(int endHourOnThursdays) {
							this.endHourOnThursdays = endHourOnThursdays;
						}

						public int getStartHourOnFridays() {
							return startHourOnFridays;
						}

						public void setStartHourOnFridays(int startHourOnFridays) {
							this.startHourOnFridays = startHourOnFridays;
						}

						public int getEndHourOnFridays() {
							return endHourOnFridays;
						}

						public void setEndHourOnFridays(int endHourOnFridays) {
							this.endHourOnFridays = endHourOnFridays;
						}

						public Boolean getPriceNotClear() {
							return priceNotClear;
						}

						public void setPriceNotClear(Boolean priceNotClear) {
							this.priceNotClear = priceNotClear;
						}

						public int getPrice() {
							return price;
						}

						public void setPrice(int price) {
							this.price = price;
						}

						public Integer getMaximumRegisters() {
							return maximumRegisters;
						}

						public void setMaximumRegisters(Integer maximumRegisters) {
							this.maximumRegisters = maximumRegisters;
						}

						public long getModificationTime() {
							return modificationTime;
						}

						public void setModificationTime(long modificationTime) {
							this.modificationTime = modificationTime;
						}

						public boolean isActive() {
							return active;
						}

						public void setActive(boolean active) {
							this.active = active;
						}

						public CoursePlan getCoursePlan() {
							return coursePlan;
						}

						public void setCoursePlan(CoursePlan coursePlan) {
							this.coursePlan = coursePlan;
						}
					}

					// TODO
					public static class CoursePlanReservation {
						@Id
						private ObjectId id;
						@Transient
						private CoursePlan coursePlan;

						public ObjectId getId() {
							return id;
						}

						public void setId(ObjectId id) {
							this.id = id;
						}

						public CoursePlan getCoursePlan() {
							return coursePlan;
						}

						public void setCoursePlan(CoursePlan coursePlan) {
							this.coursePlan = coursePlan;
						}
					}

					@Id
					private ObjectId id;
					private Boolean placeNotClear;
					private String place;
					private int showOrder;
					private String status;
					private String teachersText;
					private String description;
					@Transient
					private Course course;
					@DBRef
					private Set<Teacher> teachers;
					private Set<CoursePlanModification> modifications;
					private Set<CoursePlanReservation> reservations;

					@PersistenceConstructor
					public CoursePlan(
							Set<CoursePlanModification> modifications,
							Set<CoursePlanReservation> reservations) {
						this.modifications = new HashSet<CoursePlanModification>();
						this.reservations = new HashSet<CoursePlanReservation>();
						for (CoursePlanModification modification : modifications) {
							modification.setCoursePlan(this);
							this.modifications.add(modification);
						}
						for (CoursePlanReservation reservation : reservations) {
							reservation.setCoursePlan(this);
							this.reservations.add(reservation);
						}
					}

					public ObjectId getId() {
						return id;
					}

					public void setId(ObjectId id) {
						this.id = id;
					}

					public Boolean getPlaceNotClear() {
						return placeNotClear;
					}

					public void setPlaceNotClear(Boolean placeNotClear) {
						this.placeNotClear = placeNotClear;
					}

					public String getPlace() {
						return place;
					}

					public void setPlace(String place) {
						this.place = place;
					}

					public int getShowOrder() {
						return showOrder;
					}

					public void setShowOrder(int showOrder) {
						this.showOrder = showOrder;
					}

					public String getStatus() {
						return status;
					}

					public void setStatus(String status) {
						this.status = status;
					}

					public String getDescription() {
						return description;
					}

					public void setDescription(String description) {
						this.description = description;
					}

					public String getTeachersText() {
						return teachersText;
					}

					public void setTeachersText(String teachersText) {
						this.teachersText = teachersText;
					}

					public Course getCourse() {
						return course;
					}

					public void setCourse(Course course) {
						this.course = course;
					}

					public Set<Teacher> getTeachers() {
						if (teachers == null) {
							teachers = new HashSet<Teacher>();
						}
						return teachers;
					}

					public void setTeachers(Set<Teacher> teachers) {
						this.teachers = teachers;
					}

					public Set<CoursePlanModification> getModifications() {
						if (modifications == null) {
							modifications = new HashSet<CoursePlanModification>();
						}
						return modifications;
					}

					public void setModifications(
							Set<CoursePlanModification> modifications) {
						this.modifications = modifications;
					}

					public Set<CoursePlanReservation> getReservations() {
						if (reservations == null) {
							reservations = new HashSet<CoursePlanReservation>();
						}
						return reservations;
					}

					public void setReservations(
							Set<CoursePlanReservation> reservations) {
						this.reservations = reservations;
					}
				}

				private ObjectId id;
				private Integer code;
				private Integer duration;
				private Integer price;
				private String englishName;
				private String persianName;
				private String color;
				private int showOrder;
				private String seoKeywords;
				private String seoDescription;
				private String htmlContent;
				private String shortDescription;
				private String fullDescription;
				private Group group;
				@DBRef
				private Set<Tag> tags;
				private Set<CourseResource> resources;
				private Set<CourseSyllabus> syllabuses;
				private Set<CoursePlan> plans;

				@PersistenceConstructor
				public Course(Set<CourseResource> resources,
						Set<CourseSyllabus> syllabuses, Set<CoursePlan> plans) {
					this.resources = new HashSet<Institute.Department.Group.Course.CourseResource>();
					this.syllabuses = new HashSet<Institute.Department.Group.Course.CourseSyllabus>();
					this.plans = new HashSet<Institute.Department.Group.Course.CoursePlan>();
					for (CourseResource resource : resources) {
						resource.setCourse(this);
						this.resources.add(resource);
					}
					for (CourseSyllabus syllabus : syllabuses) {
						syllabus.setCourse(this);
						this.syllabuses.add(syllabus);
					}
					for (CoursePlan plan : plans) {
						plan.setCourse(this);
						this.plans.add(plan);
					}
				}

				public ObjectId getId() {
					return id;
				}

				public void setId(ObjectId id) {
					this.id = id;
				}

				public Integer getCode() {
					return code;
				}

				public void setCode(Integer code) {
					this.code = code;
				}

				public Integer getDuration() {
					return duration;
				}

				public void setDuration(Integer duration) {
					this.duration = duration;
				}

				public Integer getPrice() {
					return price;
				}

				public void setPrice(Integer price) {
					this.price = price;
				}

				public String getEnglishName() {
					return englishName;
				}

				public void setEnglishName(String englishName) {
					this.englishName = englishName;
				}

				public String getPersianName() {
					return persianName;
				}

				public void setPersianName(String persianName) {
					this.persianName = persianName;
				}

				public String getColor() {
					return color;
				}

				public void setColor(String color) {
					this.color = color;
				}

				public int getShowOrder() {
					return showOrder;
				}

				public void setShowOrder(int showOrder) {
					this.showOrder = showOrder;
				}

				public String getSeoKeywords() {
					return seoKeywords;
				}

				public void setSeoKeywords(String seoKeywords) {
					this.seoKeywords = seoKeywords;
				}

				public String getSeoDescription() {
					return seoDescription;
				}

				public void setSeoDescription(String seoDescription) {
					this.seoDescription = seoDescription;
				}

				public String getHtmlContent() {
					return htmlContent;
				}

				public void setHtmlContent(String htmlContent) {
					this.htmlContent = htmlContent;
				}

				public String getShortDescription() {
					return shortDescription;
				}

				public void setShortDescription(String shortDescription) {
					this.shortDescription = shortDescription;
				}

				public String getFullDescription() {
					return fullDescription;
				}

				public void setFullDescription(String fullDescription) {
					this.fullDescription = fullDescription;
				}

				public Group getGroup() {
					return group;
				}

				public void setGroup(Group group) {
					this.group = group;
				}

				public Set<Tag> getTags() {
					if (tags == null) {
						tags = new HashSet<Tag>();
					}
					return tags;
				}

				public void setTags(Set<Tag> tags) {
					this.tags = tags;
				}

				public Set<CourseResource> getResources() {
					if (resources == null) {
						resources = new HashSet<CourseResource>();
					}
					return resources;
				}

				public void setResources(Set<CourseResource> resources) {
					this.resources = resources;
				}

				public Set<CourseSyllabus> getSyllabuses() {
					if (syllabuses == null) {
						syllabuses = new HashSet<CourseSyllabus>();
					}
					return syllabuses;
				}

				public void setSyllabuses(Set<CourseSyllabus> syllabuses) {
					this.syllabuses = syllabuses;
				}
			}

			@Id
			private ObjectId id;
			private String persianName;
			private String englishName;
			private int showOrder;
			private String seoKeywords;
			private String seoDescription;
			private String htmlContent;
			@Transient
			private Department department;
			private Set<Course> courses;

			@PersistenceConstructor
			public Group(Set<Course> courses) {
				this.courses = new HashSet<Course>();
				for (Course course : courses) {
					course.setGroup(this);
					this.courses.add(course);
				}
			}

			public ObjectId getId() {
				return id;
			}

			public void setId(ObjectId id) {
				this.id = id;
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

			public int getShowOrder() {
				return showOrder;
			}

			public void setShowOrder(int showOrder) {
				this.showOrder = showOrder;
			}

			public String getSeoKeywords() {
				return seoKeywords;
			}

			public void setSeoKeywords(String seoKeywords) {
				this.seoKeywords = seoKeywords;
			}

			public String getSeoDescription() {
				return seoDescription;
			}

			public void setSeoDescription(String seoDescription) {
				this.seoDescription = seoDescription;
			}

			public String getHtmlContent() {
				return htmlContent;
			}

			public void setHtmlContent(String htmlContent) {
				this.htmlContent = htmlContent;
			}

			public Department getDepartment() {
				return department;
			}

			public void setDepartment(Department department) {
				this.department = department;
			}

			public Set<Course> getCourses() {
				if (courses == null) {
					courses = new HashSet<Course>();
				}
				return courses;
			}

			public void setCourses(Set<Course> courses) {
				this.courses = courses;
			}
		}

		@Id
		private ObjectId id;
		private String persianName;
		private String englishName;
		private String color;
		private int showOrder;
		private String seoKeywords;
		private String seoDescription;
		private String htmlContent;
		@Transient
		private Institute institute;
		private Set<Group> groups;

		public Department() {
		}

		@PersistenceConstructor
		public Department(Set<Group> groups) {
			this.groups = new HashSet<Group>();
			for (Group group : groups) {
				group.setDepartment(this);
				this.groups.add(group);
			}
		}

		public ObjectId getId() {
			return id;
		}

		public void setId(ObjectId id) {
			this.id = id;
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

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public int getShowOrder() {
			return showOrder;
		}

		public void setShowOrder(int showOrder) {
			this.showOrder = showOrder;
		}

		public String getSeoKeywords() {
			return seoKeywords;
		}

		public void setSeoKeywords(String seoKeywords) {
			this.seoKeywords = seoKeywords;
		}

		public String getSeoDescription() {
			return seoDescription;
		}

		public void setSeoDescription(String seoDescription) {
			this.seoDescription = seoDescription;
		}

		public String getHtmlContent() {
			return htmlContent;
		}

		public void setHtmlContent(String htmlContent) {
			this.htmlContent = htmlContent;
		}

		public Set<Group> getGroups() {
			if (groups == null) {
				groups = new HashSet<Group>();
			}
			return groups;
		}

		public Institute getInstitute() {
			return institute;
		}

		public void setInstitute(Institute institute) {
			this.institute = institute;
		}

		public void setGroups(Set<Group> groups) {
			this.groups = groups;
		}
	}

	public static class Financial {
		@Id
		private ObjectId id;
	}

	@Id
	private ObjectId id;
	private String persianName;
	private String englishName;
	private String phone1;
	private String phone2;
	private String faxNumber;
	private String webUrl1;
	private String webUrl2;
	private String email1;
	private String email2;
	private Set<Department> departments;

	public Institute() {
	}

	@PersistenceConstructor
	public Institute(Set<Department> departments) {
		this.departments = new HashSet<Department>();
		for (Department department : departments) {
			department.setInstitute(this);
			this.departments.add(department);
		}
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
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

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
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

	public Set<Department> getDepartments() {
		if (departments == null) {
			departments = new HashSet<Department>();
		}
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}
}
