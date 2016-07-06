package Model;

import java.io.Serializable;

public class Person implements Serializable
{
    private String firstName;
    private String lastName;
    private String gender;
    private String DOB;
    private String SSN;


    public Person()
    {
        firstName = null;
        lastName = null;
        gender = null;
        DOB = null;
        SSN = null;
    }

    public Person(String newFirstName, String newLastName, String newGender, String newDOB, String newSSN)
    {
        firstName = newFirstName;
        lastName = newLastName;
        gender = newGender;
        DOB = newDOB;
        SSN = newSSN;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getGender()
    {
        return gender;
    }

    public String getDOB()
    {
        return DOB;
    }

    public String getSSN()
    {
        return SSN;
    }

    public void setFirstName(String newFirstName)
    {
        this.firstName = newFirstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public void setDOB(String DOB)
    {
        this.DOB = DOB;
    }

    public void setSSN(String SSN)
    {
        this.SSN = SSN;
    }

    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!firstName.equals(person.firstName)) return false;
        if (!lastName.equals(person.lastName)) return false;
        if (!gender.equals(person.gender)) return false;
        if (!SSN.equals(person.SSN)) return false;
        return DOB.equals(person.DOB);

    }

    @Override
    public String toString()
    {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", DOB='" + DOB + '\'' +
                ", SSN='" + SSN + '\'' +
                '}';
    }
}
