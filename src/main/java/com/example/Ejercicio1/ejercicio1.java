package com.example.Ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ejercicio1 {

    public ejercicio1(){

        String Linea;

        int count = 1;
        int countPosition = 0;
        int lines = 0;

        StringBuilder soutError = new StringBuilder();
        StringBuilder soutRepeted = new StringBuilder();
        StringBuilder soutNull = new StringBuilder();

        List<datosUser> users = new ArrayList<>();
        List<String> list = new ArrayList<>();
        Set<String> setter = new HashSet<>();




        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\tony_\\IdeaProjects\\ProyectoFC_Ejercicio1\\src\\main\\java\\com\\example\\files\\fichero.txt")))
        {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null){

                String[] values = sCurrentLine.split(",");

                if (values[0] == null || values[0].equals("") || values[0].isEmpty()){
                    values[0] = "Null";
                    soutNull.append("Alerta: Hay un error en el primer campo Email. ").append("Ha sido remplazado por el texto 'Null'.").append("En la linea ").append(lines + 1);
                }
                if (values[1] == null || values[1].equals("") || values[1].isEmpty()){
                    values[1] = "Null";
                    soutNull.append("Alerta: Hay un error en el segundo campo Nombre. ").append("Ha sido remplazado por el texto 'Null'.").append("En la linea ").append(lines + 1);
                }
                if (values[2] == null || values[2].equals("") || values[2].isEmpty()){
                    values[2] = "Null";
                    soutNull.append("Alerta: Hay un error en el tercer campo Username. ").append("Ha sido remplazado por el texto 'Null'.").append("En la linea ").append(lines + 1);
                }

                datosUser user = new datosUser(values[0], values[1], values[2]);
                users.add(lines,user);
                lines++;

            }
        } catch (IOException | IndexOutOfBoundsException e){
            e.printStackTrace();
        }

        System.out.println("\n");

        System.out.println("se han procesado un total de " + lines + " lineas \n" +
               "\n"+
                "A continuacion mostraremos el listado de usuarios almacenados correctamente!");

        System.out.println("\n");
            for (datosUser dato : users){
                System.out.println(count + " " + dato);
                count++;
            }

        System.out.println("\n");
        System.out.println("Se ha almacenado una lista de errores las cual se mostraran acontinuacion: \n" +
                soutNull +"\n" );

    }
}

