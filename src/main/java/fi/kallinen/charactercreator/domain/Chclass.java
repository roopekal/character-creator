package fi.kallinen.charactercreator.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity

public class Chclass {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long classid;
	private String clname;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="chclass")
	private List<Character> characters;
	
	public Chclass() {}
	public Chclass(String clname) {
		super();
		this.clname = clname;
	}
	public Long getClassid() {
		return classid;
	}
	public void setClassid(Long classid) {
		this.classid = classid;
	}
	public String getClname() {
		return clname;
	}
	public void setClname(String clname) {
		this.clname = clname;
	}
	public List<Character> getCharacters() {
		return characters;
	}
	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}
	
	
}
