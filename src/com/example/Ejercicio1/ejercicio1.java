package com.example.Ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ejercicio1 {

    public ejercicio1(){
        String Linea;
        ArrayList<String> guardar_fichero = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\tony_\\IdeaProjects\\ProyectoFC_Ejercicio1\\src\\com\\example\\files\\fichero.txt")))
        {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null){
                guardar_fichero.add(sCurrentLine);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        //System.out.print(guardar_fichero);
        for (int j = 0; j < guardar_fichero.size(); j++){
            Linea = guardar_fichero.get(j);
            System.out.print(Linea + "\n");
        }
        System.out.println("EL elementos 1 es: " + guardar_fichero.get(0));
    }
}

