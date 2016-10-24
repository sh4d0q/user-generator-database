package pl.shadoq;

import pl.shadoq.entity.User;
import pl.shadoq.service.UserService;
import pl.shadoq.service.impl.UserServiceImpl;

import java.util.Date;
import java.util.Random;

public class App {
    public static String[] imieMeskie = {"Jan", "Tomasz", "Wiesław", "Zbigniew", "Lech", "Stanisław", "Marek",
            "Karol", "Mateusz", "Jakub", "Marcin", "Kamil", "Janusz", "Wojciech", "Konrad", "Paweł", "Radosław"};

    public static String[] imieZenskie = {"Katarzyna", "Monika", "Magda", "Agata", "Karolina", "Anna", "Aneta",
            "Joanna", "Agnieszka", "Weronika", "Paulina", "Ewelina", "Diana", "Edyta", "Kamila"};

    public static String[] nazwiska = {"Nowak", "Kowalski", "Wiśniewski", "Dąbrowski", "Lewandowski", "Wójcik",
            "Kamiński", "Kowalczyk", "Zieliński", "Szymański", "Woźniak", "Kozłowski", "Jankowski", "Wojciechowski", "Kwiatkowski",
            "Kaczmarek", "Mazur", "Krawczyk", "Piotrkowski", "Grabowski", "Nowakowski", "Pawłowski", "Michalski", "Nowicki", "Adamczyk",
            "Dudek", "Zając", "Wieczorek", "Jabłoński", "Król", "Majewski", "Olszewski", "Jaworksi", "Wróbel", "Malinowski", "Pawlak",
            "Witkowski", "Walczak", "Stępień", "Górski", "Rutkowski", "Michalak", "Sikorski", "Ostrowski", "Baran", "Duda", "Szewczyk",
            "Tomaszewski", "Pietrzak", "Marciniak", "Wróblewski", "Zalewski", "Jakubowski", "Jasiński", "Zawadzki", "Sadowski", "Bąk",
            "Chmielewski", "Włodarczyk", "Borkowski", "Czarnecki", "Sawicki", "Sokołowski", "Urbaniak", "Kubiak", "Maciejewski",
            "Szczepański", "Kucharski", "Wilk", "Kolanowski", "Lis", "Mazurek", "Wysocki", "Adamski", "Wasilewski", "Czerwiński"
    };

    public static String[] ulice = {"Polna", "Lesna", "Sloneczna", "Krótka", "Szkolna", "Ogrodowa", "Lipowa", "Brzozowa", "Lakowa", "Kwiatowa",
            "Sosnowa", "Koscielna", "Akacjowa", "Parkowa", "Zielona", "Kolejowa", "Sportowa", "Debowa", "Kosciuszki", "Maja", "Mickiewicza",
            "Cicha", "Spokojna", "Klonowa", "Spacerowa", "Swierkowa", "Kasztanowa", "Nowa", "Piaskowa", "Sienkiewicza", "Rózana", "Topolowa",
            "Wisniowa", "Dworcowa", "Wiejska", "Graniczna", "Slowackiego", "Dluga", "Wrzosowa", "Konopnickiej", "Boczna", "Waska", "Wierzbowa",
            "Jasminowa", "Wspólna", "Modrzewiowa", "Kopernika", "Jana", "Poprzeczna", "Wesola", "Pogodna", "Zeromskiego", "Rynek", "Bukowa",
            "Wojska", "Sadowa", "Górna", "Jodlowa", "Wolnosci", "Glówna", "Mlynska", "Strazacka", "Prusa", "Jesionowa", "Przemyslowa",
            "Osiedlowa", "Wiosenna", "Sikorskiego", "Chopina", "Poludniowa", "Malinowa", "Stawowa", "Reymonta", "Pilsudskiego", "Zacisze",
            "Cmentarna", "Okrezna", "Kochanowskiego", "Armii", "Mila", "Jasna", "Wodna", "Zamkowa", "Witosa", "Reja", "Warszawska", "Miodowa",
            "Partyzantów", "Krzywa", "Kilinskiego", "Dolna", "Podgórna", "Kreta", "Jarzebinowa", "Moniuszki", "Targowa", "Prosta",
            "Orzeszkowej", "Spóldzielcza", "Jagodowa"};


    public static String[] miasta = {"Warszawa", "Lublin", "Kraków", "Gdańsk", "Wrocław", "Szczecin", "Katowice", "Rzeszów",
            "Poznań", "Bydgoszcz", "Łódź"};

    public static String[] wojewodztwa = {"Mazowieckie", "Lubelskie", "Małopolskie", "Pomorskie", "Dolnośląskie", "Zachodnio-pomorskie",
    "Slaskie", "Podkarpackie", "Wielkopolskie", "Kujawsko-pomorskie", "Łódzkie"};

    public Character[] plec = {'M', 'K'};

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            User user = new User();

            if(random.nextBoolean()) {
                user.setSex('M');
                user.setFirstName(imieMeskie[random.nextInt(imieMeskie.length)]);

                if(random.nextBoolean()) {
                    user.setMiddleName(imieMeskie[random.nextInt(imieMeskie.length)]);
                }

                user.setLastName(nazwiska[random.nextInt(nazwiska.length)]);

            } else {
                user.setSex('K');
                user.setFirstName(imieZenskie[random.nextInt(imieZenskie.length)]);

                if(random.nextBoolean()) {
                    user.setMiddleName(imieZenskie[random.nextInt(imieZenskie.length)]);
                }

                String lastName = nazwiska[random.nextInt(nazwiska.length)];
                if(lastName.substring(lastName.length()-1, lastName.length()).equals("i")) {
                    lastName = lastName.substring(0, lastName.length()-1) + "a";
                }

                user.setLastName(lastName);
            }


            user.setAddress(ulice[random.nextInt(ulice.length)] + " " + (random.nextInt(300) + 1) + "/" + (random.nextInt(100)+1));
            int idMiasta = random.nextInt(miasta.length);
            user.setCity(miasta[idMiasta]);
            user.setState(wojewodztwa[idMiasta]);

            Integer year = random.nextInt(116);
            Integer month = random.nextInt(12);
            Integer day = random.nextInt(28);
            Date date = new Date(year,month,day);
            year += 1900;

            user.setBirth(date);
            String tMonth;
            if(month+1<10) {
                tMonth = "0" + month + 1;
            } else {
                tMonth = "" + month + 1;
            }

            String tDay;
            if(day+1<10) {
                tDay = "0" + day + 1;
            } else {
                tDay = "" + day + 1;
            }

            user.setPesel(year.toString().substring(2,4) + "" +  tMonth + "" + tDay + "" + random.nextInt(99999));

            user.setWeight(40 + (160 - 40) * random.nextDouble());
            user.setHeight(random.nextInt(150)+90);

            String zipCode = "";
            for(int j=0; j<5; j++)
                zipCode+= +random.nextInt(9);

            user.setZipCode(zipCode);

            String numberBankAccount = "";
            for(int k=0; k<26; k++)
                numberBankAccount+= +random.nextInt(9);

            user.setNumberBankAccount(numberBankAccount);

            String phone = "" + random.nextInt(9)+1;
            for(int l=0; l<9; l++)
                phone += + random.nextInt(9);

            user.setPhone(phone);
            user.setCountry("Polska");

            UserService userService = new UserServiceImpl();
            //System.out.println(user);
            userService.add(user);
        }
    }
}
