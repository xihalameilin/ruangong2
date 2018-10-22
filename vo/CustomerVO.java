package vo;

import java.io.Serializable;

public class CustomerVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * ���
	 */
	String number;
	/*
	 * ����
	 */
	int classfication;
	/*
	 * ����
	 */
	int level;
	/*
	 * ����
	 */
	String name;
	/*
	 * �绰
	 */
	String telephone;
	/*
	 * ��ַ
	 */
	String address;
	 /*
	  * �ʱ�
	  */
	String postcode;
	/*
	 * ��������
	 */
	String email;
	/*
	 * Ӧ�ն��
	 */
	double maxincome;
	/*
	 * Ӧ��
	 */
	double income;
	/*
	 * Ӧ��
	 */
	double payment;
	/*
	 * Ĭ��ҵ��Ա
	 */
	String defaultname;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getClassfication() {
		return classfication;
	}
	public void setClassfication(int classfication) {
		this.classfication = classfication;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getMaxincome() {
		return maxincome;
	}
	public void setMaxincome(double maxincome) {
		this.maxincome = maxincome;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public String getDefaultname() {
		return defaultname;
	}
	public void setDefaultname(String defaultname) {
		this.defaultname = defaultname;
	}
	
	

}