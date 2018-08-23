package com.learndaw.second.integrationdaw.quiz;

public class QuestionsIVLibrary {

    private String nQuestion[] = {
            "La aplicación esta divida en unidades logicas",
            "Se encarga de mostrar la interfaz de el usuario",
            "Es el servicio de aplicaciones",
            "Tienen instalado el motor de base de datos ",
            "La aplicación puede acceder al mismo servidor ",
            "La aplicación consumen menos procesador y menos memoria",
            "Se alcanza mediante la ejecución de diversos procesos",
            "son utilizados por cierto numero de usuarios",
            "En muchos casos es necesario tener en cuenta ",
            "Esta a la escucha en una red de una forma u otra"
    };
    private String nChoices [] []= {
            {"Red local", "Aplicacion al cliente", "Aplicacion multicapa"},
            {"Red local", "Aplicacion al cliente", "Aplicacion multicapa"},
            {"Red local", "Aplicacion al cliente", "Aplicacion multicapa"},
            {"Red local", "Aplicacion al cliente", "Aplicacion multicapa"},
            {"Encapsulamiento","Red local", "Concurrencia"},
            {"Clientes pequeños","Encapsulamiento", "Seguridad"},
            {"Encapsulamiento","Aplicacion distribuida", "Concurrencia"},
            {"Encapsulamiento","Seguridad", "Concurrencia"},
            {"El encapsulamiento", "El tipo de red", "Seguridad"},
            {"El encapsulamiento", "El tipo de red", "Seguridad"},
    };
    private String nCorrectAnswers[] = {
            "Aplicacion multicapa",
            "Aplicacion al cliente",
            "Red local",
            "Aplicacion al cliente",
            "Encapsulmiento",
            "Clientes pequños",
            "Aplicacion distribuidas",
            "Concurrencia",
            "El tipo de red",
            "Seguridad"
    };
    public String getQuestion(int a) {
        String question = nQuestion [a];
        return question;
    }
    public String getChoices1(int a) {
        String choice0 = nChoices [a] [0];
        return choice0;
    }
    public String getChoices2(int a) {
        String choice1 = nChoices [a] [1];
        return choice1;

    }
    public String getChoices3(int a) {
        String choice2 = nChoices [a] [2];
        return choice2;
    }
    public String getCorrectAnswer(int a){
        String answer = nCorrectAnswers[a];
        return answer;
    }
}
