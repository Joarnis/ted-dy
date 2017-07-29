package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usable_spaces database table.
 * 
 */
@Entity
@Table(name="usable_spaces")
@NamedQuery(name="UsableSpace.findAll", query="SELECT u FROM UsableSpace u")
public class UsableSpace implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte elevator;

	private byte gym;

	private byte jacuzzi;

	private byte kitchen;

	@Column(name="laundry_dryer")
	private byte laundryDryer;

	@Column(name="laundry_washer")
	private byte laundryWasher;

	private byte parking;

	private byte pool;

	@Column(name="priv_living_room")
	private byte privLivingRoom;

	//bi-directional one-to-one association to Listing
	@OneToOne
	@JoinColumn(name="id", referencedColumnName="usable_spaces_id")
	private Listing listing;

	public UsableSpace() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getElevator() {
		return this.elevator;
	}

	public void setElevator(byte elevator) {
		this.elevator = elevator;
	}

	public byte getGym() {
		return this.gym;
	}

	public void setGym(byte gym) {
		this.gym = gym;
	}

	public byte getJacuzzi() {
		return this.jacuzzi;
	}

	public void setJacuzzi(byte jacuzzi) {
		this.jacuzzi = jacuzzi;
	}

	public byte getKitchen() {
		return this.kitchen;
	}

	public void setKitchen(byte kitchen) {
		this.kitchen = kitchen;
	}

	public byte getLaundryDryer() {
		return this.laundryDryer;
	}

	public void setLaundryDryer(byte laundryDryer) {
		this.laundryDryer = laundryDryer;
	}

	public byte getLaundryWasher() {
		return this.laundryWasher;
	}

	public void setLaundryWasher(byte laundryWasher) {
		this.laundryWasher = laundryWasher;
	}

	public byte getParking() {
		return this.parking;
	}

	public void setParking(byte parking) {
		this.parking = parking;
	}

	public byte getPool() {
		return this.pool;
	}

	public void setPool(byte pool) {
		this.pool = pool;
	}

	public byte getPrivLivingRoom() {
		return this.privLivingRoom;
	}

	public void setPrivLivingRoom(byte privLivingRoom) {
		this.privLivingRoom = privLivingRoom;
	}

	public Listing getListing() {
		return this.listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}

}