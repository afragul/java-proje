public class CustomerData{
    private String name,surname,country, city, occupation;
    
    public CustomerData(){
    name="name not yet entered";
    surname="surname not yet entered";
    city="city not yet entered";
    country="country not yet entered";
    occupation="occupation not yet entered";
    }
    
    public CustomerData(String name, String surname, String city, String country, String occupation){
    this.name=name;
    this.surname=surname;
    this.city=city;
    this.country=country;
    this.occupation=occupation;
    }
    
    public CustomerData(CustomerData other){ //copy contructor
    name=other.name;
    surname=other.surname;
    city=other.city;
    country=other.country;
    occupation=other.occupation;
    }
    
    public String getName() { return name; }
    
    public String getSurname() { return surname; }
    
    public String getCity() { return city; }
    
    public String getCountry() { return country; }
    
    public String getOccupation() { return occupation; }
    
    public void setName(String name) { this.name = name;}
    
    public void setSurname(String surname) { this.surname = surname;}
    
    public void setCity(String city) { this.city = city;}
    
    public void setCountry(String country) { this.country = country;}
    
    public void setOccupation(String occupation) { this.occupation = occupation;}
    
    public String toString(){
    return ("name: "+ name+ " surname: " +surname+" city and country: "+city+country+" occupation: "+occupation);
    }
    
}