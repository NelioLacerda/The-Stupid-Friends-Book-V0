package ex;

import java.util.Scanner;

/**
 * @author Lord_Gargamelster
 */
public class Main {

    public static final String ADD = "Adiciona";
    public static final String DO = "Faz";
    public static final String VOTE = "Vota";
    public static final String LIST = "Lista";
    public static final String PERSONALIDADE = "Personalidade";
    public static final String EXIT = "Sair";

    public static void main(String[] args) {
        SocialSystem socialSystem = new SocialSystem();
        Scanner scanner = new Scanner(System.in);
        boolean has_finish = false;
        do {
            String input = scanner.nextLine();
            switch (input) {
                case ADD -> addOption(socialSystem, scanner);
                case DO -> DoOption(socialSystem, scanner);
                case VOTE -> voteOption(socialSystem, scanner);
                case LIST -> listOption(socialSystem, scanner);
                case PERSONALIDADE -> personalidadeOption(socialSystem, scanner);
                case EXIT -> {
                    has_finish = true;
                    System.out.println("Adeus");
                }
                default -> System.out.println("Comando Invalido");
            }
        }while (!has_finish);
        scanner.close();
    }

    private static void personalidadeOption(SocialSystem socialSystem, Scanner scanner) {
        System.out.println("Name: ");
        String name = scanner.nextLine();
        if (socialSystem.isAnExistentPerson(name)){
            System.out.println(socialSystem.getAttribute(name));
        }else{
            System.out.println(name + " não existe");
        }
    }

    private static void listOption(SocialSystem socialSystem, Scanner scanner) {
        System.out.println("Attribute: ");
        String attribute = scanner.nextLine();
        AttributeIterator attributeIterator = socialSystem.attributeIterator(attribute);
        while (attributeIterator.hasNext()){
            System.out.print(attributeIterator.next().getName() + "; ");
        }
        System.out.println("\n"+"Done");
    }

    private static void voteOption(SocialSystem socialSystem, Scanner scanner) {
        System.out.println("Name: ");
        String name = scanner.nextLine();
        if (socialSystem.isAnExistentPerson(name)){
            System.out.println("Action: ");
            String action = scanner.nextLine();
            if (socialSystem.isAnExistentPublication(name, action)){
                System.out.println("Votes: ");
                String yourSelf = scanner.nextLine();
                String others = scanner.nextLine();
                int yourSelfPoints = 0;
                int othersPoints = 0;
                yourSelfPoints = getYourSelfPoints(yourSelf, yourSelfPoints);
                othersPoints = getOthersPoints(others, othersPoints);
                socialSystem.vote(name, yourSelfPoints, othersPoints);
                System.out.println("Ok");
            }else{
                System.out.println(name + " não " + action);
            }
        }else{
            System.out.println(name + " não existe");
        }
    }

    private static int getOthersPoints(String others, int othersPoints) {
        if (others.equals("Bem")){
            othersPoints = 1;
        } else if (others.equals("Mal")) {
            othersPoints = -1;
        }
        return othersPoints;
    }

    private static int getYourSelfPoints(String yourSelf, int yourSelfPoints) {
        if (yourSelf.equals("Bem")){
            yourSelfPoints = 1;
        } else if (yourSelf.equals("Mal")) {
            yourSelfPoints = -1;
        }
        return yourSelfPoints;
    }

    private static void DoOption(SocialSystem socialSystem, Scanner scanner) {
        System.out.println("Name: ");
        String name = scanner.nextLine();
        if (socialSystem.isAnExistentPerson(name)){
            System.out.println("Action: ");
            String action = scanner.nextLine();
            if (socialSystem.isAnExistentPublication(name, action)){
                System.out.println(name + " já " + action);
            }else {
                socialSystem.addPublication(name, action);
                System.out.println("Ok");
            }
        }else{
            System.out.println(name + " não existe");
        }
    }

    private static void addOption(SocialSystem socialSystem, Scanner scanner) {
        System.out.println("Name: ");
        String name = scanner.next();
        scanner.nextLine();
        if (socialSystem.isAnExistentPerson(name)){
            System.out.println(name + " já existe");
        }else{
            socialSystem.addPerson(name);
            System.out.println("Ok");
        }
    }
}
