package fi.kallinen.charactercreator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.kallinen.charactercreator.domain.Character;
import fi.kallinen.charactercreator.domain.CharacterRepository;
import fi.kallinen.charactercreator.domain.Chclass;
import fi.kallinen.charactercreator.domain.ClassRepository;
import fi.kallinen.charactercreator.domain.User;
import fi.kallinen.charactercreator.domain.UserRepository;

@SpringBootApplication
public class CharactercreatorApplication {

private static final Logger log = LoggerFactory.getLogger(CharactercreatorApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CharactercreatorApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CharacterRepository chrepository, ClassRepository clrepository, UserRepository urepository) {
		return (args) -> {
			log.info("save some things");
			Chclass cl1 = new Chclass("Barbarian");
			Chclass cl2 = new Chclass("Bard");
			Chclass cl3 = new Chclass("Cleric");
			Chclass cl4 = new Chclass("Druid");
			Chclass cl5 = new Chclass("Fighter");
			Chclass cl6 = new Chclass("Monk");
			Chclass cl7 = new Chclass("Paladin");
			Chclass cl8 = new Chclass("Ranger");
			Chclass cl9 = new Chclass("Rogue");
			Chclass cl10 = new Chclass("Sorcerer");
			Chclass cl11 = new Chclass("Warlock");
			Chclass cl12 = new Chclass("Wizard");
			
			clrepository.save(cl1);
			clrepository.save(cl2);
			clrepository.save(cl3);
			clrepository.save(cl4);
			clrepository.save(cl5);
			clrepository.save(cl6);
			clrepository.save(cl7);
			clrepository.save(cl8);
			clrepository.save(cl9);
			clrepository.save(cl10);
			clrepository.save(cl11);
			clrepository.save(cl12);
			
			Character ch1 = new Character("Midas Mulligan", 3,"Roope", clrepository.findByClname("Cleric").get(0),13,11,16,15,20,11);
			
			chrepository.save(ch1);
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			User user3 = new User("roope", "$2a$10$12MKx935itruXQwEYfZxBeKTWepH6cO0RCsDVTIs19BwvuzWq1VMa","ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
			
			log.info("fetch all");
			for (Character character : chrepository.findAll()) {
				log.info(character.toString());
		};
		};
	}
	
}
