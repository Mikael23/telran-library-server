package telran.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.*;

import telran.library.common.AuthorData;
import telran.library.entities.Author;
import telran.library.model.interfaces.LibraryModel;

@ImportResource("classpath:beans.xml")
@RestController
@SpringBootApplication
public class LibraryRestService {
    @Autowired
    private LibraryModel library;
    
    @RequestMapping("author/{name}")
    public AuthorData getAuthor(@PathVariable String name) {
        Author a = library.getAuthor(name);
        
        AuthorData result =
            (a == null) ? null : new AuthorData(a.getName(), a.getCountry());
        
        return result;
    }
    
    public static void main(String[] args) {
        SpringApplication.run(LibraryRestService.class, args);
    }
}
