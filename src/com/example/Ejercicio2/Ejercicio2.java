package com.example.Ejercicio2;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

public class Ejercicio2 {

   static String emailUnico = "antonyrebolledo@gmail.com";
   static String password = "12345";
   static String passwordencrypt = md5(password);
   static ArrayList<String> Users = new ArrayList<>();
    public static void main(String[] args) {

        register("antonymatus@gmail.com","2355");

        login("rebolledo@gmail.com","12345");
    }


    public static boolean register(String email, String password){

        Users.add(emailUnico);
        Users.add(passwordencrypt);

        boolean respuesta = true;
        for (int i = 0; i < Users.size(); i++){
            if (email == Users.get(i)){
                respuesta = false;
                break;
            } else{
                Users.add(email);
                Users.add(md5(password));
               respuesta = true;
               break;
            }
        }

        return respuesta;

    }

    public static int login(String email, String password){
       int respuesta = 0;
       int respuesta2 = 0;
       String encryptpass = md5(password);
       for (int i = 0; i < Users.size(); i++){
           if (email == Users.get(i) ){

               if (Users.contains(encryptpass)){
                    respuesta2 = 1;
               } else {
                    respuesta2 = -2;
               }

               respuesta = respuesta2;
               break;
           }else if(email != Users.get(i)){
              respuesta = -1;
           }
       }


        System.out.println(respuesta);
        return  respuesta;
    }


    public static String md5(String txt){
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(txt.getBytes());
            String pdw = new BigInteger(1,md.digest()).toString(16);
            System.err.println(pdw);
            return pdw;

        } catch (Exception e){
            e.printStackTrace();
        }
        return txt;
}


}
