package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the listings database table.
 * 
 */
@Entity
@Table(name="listings")
@NamedQuery(name="Listing.findAll", query="SELECT l FROM Listing l")
public class Listing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="bathrooms_no")
	private BigDecimal bathroomsNo;

	private String capacity;

	@Column(name="listing_url")
	private String listingUrl;

	@Column(name="min_nights")
	private short minNights;

	private String name;

	@Column(name="rooms_no")
	private byte roomsNo;

	private String summary;

	//bi-directional one-to-one association to Amenity
	@OneToOne(mappedBy="listing")
	private Amenity amenity;

	//bi-directional many-to-one association to Calendar
	@OneToMany(mappedBy="listing")
	private List<Calendar> calendars;

	//bi-directional many-to-one association to Location
	@ManyToOne
	private Location location;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="owner_id")
	private User user;

	//bi-directional many-to-one association to Review
	@OneToMany(mappedBy="listing")
	private List<Review> reviews;

	//bi-directional one-to-one association to UsableSpace
	@OneToOne(mappedBy="listing")
	private UsableSpace usableSpace;

	public Listing() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getBathroomsNo() {
		return this.bathroomsNo;
	}

	public void setBathroomsNo(BigDecimal bathroomsNo) {
		this.bathroomsNo = bathroomsNo;
	}

	public String getCapacity() {
		return this.capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getListingUrl() {
		return this.listingUrl;
	}

	public void setListingUrl(String listingUrl) {
		this.listingUrl = listingUrl;
	}

	public short getMinNights() {
		return this.minNights;
	}

	public void setMinNights(short minNights) {
		this.minNights = minNights;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getRoomsNo() {
		return this.roomsNo;
	}

	public void setRoomsNo(byte roomsNo) {
		this.roomsNo = roomsNo;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Amenity getAmenity() {
		return this.amenity;
	}

	public void setAmenity(Amenity amenity) {
		this.amenity = amenity;
	}

	public List<Calendar> getCalendars() {
		return this.calendars;
	}

	public void setCalendars(List<Calendar> calendars) {
		this.calendars = calendars;
	}

	public Calendar addCalendar(Calendar calendar) {
		getCalendars().add(calendar);
		calendar.setListing(this);

		return calendar;
	}

	public Calendar removeCalendar(Calendar calendar) {
		getCalendars().remove(calendar);
		calendar.setListing(null);

		return calendar;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Review addReview(Review review) {
		getReviews().add(review);
		review.setListing(this);

		return review;
	}

	public Review removeReview(Review review) {
		getReviews().remove(review);
		review.setListing(null);

		return review;
	}

	public UsableSpace getUsableSpace() {
		return this.usableSpace;
	}

	public void setUsableSpace(UsableSpace usableSpace) {
		this.usableSpace = usableSpace;
	}

}