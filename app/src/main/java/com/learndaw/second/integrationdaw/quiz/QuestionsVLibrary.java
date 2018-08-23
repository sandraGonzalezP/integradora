package com.learndaw.second.integrationdaw.quiz;

public class QuestionsVLibrary {
    private String nQuestion[] = {
            "Termino general para el tipo de ataques",
            "Explota el manejo de información no confiable",
            "Esta limitado por funcionalidades del lenguaje",
            "Pasa un parametro enviendo una petición",
            "Podria intentar ejecutar un codigo diferente",
            "Pasa los datos no verificados",
            "La inyeccion de código puede ser posible",
            "Tipo de ataques que tratan de inyectar codigo",
            "Se pude inyectar código en",
            "_______ es facil de encontrar entre todos"
    };
    private String nChoices [] []= {
            {"Caracteres permitidos", "Command injection", "Code injection"},
            {"Caracteres permitidos", "Command injection", "Code injection"},
            {"Code injection", "Caracteres permitidos", "Command injection"},
            {"Include ", "GET", "Eval"},
            {"Eval", "GET", "Include"},
            {"Eval", "Include", "GET"},
            {"Verificacion de datos", "Se usa PHP", "Se usa un interpretador"},
            {"Interpretado y ejecutado", "Informacion no confiable", "PHP"},
            {"Un interpretador", "La vulnerabilidad", "En PHP"},
            {"PHP", "Interpretacion", "Vulnerabilidad"}
    };
    private String nCorrectAnswers[] = {
            "Code injection",
            "Caracteres permitidos",
            "Command injection",
            "GET",
            "Include",
            "Eval",
            "Verificacion de datos",
            "Interpreatdo y ejecutado",
            "En PHP",
            "Vulnerabilidad"
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
