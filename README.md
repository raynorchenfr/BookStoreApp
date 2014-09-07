This project includes 3 different user groups: Administrators, knowledge managers and customers. The design of the project is based on the design of knowledge tree: a tree of knowledge fields, which are represented by entities in the database. These knowledge fields are linked to each other to provide different "spectrum" of books, which will help display in-depth information about the books customers may want to purchase.

Administrators can login to the page and see the knowledge managers under his/her command.

Knowledge managers can login to the page and view the books, ideologies, authors, etc. that he/she manages. The knowledge managers have authority to create new entities of books, authors, ideologies into the database that are under his/her management and update those entities. Or he/she has the authority to remove the books, authors or ideologies from the database.

Customers can login to the page or create his/her account via the page and put books in his/her cart. In the current design, the books are put forward for selection via drop-down selection menu. Should the application be furthered into larger scale, it will be done in other ways.

This project is done with the java technology of Java Enterprise Beans (mainly Stateless EJBs, backing beans as entity controllers, and one instance of Singleton EJB as a start-up database populator), Java Server Faces with MVC design, and servelets. It is the combination and final refined version of all the relatively "mini" projects throughout the whole semester.
