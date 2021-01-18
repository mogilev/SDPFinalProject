package app.views;

import app.controllers.Warehouse;
import app.controllers.WarehouseClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet("/deposit")
    public class DepositServlet extends HttpServlet {
        Warehouse warehouse = new WarehouseClass();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            warehouse.jSonSingleOutputSender(resp, "erro", "opção indisponível");
        }


        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            Warehouse warehouse = new WarehouseClass();
            String pathInfo = req.getParameter("itemId");
            pathInfo.toLowerCase();
            String value = req.getParameter("quantity");
            commandCreateDeposit(warehouse, resp, pathInfo, value);
        }


        @Override
        protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            warehouse.jSonSingleOutputSender(resp, "erro", "opção indisponível");
        }


        @Override
        protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            warehouse.jSonSingleOutputSender(resp, "erro", "opção indisponível");
        }


        public static boolean isInteger(String str) {
            str = str.substring(1);
            try {
                Integer.parseInt(str);
                return true;
            }
            catch (NumberFormatException e) {
                return false;
            }
        }


        public void commandCreateDeposit(Warehouse warehouse, HttpServletResponse resp, String id, String value) {

            if (isInteger(id)) {
                id = id.substring(1);
                int itemId = Integer.parseInt(id);
                value = value.substring(1);
                int quantity = Integer.parseInt(value);
                warehouse.createDeposit(warehouse, resp, itemId, quantity);
            }
            else {
                warehouse.jSonSingleOutputSender(resp, "erro", "opção indisponível");
            }
        }

    }
