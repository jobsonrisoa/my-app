package br.com.contact;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/V1/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Contact> get(){
        return this.contactService.getAllContact();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createContact(@RequestBody Contact contact){
        this.contactService.createContact(contact);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteContact(@RequestParam Long id) {
        this.contactService.removeContact(id);
    }

    @GetMapping("/find-by-name")
    @ResponseStatus(HttpStatus.OK)
    public Contact getContactByName(@RequestParam String name) {
       return this.contactService.getByName(name);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public void replaceContactByName(@RequestParam String originName, @RequestParam String finalName) {
        this.contactService.replaceContactByName(originName,finalName);
    }

}
