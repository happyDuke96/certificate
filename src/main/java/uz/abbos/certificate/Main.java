package uz.isystem.certificateservicesecond;

import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        System.out.println(check(line));
    }

    public static int check(String s) {
        int count = 0;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
                stack.push(c);
            } else if (c == ')') {
                count++;
                if (stack.isEmpty() || stack.pop() != '(') {
                    return count;
                }
            }

        }
        if (count == 0){
            return -1;
        }
        return count;
    }
}

 /*   File file = new File("input.txt");
    Scanner scanner = new Scanner(file);
    int countV = Integer.parseInt(scanner.nextLine());

    List<Vacancy> vacancies = new ArrayList<>();
        for (int i = 0; i < countV; i++) {
        Vacancy vacancy = new Vacancy();

        String vacancyStr = scanner.nextLine();
        String[] vacancyList = vacancyStr.split(",");
        vacancy.setName(vacancyList[0]);
        vacancy.setCount(Integer.parseInt(vacancyList[1]));
        vacancies.add(vacancy);
    }
    List<Candidate> candidates = new ArrayList<>();

    int countC = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countC; i++) {
        Candidate candidate = new Candidate();
        String vacancyStr = scanner.nextLine();
        String[] vacancyList = vacancyStr.split(",");
        candidate.setName(vacancyList[0]);
        candidate.setVacancyName(vacancyList[1]);
        candidate.setTask(Integer.parseInt(vacancyList[2]));
        candidate.setError(Integer.parseInt(vacancyList[3]));
        candidates.add(candidate);
    }
    List<Candidate> offer = new ArrayList<>();
        for (Vacancy v : vacancies) {
        Stack<Candidate> look = new Stack<>();
        for (Candidate c : candidates) {
            if (c.getVacancyName().equals(v.getName())) {
                look.add(c);
            }
        }

        TreeSet<Candidate> candidateSet = new TreeSet<>(new Comparator<Candidate>() {
            @Override
            public int compare(Candidate o1, Candidate o2) {
                int result = o2.getTask() - o1.getTask();
                if (result == 0) {
                    result = o1.getError() - o2.getError();
                }
                return result;
            }
        });

        candidateSet.addAll(look);

        for (int i = 0; i < v.getCount(); i++) {
            offer.add(candidateSet.pollFirst());
        }

    }
    TreeSet<Candidate> resultSet = new TreeSet<>(new Comparator<Candidate>() {
        @Override
        public int compare(Candidate o1, Candidate o2) {
            return o1.getName().compareTo(o2.getName());
        }
    });
        resultSet.addAll(offer);
        for (Candidate c : resultSet) {
        System.out.println(c.getName());
    }
*/

class Candidate {
    private String name;
    private String vacancyName;
    private Integer task;
    private Integer error;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVacancyName() {
        return vacancyName;
    }

    public void setVacancyName(String vacancyName) {
        this.vacancyName = vacancyName;
    }

    public Integer getTask() {
        return task;
    }

    public void setTask(Integer task) {
        this.task = task;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }
}

class Vacancy {
    private Integer count;
    private String name;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


/*
     File file = new File("input.txt");
        Scanner scanner = new Scanner(file);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        System.out.println(first);
        System.out.println(second);
        List<String> firstList = List.of(first.split(""));
        List<String> secondList = List.of(second.split(""));

        for (int i = 0; i < secondList.size(); i++) {
            if (firstList.get(i).equals(secondList.get(i))) {
                System.out.println("correct " + secondList.get(i));
            } else {
                boolean present = false;
                for (int j = 0; j < firstList.size(); j++) {
                    if (firstList.get(j).equals(secondList.get(i))) {
                        if (!firstList.get(j).equals(secondList.get(j))) {
                            System.out.println("present " + secondList.get(i));
                            present = true;
                            break;
                        }
                    }
                }
                if (!present) {
                    System.out.println("absent " + secondList.get(i));
                }
            }
        }*/
