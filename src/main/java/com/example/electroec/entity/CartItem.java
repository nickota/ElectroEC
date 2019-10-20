package com.example.electroec.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CartItems entity class.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cartitems")
public class CartItem implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "user_id")
	@NotNull
	private Integer userId;

	@Column(name = "product_serial")
	@NotNull
	private String productSerial;

	@Column(name = "quantity")
	@NotNull
	private Integer quantity;

	@Column(name = "insert_date")
	@NotNull
	private LocalDateTime insertDate;

	@Column(name = "update_date")
	@NotNull
	private LocalDateTime updateDate;

	@Column(name = "insert_user")
	@NotNull
	private String insertUser;

	@Column(name = "update_user")
	@NotNull
	private String updateUser;

	public CartItem(@NotNull Integer userId, @NotNull String productSerial, @NotNull Integer quantity,
			@NotNull String insertUser) {
		this(null, userId, productSerial, quantity, LocalDateTime.now(), LocalDateTime.now(), insertUser, insertUser);
	}

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
		CartItem other = (CartItem) obj;
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
