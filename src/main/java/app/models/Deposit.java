package app.models;

public interface Deposit {

    /**
     * Método que mostra o ID do depósito.
     * @return
     */
    int getId();

    /**
     * Método que mostra o ID do Item no depósito.
     * @return
     */
    Item getItem();

    /**
     * Método que mostra a quantidade do Item depositado.
     * @return
     */
    int getQuantity();
}
