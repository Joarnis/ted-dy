package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the listing_pics database table.
 * 
 */
@Entity
@Table(name="listing_pics")
@NamedQuery(name="ListingPic.findAll", query="SELECT l FROM ListingPic l")
public class ListingPic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="pic_path", nullable=false, length=45)
	private String picPath;

	//bi-directional many-to-one association to Listing
	@ManyToOne
	@JoinColumn(name="listings_id", nullable=false)
	private Listing listing;

	public ListingPic() {
	}

	public String getPicPath() {
		return this.picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public Listing getListing() {
		return this.listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}

}