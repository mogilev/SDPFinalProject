package app.views;

import app.controllers.Warehouse;
import app.controllers.WarehouseClass;
import app.models.Data;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet("/deposit/*")
    public class DepositServlet extends HttpServlet {

        Warehouse warehouse = new WarehouseClass();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("application/json"); // TODO: 1/11/2021

            String urInfo = req.getRequestURI();
            String contextPath = req.getContextPath();
            String servletPath = req.getServletPath();
            String pathInfo = req.getPathInfo();

            JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
            jsonBuilder.add("urInfo", urInfo);
            jsonBuilder.add("contextPath", contextPath);
            jsonBuilder.add("servletPath", servletPath);
            jsonBuilder.add("pathInfo", pathInfo);

            JsonWriter jsonWriter = Json.createWriter(resp.getWriter());
            jsonWriter.writeObject(jsonBuilder.build());
            jsonWriter.close();

/*            Data data = new Data("doGet", 42.0);

            JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
            jsonBuilder.add("name", data.getName());
            jsonBuilder.add("value", data.getValue());

            JsonWriter jsonWriter = Json.createWriter(resp.getWriter());
            jsonWriter.writeObject(jsonBuilder.build());
            jsonWriter.close();*/
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("application/json"); // TODO

            Data data = new Data("doPost", 42.0);

            JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
            jsonBuilder.add("name", data.getName());
            jsonBuilder.add("value", data.getValue());

            JsonWriter jsonWriter = Json.createWriter(resp.getWriter());
            jsonWriter.writeObject(jsonBuilder.build());
            jsonWriter.close();
        }

        @Override
        protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("application/json");  // TODO

            Data data = new Data("doPut", 42.0);

            JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
            jsonBuilder.add("name", data.getName());
            jsonBuilder.add("value", data.getValue());

            JsonWriter jsonWriter = Json.createWriter(resp.getWriter());
            jsonWriter.writeObject(jsonBuilder.build());
            jsonWriter.close();
        }

        @Override
        protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("application/json"); // TODO

            Data data = new Data("doDelete", 42.0);

            JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
            jsonBuilder.add("name", data.getName());
            jsonBuilder.add("value", data.getValue());

            JsonWriter jsonWriter = Json.createWriter(resp.getWriter());
            jsonWriter.writeObject(jsonBuilder.build());
            jsonWriter.close();
        }
    }
