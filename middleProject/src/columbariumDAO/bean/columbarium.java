package columbariumDAO.bean;

public class columbarium {
	private int number;
	private String town;
	private String publicOrPrivacy;
	private String owner;
	private String facilityName;
	private String telephone;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getPublicOrPrivacy() {
		return publicOrPrivacy;
	}
	public void setPublicOrPrivacy(String publicOrPrivacy) {
		this.publicOrPrivacy = publicOrPrivacy;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "facility [number=" + number + ", town=" + town + ", publicOrPrivacy=" + publicOrPrivacy + ", owner="
				+ owner + ", facilityName=" + facilityName + ", telephone=" + telephone + "]";
	}
	
	
	
}
