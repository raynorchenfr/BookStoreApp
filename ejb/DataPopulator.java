/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.Administrator;
import domain.Author;
import domain.Biography;
import domain.Book;
import domain.Customer;
import domain.Ideology;
import domain.KMGR;
import domain.PoliticalSpectrum;
import domain.security.Group;
import domain.security.User;
import ejb.security.GroupBean;
import ejb.security.UserBean;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tianyang
 */
@Singleton
@Startup
public class DataPopulator {
    
    @PersistenceContext(unitName = "rchen30_FP_PU")
    private EntityManager em;
    @EJB
    private UserBean userbean;
    @EJB
    private GroupBean groupbean;
    @EJB
    private AuthorBean authorbean;
    @EJB
    private BookBean bookbean;
    @EJB
    private IdeologyBean ideobean;
    @EJB
    private PoliticalSpectrumBean psbean;
    @EJB
    private AdministratorBean adminbean;
    @EJB
    private KMGRBean kmgrbean;
    @EJB
    private CustomerBean customerbean;
    private static final Logger LOG = Logger.getLogger(DataPopulator.class.getName());
    
    
    @PostConstruct
    public void populateDatabase(){
        
        Group admingroup = new Group("Administrators","Administrator group");
        Group kmgrgroup = new Group("KMGRs","Knowledge Manager group");
        Group customergroup = new Group("Customers","Customer group");
        
        User adminuser = new User("Administrator","password123");
        adminuser.addGroup(admingroup);
        User kmgruser1 = new User("KMGR1","kmgr011");
        kmgruser1.addGroup(kmgrgroup);
        User kmgruser2 = new User("KMGR2","kmgr001");
        kmgruser2.addGroup(kmgrgroup);
        User customeruser1 = new User("Customer1","reader101");
        customeruser1.addGroup(customergroup);
        User customeruser2 = new User("Customer2","reader202");
        customeruser2.addGroup(customergroup);
        User customeruser3 = new User("Customer3","reader303");
        customeruser3.addGroup(customergroup);

        groupbean.create(admingroup);
        groupbean.create(kmgrgroup);
        groupbean.create(customergroup);
        
        userbean.create(adminuser);
        userbean.create(kmgruser1);
        userbean.create(kmgruser2);
        userbean.create(customeruser1);
        userbean.create(customeruser2);
        userbean.create(customeruser3);

        //book and other knowledge field information
        
        Author Hayek = new Author("Hayek");
        Book RTS = new Book("The Road to Serfdom");
        Ideology Libertarianism = new Ideology("Libertarianism");
        PoliticalSpectrum PS1 = new PoliticalSpectrum("Right-Wing");
        Biography HayekBio = new Biography("This is F.A. Hayek's Biography");
        //Generate basic entities first
        List<Author> authorList1 = new ArrayList<Author>();
        authorList1.add(Hayek);
        List<Book> bookList1 = new ArrayList<Book>();
        bookList1.add(RTS);
        List<String> HBEntry = new ArrayList<String>();
        String HEntry1 = "Friedrich Hayek is an Austrian philosopher ";
        String HEntry2 = "and economist who supports free market.";
        HBEntry.add(HEntry1);
        HBEntry.add(HEntry2);
        // Generate short lists for different entities
        HayekBio.setBioEntries(HBEntry);
        Hayek.setBooks(bookList1);
        Hayek.setIdeology(Libertarianism);
        Hayek.setBiography(HayekBio);
        //set author attributes
        RTS.setAuthors(authorList1);
        RTS.setIdeology(Libertarianism);
        RTS.setISBN("0226320553");
        //set book attributes
        Libertarianism.setBook(bookList1);
        Libertarianism.setAuthor(authorList1);
        //set ideology attributes
        PS1.setIdeology(Libertarianism);
        //set political spectrum attributes
        
        
        //Another book
        Author Kant = new Author("Immanuel Kant");
        Book GMM = new Book("Groundwork for the Metaphysics of Morals");
        Ideology Kantianism = new Ideology("Kantianism");
        PoliticalSpectrum PS2 = new PoliticalSpectrum("Political Liberalism");
        Biography KantBio = new Biography("This is Immanuel Kant's Biography");
        //Generate basic entities first
        List<Author> authorList2 = new ArrayList<Author>();
        authorList2.add(Kant);
        List<Book> bookList2 = new ArrayList<Book>();
        bookList2.add(GMM);
        List<String> KBEntry = new ArrayList<String>();
        String KEntry1 = "Immanuel Kant is a German philosopher ";
        String KEntry2 = "who played an important role";
        String KEntry3 = "in modern philosophy.";
        KBEntry.add(KEntry1);
        KBEntry.add(KEntry2);
        KBEntry.add(KEntry3);
        // Generate short lists
        KantBio.setBioEntries(KBEntry);
        Kant.setBooks(bookList2);
        Kant.setIdeology(Kantianism);
        Kant.setBiography(KantBio);
        //set author attributes
        GMM.setAuthors(authorList2);
        GMM.setIdeology(Kantianism);
        GMM.setISBN("087220166X");
        //set book attributes
        Kantianism.setBook(bookList2);
        Kantianism.setAuthor(authorList2);
        //set ideology attributes
        PS2.setIdeology(Kantianism);
        
        //the book to be removed in a simple way
        Author Marx = new Author("Karl Marx");
        Book Capital = new Book("Capital");
        Ideology Marxism = new Ideology("Marxism");
        PoliticalSpectrum PS3 = new PoliticalSpectrum("Left Wing");
        Biography MarxBio = new Biography("This is Karl Marx's Biography");
        //Generate basic entities first
        List<Author> authorList3 = new ArrayList<Author>();
        authorList3.add(Marx);
        List<Book> bookList3 = new ArrayList<Book>();
        bookList3.add(Capital);
        List<String> MBEntry = new ArrayList<String>();
        String MEntry1 = "Karl Marx is a German philosopher ";
        String MEntry2 = "who played an important role";
        String MEntry3 = "in modern communism.";
        MBEntry.add(MEntry1);
        MBEntry.add(MEntry2);
        MBEntry.add(MEntry3);
        // Generate short lists
        MarxBio.setBioEntries(MBEntry);
        Marx.setBooks(bookList3);
        Marx.setIdeology(Marxism);
        Marx.setBiography(MarxBio);
        //set author attributes
        Capital.setAuthors(authorList3);
        Capital.setIdeology(Marxism);
        Capital.setISBN("978-0199535705");
        //set book attributes
        Marxism.setBook(bookList3);
        Marxism.setAuthor(authorList3);
        //set ideology attributes
        PS2.setIdeology(Marxism);
        
        authorbean.create(Hayek);
        authorbean.create(Marx);
        authorbean.create(Kant);
        
        bookbean.create(RTS);
        bookbean.create(GMM);
        bookbean.create(Capital);
        
        ideobean.create(Libertarianism);
        ideobean.create(Kantianism);
        ideobean.create(Marxism);
        
        psbean.create(PS3);
        psbean.create(PS2);
        psbean.create(PS1);
        
        
        Administrator admin1 = new Administrator("William Sanderson");
        KMGR kmgr1 = new KMGR("Carl Lou");
        KMGR kmgr2 = new KMGR("Karren Takanawa");
        Customer customer1 = new Customer("bookreader010");
        Customer customer2 = new Customer("bookreader011");
        Customer customer3 = new Customer("AlienReAdEr");
        
        List<KMGR> kmgrlist = new ArrayList<KMGR>();
        List<Author> authorlist1 = new ArrayList<Author>();
        List<Author> authorlist2 = new ArrayList<Author>();
        List<Book> booklist1 = new ArrayList<Book>();
        List<Book> booklist2 = new ArrayList<Book>();
        List<Book> cartlist1 = new ArrayList<Book>();
        List<Book> cartlist2 = new ArrayList<Book>();
        List<Book> cartlist3 = new ArrayList<Book>();
        List<Ideology> ideolist1 = new ArrayList<Ideology>();
        List<Ideology> ideolist2 = new ArrayList<Ideology>();
        List<PoliticalSpectrum> pslist1 = new ArrayList<PoliticalSpectrum>();
        List<PoliticalSpectrum> pslist2 = new ArrayList<PoliticalSpectrum>();

        admin1.setUser(adminuser);
        admin1.setKMGRs(kmgrlist);
        
        kmgr1.setUser(kmgruser1);
        kmgr1.setManagedAuthors(authorlist1);
        kmgr1.setManagedBooks(booklist1);
        kmgr1.setManagedIdeos(ideolist1);
        kmgr1.setManagedPSs(pslist1);
        
        kmgr2.setUser(kmgruser2);
        kmgr2.setManagedAuthors(authorlist2);
        kmgr2.setManagedBooks(booklist2);
        kmgr2.setManagedIdeos(ideolist2);
        kmgr2.setManagedPSs(pslist2);
        
        
        customer1.setUser(customeruser1);
        customer1.setBookInCart(cartlist1);
        
        customer2.setUser(customeruser2);
        customer2.setBookInCart(cartlist2);
        
        customer3.setUser(customeruser3);
        customer3.setBookInCart(cartlist3);
        
        
        
        customer1.addBook(RTS);
        customer2.addBook(GMM);
        customer3.addBook(Capital);
        
        customerbean.create(customer1);
        customerbean.create(customer2);
        customerbean.create(customer3);
        
        
        
        
        
        kmgr1.addAuthor(Hayek);
        kmgr1.addBook(RTS);
        kmgr1.addIdeology(Libertarianism);
        kmgr1.addPS(PS1);
        
        kmgr2.addAuthor(Kant);
        kmgr2.addBook(GMM);
        kmgr2.addIdeology(Kantianism);
        kmgr2.addPS(PS2);
        
        kmgrbean.create(kmgr1);
        kmgrbean.create(kmgr2);
        
        
        admin1.addKMGR(kmgr1);
        admin1.addKMGR(kmgr2);
        
        adminbean.create(admin1);
        

       

        
        
        
        
       

        
        
        
        
        

        
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
