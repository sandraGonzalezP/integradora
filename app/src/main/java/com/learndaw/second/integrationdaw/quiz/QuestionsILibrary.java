package com.learndaw.second.integrationdaw.quiz;



public class QuestionsILibrary {
    private String nQuestion[] = {
            "¿Que son los patrones de diseño?",
            "¿Para que son utiles los patrones de diseño?",
            "Son los que facilitan la tarea de creacion de nuevos objetos",
            "Son patrones que nos facilitan la modelizacion de muestro software",
            "Se usan para gestionar algoritmos, relaciones y responsabilidades" +
                    " entre objetos",
            "Encapsulan el conocimiento acerca de los tipos concretos que "+" nuestro sistema utiliza",
            "Ocultan implementacioones necesitadas a ser creadas",
            "Los patrones creacionales más conocidos son:",
            "Los patrones estructurales más conocidos son:",
            "Los patrones comportamiento más conocidos son:"
    };
    private String nChoices [] [] = {
            {"Soluciones que damos a los problemas recurrentes","Es un lenguaje comun","Para el ahorro de tiempo"},
            {"Soluciones que damos a los problemas recurrentes","Es un lenguaje comun","Para el ahorro de tiempo"},
            {"Los patrones estructurales", "Los patrones creacionales", "Los patrones de comportamiento"},
            {"Los patrones de comportamiento","Los patrones estructurales","Los patrones creacionales"},
            {"Los patrones creacionales", "Los patrones estructurales", "Los patrones de comportamiento"},
            {"Los patrones de comportamiento","Los patrones estructurales","Los patrones creacionales"},
            {"Los patrones creacionales", "Los patrones estructurales", "Los patrones de comportamiento"},
            {"Factory Method, prototype", "Adapter, bridge,", "Visitor, observer"},
            {"Singleton, Abtract factory","Composite, Decorator", "Command, state"},
            {"Builder, prototype", "Proxy, facade", "Strategy, iterator"}
    };
    private String nCorrectAnswers[] = {
            "Soluciones que damos a los problemas recurrentes",
            "Para el ahorro de tiempo",
            "Los patrones creacionales",
            "Los patrones estructurales",
            "Los patrones de comportamiento",
            "Los patrones creacionales",
            "Los patrones creacionales",
            "Factory Method, prototype",
            "Composite, Decorator",
            "Strategy, iterator"
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