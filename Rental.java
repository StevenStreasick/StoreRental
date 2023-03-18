
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public abstract class Rental implements Serializable {

    /** What is the purpose of this variable (search google) */
    private static final long serialVersionUID = 1L;

    /** The Name of person that is reserving the Rental*/
    protected String nameOfRenter;

    /** The date the Rental was rented on */
    protected GregorianCalendar rentedOn;

    /** The date the Rental was dueBack on */
    protected GregorianCalendar dueBack;

    /** The actual date the Rental was returned on */
    protected GregorianCalendar actualDateReturned;

    public Rental() {
    }

    public abstract double getCost(GregorianCalendar checkOut);

    public Rental(String nameOfRenter,
                  GregorianCalendar rentedOn,
                  GregorianCalendar dueBack,
                  GregorianCalendar actualDateReturned) {
        this.nameOfRenter = nameOfRenter;
        this.rentedOn = rentedOn;
        this.dueBack = dueBack;
        this.actualDateReturned = actualDateReturned;
    }

    
    /** 
     * @return String
     */
    public String getNameOfRenter() {
        return nameOfRenter;
    }

    
    /** 
     * @param nameOfRenter
     */
    public void setNameOfRenter(String nameOfRenter) {
        this.nameOfRenter = nameOfRenter;
    }

    
    /** 
     * @return GregorianCalendar
     */
    public GregorianCalendar getRentedOn() {
        return rentedOn;
    }

    
    /** 
     * @param rentedOn
     */
    public void setRentedOn(GregorianCalendar rentedOn) {
        this.rentedOn = rentedOn;
    }

    
    /** 
     * @return GregorianCalendar
     */
    public GregorianCalendar getActualDateReturned() {
        return actualDateReturned;
    }

    
    /** 
     * @param actualDateReturned
     */
    public void setActualDateReturned(GregorianCalendar actualDateReturned) {
        this.actualDateReturned = actualDateReturned;
    }

    
   
    
    /** 
     * @return GregorianCalendar
     */
    public GregorianCalendar getDueBack() {
        return dueBack;
    }

    
    /** 
     * @param dueBack
     */
    public void setDueBack(GregorianCalendar dueBack) {
        this.dueBack = dueBack;
    }

    
    /** 
     * @return String
     */
    // following code used for debugging only
    @Override
    public String toString() {
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        String rentedOnStr;
        if (getRentedOn() == null)
            rentedOnStr = "";
        else
            rentedOnStr = formatter.format(getRentedOn().getTime());

        String estdueBackStr;
        if (getDueBack() == null)
            estdueBackStr = "";
        else
            estdueBackStr = formatter.format(getDueBack().getTime());

        String acutaulDateReturnedStr;
        if (getActualDateReturned() == null)
            acutaulDateReturnedStr = "";
        else
            acutaulDateReturnedStr = formatter.format(getActualDateReturned().getTime());

        return "RentUnit{" +
                "guestName='" + nameOfRenter + ' ' +
                ", rentedOn =" + rentedOnStr +
                ", dueBack =" + estdueBackStr +
                ", actualDateReturned =" + acutaulDateReturnedStr +
                '}';
    }
}
