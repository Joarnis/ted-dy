package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the location database table.
 * 
 */
@Entity
@Table(name="location")
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=45)
	private String city;

	@Column(name="house_no")
	private short houseNo;

	@Column(nullable=false)
	private double latitude;

	@Column(nullable=false)
	private double longtitude;

	@Column(name="postal_code", length=20)
	private String postalCode;

	@Column(length=45)
	private String region;

	@Column(nullable=false, length=45)
	private String street;

	@Column(name="street_no", nullable=false)
	private short streetNo;

	//bi-directional many-to-one association to Listing
	@OneToMany(mappedBy="location")
	private List<Listing> listings;

	public Location() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public short getHouseNo() {
		return this.houseNo;
	}

	public void setHouseNo(short houseNo) {
		this.houseNo = houseNo;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongtitude() {
		return this.longtitude;
	}

	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public short getStreetNo() {
		return this.streetNo;
	}

	public void setStreetNo(short streetNo) {
		this.streetNo = streetNo;
	}

	public List<Listing> getListings() {
		return this.listings;
	}

	public void setListings(List<Listing> listings) {
		this.listings = listings;
	}

	public Listing addListing(Listing listing) {
		getListings().add(listing);
		listing.setLocation(this);

		return listing;
	}

	public Listing removeListing(Listing listing) {
		getListings().remove(listing);
		listing.setLocation(null);

		return listing;
	}

}