public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age = -1;
    protected String city;

    public PersonBuilder setName(String name){
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname){
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException{
        if(age < 0) throw new IllegalArgumentException("Возраст не может быть отрицательным");
        this.age = age;
        return this;
    }

    public PersonBuilder setCity(String city){
        this.city = city;
        return this;
    }

    public Person build() throws IllegalStateException{
        if(name == null || surname == null){
            throw new IllegalStateException("Фамилия и имя должны быть указаны");
        }
        if(age != -1 && city != null){
            return new Person(name, surname, age, city);
        } else if(age == -1 && city != null){
            return new Person(name, surname, city);
        } else if(age != -1){
            return new Person(name, surname, age);
        }
        return new Person(name, surname);
    }
}
