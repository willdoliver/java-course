package br.com.app.main;

import br.com.app.dao.ContactDAO;
import br.com.app.model.Contact;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            // Insert contact
            ContactDAO contactDAO = new ContactDAO();

            Contact contact = new Contact();
            contact.setName("Willzito Souza");
            contact.setAge(23);
            contact.setCreatedAt(new Date());

            // contactDAO.save(contact);

            // Update contact
            Contact cttToUpdate = new Contact();
            cttToUpdate.setName("Maria zinha");
            cttToUpdate.setAge(42);
            cttToUpdate.setCreatedAt(new Date());
            cttToUpdate.setId(1);

            // contactDAO.update(cttToUpdate);

            contactDAO.deleteContactById(2);

            // Read contact
            for (Contact c : contactDAO.getContacts()) {
                System.out.println("Contact: "+ c.getId() +" - " + c.getName() + " - " + c.getAge());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
