package chapter1; //my Package name

//Author name: Miss Diana
//Date create: 17.09.2025
//Purpose of Code: Create Chapter's 1 Encapsulation Simple Code

//library that being imported when necessary

class Student {
    // private fields
    private String name;
    private int age;

    // getter and setter methods
    public String getName() //getter methods
    { 
    	return name; 
    }
    
    public void setName(String n) //setter methods
    { 
    	this.name = n; 
    }

    public int getAge() //getter methods
    { 
    	return age; 
    }
    
    public void setAge(int a) //setter methods
    {
        if (a > 0) this.age = a;
    }
}

//my class name
public class Encapsulation {
    public static void main(String[] args) {
        Student st = new Student();
        st.setName("Ali");
        st.setAge(20);
        System.out.println("Name: " + st.getName());
        System.out.println("Age: " + st.getAge());
    }
}