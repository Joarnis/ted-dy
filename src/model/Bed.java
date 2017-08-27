package bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bed database table.
 * 
 */
@Entity
@Table(name="bed")
@NamedQuery(name="Bed.findAll", query="SELECT b FROM Bed b")
public class Bed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="bedroom_no", nullable=false)
	private int bedroomNo;

	@Column(name="is_common", nullable=false)
	private byte isCommon;

	@Column(nullable=false, length=20)
	private String type;

	//bi-directional many-to-one association to Listing
	@ManyToOne
	@JoinColumn(name="listings_id", nullable=false)
	private Listing listing;

	public Bed() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBedroomNo() {
		return this.bedroomNo;
	}

	public void setBedroomNo(int bedroomNo) {
		this.bedroomNo = bedroomNo;
	}

	public byte getIsCommon() {
		return this.isCommon;
	}

	public void setIsCommon(byte isCommon) {
		this.isCommon = isCommon;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Listing getListing() {
		return this.listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}

}