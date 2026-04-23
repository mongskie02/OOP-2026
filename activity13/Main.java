package activity13;

public class Main {

    public static void main(String[] args) {

        Repository<String> names = new Repository<>();

        names.add("Tanggol");
        names.add("Jumong");
        names.add("Jeroy");

        System.out.println("Guests: " + names.size());

        Repository<Employee> empRepo = new Repository<>();

        empRepo.add(new Employee("Tanggol", 50000));
        empRepo.add(new Employee("Jumong", 60000));

        Employee e = empRepo.get(0);

        Result<Employee> result = new Result<>(e, "Load Successful", true);

        result.display();
    }
}
