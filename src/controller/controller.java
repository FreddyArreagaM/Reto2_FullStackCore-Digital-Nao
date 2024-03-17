package controller;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;
import model.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class controller {

    //Definición de variables para manejo de datos para parámetros de conexión a MySQL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/google_search_api";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Neo04092016@@";
    private static final int maxResultados = 3;

    public void fetchScholarData(String apiKey, String searchQuery, DefaultTableModel tableModel) throws IOException, InterruptedException {

        //Creación de instancia de la clase HttpCliente
        HttpClient client = HttpClient.newHttpClient();

        //Creación de instancia request de la clase HttpRequest para petición a la API
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://serpapi.com/search.json?engine=google_scholar&q=" + searchQuery + "&key=" + apiKey))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println(response.body());

            //Mapear consulta del JSON
                JSONObject jsonResponse = new JSONObject(response.body());
                // Obtener el objeto organic_results
                JSONArray organicResults = jsonResponse.getJSONArray("organic_results");

                // Creacion de lista según los datos del modelo
                List<model> resultsList = new ArrayList<>();

                // Recorrer el array y obtener los títulos
                for (int i = 0; i < maxResultados; i++) {
                    JSONObject result = organicResults.getJSONObject(i);
                    String title = result.getString("title");

                    //Definición de la clave mayor publication_info para obtener el nombre de el/los autor/autores
                    JSONObject publicationInfo = result.getJSONObject("publication_info");

                    String authorsString;
                    
                    //Validación en caso de tener nombre de autor o no.
                    if (publicationInfo.has("authors")) {
                        JSONArray authorsArray = publicationInfo.getJSONArray("authors");    
                        StringBuilder authors = new StringBuilder();

                        //Recorremos el array para obtener el valor de los autores de cada resultado
                        for (int j = 0; j < authorsArray.length(); j++) {
                            JSONObject authorObj = authorsArray.getJSONObject(j);
                            String name = authorObj.getString("name");

                            authors.append(name).append(", ");
                        }

                        authorsString = authors.substring(0, authors.length() - 2);
                    }
                    
                    //Caso contrario de no contar con esa clave en el JSON se define el autor como desconocido.
                    else {
                        authorsString = "Desconocido";
                    }

                    //Obtención del resumen de cada publicación 
                    String summary = publicationInfo.getString("summary");
                    
                    //Instanciamos un objeto de tipo model para agregar bajo su estructura los datos en un Array local.
                    model newModel = new model(title, authorsString, summary);
                    resultsList.add(newModel);
                }

                //Presentación por consola de los top 10 en resultados obtenidos por el API
                for (model result : resultsList) {
                    System.out.println("====================================");
                    System.out.println("Title: " + result.getTitulo());
                    System.out.println("Author(s): " + result.getAutor());
                    System.out.println("Summary: " + result.getResumen());
                    System.out.println("====================================");
                }

                this.connectionMySQL(resultsList, tableModel);
                
             
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void connectionMySQL(List<model> resultsList, DefaultTableModel tableModel) throws IOException, InterruptedException {
        // Conexión a la base de datos
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Creación de sentencia para insertar datos en MySQL
            String sql = "INSERT INTO datos (titulo, autor, resumen) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(sql);

            // Insersión de datos del resultado de la Lista creada localmente
            for (model result : resultsList) {
                statement.setString(1, result.getTitulo());
                statement.setString(2, result.getAutor());
                statement.setString(3, result.getResumen());
                statement.executeUpdate();

                // Agregamos esos datos a la tabla
                tableModel.addRow(new Object[]{result.getTitulo(), result.getAutor(), result.getResumen()});
            }

            System.out.println("Datos guardados exitosamente!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cierre de conexión
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}