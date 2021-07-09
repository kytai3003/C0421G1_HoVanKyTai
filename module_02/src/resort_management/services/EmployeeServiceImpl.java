package resort_management.services;

import resort_management.common.EmployeeReadAndWriteFile;
import resort_management.models.Employee;
import resort_management.regex.DayOfBirthRegex;
import resort_management.services.interfaces.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private static final String FILE_PATH = "D:\\C2401G1_HoVanKyTai\\module_02\\src\\resort_management\\data\\employee.csv";
    static Scanner sc = new Scanner(System.in);
    private static List<Employee> employees = new ArrayList<>();
    static EmployeeReadAndWriteFile readAndWriteFile = new EmployeeReadAndWriteFile();
    private static DayOfBirthRegex dayOfBirthRegex = new DayOfBirthRegex();
    String[] qualificationArr = {"University", "College", "Intermediate", "Postgraduate"};
    String[] positionArr = {"Receptionist", "Waiter", "Specialist", "Supervisor", "Manager", "Director"};

    @Override
    public void displayList() {
        for (Employee e: readAndWriteFile.readFile(FILE_PATH)) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void addNew() {
        employees = readAndWriteFile.readFile(FILE_PATH);
        System.out.println("Input code: ");
        String code = sc.nextLine();
        System.out.println("Input name: ");
        String name = sc.nextLine();
        System.out.println("Input day of birth (Format: dd/mm/yyyy and the age must be in 18 - 100 range)"); // Sử dụng Regular Expression
        String dayOfBirth = dayOfBirthRegex.legalDayOfBirth();
        System.out.println("Input sex: ");
        String sex = sc.nextLine();
        System.out.println("Input email: ");
        String email = sc.nextLine();
        System.out.println("Input ID number: ");
        int idNumber = 0;
        boolean isLegalID = false;
        while (!isLegalID) {
            try {
                idNumber = Integer.parseInt(sc.nextLine());
                isLegalID = true;
            } catch (Exception e) {
                System.err.println("Input number only. Retry: ");
            }
        }
        System.out.println("Input phone number: ");
        String phone = sc.nextLine();
        String position = inputPosition();
        System.out.println("Input salary: ");
        double salary = 0;
        boolean isLegalSalary = false;
        while (!isLegalSalary) {
            try {
                idNumber = Integer.parseInt(sc.nextLine());
                isLegalSalary = true;
            } catch (Exception e) {
                System.err.println("Input number only. Retry: ");
            }
        }
        String qualification = inputQualification();
        Employee newEmployee = new Employee(code, name, dayOfBirth, sex, email, idNumber, phone, position, salary, qualification);
        employees.add(newEmployee);
        System.out.println("Successful.");
        readAndWriteFile.writeFile(FILE_PATH, employees);
    }

    @Override
    public void editEmployee() {
            employees = readAndWriteFile.readFile(FILE_PATH);
            System.out.println("You chose Employee Editing.");
            boolean isTrueCode = false;
            while (!isTrueCode) {
                System.out.println("Input employee code: ");
                String input = sc.nextLine();
                boolean isExist = false;
                int index = 0;
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i).getCode().equals(input)) {
                        isExist = true;
                        index = i;
                        break;
                    }
                }
                if (!isExist) {
                    System.err.println("Code not found!");
                } else {
                    isTrueCode = true;
                    boolean isLegalEdit = false;
                    System.out.println("Result: " + "\n" + employees.get(index).toString());
                    System.out.println("Choose the property: ");
                    System.out.println("1) Edit name");
                    System.out.println("2) Edit day of birth");
                    System.out.println("3) Edit sex");
                    System.out.println("4) Edit email");
                    System.out.println("5) Edit ID number");
                    System.out.println("6) Edit phone");
                    System.out.println("7) Edit position");
                    System.out.println("8) Edit salary");
                    System.out.println("9) Edit qualification");
                    System.out.println("0) Back.");
                    while (!isLegalEdit) {
                        try {
                            int empChoice = Integer.parseInt(sc.nextLine());
                            switch (empChoice) {
                                case 1:
                                    System.out.println("Input new name: ");
                                    String newName = sc.nextLine();
                                    employees.get(index).setName(newName);
                                    break;

                                case 2:
                                    System.out.println("Input new day of birth (Format: dd/mm/yyyy and the age must be in 18 - 100 range)"); // Sử dụng Sử dụng Regular Expression
                                    String newDob = dayOfBirthRegex.legalDayOfBirth();
                                    employees.get(index).setDayOfBirth(newDob);
                                    break;

                                case 3:
                                    System.out.println("Input new sex: ");
                                    String newSex = sc.nextLine();
                                    employees.get(index).setSex(newSex);
                                    break;

                                case 4:
                                    System.out.println("Input new email: ");
                                    String newEmail = sc.nextLine();
                                    employees.get(index).setEmail(newEmail);
                                    break;

                                case 5:
                                    System.out.println("Input new ID number: ");
                                    boolean isLegalID = false;
                                    while (!isLegalID) {
                                        try {
                                            int newIdNumb = Integer.parseInt(sc.nextLine());
                                            employees.get(index).setIdNumber(newIdNumb);
                                            System.out.println("Success");
                                            isLegalID = true;
                                        } catch (Exception e) {
                                            System.err.println("Input number only. Retry: ");
                                        }
                                    }
                                    break;

                                case 6:
                                    System.out.println("Input phone number: ");
                                    String newPhone = sc.nextLine();
                                    employees.get(index).setPhoneNumber(newPhone);
                                    break;

                                case 7:
                                    String newPos = inputPosition();
                                    employees.get(index).setPosition(newPos);
                                    break;

                                case 8:
                                    System.out.println("Input new salary: ");
                                    boolean isLegalSalary = false;
                                    double newSalary = 0;
                                    while (!isLegalSalary) {
                                        try {
                                            newSalary = Integer.parseInt(sc.nextLine());
                                            employees.get(index).setSalary(newSalary);
                                            System.out.println("Success");
                                            isLegalSalary = true;
                                        } catch (Exception e) {
                                            System.err.println("Input number only. Retry: ");
                                        }
                                    }
                                    break;

                                case 9:
                                    String qualification = inputQualification();
                                    employees.get(index).setQualification(qualification);
                                    break;

                                case 0:
                                    return;

                                default:
                                    System.err.println("False input. Please retry.");
                            }
                            isLegalEdit = true;
                        } catch (Exception e) {
                            System.err.println("Input number only. Retry.");
                        }
                    }
                }
            }
        readAndWriteFile.writeFile(FILE_PATH, employees);
    }
    public String inputPosition() {
        System.out.println("Input position. Choose one: ");
        for (int i = 0; i < positionArr.length; i++) {
            System.out.println(i + ") " + positionArr[i]);
        }
        String position = "";
        boolean isLegalPosition = false;
        while (!isLegalPosition) {
            try {
                int choicePos = Integer.parseInt(sc.nextLine());
                switch (choicePos) {
                    case 0:
                        isLegalPosition = true;
                        position = positionArr[0];
                        break;
                    case 1:
                        isLegalPosition = true;
                        position = positionArr[1];
                        break;
                    case 2:
                        isLegalPosition = true;
                        position = positionArr[2];
                        break;
                    case 3:
                        isLegalPosition = true;
                        position = positionArr[3];
                        break;
                    case 4:
                        isLegalPosition = true;
                        position = positionArr[4];
                        break;
                    case 5:
                        isLegalPosition = true;
                        position = positionArr[5];
                        break;
                    default:
                        System.err.println("Input position false. Please retry.");
                }
            } catch (Exception e) {
                System.err.println("Input number only. Retry.");
            }
        }
        return position;
    }

    public String inputQualification() {
        System.out.println("Input qualification. Choose one: ");
        for (int i = 0; i < qualificationArr.length; i++) {
            System.out.println(i + ") " + qualificationArr[i]);
        }
        String qualification = "";
        boolean isLegalQualification = false;
        while (!isLegalQualification) {
            try {
                int choiceQual = Integer.parseInt(sc.nextLine());
                switch (choiceQual) {
                    case 0:
                        isLegalQualification = true;
                        qualification = qualificationArr[0];
                        break;
                    case 1:
                        isLegalQualification = true;
                        qualification = qualificationArr[1];
                        break;
                    case 2:
                        isLegalQualification = true;
                        qualification = qualificationArr[2];
                        break;
                    case 3:
                        isLegalQualification = true;
                        qualification = qualificationArr[3];
                        break;
                    default:
                        System.err.println("Input qualification false. Please retry.");
                }
            } catch (Exception e) {
                System.err.println("Input number only. Retry.");
            }
        }
        return qualification;
    }
}