package br.com.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    @Override
    public void createContact(Contact contact) {
        this.contactRepository.save(contact);
    }

    @Override
    public void removeContact(Long id) {
        this.contactRepository.deleteById(id);
    }

    @Override
    public Contact getContactByName(String name) {
        List<Contact> contatcs = this.contactRepository.findAll();
        Contact c = contatcs.stream().filter(contact -> contact.getName().equals(name)).findAny().get();
        return c;
    }

    @Override
    public Contact getByName(String name) {
        return this.contactRepository.findByName(name);
    }

    @Override
    public List<Contact> getAllContact() {

        return this.contactRepository.findAll();
    }

    @Override
    public void replaceContactByName(String originName, String finalName) {
        Contact originName1 = getByName(originName);
        originName1.setName(finalName);
    }
}
