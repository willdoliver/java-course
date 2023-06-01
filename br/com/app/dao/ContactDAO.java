package br.com.app.dao;

import br.com.app.factory.ConnectionFactory;
import br.com.app.model.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Data Access Object
public class ContactDAO {
    public void save(Contact contact) {
        String sql = "INSERT INTO contacts (name, age, createdAt) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, contact.getName());
            pstm.setInt(2, contact.getAge());
            pstm.setDate(3, new Date(contact.getCreatedAt().getTime()));

            pstm.execute();
            System.out.println("Contact saved successfully");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update(Contact contact) {
        String sql = "UPDATE contacts SET name = ?, age = ?, createdAt = ?"+
                " WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, contact.getName());
            pstm.setInt(2, contact.getAge());
            pstm.setDate(3, new Date(contact.getCreatedAt().getTime()));
            pstm.setInt(4, contact.getId());

            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public List<Contact> getContacts() {
        String sql = "SELECT * FROM contacts";

        List<Contact> contacts = new ArrayList<Contact>();

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while (rset.next()) {
                Contact newContact = new Contact();

                newContact.setId(rset.getInt("id"));
                newContact.setName(rset.getString("name"));
                newContact.setAge(rset.getInt("age"));
                newContact.setCreatedAt(rset.getDate("createdAt"));

                contacts.add(newContact);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset!=null) {
                    rset.close();
                }
                if (pstm!=null) {
                    pstm.close();
                }
                if (conn!=null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return contacts;
    }

    public void deleteContactById(int contactId) {
        String sql = "DELETE FROM contacts WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, contactId);

            pstm.execute();
            System.out.println("Contact "+ contactId + " removed successfully");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
