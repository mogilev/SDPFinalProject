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
 * Responsible for accepting the delivery requests
 * requests must be sent to "/delivery"
 */
@WebServlet("/delivery")
public class DeliveryServlet extends HttpServlet {
    Warehouse warehouse = new WarehouseClass();

    /**
     * Responsible for receiving http request to get the all the deliveries(in json format)
     *
     * NOT implemented
     *
     * @param req HttpServletRequest type used to receive http requests
     * @param resp HttpServletResponse type used to send http response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        warehouse.jSonSingleOutputSender(resp,"request","not implemented");
    }

    /**
     * Responsible for receiving http request for creating a new delivery
     *
     * NOT implemented
     *
     * @param req HttpServletRequest type used to receive http requests
     * @param resp HttpServletResponse type used to send http response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        warehouse.jSonSingleOutputSender(resp,"request","not implemented");

    }

    /**
     * Responsible for receiving http request for changing a specific delivery's place
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
        warehouse.jSonSingleOutputSender(resp,"request","not implemented");
    }

    /**
     * Responsible for receiving http request for deleting a specific delivery's place
     *
     * NOT available
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

}
