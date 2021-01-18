package app.views;

import app.controllers.Warehouse;
import app.controllers.WarehouseClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Responsible for accepting the deposit requests
 * requests must be sent to "/deposit"
 */
@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {
    Warehouse warehouse = new WarehouseClass();

    /**
     *  Responsible for receiving http request for get all deposits tracked
     *
     * @param req HttpServletRequest type used to receive http requests
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        warehouse.jSonSingleOutputSender(resp, "erro", "opção indisponível");
        }

    /**
     * Responsible for receiving http request for creating a new deposit
     *
     * @param req HttpServletRequest type used to receive http requests
     * @param resp HttpServletResponse type used to send http response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Warehouse warehouse = new WarehouseClass();
        String pathInfo = req.getParameter("itemId");
        pathInfo.toLowerCase();
        String value = req.getParameter("quantity");
        commandCreateDeposit(warehouse, resp, pathInfo, value);
        }

    /**
     * Responsible for receiving http request for changing a deposit's parameter
     *
     * NOT implemented
     *
     * @param req HttpServletRequest type used to receive http requests
     * @param resp HttpServletResponse type used to send http response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            warehouse.jSonSingleOutputSender(resp, "erro", "opção indisponível");
        }

    /**
     *
     *
     * @param req HttpServletRequest type used to receive http requests
     * @param resp HttpServletResponse type used to send http response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        warehouse.jSonSingleOutputSender(resp, "erro", "opção indisponível");
        }

    /**
     * Checks if pathinfo has an integer/id
     *
     * @param str pathinfo URL
     * @return true if param is
     */
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

    /**
     * Requests creation of a new deposit
     *
     * @param warehouse responsible for applying project's business rules
     * @param resp HttpServletResponse type used to send http response
     * @param id of the item that'll receive the deposit
     * @param value to be deposited
     */
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
