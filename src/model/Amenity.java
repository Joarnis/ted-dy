package model;

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
	private int id;

	@Column(name="air_conditioning")
	private byte airConditioning;

	@Column(name="bed_lock")
	private byte bedLock;

	@Column(name="breakfast_coffee_tea")
	private byte breakfastCoffeeTea;

	@Column(name="closet_drawers")
	private byte closetDrawers;

	@Column(name="co_detector")
	private byte coDetector;

	private byte essentials;

	private byte events;

	private byte extinguisher;

	private byte fireplace;

	@Column(name="first_aids")
	private byte firstAids;

	private byte hairdryer;

	private byte heat;

	private byte iron;

	@Column(name="office_wspace")
	private byte officeWspace;

	private byte pets;

	@Column(name="priv_entrance")
	private byte privEntrance;

	@Column(name="safety_card")
	private byte safetyCard;

	private byte shampoo;

	@Column(name="smoke_detector")
	private byte smokeDetector;

	private byte smoking;

	private byte tv;

	private byte wifi;

	//bi-directional one-to-one association to Listing
	@OneToOne
	@JoinColumn(name="id", referencedColumnName="amenities_id")
	private Listing listing;

	public Amenity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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