package com.example.electroec.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Product entity class.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "products")
public class Product implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Column(name = "serial_num")
	@Id
	private String serialNum;

	@Column(name = "name")
	@NotNull
	private String name;

	@Column(name = "category_id")
	@NotNull
	private Integer categoryId;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	@NotNull
	private Double price;

	@Column(name = "brand_id")
	private Integer brandId;

	@Column(name = "status")
	@NotNull
	private Integer status;

	@Column(name = "rating")
	private Integer rating;

	@Column(name = "main")
	private String main;

	@Column(name = "sub1")
	private String sub1;

	@Column(name = "sub2")
	private String sub2;

	@Column(name = "sub3")
	private String sub3;

	@Column(name = "insert_date")
	@NotNull
	private Date insertDate;

	@Column(name = "update_date")
	@NotNull
	private Date updateDate;

	@Column(name = "insert_user")
	@NotNull
	private String insertUser;

	@Column(name = "update_user")
	@NotNull
	private String updateUser;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serialNum == null) ? 0 : serialNum.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Product other = (Product) obj;
		if (serialNum == null) {
			if (other.serialNum != null) {
				return false;
			}
		} else if (!serialNum.equals(other.serialNum)) {
			return false;
		}
		return true;
	}

}
