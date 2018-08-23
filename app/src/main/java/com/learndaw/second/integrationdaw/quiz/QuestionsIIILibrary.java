package com.learndaw.second.integrationdaw.quiz;

public class QuestionsIIILibrary {
    private String nQuestion[] = {
            "Una cadena de conexion contiene ...",
            "¿La sintaxis depende de?",
            "EntityFramework contiene información que se emplea",
            "Obtiene acceso a los metadatos",
            "Se puede obtener acceso a la cadena de conexión",
            "La conexión de almacena en el archivo de configuración",
            "Recupera la inforación de conexón automatica",
            "Se requiere si no se especifica la palabra Name",
            "Lista delimitada por barras verticales de los directorios",
            "La aplicacion la puede especificar si se desea"
    };
    private String nChoices [] []= {
            {"Secuencia de datos", "Informacion de inicializacion", "Provedor de datos"},
            {"Secuencia de datos", "Informacion de inicializacion", "Provedor de datos"},
            {"EntityFramework","ADO.NET", "EntityClient"},
            {"Entity DataModel", "EntityConnection", "EntityClient"},
            {"EntityConnection","EntityDatamodel", "EntityFramework"},
            {"EntityClient", "EntityConnection", "EntityDatamodel"},
            {"Provider", "Metadata", "Object context"},
            {"Name", "Object context", "Provider"},
            {"Provider", "Metadata", "Name"},
            {"Metadata", "Object context", "Name"},
    };
    private String nCorrectAnswers[] = {
            "Informacion de inicializacion",
            "Provedor de datos",
            "ADO.NET",
            "EntityClient",
            "EntityConnection",
            "Entity DataModel",
            "Object context",
            "Provider",
            "Metadata",
            "Name"
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
