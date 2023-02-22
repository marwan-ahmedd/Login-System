import java.util.*;


class loginSystem {

    HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();
    private int id;
    private String name;
    private String email;
    private String number;
    private String password;
    private boolean loggedIn = true;

    public static void main(String[] args) {
        System.out.println("Welcome to Login Application Program!");
        System.out.println("*  Please select an option from the menu below: ");
        System.out.println("*  1. Register");
        System.out.println("*  2. Login");
        System.out.println("*  3. Exit");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        input.close();

        loginSystem system = new loginSystem();
        switch (choice)
        {
            case 1:
                system.register();
                break;
            case 2:
                if (system.login() == 0) {
                    break;
                } else {
                    if (system.loggedIn) {
                        system.loginPage();
                    }
                }
                break;
            case 3:
                break;
        }
    }

    public void register() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter id: ");
        id = input.nextInt();
        input.close();
        System.out.print("Enter name: ");
        name = input.next();
        input.close();
        System.out.print("Enter email: ");
        email = input.next();
        input.close();
        System.out.print("Enter number: ");
        number = input.next();
        input.close();
        map.put(id, new ArrayList<String>());
        map.get(id).add(name);
        map.get(id).add(password);
        map.get(id).add(email);
        map.get(id).add(number);
    }

    public void loginPage() {
        System.out.printf("You are logged in as %d\n", map.get(id).get(0));
        System.out.println("*  Please select an option from the menu below: ");
        System.out.println("*  1. Change Password");
        System.out.println("*  2. Logout");
        System.out.println("*  3. Exit");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        input.close();
        switch (choice)
        {
            case 1:
                changePass(id);
                break;
            case 2:
                loggedIn = false;
                break;
            case 3:
                break;
        }
    }
    public int login() {
        Scanner input = new Scanner(System.in);
        int id;
        String pass;
        System.out.print("Enter your id: ");
        id = input.nextInt();
        input.close();  

        if (!map.containsKey(id)) {
            System.out.println("Id does not exist");
            return 0;
        } else {
            System.out.print("Enter password: ");
            pass = input.nextLine();
            input.close();  
            
            if (map.get(id).get(1) != pass) {
                System.out.println("Incorrect password");
                return 0;
            }
        }
        return 1;
    }

    public void changePass(int myID) {
        boolean isPassCorrect = false;
        Scanner input = new Scanner(System.in);

        while (!isPassCorrect) {
            System.out.print("Enter old password: ");
            String oldPass = input.nextLine();
            input.close();
            if (map.get(id).get(1) != oldPass) {
                System.out.println("Incorrect password");
            } else {
                isPassCorrect = true;
            }
        }

        System.out.print("Enter the new password: ");
        String newPass = input.nextLine();
        map.get(myID).set(1, newPass);
        System.out.println("Password changed successfully");
    }
}