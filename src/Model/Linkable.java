package Model;

/**
 * Meant to link the secondary tables to the main Trips table
 * by uploading the secondary table identifier.
 *
 * @author AfricanRiot
 */
public interface Linkable {

    /**
     * This method links this class with the Trips table row generated.
     *
     * So it first gets a random identifier to simulate an
     * assignation, and then it uploads this identifier to the Trip table thus
     * linking these two tables.
     *
     * @param tripTicket This is the identifier of the Trip table's row to link.
     */
    void makeAppointment(int tripTicket);
}

/**
 * To populate a class with the database information.
 *
 * @author AfricanRiot
 */
interface Populable{

    /**
     * This method fills the fields on the class.
     *
     * To populate the class we make a query and then a distribution of the
     * result to the correspondent fields in the class.
     *
     */
    void populate();
}
