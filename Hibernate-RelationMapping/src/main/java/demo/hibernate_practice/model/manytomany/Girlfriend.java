package demo.hibernate_practice.model.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Girlfriend {
	@Id
	private int girlfriendId;
	private String girlfriendName;
	private String girlfriendType;
	@ManyToMany(mappedBy = "girlfriend")
	private List<Boyfriend> boyfriend = new ArrayList<Boyfriend>();

	public int getGirlfriendId() {
		return girlfriendId;
	}

	public void setGirlfriendId(int girlfriendId) {
		this.girlfriendId = girlfriendId;
	}

	public String getGirlfriendName() {
		return girlfriendName;
	}

	public void setGirlfriendName(String girlfriendName) {
		this.girlfriendName = girlfriendName;
	}

	public String getGirlfriendType() {
		return girlfriendType;
	}

	public void setGirlfriendType(String girlfriendType) {
		this.girlfriendType = girlfriendType;
	}

	public List<Boyfriend> getBoyfriend() {
		return boyfriend;
	}

	public void setBoyfriend(List<Boyfriend> boyfriend) {
		this.boyfriend = boyfriend;
	}

}
