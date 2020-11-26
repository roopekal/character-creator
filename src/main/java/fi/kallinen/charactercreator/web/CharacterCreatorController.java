package fi.kallinen.charactercreator.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.kallinen.charactercreator.domain.Character;
import fi.kallinen.charactercreator.domain.CharacterRepository;
import fi.kallinen.charactercreator.domain.ClassRepository;
import fi.kallinen.charactercreator.domain.UserRepository;


@Controller
public class CharacterCreatorController {
	
	@Autowired
	private UserRepository urepository;

	@Autowired
private CharacterRepository chrepository;
	@Autowired
	private ClassRepository clrepository;
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
	
	@RequestMapping("/index")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/characterlist")
	public String characterList(Model model) {
	model.addAttribute("characters", chrepository.findAll());
		return "characterlist";
	}
	@RequestMapping(value="/viewcharacter/{id}", method = RequestMethod.GET)
	public String character(@PathVariable("id") Long id, Model model) {
		model.addAttribute("characters",chrepository.findById(id).get());
		return "character";
	}

	@RequestMapping(value="/characterlistr", method = RequestMethod.GET)
	public @ResponseBody List<Character> characterListRest() {
	 return (List<Character>) chrepository.findAll();
	}
	@RequestMapping(value="/character/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Character> findCharacterRest(@PathVariable("id") Long id) {
	 return chrepository.findById(id);
	}
	@RequestMapping(value = "/add")
	public String addCharacter(Model model) {
		model.addAttribute("character", new Character());
		model.addAttribute("classes",clrepository.findAll());
		model.addAttribute("user",urepository.findAll());
		return "add";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Character character) {
		chrepository.save(character);
		return "redirect:characterlist";
	}	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteCharacter(@PathVariable("id")Long characterId, Model model) {
		chrepository.deleteById(characterId);
		return "redirect:../characterlist";
	}
	@RequestMapping(value = "/edit/{id}", method= RequestMethod.GET)
	public String editCharacter(@PathVariable("id")Long characterId, Model model) {
		model.addAttribute("classes",clrepository.findAll());
		Optional<Character> character = chrepository.findById(characterId);
		model.addAttribute("character", character);
		return "edit";
	}
	}
	
