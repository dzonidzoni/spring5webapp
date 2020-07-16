package guru.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import guru.springframework.spring5webapp.repositories.BookRepository;

@Controller
public class BookController
{
	private final BookRepository _bookRepository;

	public BookController(final BookRepository bookRepository)
	{
		_bookRepository = bookRepository;
	}

	@RequestMapping("/books")
	public String getBooks(final Model model)
	{
		model.addAttribute("books", _bookRepository.findAll());
		return "books/list";
	}
}

