package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=45)
	private String email;

	@Column(name="first_name", nullable=false, length=30)
	private String firstName;

	@Column(name="is_host", nullable=false)
	private byte isHost;

	@Column(name="is_verified", nullable=false)
	private byte isVerified;

	@Column(name="last_name", nullable=false, length=30)
	private String lastName;

	@Column(nullable=false, length=128)
	private String passhash;

	@Column(name="phone_num", nullable=false, length=20)
	private String phoneNum;

	@Column(nullable=false, length=20)
	private String username;

	//bi-directional many-to-one association to Calendar
	@OneToMany(mappedBy="user")
	private List<Calendar> calendars;

	//bi-directional many-to-one association to Listing
	@OneToMany(mappedBy="user")
	private List<Listing> listings;

	//bi-directional many-to-one association to Review
	@OneToMany(mappedBy="user")
	private List<Review> reviews;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public byte getIsHost() {
		return this.isHost;
	}

	public void setIsHost(byte isHost) {
		this.isHost = isHost;
	}

	public byte getIsVerified() {
		return this.isVerified;
	}

	public void setIsVerified(byte isVerified) {
		this.isVerified = isVerified;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPasshash() {
		return this.passhash;
	}

	public void setPasshash(String passhash) {
		this.passhash = passhash;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Calendar> getCalendars() {
		return this.calendars;
	}

	public void setCalendars(List<Calendar> calendars) {
		this.calendars = calendars;
	}

	public Calendar addCalendar(Calendar calendar) {
		getCalendars().add(calendar);
		calendar.setUser(this);

		return calendar;
	}

	public Calendar removeCalendar(Calendar calendar) {
		getCalendars().remove(calendar);
		calendar.setUser(null);

		return calendar;
	}

	public List<Listing> getListings() {
		return this.listings;
	}

	public void setListings(List<Listing> listings) {
		this.listings = listings;
	}

	public Listing addListing(Listing listing) {
		getListings().add(listing);
		listing.setUser(this);

		return listing;
	}

	public Listing removeListing(Listing listing) {
		getListings().remove(listing);
		listing.setUser(null);

		return listing;
	}

	public List<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Review addReview(Review review) {
		getReviews().add(review);
		review.setUser(this);

		return review;
	}

	public Review removeReview(Review review) {
		getReviews().remove(review);
		review.setUser(null);

		return review;
	}

}