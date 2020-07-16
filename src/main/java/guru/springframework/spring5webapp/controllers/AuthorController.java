package guru.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import guru.springframework.spring5webapp.repositories.AuthorRepository;

@Controller
public class AuthorController
{
	private final AuthorRepository _authorRepository;

	public AuthorController(final AuthorRepository authorRepository)
	{
		_authorRepository = authorRepository;
	}

	@RequestMapping("/authors")
	public String getAuthors(final Model model)
	{
		model.addAttribute("authors", _authorRepository.findAll());
		return "authors/list";
	}
}
