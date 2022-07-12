package main.java.controller.impl;

import controller.dto.BookFormatDto;
import enums.Format;
import model.BookFormat;
import repository.BookFormatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class BookFormatController {

    @Autowired
    private BookFormatRepository bookFormatRepository;

    @GetMapping("/format/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getBookFormat(@PathVariable String isbn) {
        return bookFormatRepository.findByIsbn(isbn);
    }

    @PostMapping("/format")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBookFormat(@RequestBody @Valid BookFormatDto bookFormatDto) {
        for (String format : bookFormatDto.getFormats()){
            bookFormatRepository.save(new BookFormat(bookFormatDto.getIsbn(), Format.valueOf(format)));
        }
    }
}
