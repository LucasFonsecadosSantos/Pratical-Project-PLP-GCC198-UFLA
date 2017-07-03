/**
 *
 *  CITY MANAGER 1.0 June 26, 2017.
 *  Pratical Project by Paradigms and Programming Languages
 *  GCC198 - Federal University of Lavras (UFLA)
 *
 *  @author Lucas Fonseca dos Santos
 *  @author Leticia Ferreira
 */
package util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import app.City;
import app.Neighborhood;
import java.io.Serializable;

/**
 * This class describes the data object. It is responsible
 * for the access to secondary memory. It reads and writes in
 * binary files data.
 * The serializable interface was implemented here.
 */
public class Data implements Serializable {
    
    /**
     * Successfully message string attribute.
     */
    private final String successfullyMessage;

    /**
     * Data object constructor. He attributes a state to
     * successfully message attribute.
     */
    public Data() {
        successfullyMessage = "[!] SUCCESSFULLY OPERATION!";
    }

    /**
     * This method loads all data binary files presents in cities/
     * directory. He returns a List<String> java data structure
     * with all files name.
     * 
     * @return List<String> Java list with all files name.
     */
    public List<String> loadDisponibleCities() {
            File[] citiesData = new File("./data/cities").listFiles();
            if(citiesData != null) {
                List<String> citiesNames = new ArrayList<String>();
                for(File f : citiesData) {
                    if(f.isFile()) {
                        citiesNames.add(f.getName());
                    }
                }
                return citiesNames;
            }else {
                return null;
            }
    }

    /**
     * This method sotres a city record in the data binary
     * file, located in the cities/ directory.
     * 
     * @param cityList Java list data structure with cities object to be stored.
     * @return String Successfully message about the operation.
     */
    public String storeCityData(List<City> citiesList) {
        for(City c : citiesList) {
            try {
                File file = new File("./data/cities/"+c.getName()+".bin");
                if(!new File("./data/cities").exists()) {
                    new File("./data/cities").mkdirs();
                }
                if(!file.exists()) {
                    file.createNewFile();
                }   
                ObjectOutputStream object = new ObjectOutputStream(new FileOutputStream("./data/cities/" + c.getName() + ".bin", true));
                object.writeObject(c);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        return successfullyMessage;    
    }

    /**
     * This method sotres a city record in the data binary
     * file, located in the cities/ directory.
     * 
     * @param cityList Java list data structure with cities object to be stored.
     * @return String Successfully message about the operation.
     */
    public String storeCityData(City city) {
        try {
            File file = new File("./data/cities/"+city.getName()+".bin");
            if(!new File("./data/cities").exists()) {
                new File("./data/cities").mkdirs();
            }
            if(!file.exists()) {
                file.createNewFile();
            }   
            ObjectOutputStream object = new ObjectOutputStream(new FileOutputStream("./data/cities/" + city.getName() + ".bin", true));
            object.writeObject(city);
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return successfullyMessage;    
    }

    /**
     * This method is responsible for load a city data stored in
     * binary data file. He returns a java list data structure with
     * all cities loaded.
     * 
     * @return List<City> Java list data structure with all cities loaded.
     */
    public List<City> loadCities() {
        try {
            File directory = new File("./data/cities");
            if(!directory.exists()) {
                return null;
            }else {
                File[] cities = directory.listFiles();
                List<City> loadedCities = new ArrayList<City>();
                for(File f : cities) {
                    ObjectInputStream objectS = new ObjectInputStream(new FileInputStream(f));
                    City c = (City) objectS.readObject();
                    loadedCities.add(c);
                    objectS.close();
                }
                return loadedCities;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteAllFiles() {
        try {
            File[] files = new File("./data/cities").listFiles();
            for(File f : files) {
                f.delete();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
} 