/**
 *
 *  CITY MANAGER 1.0 June 26, 2017.
 *  Pratical Project by Paradigms and Programming Languages
 *  GCC198 - Federal University of Lavras (UFLA)
 *
 *  @author Lucas Fonseca dos Santos
 *  @author Leticia Ferreira
 */
package gui;

import java.util.Scanner;

import app.Neighborhood;
import app.City;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

public class Gui {

    private Scanner scanner;
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";
    private static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    private static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    private static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    private static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    private static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public Gui() {
        scanner = new Scanner(System.in);
    }

    public static void clear() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
     } 

    public static void pressToContinue() {
        System.out.println("[#] Press any key to continue...");
        try { 
            System.in.read();
        }catch(IOException ex) {
            //The famous try-catch shut up, rs.
        }
    }

    public String callMenu(){
        clear();
        System.out.println("+==================================================+");
        System.out.println("+                                                  +");
        System.out.println("+           CITY MANAGER SYSTEM v1.0               +");
        System.out.println("+                                                  +");
        System.out.println("+==================================================+");
        System.out.println("+                                                  +");
        System.out.println("+ What do you want here?                           +");
        System.out.println("+ [1] Add a new city;                              +");
        System.out.println("+ [2] Remove a city;                               +");
        System.out.println("+ [3] Load all registereds citys;                  +");
        System.out.println("+ [4] Edit a city;                                 +");
        System.out.println("+ [5] Enter a city to manager it;                  +");
        System.out.println("+ [6] Print out;                                   +");
        System.out.println("+                                                  +");
        System.out.println("+ [-99] EXIT                                       +");
        System.out.println("+                                                  +");
        System.out.println("+==================================================+");
        System.out.print("[#] ENTER YOUR OPTION: ");
        try {
            return scanner.nextLine();
        }catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            return "-99";
        }catch (Exception e) {
            e.printStackTrace();
            return "-99";
        }
    }

    public String callCityManager(City city) {
        System.out.println("+--------------------------------------------------+");
        System.out.println(city.getName());
        System.out.println("+--------------------------------------------------+");
        System.out.println("+                                                  +");
        System.out.println("+ What do you want with this city?                 +");
        System.out.println("+ [1] Show city informations;                      +");
        System.out.println("+ [2] Add a new neighborhood;                      +");
        System.out.println("+ [3] Remove a neighborhood;                       +");
        System.out.println("+ [4] Edit a neighborhood;                         +");
        System.out.println("+ [5] Generate statistcs report file               +");
        System.out.println("+                                                  +");
        System.out.println("+ [-99] Back to main menu                          +");
        System.out.println("+                                                  +");
        System.out.println("+--------------------------------------------------+");
        System.out.print("[#] ENTER YOUR OPTION: ");
        try {
            return scanner.nextLine();
        }catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            return "-99";
        }catch (Exception e) {
            e.printStackTrace();
            return "-99";
        }
    }

    /**
     * This method is reponsible for shows informations 
     * to the user to registering a new city 
     * on system data. He can add how many citys the user
     * wants.
     * 
     * @return List<String> New citys registered.
     */
    public List<String> createCityInformations() {
        List<String> informations = new ArrayList<String>();
        String option = "y";
        do {
            clear();
            System.out.println(ANSI_GREEN+"+--------------------------------------------------+"+ANSI_RESET);
            System.out.println(ANSI_GREEN+"+ REGISTER A NEW CITY                              +"+ANSI_RESET);
            System.out.println(ANSI_GREEN+"+--------------------------------------------------+"+ANSI_RESET);
            System.out.println(ANSI_YELLOW+"[!] The neighborhoods will be add after this process;"+ANSI_RESET);
            System.out.print(ANSI_WHITE+"[#] CITY NAME: "+ANSI_RESET);
            informations.add(scanner.nextLine());
            System.out.print(ANSI_WHITE+"[#] STATE/PROVINCE/DISTRICT: "+ANSI_RESET);
            informations.add(scanner.nextLine());
            System.out.print(ANSI_WHITE+"[#] COUNTRY: "+ANSI_RESET);
            informations.add(scanner.nextLine());
            System.out.print(ANSI_WHITE+"[#] CURRENT MAYOR: "+ANSI_RESET);
            informations.add(scanner.nextLine());
            System.out.print(ANSI_WHITE+"[#] DO YOU WANT TO REGISTER A NEW CITY? [Y/n]?"+ANSI_RESET);
            option = scanner.nextLine().toLowerCase();
        }while(option.equals("y"));
        pressToContinue();
        return informations;
    }

    public void showCitiesData(List<City> cities) {
        clear();
        List<Neighborhood> neighborhoodList;
        System.out.println("+--------------------------------------------------+");
        System.out.println("+ REGISTERED CITIES INFORMATIONS                   +");
        System.out.println("+--------------------------------------------------+");
        for(City c : cities) {
            System.out.println("\n+ CITY NAME: " +c.getName());
            System.out.println("+ STATE/DISTRICT: " +c.getDistrict());
            System.out.println("+ COUNTRY: " +c.getCountry());
            System.out.println("+ CURRENT MAYOR: " +c.getMayor());
            System.out.println("+ NEIGHBORHOODS: ");
            neighborhoodList = c.getNeighborhoods();
            if(neighborhoodList != null) {
                for(Neighborhood n : neighborhoodList) {
                    System.out.println(n.toString());
                }
            }
        }
        pressToContinue();
    }

    public void showCitiesData(City c) {
        clear();
        System.out.println("+--------------------------------------------------+");
        System.out.println("+ REGISTERED CITY INFORMATIONS                     +");
        System.out.println("+--------------------------------------------------+");
        
            System.out.println("\n+ CITY NAME: " +c.getName());
            System.out.println("+ STATE/DISTRICT: " +c.getDistrict());
            System.out.println("+ COUNTRY: " +c.getCountry());
            System.out.println("+ CURRENT MAYOR: " +c.getMayor());
            System.out.println("+ DEMOGRAPHIC RATE: " + c.getDemographicRate());
            System.out.println("+ PER CAPTA INCOME RATE: " + c.getPerCaptaIncome());
            System.out.println("+ CRIME RATE: " + c.getCrimeRate());
            System.out.println("+ NEIGHBORHOODS: ");
            List<Neighborhood> neighborhoodList = c.getNeighborhoods();
            if(neighborhoodList != null) {
                for(Neighborhood n : neighborhoodList) {
                    System.out.println(n.toString());
                }
            }
        
        pressToContinue();
    }
    public String captureCity() {
        clear();
        System.out.println("+--------------------------------------------------+");
        System.out.println("+ WELCOME TO THE CITY MANAGER!                     +");
        System.out.println("+--------------------------------------------------+");
        System.out.print("[#] WHAT IS THE CITY NAME: ");
        return scanner.nextLine();
    }

    public List<String> addNewNeighborhoodInformations() {
        clear();
        String option = "y";
        List<String> informations = new ArrayList<String>();
        do {
            System.out.println("+--------------------------------------------------+");
            System.out.println("+ REGISTER A NEW NEIGHBORHOOD                      +");
            System.out.println("+--------------------------------------------------+");
            System.out.println(ANSI_YELLOW+"[!] After that, the statistcs rates will be updated;"+ANSI_RESET);
            System.out.print("[#] NEIGHBORHOOD NAME: ");
            informations.add(scanner.nextLine().toLowerCase());
            System.out.print("[#] DEMOGRAPHIC RATE: ");
            informations.add(scanner.nextLine().toLowerCase());
            System.out.print("[#] PER CAPTA INCOME RATE: ");
            informations.add(scanner.nextLine().toLowerCase());
            System.out.print("[#] CRIME RATE: ");
            informations.add(scanner.nextLine().toLowerCase());
            System.out.print(ANSI_WHITE+"[#] DO YOU WANT TO REGISTER A NEW NEIGHBORHOOD? [Y/n]?"+ANSI_RESET);
            option = scanner.nextLine().toLowerCase();
        } while(option.equals("y"));
        pressToContinue();
        return informations;
    }
}