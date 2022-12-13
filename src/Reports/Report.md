# Behavioral Design Patterns

### Course: Software Design Techniques and Mechanisms 
### Author: Bitca Dina

----

## Theory
In software engineering, behavioral design patterns are design patterns that identify common communication patterns between objects and realize these patterns. By doing so, these patterns increase flexibility in carrying out this communication.
This laboratory work follows the implementation and integration of the following design patterns:
* Chain of responsibility 
* Template method
* Observer method

Chain of responsibility was used to create a customer/seller authentication flow.The pattern is recognizable by behavioral methods of
one group of objects that indirectly call the same methods in other objects, while all the objects follow the common interface
Template method was used to post the same product review from our app
to the user`s social networks. Observer method was used to send log information about the site user's activity. Particularly,
the activity of vendors which add and delete new products from different product cathegories.

## Objectives:

* Study and understand the Behavioral Design Patterns.
* Implement some additional functionalities using behavioral design patterns.


## Implementation description

* Chain of Responsibility Implementation

This implementation shows how a request containing
user data passes a sequential chain of handlers that perform various things such as authentication, authorization, and validation.
The example is different from the canonical version of the pattern
given by various sources. Most of the pattern examples are built on the notion of looking for the right handler, launching it and exiting the chain after that.
But this code executes every handler until there`s one that
cannot handle a request.
This type of implementation is logical for the logging in flow.

The implementation will be explained according to its structure.

1. The UserAction interface

This abstract class declares the interface, common for all concrete User Actions.  It usually contains just a single method for handling requests, but sometimes it may also have another method for setting the next handler on the chain.
In this case, the method defined is called "checkUser. See code below:
````
public abstract boolean checkUser(String email, String password);
````
But it also includes a method to link all other Handlers using the "doNext" function which creates a chain of actions.
See code snippet below:
````
        UserActions head = first;
        for (UserActions nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
````
Next, one or more concrete handlers are created. In this case, the concrete
handlers are called "Expired action", "User exist" and "User role". All of the concrete
handlers check for different constraints
to ensure user authentication.

2. Concrete handler: Expired Action

This handler sets a time constraint for the user to input their credentials. It is checked first
and keeps running until request time out if the user does not authenticate in given time limit.
See code snippet below:
````
if (request > requestPerMinute) {
System.out.println("Request limit exceeded!");
Thread.currentThread().stop();
````

3. Concrete handler: User exist

This handler check if this user has already signed in and exists
in the database. For the purpose of simplicity, user credentials have been stored into a Map.
See code snippet below:
````
public boolean checkUser(String email, String password) {
        if (!server.hasEmail(email)) {
            System.out.println("This email is not registered!");
            return false;
        }
        if (!server.isValidPassword(email, password)) {
            System.out.println("Wrong password!");
            return false;
        }
````

4. Concrete handler: User role

There are two potential roles for this application`s users: customer and seller. We check what type
of user is logging in according to their email. 
See code snippet below:
````
  if (email.equals("seller@example.com")) {
            System.out.println("Hello, seller!");
            return true;
        }
        System.out.println("Hello, customer!");
        return checkNext(email, password);
````
5. Server class: stores and checks user information according to information in the map
The server gets email and password from client and sends the authorization request to the chain.
See code snippet below:
````
public boolean LogIn(String email, String password){
        if (userActions.checkUser(email,password)){
            System.out.println("Log In Successful");
            return true;
        }
        return false;
````
````
public void SignIn(String email, String password){
        users.put(email, password);
    }
````
There are many other actions implemented at this level, such as Password and Email check.

6. Client 

This class is implementing the workflow through the handlers
described above. This is also where the BufferReader is called and where the data
is introduced into the Map.
See code snippet below:
````
 server.SignIn("seller@example.com", "seller_pass");
        server.SignIn("customer@example.com", "customer_pass");

        UserActions userActions = UserActions.doNext(
                new ExpiredAction(2),
                new UserExist(server),
                new UserRole()
        );
        server.setUserActions(userActions);
````
These are the basics for this scope's Chain of Responsibility implementation.

* Template method implementation

The intent of this particular design pattern
is to define the skeleton of an algorithm in an operation, deferring some steps to client subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.

This particular implementation of this pattern offers the users the possibility to post
their product reviews as messages on either Facebook or Twitter. 
The implementation will be further explained according to its structure.

1. Framework Class: Network
The Network class is a template method that defines 
methods that act as steps of the algorithm. The base class Network
defines four actions: "post", "logIn", "sendData" and "LogOut". All of these
are basic components of a posting flow.
See code snippet below:
````
 abstract boolean logIn(String userName, String password);
    abstract boolean sendData(byte[] data);
    abstract void logOut();
````

2. Concrete Classes: Facebook and Twitter
This class defines the concrete actions to be taken for each of the steps
described above. Because this implementation is made to strictly
showcase design patterns, the actions are mainly printing.
See code snippet below:
````
void logOut() {
        System.out.println("User: '" + userName + "' was logged out from Facebook");
    }
````
The end user inputs their message and prefered network. The result will be posting the
user`s reviews on their network of choice.

* Observer

Observer is a behavioral design pattern that allows some objects to notify other objects about changes in their state.
In the scope of this particular project, it was used to 
notify site admins about the activity of vendors on the application by sending notifications through
mail and log. Particular notifications were sent once a vendor added a product and saved their modifications
so app admins can keep track and check all products added to the app for compliance with the app policy.
The implementation is further explained according to the pattern structure:

1. Event Manager: base publisher class

The class event manager includes subscription management code and notification methods. In the scope of this product
it can be considered the "publisher" class. The publisher issues events of interest to other objects. These events occur when the publisher changes its state or executes some behaviors. Publishers contain a subscription infrastructure that lets new subscribers join and current subscribers leave the list.
See code snippet below:
````
public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
````
When a new event happens, the publisher goes over the subscription list and calls the notification method declared in the subscriber
interface on each subscriber object.
See code snippet below:
````
 public void notify(String eventType, Contents contents) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType, contents);
            }
````

2. EventListener: the subscriber interface

The subscriber interface declares the notification interface. 
As in most cases, this particular implementation of the subscriber interface
consists of a single "update" method. This method has two parameters
that lets the publisher past some event details along with the update.
See code snippet below:
````
 void update(String eventType, Contents contents);
````

3. Concrete subscribers: EmailNoftificationListener and LogOpenListener

The concrete subscribers perform some actions in response
to notifications issued by the publisher. All of these classes must implement the same interface so the publisher isn’t coupled to concrete classes.
In this particular implementation, the subscribers need some contextual information to handle and update correctly.
The publisher needs to provide their email, event type and the content type they are performing an action upon.
See code snippet below:
````
  @Override
        public void update(String eventType, Contents contents) {
            System.out.println("Email to " + email + ": Someone has performed " + eventType + " operation with the following product: " + contents.name());
        }
````

4. Client

The client creates publisher and subscriber objects separately and then registers
subscribers for publisher updates.
See code snippet below:
````
   editor.events.subscribe("add", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("customer@example.com"));

                editor.addProduct(Bath_Products);
                editor.saveProduct();
````

## Conclusions
The design patterns implemented above helped further develop this conceptual Makeup Shop application
into a more detailed and complex entity. It was also a great help into refactoring bigs chunks of code that
would have otherwise complicated the overall product. These particular Design Patterns integrated perfectly into the scope
of the project and helped mimic a real user experience.
