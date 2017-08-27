package bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the amenities database table.
 * 
 */
@Entity
@Table(name="amenities")
@NamedQuery(name="Amenity.findAll", query="SELECT a FROM Amenity a")
public class Amenity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="listings_id", unique=true, nullable=false)
	private int listingsId;

	@Column(name="air_conditioning", nullable=false)
	private byte airConditioning;

	@Column(name="bed_lock", nullable=false)
	private byte bedLock;

	@Column(name="breakfast_coffee_tea", nullable=false)
	private byte breakfastCoffeeTea;

	@Column(name="closet_drawers", nullable=false)
	private byte closetDrawers;

	@Column(name="co_detector", nullable=false)
	private byte coDetector;

	@Column(nullable=false)
	private byte essentials;

	@Column(nullable=false)
	private byte events;

	@Column(nullable=false)
	private byte extinguisher;

	@Column(nullable=false)
	private byte fireplace;

	@Column(name="first_aids", nullable=false)
	private byte firstAids;

	@Column(nullable=false)
	private byte hairdryer;

	@Column(nullable=false)
	private byte heat;

	@Column(nullable=false)
	private byte iron;

	@Column(name="office_wspace", nullable=false)
	private byte officeWspace;

	@Column(nullable=false)
	private byte pets;

	@Column(name="priv_entrance", nullable=false)
	private byte privEntrance;

	@Column(name="safety_card", nullable=false)
	private byte safetyCard;

	@Column(nullable=false)
	private byte shampoo;

	@Column(name="smoke_detector", nullable=false)
	private byte smokeDetector;

	@Column(nullable=false)
	private byte smoking;

	@Column(nullable=false)
	private byte tv;

	@Column(nullable=false)
	private byte wifi;

	//bi-directional one-to-one association to Listing
	@OneToOne
	@JoinColumn(name="listings_id", nullable=false, insertable=false, updatable=false)
	private Listing listing;

	public Amenity() {
	}

	public int getListingsId() {
		return this.listingsId;
	}

	public void setListingsId(int listingsId) {
		this.listingsId = listingsId;
	}

	public byte getAirConditioning() {
		return this.airConditioning;
	}

	public void setAirConditioning(byte airConditioning) {
		this.airConditioning = airConditioning;
	}

	public byte getBedLock() {
		return this.bedLock;
	}

	public void setBedLock(byte bedLock) {
		this.bedLock = bedLock;
	}

	public byte getBreakfastCoffeeTea() {
		return this.breakfastCoffeeTea;
	}

	public void setBreakfastCoffeeTea(byte breakfastCoffeeTea) {
		this.breakfastCoffeeTea = breakfastCoffeeTea;
	}

	public byte getClosetDrawers() {
		return this.closetDrawers;
	}

	public void setClosetDrawers(byte closetDrawers) {
		this.closetDrawers = closetDrawers;
	}

	public byte getCoDetector() {
		return this.coDetector;
	}

	public void setCoDetector(byte coDetector) {
		this.coDetector = coDetector;
	}

	public byte getEssentials() {
		return this.essentials;
	}

	public void setEssentials(byte essentials) {
		this.essentials = essentials;
	}

	public byte getEvents() {
		return this.events;
	}

	public void setEvents(byte events) {
		this.events = events;
	}

	public byte getExtinguisher() {
		return this.extinguisher;
	}

	public void setExtinguisher(byte extinguisher) {
		this.extinguisher = extinguisher;
	}

	public byte getFireplace() {
		return this.fireplace;
	}

	public void setFireplace(byte fireplace) {
		this.fireplace = fireplace;
	}

	public byte getFirstAids() {
		return this.firstAids;
	}

	public void setFirstAids(byte firstAids) {
		this.firstAids = firstAids;
	}

	public byte getHairdryer() {
		return this.hairdryer;
	}

	public void setHairdryer(byte hairdryer) {
		this.hairdryer = hairdryer;
	}

	public byte getHeat() {
		return this.heat;
	}

	public void setHeat(byte heat) {
		this.heat = heat;
	}

	public byte getIron() {
		return this.iron;
	}

	public void setIron(byte iron) {
		this.iron = iron;
	}

	public byte getOfficeWspace() {
		return this.officeWspace;
	}

	public void setOfficeWspace(byte officeWspace) {
		this.officeWspace = officeWspace;
	}

	public byte getPets() {
		return this.pets;
	}

	public void setPets(byte pets) {
		this.pets = pets;
	}

	public byte getPrivEntrance() {
		return this.privEntrance;
	}

	public void setPrivEntrance(byte privEntrance) {
		this.privEntrance = privEntrance;
	}

	public byte getSafetyCard() {
		return this.safetyCard;
	}

	public void setSafetyCard(byte safetyCard) {
		this.safetyCard = safetyCard;
	}

	public byte getShampoo() {
		return this.shampoo;
	}

	public void setShampoo(byte shampoo) {
		this.shampoo = shampoo;
	}

	public byte getSmokeDetector() {
		return this.smokeDetector;
	}

	public void setSmokeDetector(byte smokeDetector) {
		this.smokeDetector = smokeDetector;
	}

	public byte getSmoking() {
		return this.smoking;
	}

	public void setSmoking(byte smoking) {
		this.smoking = smoking;
	}

	public byte getTv() {
		return this.tv;
	}

	public void setTv(byte tv) {
		this.tv = tv;
	}

	public byte getWifi() {
		return this.wifi;
	}

	public void setWifi(byte wifi) {
		this.wifi = wifi;
	}

	public Listing getListing() {
		return this.listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}

}