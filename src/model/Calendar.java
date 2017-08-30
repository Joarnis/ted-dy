package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the calendar database table.
 * 
 */
@Entity
@Table(name="calendar")
@NamedQuery(name="Calendar.findAll", query="SELECT c FROM Calendar c")
public class Calendar implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CalendarPK id;

	@Column(nullable=false)
	private byte available;

	@Column(length=45)
	private String price;

	//bi-directional many-to-one association to Listing
	@ManyToOne
	@JoinColumn(name="listings_id", nullable=false, insertable=false, updatable=false)
	private Listing listing;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="guest_id")
	private User user;

	public Calendar() {
	}

	public CalendarPK getId() {
		return this.id;
	}

	public void setId(CalendarPK id) {
		this.id = id;
	}

	public byte getAvailable() {
		return this.available;
	}

	public void setAvailable(byte available) {
		this.available = available;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Listing getListing() {
		return this.listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}