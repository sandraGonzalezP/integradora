package com.learndaw.second.integrationdaw.quiz;

public class QuestionsIILibrary {

    private String nQuestion[] = {
            "Se define para tratar la comunicación de información",
            "Fluye entre una fuente y un destino",
            "Implementa la entrada estandar",
            "Implemanta la salidad estandar",
            "Implemanta la salida por error",
            "Método que permite número n de bytes disponobles",
            "Método que vacia el buffer de salida",
            "Implementa lo que se denomina serialización de objetos",
            "Permite filtrar datos mientras se escriben o leen",
            "Pueden utilizar un DataInputStream"
    };
    private String nChoices [] []= {
            {"Implementacion de salida", "Secuencia de datos", "Abtraccion de stream"},
            {"Implementacion de salida", "Secuencia de datos", "Abtraccion de stream"},
            {"System.out", "System.in", "System.err"},
            {"System.in", "System.out", "System.err"},
            {"System.err", "System.out", "System.in"},
            {"Skip()", "Available()", "Read()"},
            {"Flush()", "Println()", "Print()"},
            {"Datos primitivos", "Filter streams", "File stream"},
            {"File stream", "Filter streams", "Datos primitivos"},
            {"Filter streams", "Datos primitivos", "File stream"},
    };
    private String nCorrectAnswers[] = {
            "Abtraccion de stream",
            "Secuencia de datos",
            "System.in",
            "System.out",
            "System.err",
            "Avaliable()",
            "Flush()",
            "Files stream",
            "Filter streams",
            "Datos primitivos"
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
