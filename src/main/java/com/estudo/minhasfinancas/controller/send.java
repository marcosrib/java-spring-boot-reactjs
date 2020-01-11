package com.estudo.minhasfinancas.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.estudo.minhasfinancas.model.Intermediario;
import com.estudo.minhasfinancas.model.Intermediario.Pk;
import com.estudo.minhasfinancas.model.Module;
import com.estudo.minhasfinancas.model.Profile;
import com.estudo.minhasfinancas.model.UserDto;
import com.estudo.minhasfinancas.model.Usert;
import com.estudo.minhasfinancas.repositories.IntermediarioRpository;
import com.estudo.minhasfinancas.repositories.UsertRepository;

@Controller
public class send {
	@Autowired
	private UsertRepository repo;

	@Autowired
	private IntermediarioRpository Intrepo;

	@GetMapping("/chat")
	public String sendTeste() {
		Module module = new Module();
		module.setId(6L);
		module.setName("VOL");

		Profile profile = new Profile();
		profile.setId(7L);
		profile.setName("ADMIN");

		Intermediario intermediario = new Intermediario();
		intermediario.setModule(module);
		intermediario.setProfile(profile);

		Usert usert2 = new Usert();
		usert2.setName("marcos2");

		 Usert usert = repo.save(usert2);
		 Pk pk = new Pk(profile.getId(), module.getId(), usert.getId());

		intermediario.setPk(pk);

		Intrepo.save(intermediario);
		return "This is Home page";
	}

	@PutMapping("/update")
	public String send(@RequestBody UserDto userDto) {

		List<Module> listModule = new ArrayList<>();
		List<Usert> listUSert = new ArrayList<>();
		List<Intermediario> listInt = new ArrayList<>();
		Module module = new Module();
		module.setId(userDto.getIdModule());

		Usert usert2 = new Usert();
		usert2.setId(userDto.getIdUser());

		List<Intermediario> lst = Intrepo.buscaModuloUsuario(module, usert2);
		lst.forEach(i -> {
			listModule.add(i.getModule());
			listUSert.add(i.getUsert());
		});
		if (lst.size() >= 1) {
			Intrepo.deleteModuleAndUsert(listModule, listUSert);
		}
		Usert usert = repo.save(usert2);
		
		
		userDto.getProfile().forEach(p -> {
			Profile profile = new Profile();
			profile.setId(p.getId());
			Intermediario intermediario = new Intermediario();
			intermediario.setModule(module);
			intermediario.setProfile(profile);
			intermediario.setUsert(usert);

			Pk pk = new Pk(profile.getId(), module.getId(), usert.getId());
			intermediario.setPk(pk);
			listInt.add(intermediario);
		});

		Intrepo.saveAll(listInt);
		return "fvfmvl";
	}
}
