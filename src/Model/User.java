package Model;

import java.io.Serializable;

public class User extends Person implements Serializable
{
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String photo;

    public User()
    {
        super();
        username = "None";
        password = "None";
        email = "None";
        phoneNumber = "None";
        photo = "None";
    }

    public User(String newFirstName, String newLastName, String newGender, String newDOB, String newSSN,
                String username, String password, String email, String phoneNumber, String photo)
    {
        super(newFirstName, newLastName, newGender, newDOB, newSSN);
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.photo = photo;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getPhoto()
    {
        return photo;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void setPhoto(String photo)
    {
        this.photo = photo;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
