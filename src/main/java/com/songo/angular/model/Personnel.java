/**
 * 
 */
package com.songo.angular.model;

import java.util.Date;

/**
 * <p>decription:</p>
 * <p>date:2014年8月28日 下午4:01:52</p>
 * @author gsu·napoleon
 */
public class Personnel extends BaseModel {

	/**
	 * <p>attribute:</p>
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String sex;
	private Date birthDate;
	private String zodiacSign;
	private String constellation;
	private int age;
	private String mobilePhone;
	private String email;
	private int qq;
	private String profession;
	private String nativePlace;
	private String hobbies;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the zodiacSign
	 */
	public String getZodiacSign() {
		return zodiacSign;
	}

	/**
	 * @param zodiacSign the zodiacSign to set
	 */
	public void setZodiacSign(String zodiacSign) {
		this.zodiacSign = zodiacSign;
	}

	/**
	 * @return the constellation
	 */
	public String getConstellation() {
		return constellation;
	}

	/**
	 * @param constellation the constellation to set
	 */
	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the mobilePhone
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * @param mobilePhone the mobilePhone to set
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the qq
	 */
	public int getQq() {
		return qq;
	}

	/**
	 * @param qq the qq to set
	 */
	public void setQq(int qq) {
		this.qq = qq;
	}

	/**
	 * @return the profession
	 */
	public String getProfession() {
		return profession;
	}

	/**
	 * @param profession the profession to set
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}

	/**
	 * @return the nativePlace
	 */
	public String getNativePlace() {
		return nativePlace;
	}

	/**
	 * @param nativePlace the nativePlace to set
	 */
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	/**
	 * @return the hobbies
	 */
	public String getHobbies() {
		return hobbies;
	}

	/**
	 * @param hobbies the hobbies to set
	 */
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	
}
