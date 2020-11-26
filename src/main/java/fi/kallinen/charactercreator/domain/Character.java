package fi.kallinen.charactercreator.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity

public class Character {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String chname;
	private int level;
	private String player;
	private int strength;
	private int dexterity;
	private int constitution;
	private int intelligence;
	private int wisdom;
	private int charisma;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "classid")
	private Chclass chclass;
	
	public Character() {
		this.strength = 0;
		this.dexterity = 0;
		this.constitution = 0;
		this.intelligence = 0;
		this.wisdom = 0;
		this.charisma = 0;
		
	}
	
	public Character(String chname, int level, String player, Chclass chclass, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
		super();
		this.chname = chname;
		this.level = level;
		this.player = player;
		this.chclass = chclass;	
		this.strength = 0;
		this.dexterity = 0;
		this.constitution = 0;
		this.intelligence = 0;
		this.wisdom = 0;
		this.charisma = 0;
	}
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getChname() {
		return chname;
	}

	public void setChname(String chname) {
		this.chname = chname;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public Chclass getChclass() {
		return chclass;
	}

	public void setChclass(Chclass chclass) {
		this.chclass = chclass;
	}
	@Override
	public String toString() {
		return "Character [id=" + id + ", chname=" + chname + ", level=" + level + ", player=" + player + "]";
	}

}
