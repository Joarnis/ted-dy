package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the calendar database table.
 * 
 */
@Embeddable
public class CalendarPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="listing_id", insertable=false, updatable=false)
	private int listingId;

	@Temporal(TemporalType.DATE)
	private java.util.Date date;

	public CalendarPK() {
	}
	public int getListingId() {
		return this.listingId;
	}
	public void setListingId(int listingId) {
		this.listingId = listingId;
	}
	public java.util.Date getDate() {
		return this.date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CalendarPK)) {
			return false;
		}
		CalendarPK castOther = (CalendarPK)other;
		return 
			(this.listingId == castOther.listingId)
			&& this.date.equals(castOther.date);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.listingId;
		hash = hash * prime + this.date.hashCode();
		
		return hash;
	}
}