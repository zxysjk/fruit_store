This project has two main functions:

· the sell class is used by the fruit store

(1) nowFruit(Statement STMT) displays the fruit function of the day, and the return value is fruit array;

(2) addFruit(statement STMT, Boolean b) is the addition function, and the Boolean value b is used to display the query results.

(3) deleteFruit(statement STMT, Boolean b) is the delete function, and the Boolean value b is used to display the query results.

(4) noty is the sending message function, in which several accounts are created to send messages

·buy is used by shoppers

(1) nowFruit(Statement STMT) is to display the fruit function of the day, and the return value is fruit fruit array;

(2) login(Statement STMT,Scanner in) is the login function, and the return value is the User name in the database. The password is read and compared, which is a simplified login process.

(3) selectApple(Statement STMT) is to display the apple function of the day, and the return value is fruit array of fruit, which can be changed to query other fruits;

(4) choose(User u1,Vector fruits,Scanner reader) is the function of selecting Fruit to purchase cars;

(5) showCart() is a function in the User class to display the shopping cart;

(6) calOrder() is a function in the User class, which USES the policy mode to judge the User's account type (VIP/Normal) and conduct order settlement
