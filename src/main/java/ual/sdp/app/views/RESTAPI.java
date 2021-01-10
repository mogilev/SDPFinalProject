package ual.sdp.app.views;

import ual.sdp.app.models.Data;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api")
public class RESTAPI extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        Data data = new Data("code", 42.0);

        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
        jsonBuilder.add("name", data.getName());
        jsonBuilder.add("value", data.getValue());

        JsonWriter jsonWriter = Json.createWriter(resp.getWriter());
        jsonWriter.writeObject(jsonBuilder.build());
        jsonWriter.close();
    }
}

