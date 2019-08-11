package com.example.electroec.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Cart entity class.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "cart")
public class Cart implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "customer_id")
	@NotNull
	private Integer customerId;

	@JoinColumn(name = "product_serial")
	@ManyToOne
	@NotNull
	private Product product;

	@Column(name = "quantity")
	@NotNull
	private Integer quantity;

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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Cart other = (Cart) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
