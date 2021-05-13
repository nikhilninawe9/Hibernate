package demo.hibernate_practice.model.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Boyfriend {
	@Id
	private int boyfriendId;
	private String boyfriendName;
	private String boyfriendBusiness;
	private String boyfriendType;
	@ManyToMany
	private List<Girlfriend> girlfriend = new ArrayList<Girlfriend>();

	public int getBoyfriendId() {
		return boyfriendId;
	}

	public void setBoyfriendId(int boyfriendId) {
		this.boyfriendId = boyfriendId;
	}

	public String getBoyfriendName() {
		return boyfriendName;
	}

	public void setBoyfriendName(String boyfriendName) {
		this.boyfriendName = boyfriendName;
	}

	public String getBoyfriendBusiness() {
		return boyfriendBusiness;
	}

	public void setBoyfriendBusiness(String boyfriendBusiness) {
		this.boyfriendBusiness = boyfriendBusiness;
	}

	public String getBoyfriendType() {
		return boyfriendType;
	}

	public void setBoyfriendType(String boyfriendType) {
		this.boyfriendType = boyfriendType;
	}

	public List<Girlfriend> getGirlfriend() {
		return girlfriend;
	}

	public void setGirlfriend(List<Girlfriend> girlfriend) {
		this.girlfriend = girlfriend;
	}
}
