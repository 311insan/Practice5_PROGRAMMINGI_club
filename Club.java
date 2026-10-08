import java.util.ArrayList;
import java.util.Iterator;
/**
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version 7.0
 */
public class Club
{
    // Define any necessary fields here ...
    private ArrayList<Membership> clubMembers;
    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        // Initialise any fields here ...
        clubMembers = new ArrayList<>();
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
        clubMembers.add(member);
    }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        return clubMembers.size();
    }
    /**
    * Determine the number of members who joined in the
    * given month.
    * @param month The month we are interested in.
    * @return The number of members who joined in that month.
    */
    public int joinedInMonth(int month){
        int joinedInMonth = 0;
        for (Membership member : clubMembers){
            if (member.getMonth() == month){
                joinedInMonth++;
            }
        }
        return joinedInMonth;
    }
    
    /**
    * Remove from the club's collection all members who
    * joined in the given month, and return them stored
    * in a separate collection object.
    * @param month The month of the membership.
    * @param year The year of the membership.
    * @return The members who joined in the given month and year.
    */
    public ArrayList<Membership> purge(int month, int year){
        ArrayList<Membership> purged = new ArrayList<>();
        Iterator<Membership> i = clubMembers.iterator();
        int currentYear = 2026; //assumed currentYear
        int currentMonth = 10; //assumed currentMonth
        if ((month > 0 || month <= 12) && year < currentYear && month < currentMonth){
            while(i.hasNext()){
                Membership member = i.next();
                if(month == member.getMonth() && year == member.getYear()){
                    purged.add(member);
                    i.remove();
                }
            }
            return purged;
        } else if (year > currentYear && month <= currentMonth){
            System.out.println("INVALID YEAR");
            return null;
        } else if (month > currentMonth && year <= currentYear) {
            System.out.println("INVALID MONTH");
            return null;
        } else {
            System.out.println("INVALID YEAR AND MONTH");
            return null;
        }
    }
}
